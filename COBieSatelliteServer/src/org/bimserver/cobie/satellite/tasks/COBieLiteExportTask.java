package org.bimserver.cobie.satellite.tasks;

import java.io.File;

import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.plugins.COBieLiteSerializer;
import org.bimserver.cobie.satellite.tasks.DeserializeToCOBieLiteTask.TaskStep;
import org.bimserver.cobie.utils.deserializer.FromCOBieToIfc;
import org.bimserver.ifc.IfcModel;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class COBieLiteExportTask extends ApplicationTask<Void>
{
	private static final int PROGRESS_VALUE_SERIALIZING = 50;
	private static final int PROGRESS_VALUE_INITIALIZE_SERIALIZER = 45;
	private static final int PROGRESS_VALUE_DESERIALIZE = 40;
	private static final String PROGRESS_MESSAGE_DONE = "Done";
	private static final String PROGRESS_MESSAGE_STARTING = "Begin export";
	private static final String PROGRESS_MESSAGE_DESERIALIZE = "Deriving Ifc Model Objects";
	private static final String PROGRESS_MESSAGE_INITIALIZE_SERIALIZER = "Initializing Serializer";
	private static final String PROGRESS_MESSAGE_SERIALIZING = "Executing Serialize Routine";
	private static final String PROGRESS_MESSAGE_ERROR = "An error occured while exporting COBieLite.  Select another file to try again";
	SerializerPlugin serializerPlugin;
	COBIEDocument cobieLite;
	IfcModel model;
	PluginManager pluginManager;
	File outputFile;
	public COBieLiteExportTask(Informable informable,
			boolean requiresRunningBiMServer,SerializerPlugin serializerPlugin,
			PluginManager pluginManager,
			COBIEDocument cobieLite,File outputFile)
	{
		super(informable, requiresRunningBiMServer);
		this.serializerPlugin = serializerPlugin;
		this.cobieLite = cobieLite;
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
			EmfSerializer emfSerializer = serializerPlugin.createSerializer();
			if(model==null && !(emfSerializer instanceof COBieLiteSerializer))
			{
				model = deserializeCOBieLiteToIfc();
				super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_DESERIALIZE));
				super.setProgress(PROGRESS_VALUE_DESERIALIZE);
			}

			super.publish(new COBieTaskProgress(PROGRESS_MESSAGE_INITIALIZE_SERIALIZER));
			
			if(emfSerializer instanceof COBieLiteSerializer)
			{
				((COBieLiteSerializer)emfSerializer).init(pluginManager,cobieLite);
			}
			else
			{
				emfSerializer.init(model, null, pluginManager, null);
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
	
	protected IfcModel deserializeCOBieLiteToIfc()
	{
		FromCOBieToIfc deser = 
				new FromCOBieToIfc(cobieLite.getCOBIE());
		return deser.getModelFromCOBie();
	}

}
