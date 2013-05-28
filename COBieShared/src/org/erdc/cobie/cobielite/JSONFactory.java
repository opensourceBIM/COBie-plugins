package org.erdc.cobie.cobielite;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import org.bimserver.emf.IfcModelInterface;
import org.erdc.cobie.shared.cobiesheetxmldata.COBieFactory;
import org.erdc.cobie.sheetxmldata.COBIEDocument;

public class JSONFactory
{

    private XMLSerializer xmlSerializer;
    
    public JSONFactory()
    {
        setSerializer(newXMLSerializer());
    }
    
    public JSON parse(FacilityDocument facility)
    {
        JSON json =  xmlSerializer.readFromStream(facility.newInputStream());
        return json;
              
    }

    private XMLSerializer newXMLSerializer()
    {
        XMLSerializer serializer = new XMLSerializer();
        applySerializerSettings(serializer);
        return serializer;
    }
    
    public JSON parse(File file) throws FileNotFoundException
    {
        JSON json =  xmlSerializer.readFromFile(file);        
        return json;
              
    }
    
    private void applySerializerSettings(XMLSerializer serializer)
    {
        serializer.setRemoveNamespacePrefixFromElements(true);
        serializer.setSkipNamespaces(true);
    }
    
    public JSON parse(IfcModelInterface model)
    {
        JSON json = null;
        COBieFactory cobieFactory = new COBieFactory();
        COBIEDocument cobie = cobieFactory.parse(model);
        FacilityFactory facilityFactory = new FacilityFactory();
        FacilityDocument facility = facilityFactory.parse(cobie);
        JSONFactory jsonFactory = new JSONFactory();
        json = jsonFactory.parse(facility);
        return json;
    }

    public XMLSerializer getSerializer()
    {
        return xmlSerializer;
    }

    public void setSerializer(XMLSerializer serializer)
    {
        this.xmlSerializer = serializer;
    }
}
