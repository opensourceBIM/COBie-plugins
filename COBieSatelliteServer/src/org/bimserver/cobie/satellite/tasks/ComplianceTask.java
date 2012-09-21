package org.bimserver.cobie.satellite.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.plugins.COBieCheckSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.xml.sax.SAXException;

public class ComplianceTask extends ApplicationTask<Void>
{

	private static final String SCHEMATRON_RULEPATH =
			"lib/COBieRules.sch";
			private static final String PRE_PROCESSOR_PATH =
			"lib/iso_svrl_for_xslt2.xsl";
			private static final String SVRL_XSD_PATH =
			"lib/SVRL.xsd";
			private static final String SVRL_HTML_XSLT_PATH =
			"lib/SVRL_HTML.xslt";
			private static final String CSS_PATH=
			"lib/SpaceReport.css";
			private COBieCheckSerializer checkSerializer;
			private HashMap<String,File> configFiles;
			private COBIEDocument cobieDocument;
			private String targetFilePath;
			public ComplianceTask(COBIEDocument cobieDocument,String targetFilePath,
					Informable informable,boolean requiresRunningBiMServer)
			{
				super(informable,requiresRunningBiMServer);
				this.targetFilePath = targetFilePath;
				this.cobieDocument = cobieDocument;
				initializeConfigFiles();
				// TODO Auto-generated constructor stub
			}
			
			
			public void initializeConfigFiles()
			{
				configFiles = new HashMap<String,File>();
				configFiles.put(SCHEMATRON_RULEPATH,new File(SCHEMATRON_RULEPATH));
				configFiles.put(PRE_PROCESSOR_PATH, new File(PRE_PROCESSOR_PATH));
				configFiles.put(SVRL_XSD_PATH, new File(SVRL_XSD_PATH));
				configFiles.put(SVRL_HTML_XSLT_PATH, new File(SVRL_HTML_XSLT_PATH));
				configFiles.put(CSS_PATH, new File(CSS_PATH));
			}

			private void saveComplianceFile() throws FileNotFoundException, SerializerException
			{

					checkSerializer.writeModeFree(new FileOutputStream(targetFilePath));
			}
			
	@Override
	protected Void doInBackground() throws Exception
	{	
		try
		{
			// TODO Auto-generated method stub
			initializeComplianceSerializer();
			publish(new COBieTaskProgress("initialized compliance export"));
			super.setProgress(50);
			saveComplianceFile();
			super.setProgress(100);
			publish(new COBieTaskProgress("compliance report generated"));
			super.sleep();
		}
		catch(Exception e)
		{

			handleExecutionException(new COBieTaskProgress("An error occured while performing compliance transform:  "+e.getMessage()));
		}
		
		return null;
	}
	
	private void initializeComplianceSerializer() throws FileNotFoundException, SerializerException, XmlException, IOException, 
	ParserConfigurationException, SAXException
	{

		checkSerializer = new COBieCheckSerializer
				(this.configFiles.get(SCHEMATRON_RULEPATH).getAbsolutePath(),
						this.configFiles.get(PRE_PROCESSOR_PATH).getAbsolutePath(),
						this.configFiles.get(SVRL_XSD_PATH).getAbsolutePath(),
						this.configFiles.get(SVRL_HTML_XSLT_PATH).getAbsolutePath(),
						this.configFiles.get(CSS_PATH).getAbsolutePath()
						);
		checkSerializer.init(cobieDocument.newInputStream());	
	}

	

}
