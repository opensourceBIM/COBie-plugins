package org.bimserver.cobie.satellite.gui.controls;

public interface BimServerComponentConnectable
{
	public void onConnect();
	public void onDisconnect();
	public void refresh();
}
