package org.bimserver.cobie.shared.compare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.shared.cobietab.COBIERowDictionary;
import org.bimserver.cobie.shared.cobietab.COBIESheetCollection;
import org.bimserver.cobie.shared.cobietab.COBIESheetDictionary;
import org.bimserver.cobie.shared.compare.COBieCompareState.CompareMode;
import org.bimserver.cobie.shared.compare.COBieCompareState.ComparisonDocument;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.PluginUtilities;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.cobie.compare.COBieCompareDocument;
import org.bimserver.shared.cobie.compare.COBieCompareType;
import org.bimserver.shared.cobie.compare.COBieItemAddedType;
import org.bimserver.shared.cobie.compare.COBieItemDeletedType;
import org.bimserver.shared.cobie.compare.COBieItemModifiedChangeType;
import org.bimserver.shared.cobie.compare.COBieItemModifiedChangesType;
import org.bimserver.shared.cobie.compare.COBieItemModifiedType;
import org.bimserver.shared.cobie.compare.COBieItemsAddedType;
import org.bimserver.shared.cobie.compare.COBieItemsDeletedType;
import org.bimserver.shared.cobie.compare.COBieItemsModifiedType;
import org.bimserver.shared.cobie.compare.COBieSheetComparisonType;
import org.bimserver.shared.cobie.compare.CompareMetadataType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.nibs.cobie.tab.COBIEDocument;

public class COBieCompareResult// extends SCompareResult
{
    private static final String DEFAULT_MODEL_A_DISPLAY_NAME = "Baseline COBie Document";
    private static final String DEFAULT_MODEL_B_DISPLAY_NAME = "Revised COBie Document";
    private static final String ROID_NO_BIMSERVER = "na";
    private COBIEDocument cobie1, cobie2;
    private COBIESheetDictionary cobie1Lookup, cobie2Lookup;
    private boolean hasBiMServerConnection;
    private long roid1, roid2;
    private Bimsie1ServiceInterface service;
    private HashMap<String, ArrayList<COBieCompareItem>> sheetNameToCobieCompareItems;
    private COBieCompareState state;

    public COBieCompareResult()
    {
        initializeState();

    }

    public COBieCompareResult(COBIEDocument baselineDocument, COBIEDocument revisionDocument)
    {
        /*
         * try { d.evaluateXQuery(
         * " for $c in //Components/Component where lower-case($c//ExtObject)='ifcdoor' return $c "
         * ); } catch (XQException e) { // TODO Auto-generated catch block
         * e.printStackTrace(); }
         */
        initializeState();
        setHasBiMServerConnection(false);
        cobie1 = baselineDocument;
        cobie2 = revisionDocument;

    }

   
    public COBieCompareResult(long roid1, long roid2, PluginInterface pluginInterface, Bimsie1ServiceInterface serviceInterface) throws ServerException, UserException, XmlException, IOException
    {
        initializeState();
        this.roid1 = roid1;
        this.roid2 = roid2;
        if (roid1 == roid2)
        {
            throw new IOException("Baseline and Target Revision the same, no comparison performed");
        }
        this.service = serviceInterface;
        state.setMode(CompareMode.Fetching);
        state.setCurrentDocument(ComparisonDocument.baseline);
        state.setProgress(1);
        cobie1 = PluginUtilities.getCOBieFromROID(roid1, pluginInterface, serviceInterface);
        state.setCurrentDocument(ComparisonDocument.revision);
        state.setProgress(12);
        cobie2 = PluginUtilities.getCOBieFromROID(roid2, pluginInterface, serviceInterface);
        state.setProgress(25);
        setHasBiMServerConnection(true);
        indexDocumentsAndPerformCompare();
    }

