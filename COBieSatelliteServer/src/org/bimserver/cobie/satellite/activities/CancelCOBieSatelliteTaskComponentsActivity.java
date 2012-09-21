package org.bimserver.cobie.satellite.activities;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.tasks.ApplicationTask;
import org.bimserver.cobie.satellite.tasks.BimServerTaskConnectable;
import org.bimserver.cobie.satellite.gui.controls.COBieTaskComponent;


public class CancelCOBieSatelliteTaskComponentsActivity extends Activity
{
	ArrayList<COBieTaskComponent> taskComponents;
	public CancelCOBieSatelliteTaskComponentsActivity(List<COBieTaskComponent> taskComponents)
	{
		super();
		this.taskComponents = new ArrayList(taskComponents);
	}

	@Override
	public void activate(CobieSatelliteServer satelliteServer)
	{
		satelliteServer.getBimServerClient().registerNotificationListener(this);
		
	}

	@Override
	public void deactivate(CobieSatelliteServer satelliteServer)
	{
		satelliteServer.getBimServerClient().unregisterNotificationListener(this);
		
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "CancelCOBieSatelliteTaskComponentsActivity";
	}

	@Override
	public void serverWillBeShutdown()
	{
		// TODO Auto-generated method stub
		for(COBieTaskComponent taskComponent:taskComponents)
		{

			if (taskComponent instanceof ApplicationTask)
			{
				ApplicationTask applicationTask =
						(ApplicationTask) taskComponent;
				if(applicationTask!=null && applicationTask instanceof BimServerTaskConnectable)
				{	
					applicationTask.cancel(applicationTask.isBusy());
				}
			}

		}
	}

}
