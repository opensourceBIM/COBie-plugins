package com.prairiesky.transform.template.test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.XmlException;
import org.junit.Test;
import org.nibs.cobie.tab.COBIEDocument;

import com.prairiesky.transform.template.CobieXLSXToCobieTabTransform;

public class TestTransform
{

	@Test
	public void test() throws InvalidFormatException, IOException, XmlException
	{
		COBIEDocument document = COBIEDocument.Factory.newInstance();
		CobieXLSXToCobieTabTransform transform =
				new CobieXLSXToCobieTabTransform(WorkbookFactory.create(new File("C:\\Users\\Bogen\\Documents\\Consulting\\CobieQcReporter\\test\\cobie_test.xlsx")), document);
		transform.transform().save(new File("testTransform.xml"));;
		COBIEDocument deserialized =
				COBIEDocument.Factory.parse(new File("testTransform.xml"));
		String noop = "";
	}

}
