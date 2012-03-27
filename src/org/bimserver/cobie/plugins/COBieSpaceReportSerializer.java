package org.bimserver.cobie.plugins;

import java.io.OutputStream;
import java.io.PrintWriter;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieSpaceReportSerializer extends COBieLiteSerializer

{
	private static final String HELLO_WORLD_PATH = "../COBiePlugins/lib/BIRT_REPORTS/HelloWorld.rptdesign";
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieSpaceReportSerializer.class);
	private PrintWriter out;
	public COBieSpaceReportSerializer()
	{
		super();
	}
	
	protected void reset() 
	{
		super.reset();
	}
	
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException 
	{
		super.init(model, projectInfo, pluginManager);
	}
	
	@Override
	public boolean write(OutputStream outputStream) throws SerializerException {
	//	if (out == null) 
		//{
		//	this.out = new UTF8PrintWriter(outputStream);
		//}
		
		if (getMode() == Mode.BODY) 
		{
			//this.out = new UTFPrintWriter(out);
			try
			{
				writeReport(outputStream);
				//this.out.flush();
				setMode(Mode.FINISHED);
				return true;
			}
			catch (Exception e)
			{
				//this.out.flush();
				setMode(Mode.FINISHED);
				LOGGER.error(e.getMessage());
				return false;
			}



		} 
		else if (getMode() == Mode.FINISHED) 
		{
			return false;
		}
		return false;
		
	}
	
	private void writeReport(OutputStream oStream)
	{
		/*EngineConfig config= new EngineConfig( );
		IReportEngine engine = null;
		try{
			//delete the following line if using BIRT 3.7 or later
		//	config.setEngineHome( "C:\birt-runtime-2_1_0\birt-runtime-2_1_0\ReportEngine" );
		//	config.setLogConfig(c:/temp, Level.FINE);
					
			Platform.startup( config );  //If using RE API in Eclipse/RCP application this is not needed.
			IReportEngineFactory factory = (IReportEngineFactory) Platform
					.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
			engine = factory.createReportEngine( config );
			//engine.changeLogLevel( Level.WARNING );
					
		}catch( Exception ex){
			ex.printStackTrace();
		}
		IReportRunnable design=null;
		try {
			design = engine.openReportDesign(this.HELLO_WORLD_PATH);
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IRunAndRenderTask task = engine.createRunAndRenderTask(design); 
		HTMLRenderOption options = new HTMLRenderOption();
		options.setOutputStream(oStream);
		task.setRenderOption(options);		
		//run the report
		try {
			task.run();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		engine.destroy();
//	Platform.shutdown();    */
		
	}
}
