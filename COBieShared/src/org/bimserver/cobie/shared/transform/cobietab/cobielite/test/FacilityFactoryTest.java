package org.bimserver.cobie.shared.transform.cobietab.cobielite.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.shared.transform.cobietab.cobielite.FacilityFactory;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.junit.Test;
import org.nibs.cobie.tab.COBIEDocument;

public class FacilityFactoryTest {

	@Test
	public void test() throws XmlException, IOException 
	{
		COBIEDocument cobieDocument = COBIEDocument.Factory.parse(new File("cobietab_example.xml"));
		FacilityFactory factory = new FacilityFactory();
		FacilityDocument facility = factory.parse(cobieDocument);
		facility.save(new File("cobielite_example.xml"));
		String nop = "";
	}

}
