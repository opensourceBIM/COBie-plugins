package org.erdc.cobie.deserializers;

import java.io.File;
import java.io.InputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.erdc.cobie.shared.COBieSheetXMLDataProducable;
import org.erdc.cobie.shared.deserializer.sheetxmldata.COBieIfcModel;
import org.erdc.cobie.shared.deserializer.sheetxmldata.FromCOBieToIfc;
import org.erdc.cobie.sheetxmldata.COBIEDocument;

public class COBieSheetXMLDataDeserializer extends EmfDeserializer implements
		COBieSheetXMLDataProducable
{

	@Override
	public COBIEDocument toCOBieSheetXMLData(File incomingFile)
			throws Exception
	{
		return COBIEDocument.Factory.parse(incomingFile);
	}

	@Override
	public void init(SchemaDefinition schema)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public IfcModelInterface read(InputStream in, String filename, long fileSize)
			throws DeserializeException
	{
		COBieIfcModel cobieModel = null;
		try
		{
			FromCOBieToIfc cobieTransform;
			cobieTransform = new FromCOBieToIfc(COBIEDocument.Factory.parse(in).getCOBIE());
			cobieModel = cobieTransform.getModelFromCOBie();
		}
		catch (Exception e)
		{
			throw new DeserializeException(e);
		}

		return cobieModel;
	}

}
