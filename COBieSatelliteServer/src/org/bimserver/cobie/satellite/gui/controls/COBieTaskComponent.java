package org.bimserver.cobie.satellite.gui.controls;

import org.bimserver.cobie.satellite.tasks.ApplicationTask;


public interface COBieTaskComponent
{
	 void initializeToggleComponents();
	 void initializeProgressComponents();
	 ApplicationTask getCOBieSatelliteApplicationTask();
	 void executeInstantiatedTask(ApplicationTask task) 
	 	throws Exception;
}
