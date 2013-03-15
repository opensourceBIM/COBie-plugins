package org.erdc.cobie.plugins.serializers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.xmlbeans.XmlException;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.shared.COBieSheetXMLDataTransformable;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.utils.serializer.COBieSchematronCheckable;
import org.erdc.cobie.utils.serializer.COBieSchematronChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieCheckSerializer extends COBieSheetXMLDataSerializer implements
		COBieSheetXMLDataTransformable
{
	private static final String LOGGER_MESSAGE_END_COMPLIANCE_REPORT = ":  COBie Compliance report done.";
	private static final String LOGGER_MSG_BEGIN_COMPLIANCE_REPORT = ":  Begin generating COBie compliance report.";
	private static final Logger LOGGER = LoggerFactory
			.getLogger(COBieCheckSerializer.class);
	private COBieSchematronChecker checker;

	public COBieCheckSerializer(String schematronRulePath,
			String preProcessorPath, String svrlXSDPath, String svrlHTMLPath,
			String cssPath)
	{
		checker = createChecker(schematronRulePath, preProcessorPath, svrlXSDPath,
				svrlHTMLPath, cssPath);
	}

	public COBieSchematronChecker createChecker(String schematronRulePath,
			String preProcessorPath, String svrlXSDPath, String svrlHTMLPath,
			String cssPath)
	{
		return new COBieSchematronChecker(schematronRulePath,
				preProcessorPath, svrlXSDPath, svrlHTMLPath, cssPath);
	}

	private String getBeginMessage()
	{
		return super.projectName + LOGGER_MSG_BEGIN_COMPLIANCE_REPORT;
	}


	private String getDoneMessage()
	{
		return super.projectName + LOGGER_MESSAGE_END_COMPLIANCE_REPORT;
	}

	@Override
	public void init(COBIEDocument cobie) throws SerializerException
	{
		try
		{

			super.init(cobie);
			checker.setCOBie(cobie);
		}
		catch (SerializerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo,
			PluginManager pluginManager) throws SerializerException
	{
		try
		{

			super.init(model, getProjectInfo(), pluginManager);
			checker.setCOBie(getCOBieDocument());
		}
		catch (SerializerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo,
			PluginManager pluginManager, IfcEnginePlugin ifcEnginePlugin,
			boolean normalizeOids) throws SerializerException
	{
		try
		{

			super.init(model, getProjectInfo(), pluginManager, ifcEnginePlugin,
					normalizeOids);
			checker.setCOBie(getCOBieDocument());
		}
		catch (SerializerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init(InputStream cobieSheetXMLData) throws SerializerException,
			XmlException, IOException
	{
		init(COBIEDocument.Factory.parse(cobieSheetXMLData));
		checker.setCOBie(getCOBieDocument());
	}

	@Override
	public void init(PluginManager pluginManager, COBIEDocument cobie)
			throws SerializerException
	{
		super.init(pluginManager, cobie);
		checker.setCOBie(cobie);
	}

	public void schematronReportToOutputStream(OutputStream outputStream)
			throws Exception
	{
		checker.writeResult(outputStream);

	}

	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieSheetXMLData,
			File targetExportFile) throws Exception
	{
		init(cobieSheetXMLData);
		writeModeFree(new FileOutputStream(targetExportFile));

	}

	@Override
	public boolean write(OutputStream outputStream) throws SerializerException
	{
		if (getMode() == Mode.BODY)
		{
			super.modelToCOBie();
			LOGGER.info(getBeginMessage());
			try
			{
				schematronReportToOutputStream(outputStream);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOGGER.info(getDoneMessage());
			setMode(Mode.FINISHED);
			return true;
		}
		else
			if (getMode() == Mode.FINISHED)
			{
				return false;
			}
		return false;

		// TODO Auto-generated method stub
	}

	public boolean writeModeFree(OutputStream outputStream)
			throws SerializerException
	{

		LOGGER.info(getBeginMessage());
		try
		{
			schematronReportToOutputStream(outputStream);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info(getDoneMessage());
		setMode(Mode.FINISHED);
		return true;

		// TODO Auto-generated method stub
	}
}