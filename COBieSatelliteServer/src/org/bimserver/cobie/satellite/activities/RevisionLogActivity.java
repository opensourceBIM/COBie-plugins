package org.bimserver.cobie.satellite.activities;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.activities.Activity;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class RevisionLogActivity extends Activity {
	private static final String COMMENT_TAG = "NameChange";
	private CobieSatelliteServer satelliteServer;
	private final Set<Activity> activities = new HashSet<Activity>();
	@Override
	public void activate(CobieSatelliteServer satelliteServer) {
		this.satelliteServer = satelliteServer;
		satelliteServer.getBimServerClient().registerNotificationListener(this);
	}

	@Override
	public void deactivate(CobieSatelliteServer satelliteServer) {
		satelliteServer.getBimServerClient().unregisterNotificationListener(this);
	}

	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException 
	{
		try
		{
			long projectId = newRevisionNotification.getProjectId();
			long revisionId = newRevisionNotification.getRevisionId();
			log("Project "+String.valueOf(projectId)+" revised with rid "+String.valueOf(revisionId));
		}
		catch(Exception e)
		{
			
		}

	}
	
	@Override
	public String getName() {
		return "RevisionLog";
	}
}