    public COBieCompareDocument asCOBieCompareDocument() throws ServerException, UserException
    {
        state.setMode(COBieCompareState.CompareMode.TransformingToDocument);
        state.setProgress(0);
        int progressBefore = state.getProgress();
        int sheetCount = cobie1Lookup.keySet().size();
        int loopCount = 0;
        int currentProgress;

        COBieCompareDocument compareDocument = COBieCompareDocument.Factory.newInstance();
        if (hasBiMServerConnection)
        {
            compareDocument = initializeCOBieCompareDocumentWithBiMServerMetadata();
        } else
        {
            compareDocument = initializeCOBieCompareDocumentWithoutBiMServerMetadata();
        }

        for (String sheetName : sheetNameToCobieCompareItems.keySet())
        {
            try
            {
                double decimalPercentDone = ((double)loopCount / (double)sheetCount);
                currentProgress = getCummulativePercentDone(progressBefore, 100, decimalPercentDone);
                state.setProgress(currentProgress);
                state.setCurrentSpreadsheet(COBieUtility.CobieSheetName.valueOf(sheetName));
            } catch (Exception ex)
            {

            }
            handleCompareDocumentAddSheetComparisons(compareDocument.getCOBieCompare(), sheetName);

            loopCount++;

        }
        state.setProgress(100);
        state.setMode(COBieCompareState.CompareMode.Done);
        return compareDocument;
    }

    public void compareSheet(String sheetName)
    {
        if (cobie1Lookup.containsKey(sheetName) && cobie2Lookup.containsKey(sheetName))
        {
            COBIESheetCollection cobie1Sheet = cobie1Lookup.get(sheetName);
            COBIESheetCollection cobie2Sheet = cobie2Lookup.get(sheetName);
            ArrayList<String> document1HashesProcessed = new ArrayList<String>();
            for (COBIERowDictionary cobie1Row : cobie1Sheet)
            {
                String cobie1RowIDHash = cobie1Row.getCOBieRowIdHash();
                COBIERowDictionary cobie2Row = cobie2Sheet.getByRowHash(cobie1RowIDHash);
                if (cobie2Row == null)
                {
                    handleDeletedRow(cobie1RowIDHash, sheetName);
                } else
                {
                    handleModifiedRow(cobie1Row, cobie1RowIDHash, cobie2Row);
                }
                document1HashesProcessed.add(cobie1RowIDHash);
            }
            for (COBIERowDictionary cobie2Row : cobie2Sheet)
            {
                String cobie2RowIDHash = cobie2Row.getCOBieRowIdHash();
                if (!document1HashesProcessed.contains(cobie2RowIDHash))
                {
                    handleAddedRow(cobie2RowIDHash, cobie2Row);
                }
            }

        }
    }

    public COBIEDocument getBaselineDocument()
    {
        return cobie1;
    }

    public COBIEDocument getComparisonDocument()
    {
        return cobie2;
    }

    private int getCummulativePercentDone(int progressBefore, int maxProgress, double decimalPercentDoneSubtask)
    {
        int currentProgress;
        currentProgress = (int)Math.floor(decimalPercentDoneSubtask * maxProgress) + progressBefore;
        return currentProgress;
    }

    public COBieCompareState getState()
    {
        return state;
    }

    public void handleAddedRow(String rowHash, COBIERowDictionary newCOBieRow)
    {
        String sheetName = newCOBieRow.getSheetName();
        COBieCompareItemAdd addItem = new COBieCompareItemAdd(cobie2Lookup, rowHash, sheetName);
        handleAddNewCompareItem(sheetName, addItem);
    }

    public void handleAddNewCompareItem(String sheetName, COBieCompareItem compareItem)
    {
        ArrayList<COBieCompareItem> compareItems;
        if (sheetNameToCobieCompareItems.containsKey(sheetName))
        {
            compareItems = sheetNameToCobieCompareItems.get(sheetName);
        } else
        {
            compareItems = new ArrayList<COBieCompareItem>();
        }
        compareItems.add(compareItem);
        sheetNameToCobieCompareItems.put(sheetName, compareItems);
    }

