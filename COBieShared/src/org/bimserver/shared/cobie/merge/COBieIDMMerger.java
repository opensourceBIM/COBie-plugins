package org.bimserver.shared.cobie.merge;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.shared.cobie.COBIERowDictionary;
import org.bimserver.shared.cobie.COBIESheetCollection;
import org.bimserver.shared.cobie.COBIESheetDictionary;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.compare.COBieCompareDocument;
import org.bimserver.shared.cobie.compare.COBieCompareResult;
import org.bimserver.shared.cobie.compare.COBieCompareType;
import org.bimserver.shared.cobie.compare.COBieItemAddedType;
import org.bimserver.shared.cobie.compare.COBieItemDeletedType;
import org.bimserver.shared.cobie.compare.COBieItemModifiedChangeType;
import org.bimserver.shared.cobie.compare.COBieItemModifiedChangesType;
import org.bimserver.shared.cobie.compare.COBieItemModifiedType;
import org.bimserver.shared.cobie.compare.COBieSheetComparisonType;
import org.bimserver.shared.cobie.generated.merge.COBieMergeIDMDocument;
import org.bimserver.shared.cobie.generated.merge.COBieSheetModificationPrecedenceCollectionType;
import org.bimserver.shared.cobie.generated.merge.COBieSheetModificationPrecedenceType;
import org.bimserver.shared.cobie.generated.merge.COBieSheetModificationPrecedenceType.ColumnOverrideModifyRule;
import org.bimserver.shared.cobie.generated.merge.COBieSheetNameType;
import org.bimserver.shared.cobie.generated.merge.ModificationPrecedenceDefaultRulesetType;
import org.bimserver.shared.cobie.generated.merge.ModificationPrecedenceDefaultRulesetType.Enum;
import org.bimserver.shared.cobie.generated.merge.ModifyRuleType;
import org.bimserver.shared.cobie.merge.COBieMergeState.MergeMode;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class COBieIDMMerger extends 
COBieMerger<COBieMergeIDMItem,COBieMergeIDMItem,COBieMergeIDMDocument,COBieMergeIDMDocument,COBIEDocument>
{
	private static final String STATUS_MESSAGE_DONE = "Merge completed";


	private static final String STATUS_MESSAGE_MERGING = "Merging items";


	private static final String STATUS_MESSAGE_COMPARE = "Comparing merge items";


	private static final String STATUS_MESSAGE_PREPARING_REVISION_ITEMS = "Preparing merge document 2 of 2";


	private static final String STATUS_MESSAGE_PREPARING_BASE_ITEMS = "Preparing merge document 1 of 2";


	private static final String STATUS_MESSAGE_INITIALIZE = "Initializing Merge Object";


	private COBieMergeState mergeState;


	private HashMap<MergeMode,Integer> mergeModeToProgress;
	private COBIEDocument result;
	private ModifyRuleType.Enum defaultModifyRule;
	private HashMap<COBieSheetNameType.Enum,Boolean> allowAddLookup;
	private HashMap<COBieSheetNameType.Enum,HashMap<String,ModifyRuleType.Enum>> modifyColumnsOverridingDefault;
	private HashMap<COBieSheetNameType.Enum,ModifyRuleType.Enum> modifySheetsOverridingDefault;
	//private HashMap<COBieSheetNameType.Enum,ArrayList<String>>
	public COBieIDMMerger(COBieMergeIDMItem baseMergeItem, COBieMergeIDMItem revisionMergeItem)
	{
		super(baseMergeItem,revisionMergeItem);
		init();
	}
	
	private void init()
	{
		mergeState = new COBieMergeState();
		initializeMergeModeToProgress();
		setStateInitialize();
		initializeAllowAddLookup();
		initializeModifyColumnsOverridingDefault();
		initializeDefaultModifyRule();

	}

	private void setStateInitialize()
	{
		mergeState.setMode(MergeMode.Initializing);
		mergeState.setProgress(mergeModeToProgress.get(mergeState.getMode()));
		mergeState.setStatusMessageSuffix(STATUS_MESSAGE_INITIALIZE);
	}
	
	private void initializeMergeModeToProgress()
	{
		mergeModeToProgress =
				new HashMap<MergeMode,Integer>();
		for(MergeMode mergeMode:COBieMergeState.MergeMode.class.getEnumConstants())
		{
			switch(mergeMode)
			{
			case Comparing:
				mergeModeToProgress.put(mergeMode, 40);
				break;
			case Done:
				mergeModeToProgress.put(mergeMode, 100);
				break;
			case Idle:
				mergeModeToProgress.put(mergeMode, 0);
				break;
			case Initializing:
				mergeModeToProgress.put(mergeMode, 0);
				break;
			case Merging:
				mergeModeToProgress.put(mergeMode, 75);
				break;
			case PreparingBaseItems:
				mergeModeToProgress.put(mergeMode, 10);
				break;
			case PreparingRevisionItems:
				mergeModeToProgress.put(mergeMode, 25);
				break;
			
			}
		}
	}
	
	private void initializeDefaultModifyRule()
	{
		defaultModifyRule =
				revisionMergeItem.getMergeRules().getCOBieMergeIDM().getModificationPrecedence().getModifyRulesetDefault();
	}
	
	private void initializeModifyColumnsOverridingDefault()
	{
		setModifySheetsOverridingDefault(new HashMap<COBieSheetNameType.Enum,ModifyRuleType.Enum>());
		setModifyColumnsOverridingDefault(new HashMap<COBieSheetNameType.Enum,HashMap<String,ModifyRuleType.Enum>>());
		COBieMergeIDMDocument revisionRules =
				revisionMergeItem.getMergeRules();
		COBieSheetModificationPrecedenceCollectionType
			revisionModificationPrecedence = 
			revisionRules.getCOBieMergeIDM().getModificationPrecedence();
		for(COBieSheetModificationPrecedenceType sheetPrecedence: 
			revisionModificationPrecedence.getCOBieSheetModificationPrecedenceArray())
		{		
			modifySheetsOverridingDefault.put(sheetPrecedence.getCOBieSheetName(), 
					sheetPrecedence.getModifyRule());
			for(ColumnOverrideModifyRule columnRule :sheetPrecedence.getColumnOverrideModifyRuleArray())
			{
				HashMap<String,ModifyRuleType.Enum> columnMap;
				if(modifyColumnsOverridingDefault.containsKey(sheetPrecedence.getCOBieSheetName()))
				{
					 columnMap =
							modifyColumnsOverridingDefault.get(sheetPrecedence.getCOBieSheetName());
					columnMap.put(columnRule.getStringValue(),columnRule.getModifyRule());
					modifyColumnsOverridingDefault.put(sheetPrecedence.getCOBieSheetName(),columnMap);
				}
				else
				{
					 columnMap =
							new HashMap<String,ModifyRuleType.Enum>();
					
				}
				columnMap.put(columnRule.getStringValue(),columnRule.getModifyRule());
				modifyColumnsOverridingDefault.put(sheetPrecedence.getCOBieSheetName(),columnMap);
			}
		}
		
	}
	
	private void initializeAllowAddLookup()
	{
		setAllowAddLookup(new HashMap<COBieSheetNameType.Enum,Boolean>());
		
		COBieMergeIDMDocument revisionRules =
				revisionMergeItem.getMergeRules();
		COBieSheetModificationPrecedenceCollectionType
		revisionModificationPrecedence = 
		revisionRules.getCOBieMergeIDM().getModificationPrecedence();
		
		ModificationPrecedenceDefaultRulesetType.Enum defaultAdd =
	 			revisionModificationPrecedence.getAddRulesetDefault();
		boolean defaultAllowAdd = false;
		if(defaultAdd==ModificationPrecedenceDefaultRulesetType.ALLOW)
			defaultAllowAdd = true;
		int maxEnumInt = COBieSheetNameType.Enum.table.lastInt();
		for(int i=1; i <= maxEnumInt;i++)
		{
			COBieSheetNameType.Enum sheetName =
					COBieSheetNameType.Enum.forInt(i);
			allowAddLookup.put(sheetName,defaultAllowAdd);
		}
		for(COBieSheetModificationPrecedenceType modificationPrecedence:revisionModificationPrecedence.getCOBieSheetModificationPrecedenceArray())
		{
			COBieSheetNameType.Enum sheetName = modificationPrecedence.getCOBieSheetName();
			allowAddLookup.put(sheetName, modificationPrecedence.getAllowAdd());
		}	 	
	}
	

	
	/*public COBieIDMMerger(List<COBieMergeIDMItem> mergeItems)
	{
		super(mergeItems);
		init();
	}

	private void init()
	{
		Collections.sort(mergeItems);
	}
	public COBIEDocument getResult()
	{
		return result;
	}
	private void setResult(COBIEDocument result)
	{
		this.result = result;
	}*/
	

	@Override
	public void prepareBaseMergeItem()
	{
		setStatePreparingBaseItems();
		baseMergeItem.applyPreMergeRules();	
	}

	private void setStatePreparingBaseItems()
	{
		mergeState.setMode(MergeMode.PreparingBaseItems);
		mergeState.setProgress(mergeModeToProgress.get(mergeState.getMode()));
		mergeState.setStatusMessageSuffix(STATUS_MESSAGE_PREPARING_BASE_ITEMS);
	}

	@Override
	public void prepareRevisionMergeItem()
	{
		setMergeStatePreparingRevisionItems();
		revisionMergeItem.applyPreMergeRules();
		
	}

	private void setMergeStatePreparingRevisionItems()
	{
		mergeState.setMode(MergeMode.PreparingRevisionItems);
		mergeState.setProgress(mergeModeToProgress.get(mergeState.getMode()));
		mergeState.setStatusMessageSuffix(STATUS_MESSAGE_PREPARING_REVISION_ITEMS);
	}

	@Override
	public COBIEDocument prepareResult() throws Exception
	{

		COBIESheetDictionary mergedSheetDictionary =
				getMergedCOBIESheetDictionary();
		result = mergedSheetDictionary.asCOBie();
		setMergeStateDone();
		return result;

	}

	private void setMergeStateDone()
	{
		mergeState.setMode(MergeMode.Done);
		mergeState.setProgress(mergeModeToProgress.get(mergeState.getMode()));
		mergeState.setStatusMessageSuffix(STATUS_MESSAGE_DONE);
	}
	private COBIESheetDictionary getMergedCOBIESheetDictionary() throws ServerException, UserException
	{
		COBIESheetDictionary mergeResult =
				getInitialCOBIESheetDictionary();
		setMergeStateComparing();
		COBieCompareDocument compareResultDocument =
				getCompareResult();
		COBieCompareType compareRootNode =
				compareResultDocument.getCOBieCompare();
		setMergeStateMerging();
		for(COBieSheetComparisonType sheetComparison:compareRootNode.getCOBieSheetComparisonsArray())
		{
			handleSheetComparison(sheetComparison,mergeResult);
		}
		return mergeResult;
	}

	private void setMergeStateMerging()
	{
		mergeState.setMode(MergeMode.Merging);
		mergeState.setProgress(mergeModeToProgress.get(mergeState.getMode()));
		mergeState.setStatusMessageSuffix(STATUS_MESSAGE_MERGING);
	}

	private void setMergeStateComparing()
	{
		mergeState.setMode(MergeMode.Comparing);
		mergeState.setProgress(mergeModeToProgress.get(mergeState.getMode()));
		mergeState.setStatusMessageSuffix(STATUS_MESSAGE_COMPARE);
	}


	private void handleSheetComparison(COBieSheetComparisonType sheetComparison,
			COBIESheetDictionary mergeResult)
	{
	
		for(COBieItemAddedType addedItem:sheetComparison.getAdded().getCOBieItemAddedArray())
		{
			handleItemAdded(sheetComparison.getCOBieSheetName(),addedItem,mergeResult);
		}
		
		for(COBieItemDeletedType deletedItem:sheetComparison.getDeleted().getCOBieItemDeletedArray())
		{
			handleItemDeleted(sheetComparison.getCOBieSheetName(),deletedItem,mergeResult);
		}
		
		for(COBieItemModifiedType modifiedItem:sheetComparison.getModified().getCOBieItemModifiedArray())
		{
			handleItemModified(sheetComparison.getCOBieSheetName(),modifiedItem,mergeResult);
		}
		
	}
	private void handleItemModified(String cobieSheetName,COBieItemModifiedType modifiedItem,
			COBIESheetDictionary mergeResult)
	{
		COBieSheetNameType.Enum sheetNameLiteral =
				COBieSheetNameType.Enum.forString(cobieSheetName);
		ModifyRuleType.Enum modificationRule;
		if(modifySheetsOverridingDefault.containsKey(sheetNameLiteral))
		{
			modificationRule =
					modifySheetsOverridingDefault.get(sheetNameLiteral);
		}
		else
		{
			modificationRule = defaultModifyRule;
		}
		processModification(cobieSheetName,modifiedItem,mergeResult,modificationRule);
	}
	
	private void processModification(String cobieSheetName,COBieItemModifiedType modifiedItem,
			COBIESheetDictionary mergeResult,ModifyRuleType.Enum modifyRule)
	{
		COBIERowDictionary modifiedRow =
				mergeResult.get(cobieSheetName).getByCOBieRowIdString(modifiedItem.getRowId());
		COBieSheetNameType.Enum sheetNameLiteral =
				COBieSheetNameType.Enum.forString(cobieSheetName);
		for(COBieItemModifiedChangeType change :modifiedItem.getChanges().getCOBieChangeItemArray())
		{
			ModifyRuleType.Enum columnRule = modifyRule;
			String baseValue = change.getModel1Value();
			String columnName = change.getColumnName();
			if(modifyColumnsOverridingDefault.containsKey(sheetNameLiteral))
				if(modifyColumnsOverridingDefault.get(sheetNameLiteral).containsKey(columnName))
					columnRule = modifyColumnsOverridingDefault.get(sheetNameLiteral).get(columnName);

			if ( (columnRule.equals(ModifyRuleType.ALLOW_ONLY_ON_NA) && COBieUtility.isNA(baseValue)) 
					|| (columnRule.equals(ModifyRuleType.ALLOW)))
				modifiedRow.put(columnName, change.getModel2Value());
		}
	}

	private void handleItemDeleted(String cobieSheetName,
			COBieItemDeletedType deletedItem,COBIESheetDictionary mergeResult)
	{
		//All deleted rows are passed forward so do nothing

	}


	private void handleItemAdded(String cobieSheetName, 
			COBieItemAddedType addedItem,COBIESheetDictionary mergeResult)
	{
		try
		{
			COBieSheetNameType.Enum sheetNameLiteral =
					COBieSheetNameType.Enum.forString(cobieSheetName);
			boolean allowAdd =
					allowAddLookup.get(sheetNameLiteral);
			if(allowAdd)
			{
				COBIESheetCollection addDestination =
						mergeResult.get(cobieSheetName);
				COBIERowDictionary newRow =
						revisionMergeItem.getCobieSheetDictionary().get(cobieSheetName).getByCOBieRowIdString(addedItem.getRowId());
				addDestination.add(newRow);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	private COBieCompareDocument getCompareResult() throws ServerException, UserException
	{
		COBieCompareResult comparisonResult =
				new COBieCompareResult(baseMergeItem.getCobie(),revisionMergeItem.getCobie());
		comparisonResult.indexDocumentsAndPerformCompare();
		
		COBieCompareDocument compareDocument =
				comparisonResult.asCOBieCompareDocument();
		return compareDocument;
	}
	
	private COBIESheetDictionary getInitialCOBIESheetDictionary()
	{
		COBIESheetDictionary mergeResult =
				new COBIESheetDictionary(baseMergeItem.getCobie());
		return mergeResult;
	}


	public HashMap<COBieSheetNameType.Enum, Boolean> getAllowAddLookup()
	{
		return allowAddLookup;
	}


	public void setAllowAddLookup(HashMap<COBieSheetNameType.Enum, Boolean> allowAddLookup)
	{
		this.allowAddLookup = allowAddLookup;
	}

	public HashMap<COBieSheetNameType.Enum, HashMap<String,ModifyRuleType.Enum>> getModifyColumnsOverridingDefault()
	{
		return modifyColumnsOverridingDefault;
	}

	public void setModifyColumnsOverridingDefault(
			HashMap<COBieSheetNameType.Enum,HashMap<String,ModifyRuleType.Enum>> modifyColumnsOverridingDefault)
	{
		this.modifyColumnsOverridingDefault = modifyColumnsOverridingDefault;
	}

	public HashMap<COBieSheetNameType.Enum,ModifyRuleType.Enum> getModifySheetsOverridingDefault()
	{
		return modifySheetsOverridingDefault;
	}

	public void setModifySheetsOverridingDefault(
			HashMap<COBieSheetNameType.Enum,ModifyRuleType.Enum> modifySheetsOverridingDefault)
	{
		this.modifySheetsOverridingDefault = modifySheetsOverridingDefault;
	}

	public COBieMergeState getMergeState()
	{
		return mergeState;
	}
	
	public void setMergeState(COBieMergeState mergeState)
	{
		this.mergeState = mergeState;
	}

	
}
