package org.bimserver.cobie.shared.deserialization;

import java.io.File;
import java.io.InputStream;

import org.bimserver.cobie.shared.cobietab.COBieTabProducable;
import org.bimserver.cobie.shared.deserialization.cobietab.COBieIfcModel;
import org.bimserver.cobie.shared.deserialization.cobietab.FromCOBieToIfc;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.ByteProgressReporter;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.nibs.cobie.tab.COBIEDocument;

public class COBieTabDeserializer extends EmfDeserializer implements
		COBieTabProducable
{

	@Override
	public COBIEDocument toCOBieSheetXMLData(File incomingFile)
			throws Exception
	{
		return COBIEDocument.Factory.parse(incomingFile);
	}

	@Override
	public IfcModelInterface read(InputStream in, String filename, long fileSize, ByteProgressReporter progress)
			throws DeserializeException
	{
		COBieIfcModel cobieModel = null;
		try
		{
			FromCOBieToIfc cobieTransform;
			cobieTransform = new FromCOBieToIfc(COBIEDocument.Factory.parse(in).getCOBIE(), getPackageMetaData());
			
			cobieModel = cobieTransform.getModelFromCOBie();
		}
		catch (Exception e)
		{
			throw new DeserializeException(e);
		}

		return cobieModel;
	}

}