    public void handleCompareDocumentAddSheetComparisons(COBieCompareType compareDocumentRoot, String sheetName)
    {
        COBieSheetComparisonType comparisons = compareDocumentRoot.addNewCOBieSheetComparisons();
        comparisons.setCOBieSheetName(sheetName);
        COBieItemsAddedType itemsAdded = comparisons.addNewAdded();
        COBieItemsDeletedType itemsDeleted = comparisons.addNewDeleted();
        COBieItemsModifiedType itemsModified = comparisons.addNewModified();
        for (COBieCompareItem compareItem : sheetNameToCobieCompareItems.get(sheetName))
        {
            if (compareItem instanceof COBieCompareItemAdd)
            {
                COBieItemAddedType itemAdded = itemsAdded.addNewCOBieItemAdded();
                itemAdded.setRowId(compareItem.getRowIdString());
                itemAdded.setRowNumber(((COBieCompareItemAdd)compareItem).getRowNumber());
            } else if (compareItem instanceof COBieCompareItemDelete)
            {
                COBieItemDeletedType itemDeleted = itemsDeleted.addNewCOBieItemDeleted();
                COBieCompareItemDelete tmpDeletedItem = (COBieCompareItemDelete)compareItem;
                itemDeleted.setRowId(compareItem.getRowIdString());
                itemDeleted.setRowNumber(tmpDeletedItem.getRowNumber());

            } else if (compareItem instanceof COBieCompareItemModify)
            {
                COBieCompareItemModify compareItemModify = (COBieCompareItemModify)compareItem;
                COBieItemModifiedType itemModified = itemsModified.addNewCOBieItemModified();
                itemModified.setRowId(compareItem.getRowIdString());
                itemModified.setModel1RowNumber(compareItemModify.getCobie1RowNumber());
                itemModified.setModel2RowNumber(compareItemModify.getCobie2RowNumber());
                COBieItemModifiedChangesType changes = itemModified.addNewChanges();
                for (String columnName : compareItemModify.getModifiedColumns())
                {
                    COBieItemModifiedChangeType change = changes.addNewCOBieChangeItem();
                    change.setColumnName(columnName);
                    change.setModel1Value(compareItemModify.getCobie1ModifiedValues().get(columnName));
                    change.setModel2Value(compareItemModify.getCobie2ModifiedValues().get(columnName));
                }

            }
        }
    }

    public void handleDeletedRow(String rowHash, String sheetName)
    {
        COBieCompareItemDelete deleteItem = new COBieCompareItemDelete(cobie1Lookup, rowHash, sheetName);
        handleAddNewCompareItem(sheetName, deleteItem);
    }

    public void handleModifiedRow(COBIERowDictionary cobie1Row, String rowHash, COBIERowDictionary cobie2Row)
    {
        String sheetName = cobie1Row.getSheetName();

        String cobie1RowValuesHash;

        cobie1RowValuesHash = cobie1Row.getRowValuesHash();
        String cobie2RowValuesHash = cobie2Row.getRowValuesHash();
        if (!cobie1RowValuesHash.equals(cobie2RowValuesHash))
        // Does not necessarily mean that row is "modified"...
        // column-wise equality is calculated in COBieCompareItemModify
        // e.g. COBieCompareItemModify may decide that
        // 2=2.00 while a row hash would flag a difference b/c it is
        // based on strings.
        // Future revisions should refactor equality calculations
        // into COBieCompareResult
        // TODO refactor equality operation so the same thing
        // is used in COBieCompareItemModify and the if statement above
        {
            COBieCompareItemModify modifyItem = new COBieCompareItemModify(cobie1Lookup, cobie2Lookup, rowHash, sheetName);
            if (modifyItem.getModifiedColumns().size() > 0)
            {
                handleAddNewCompareItem(sheetName, modifyItem);
            }
        }

    }

    private void indexDocuments()
    {
        state.setMode(COBieCompareState.CompareMode.Indexing);
        state.setCurrentDocument(ComparisonDocument.baseline);
        int progressBefore = state.getProgress();
        double decmialProgressAtStart = (double)1 / (double)50;
        double decimalProgressAfterBaseline = (double)25 / (double)50;
        double decimalProgressAfterRevision = 1.0;
        state.setProgress(getCummulativePercentDone(progressBefore, 50, decmialProgressAtStart));
        cobie1Lookup = new COBIESheetDictionary(cobie1);
        state.setProgress(getCummulativePercentDone(progressBefore, 50, decimalProgressAfterBaseline));
        state.setCurrentDocument(ComparisonDocument.revision);
        cobie2Lookup = new COBIESheetDictionary(cobie2);
        state.setProgress(getCummulativePercentDone(progressBefore, 50, decimalProgressAfterRevision));
    }

    public void indexDocumentsAndPerformCompare()
    {
        indexDocuments();
        performComparisons();

    }

