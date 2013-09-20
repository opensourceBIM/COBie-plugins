package org.erdc.cobie.cobielite.parsers.sheetxmldata;

import org.buildingsmartalliance.docs.nbims03.cobie.core.CobieBaseType;
import org.erdc.cobie.cobielite.parsers.COBieLiteParsable;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.AttributesDocumentsIssues;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEBaseType;

public abstract class COBieLiteCOBIEBaseTypeParser<COBIE_SHEET_XML_DATA_TYPE extends COBIEBaseType, COBIE_LITE_DATA_TYPE extends CobieBaseType>
        extends COBieLiteSheetXMLDataParser<COBIE_SHEET_XML_DATA_TYPE, COBIE_LITE_DATA_TYPE> implements COBieLiteParsable
{

    public COBieLiteCOBIEBaseTypeParser(COBIE_SHEET_XML_DATA_TYPE cobieSheetXMLData, COBIE_LITE_DATA_TYPE cobieLiteRowData, IndexedCOBie indexedCOBie)
    {
        super(cobieSheetXMLData, cobieLiteRowData, indexedCOBie);
    }

    @Override
    protected AttributesDocumentsIssues findDescriptiveDataRows()
    {
        AttributesDocumentsIssues descriptiveData = indexedCOBie.getDescriptiveElementIndex().getDescriptiveDataBySheetNameRowName(
                cobieSpreadsheetName, sourceCOBie.getName());
        return descriptiveData;
    }

    @Override
    public COBIE_LITE_DATA_TYPE getCobieRowData()
    {
        return targetCOBie;
    }

   

    @Override
    public CobieSheetName getCobieSpreadsheetName()
    {
        return cobieSpreadsheetName;
    }

    @Override
    public COBIE_LITE_DATA_TYPE parse()
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
        return targetCOBie;
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
