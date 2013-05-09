package org.erdc.cobie.cobielite;


import java.io.File;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.xml.XMLSerializer;

import org.apache.xmlbeans.XmlException;
import org.erdc.cobie.cobielite.parsers.sheetxmldata.FacilityParser;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;
import org.erdc.cobie.shared.utils.XMLUtils;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.w3c.dom.Element;

public class FacilityFactory
{

    public FacilityDocument parse(COBIEDocument cobieXMLSheetDataDocument)
    {
        FacilityDocument facilityDocument = FacilityDocument.Factory.newInstance();
        FacilityType targetFacility = facilityDocument.addNewFacility();
        COBIEType sheetXMLCOBie = cobieXMLSheetDataDocument.getCOBIE();
        org.erdc.cobie.sheetxmldata.FacilityType sourceFacility = sheetXMLCOBie.getFacilities().getFacilityArray()[0];
        IndexedCOBie indexedCOBie = new IndexedCOBie(sheetXMLCOBie);
        FacilityParser facilityParser = new FacilityParser(sourceFacility, targetFacility, indexedCOBie);
        facilityParser.parse();
        XMLUtils.removeEmptyChildElements((Element)facilityDocument.getFacility().getDomNode());
        return facilityDocument;
    }
    

    
    public FacilityDocument parse(File file) throws XmlException, IOException
    {
        return FacilityDocument.Factory.parse(file, Settings.XML_Beans_Settings.getSaveSettings());
    }

}
