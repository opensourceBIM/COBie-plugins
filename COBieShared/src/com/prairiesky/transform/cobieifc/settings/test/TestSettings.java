package com.prairiesky.transform.cobieifc.settings.test;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.prairiesky.transform.cobieifc.settings.FacilitySettingsType;
import com.prairiesky.transform.cobieifc.settings.ObjectFactory;
import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class TestSettings {

	@Test
	public void test() throws JAXBException, SAXException, IOException, ParserConfigurationException 
	{
		File settingsFile =
				new File("C:\\Users\\Bogen\\Documents\\Java\\BIMserver-1.4.0-FINAL-2015-11-04\\COBieShared\\xsd\\IfcToCobieConfig.xml");
		JAXBContext context =
				JAXBContext.newInstance("com.prairiesky.transform.cobieifc.settings");
		Unmarshaller unmarsheller =
				context.createUnmarshaller();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(settingsFile);
		Object object = unmarsheller.unmarshal(doc, SettingsType.class);
		String noop = "";
		
	}
	
	@Test
	public void testMarshal() throws JAXBException
	{
		File t = new File("temp.xml");
		ObjectFactory f = new ObjectFactory();
	
		SettingsType settings = new SettingsType();
		FacilitySettingsType facilitySettings =
				new FacilitySettingsType();
		facilitySettings.setFacilityDefaultProjectName("Default");
		facilitySettings.setFacilitySiteDefaultName("Default");
		settings.setFacilitySettings(facilitySettings);
		JAXBContext context =
				JAXBContext.newInstance("com.prairiesky.transform.cobieifc.settings");
		javax.xml.bind.Marshaller m = context.createMarshaller();
		m.marshal(settings, t);
				
		
	}

}
