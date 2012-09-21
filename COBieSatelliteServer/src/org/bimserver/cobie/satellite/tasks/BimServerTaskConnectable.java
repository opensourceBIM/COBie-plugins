package org.bimserver.cobie.satellite.tasks;

import org.bimserver.cobie.satellite.CobieSatelliteServer;

public interface BimServerTaskConnectable
{
	public CobieSatelliteServer getSatelliteServer();
	public void setSatelliteServer(final CobieSatelliteServer satelliteServer);
	
}
