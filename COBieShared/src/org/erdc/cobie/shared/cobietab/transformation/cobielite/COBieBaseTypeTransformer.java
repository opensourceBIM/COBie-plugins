package org.erdc.cobie.shared.cobietab.transformation.cobielite;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.cobietab.AttributesDocumentsIssues;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public abstract class COBieBaseTypeTransformer<TSource extends COBIEBaseType, TTarget extends CobieBaseType>
        extends COBieTabTransformer<TSource, TTarget>
{

    public COBieBaseTypeTransformer(TSource cobieSheetXMLData, TTarget cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    protected AttributesDocumentsIssues findDescriptiveDataRows()
    {
        AttributesDocumentsIssues descriptiveData = indexedCOBie.getDescriptiveElementIndex().getDescriptiveDataBySheetNameRowName(
                cobieSpreadsheetName, source.getName());
        return descriptiveData;
    }

    @Override
    public TTarget getCobieRowData()
    {
        return target;
    }

    @Override
    public CobieSheetName getCobieSpreadsheetName()
    {
        return cobieSpreadsheetName;
    }

    @Override
    public TTarget transform()
    {
        try
        {
            parseSimpleElements();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            // TODO: log mapping errors
        }
        try
        {
            parseDescriptiveElements();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            // TODO: log mapping errors
        }

        try
        {
            parseComplexElements();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            // TODO: log mapping errors
        }
        return target;
    }

    @Override
    protected abstract void parseAttributes() throws Exception;


    @Override
    protected void parseDescriptiveElements()
    {
        try
        {
            parseAttributes();
        } catch (Exception ex)
        {

            // TODO: log mapping errors
        }

        try
        {
            parseDocuments();
        } catch (Exception ex)
        {

            // TODO: log mapping errors
        }
        try
        {
          parseIssues();
        } catch (Exception ex)
        {

            // TODO: log mapping errors
        }

    }

    @Override
    protected abstract void parseDocuments() throws Exception;

    @Override
    protected abstract void parseIssues() throws Exception;

}
