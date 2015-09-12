package org.bimserver.cobie.shared.transform.cobietab.cobielite;


import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;

public class FacilityFactory
{

    public FacilityDocument parse(COBIEDocument cobieXMLSheetDataDocument)
    {
        FacilityDocument facilityDocument = FacilityDocument.Factory.newInstance();
        FacilityType targetFacility = facilityDocument.addNewFacility2();
        COBIEType sheetXMLCOBie = cobieXMLSheetDataDocument.getCOBIE();
		org.nibs.cobie.tab.FacilityType sourceFacility = sheetXMLCOBie.getFacilities().getFacilityList().get(0);
        IndexedCOBie indexedCOBie = new IndexedCOBie(sheetXMLCOBie);
        FacilityTransformer facilityParser = new FacilityTransformer(sourceFacility, targetFacility, indexedCOBie);
        facilityParser.transform();
        return facilityDocument;
    }
    

    
    public FacilityDocument parse(File file) throws XmlException, IOException
    {
        return FacilityDocument.Factory.parse(file, Settings.XML_Beans_Settings.getSaveSettings());
    }

}
