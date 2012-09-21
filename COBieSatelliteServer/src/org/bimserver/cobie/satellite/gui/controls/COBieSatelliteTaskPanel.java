package org.bimserver.cobie.satellite.gui.controls;

import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.shared.ConnectDisconnectListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class COBieSatelliteTaskPanel<T> extends COBieApplicationTaskPanel<T> implements BimServerComponentConnectable
{

	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieSatelliteTaskPanel.class);
	private static final long serialVersionUID = 1L;
	private CobieSatelliteServer satelliteServer;
	private boolean RequiresRunningBiMServer;
	public CobieSatelliteServer getSatelliteServer()
	{
		return satelliteServer;
	}
	public void setSatelliteServer(final CobieSatelliteServer satelliteServer)
	{
		this.satelliteServer = satelliteServer;
	}
	
	@Override
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		if(!enabled)
			onDisconnect();
	}
	


	
	public COBieSatelliteTaskPanel(final CobieSatelliteServer satelliteServer,boolean requiresRunningBiMServer)
	{
		super();
		setRequiresRunningBiMServer(requiresRunningBiMServer);
		setSatelliteServer(satelliteServer);
		try
		{
			satelliteServer.getBimServerGuiClient().registerConnectDisconnectListener(new ConnectDisconnectListener() {
				@Override
				public void connected() 
				{
					try
					{
						onConnect();
					}
					catch(Exception e)
					{
						handleError("An exception occured while refreshing a user interface element during BiMServer connect",
								e, LOGGER, false);
					}
				}

				@Override
				public void disconnected() 
				{
					try
					{
						onDisconnect();
						getToggleComponents().disableAllControls();
						
					}
					catch(Exception e)
					{
						handleError("An exception occured while refreshing a user interface element during BiMServer disconnect",
								e, LOGGER, false);
					}
				}
				

			});
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	public boolean isRequiresRunningBiMServer()
	{
		return RequiresRunningBiMServer;
	}
	protected void setRequiresRunningBiMServer(boolean requiresRunningBiMServer)
	{
		RequiresRunningBiMServer = requiresRunningBiMServer;
	}
	
	
}