    public void initializeBiMServerCompare(long roid1, long roid2, PluginInterface pluginInterface, Bimsie1ServiceInterface serviceInterface) throws ServerException, UserException, XmlException,
            IOException
    {
        // initializeState();
        this.roid1 = roid1;
        this.roid2 = roid2;
        if (roid1 == roid2)
        {
            throw new IOException("Baseline and Target Revision the same, no comparison performed");
        }
        this.service = serviceInterface;
        state.setMode(CompareMode.Fetching);
        state.setCurrentDocument(ComparisonDocument.baseline);
        state.setProgress(1);
        cobie1 = PluginUtilities.getCOBieFromROID(roid1, pluginInterface, service);
        state.setCurrentDocument(ComparisonDocument.revision);
        state.setProgress(12);
        cobie2 = PluginUtilities.getCOBieFromROID(roid2, pluginInterface, service);
        state.setProgress(25);
        setHasBiMServerConnection(true);
    }

    private COBieCompareDocument initializeCOBieCompareDocumentWithBiMServerMetadata() throws ServerException, UserException
    {
        COBieCompareDocument compareDocument = COBieCompareDocument.Factory.newInstance();
        COBieCompareType compareDocumentRoot = compareDocument.addNewCOBieCompare();
        CompareMetadataType compareMetadata = compareDocumentRoot.addNewCompareMetadata();
        compareMetadata.setCOBieModelARoid(String.valueOf(roid1));
        compareMetadata.setCOBieModelBRoid(String.valueOf(roid2));
        compareMetadata.setCompareDateTime(COBieUtility.getCurrentTimeCalendar());
        try
        {
            SRevision rev1 = service.getRevision(roid1);
            SRevision rev2 = service.getRevision(roid2);
            long proj1Id = rev1.getProjectId();
            long proj2Id = rev2.getProjectId();
            SProject project1 = service.getProjectByPoid(proj1Id);
            SProject project2 = service.getProjectByPoid(proj2Id);
            compareMetadata.setCOBieModelADisplayName(project1.getName());
            compareMetadata.setCOBieModelBDisplayName(project2.getName());
        } catch (ServerException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        } catch (UserException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
        return compareDocument;
    }

    private COBieCompareDocument initializeCOBieCompareDocumentWithoutBiMServerMetadata()
    {
        COBieCompareDocument compareDocument = COBieCompareDocument.Factory.newInstance();
        COBieCompareType compareDocumentRoot = compareDocument.addNewCOBieCompare();
        CompareMetadataType compareMetadata = compareDocumentRoot.addNewCompareMetadata();
        compareMetadata.setCOBieModelARoid(ROID_NO_BIMSERVER);
        compareMetadata.setCOBieModelBRoid(ROID_NO_BIMSERVER);
        compareMetadata.setCompareDateTime(COBieUtility.getCurrentTimeCalendar());
        compareMetadata.setCOBieModelADisplayName(DEFAULT_MODEL_A_DISPLAY_NAME);
        compareMetadata.setCOBieModelBDisplayName(DEFAULT_MODEL_B_DISPLAY_NAME);
        return compareDocument;
    }

    public void initializeguidToCompareItem()
    {

    }

    private void initializeState()
    {
        state = new COBieCompareState();
        state.setMode(CompareMode.Idle);
    }

    public boolean isHasBiMServerConnection()
    {
        return hasBiMServerConnection;
    }

    private void performComparisons()
    {
        state.setMode(COBieCompareState.CompareMode.Comparing);
        sheetNameToCobieCompareItems = new HashMap<String, ArrayList<COBieCompareItem>>();
        int sheetCount = cobie1Lookup.keySet().size();
        int loopCount = 0;
        int currentProgress;
        int progressBefore = state.getProgress();
        for (String sheetName : cobie1Lookup.keySet())
        {
            double decimalPercentDone = ((double)loopCount / (double)sheetCount);
            currentProgress = getCummulativePercentDone(progressBefore, 100, decimalPercentDone);
            try
            {
                state.setCurrentSpreadsheet(COBieUtility.CobieSheetName.valueOf(sheetName));
                state.setProgress(currentProgress);
            } catch (Exception ex)
            {

            }
            compareSheet(sheetName);
            loopCount++;
        }
        state.setProgress(100);
        state.setMode(COBieCompareState.CompareMode.Done);
    }

    private void setHasBiMServerConnection(boolean hasBiMServerConnection)
    {
        this.hasBiMServerConnection = hasBiMServerConnection;
    }

}
