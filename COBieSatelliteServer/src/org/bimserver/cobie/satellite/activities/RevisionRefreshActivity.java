package org.bimserver.cobie.satellite.activities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.gui.controls.COBieSatelliteTaskPanel;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.shared.exceptions.ServiceException;

public class RevisionRefreshActivity extends Activity
{
	private static final String COMMENT_TAG = "RefreshOnRevision";
	private CobieSatelliteServer satelliteServer;
	private final Set<Activity> activities = new HashSet<Activity>();
	@SuppressWarnings("rawtypes")
	private List<COBieSatelliteTaskPanel> taskPanels;
	public RevisionRefreshActivity()
	{
		taskPanels = new ArrayList<COBieSatelliteTaskPanel>();
	}
	
	public <T> void addCOBieSatelliteTaskPanel(COBieSatelliteTaskPanel<T> taskPanel)
	{
		this.taskPanels.add(taskPanel);
	}
	
	@Override
	public void activate(CobieSatelliteServer satelliteServer)
	{
		this.satelliteServer = satelliteServer;
		satelliteServer.getBimServerClient().registerNotificationListener(this);
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate(CobieSatelliteServer satelliteServer)
	{

			satelliteServer.getBimServerClient().unregisterNotificationListener(this);
	}
	
	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException 
	{
		try
		{
			for(COBieSatelliteTaskPanel taskPanel:taskPanels)
			{
				taskPanel.refresh();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return COMMENT_TAG;
	}

}
