package org.erdc.cobie.toolkit.gui.controls;

import org.bimserver.shared.ConnectDisconnectListener;
import org.erdc.cobie.toolkit.CobieToolkit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class COBieToolkitTaskPanel<T> extends COBieApplicationTaskPanel<T> implements BimServerComponentConnectable
{

	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieToolkitTaskPanel.class);
	private static final long serialVersionUID = 1L;
	private CobieToolkit cobieToolkit;
	private boolean RequiresRunningBiMServer;
	public CobieToolkit getCobieToolkit()
	{
		return cobieToolkit;
	}
	public void setCobieToolkit(final CobieToolkit cobieToolkit)
	{
		this.cobieToolkit = cobieToolkit;
	}
	
	@Override
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		if(!enabled)
			onDisconnect();
	}
	


	
	public COBieToolkitTaskPanel(final CobieToolkit cobieToolkit,boolean requiresRunningBiMServer)
	{
		super();
		setRequiresRunningBiMServer(requiresRunningBiMServer);
		setCobieToolkit(cobieToolkit);
			
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
