package org.erdc.cobie.shared.bimserver.cobietab.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.bimserver.plugins.serializers.SerializerException;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;
import org.erdc.cobie.shared.altova.mapping.COBieLiteTemplateMapper;
import org.erdc.cobie.shared.bimserver.COBieSheetXMLDataTransformable;
import org.erdc.cobie.shared.cobietab.transformation.cobielite.FacilityFactory;
import org.erdc.cobie.sheetxmldata.COBIEDocument;

public class COBieTemplateSerializer extends COBieTabXMLSerializer implements
COBieSheetXMLDataTransformable
{

	private final COBieLiteTemplateMapper mapper;
	private FacilityDocument facilityDocument;
	public COBieTemplateSerializer(COBieLiteTemplateMapper mapper)
	{
		this.mapper = mapper;
	}
	
	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieDocument, File out) throws Exception
	{
		setCOBie(cobieDocument);
		writeCOBIE(new FileOutputStream(out));
	}

	
	
	@Override
	protected void writeCOBIE(OutputStream outputStream) throws SerializerException
	{
		FacilityFactory facilityFactory = new FacilityFactory();
		facilityDocument = facilityFactory.parse(getCOBieDocument());
		mapper.setFacilityDocument(facilityDocument);
		try
		{
			mapper.run();
			mapper.write(outputStream);
		}
		catch (Exception e)
		{
			throw new SerializerException(e);
		}

	}


}
