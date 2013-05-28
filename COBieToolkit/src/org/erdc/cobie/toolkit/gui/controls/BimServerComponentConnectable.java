package org.erdc.cobie.toolkit.gui.controls;

public interface BimServerComponentConnectable
{
	public void onConnect();
	public void onDisconnect();
	public void refresh();
}
