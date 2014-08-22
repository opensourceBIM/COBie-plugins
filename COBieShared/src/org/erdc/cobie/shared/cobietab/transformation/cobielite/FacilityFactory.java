package org.erdc.cobie.shared.cobietab.transformation.cobielite;


import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityType;
import org.erdc.cobie.shared.cobietab.IndexedCOBie;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.sheetxmldata.COBIEType;

public class FacilityFactory
{

    public FacilityDocument parse(COBIEDocument cobieXMLSheetDataDocument)
    {
        FacilityDocument facilityDocument = FacilityDocument.Factory.newInstance();
        FacilityType targetFacility = facilityDocument.addNewFacility2();
        COBIEType sheetXMLCOBie = cobieXMLSheetDataDocument.getCOBIE();
        org.erdc.cobie.sheetxmldata.FacilityType sourceFacility = sheetXMLCOBie.getFacilities().getFacilityArray()[0];
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
