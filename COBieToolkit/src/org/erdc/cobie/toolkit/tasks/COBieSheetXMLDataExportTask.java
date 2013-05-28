package org.erdc.cobie.toolkit.tasks;

import java.io.File;

import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.erdc.cobie.shared.deserializer.sheetxmldata.COBieIfcModel;
import org.erdc.cobie.shared.deserializer.sheetxmldata.FromCOBieToIfc;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.utils.serializer.BIMServerCOBieSheetXMLDataSerializer;

public class COBieSheetXMLDataExportTask extends ApplicationTask<Void>
{
	private static final int PROGRESS_VALUE_SERIALIZING = 50;
	private static final int PROGRESS_VALUE_INITIALIZE_SERIALIZER = 45;
	private static final int PROGRESS_VALUE_DESERIALIZE = 40;
	private static final String PROGRESS_MESSAGE_DONE = "Done";
	private static final String PROGRESS_MESSAGE_STARTING = "Begin export";
	private static final String PROGRESS_MESSAGE_DESERIALIZE = "Deriving Ifc Model Objects";
	private static final String PROGRESS_MESSAGE_INITIALIZE_SERIALIZER = "Initializing Serializer";
	private static final String PROGRESS_MESSAGE_SERIALIZING = "Executing Serialize Routine";
	private static final String PROGRESS_MESSAGE_ERROR = "An error occured while exporting COBieXML Data.  Select another file to try again";
	SerializerPlugin serializerPlugin;
	COBIEDocument cobieSheetXMLData;
	IfcModel model;
	PluginManager pluginManager;
	File outputFile;
	public COBieSheetXMLDataExportTask(Informable informable,
			boolean requiresRunningBiMServer,SerializerPlugin serializerPlugin,
			PluginManager pluginManager,
			COBIEDocument cobieSheetXMLData,File outputFile)
	{
		super(informable, requiresRunningBiMServer);
		this.serializerPlugin = serializerPlugin;
		this.cobieSheetXMLData = cobieSheetXMLData;
		this.pluginManager = pluginManager;
		this.outputFile = outputFile;
		model = null;
	}

	@Override
	protected Void doInBackground() throws Exception
	{
		super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_STARTING));
		super.setProgress(1);
		try
		{
			EmfSerializer emfSerializer = (EmfSerializer) serializerPlugin.createSerializer(new PluginConfiguration());
			if(model==null && !(emfSerializer instanceof BIMServerCOBieSheetXMLDataSerializer))
			{
				model = deserializeCOBieSheetXMLDataToIfc();
				super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_DESERIALIZE));
				super.setProgress(PROGRESS_VALUE_DESERIALIZE);
			}

			super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_INITIALIZE_SERIALIZER));
			
			if(emfSerializer instanceof BIMServerCOBieSheetXMLDataSerializer)
			{
				((BIMServerCOBieSheetXMLDataSerializer)emfSerializer).init(cobieSheetXMLData);
			}
			else
			{
				emfSerializer.init(model, null, pluginManager, null,true);
			}
			super.setProgress(PROGRESS_VALUE_INITIALIZE_SERIALIZER);
			super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_SERIALIZING));
			super.setProgress(PROGRESS_VALUE_SERIALIZING);
			emfSerializer.writeToFile(outputFile);
			publish(new COBieTaskProgress(PROGRESS_MESSAGE_DONE));
			setProgress(100);
			sleep();
		}
		catch(Exception ex)
		{
			super.handleExecutionException(new COBieTaskProgress(PROGRESS_MESSAGE_ERROR));
		}
		
		return null;
	}
	
	protected IfcModel deserializeCOBieSheetXMLDataToIfc() throws IfcModelInterfaceException
	{
		FromCOBieToIfc deserializer = 
				new FromCOBieToIfc(cobieSheetXMLData.getCOBIE());
		COBieIfcModel model = deserializer.getModelFromCOBie();
		model.forceAllObjectsAsDelegateLoaded();
		return model;
	}

}
