package org.erdc.cobie.toolkit.gui.controls;

import org.erdc.cobie.toolkit.tasks.ApplicationTask;


public interface COBieTaskComponent
{
	 void initializeToggleComponents();
	 void initializeProgressComponents();
	 ApplicationTask getCOBieSatelliteApplicationTask();
	 void executeInstantiatedTask(ApplicationTask task) 
	 	throws Exception;
}
