package org.bimserver.cobie.satellite.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import org.bimserver.client.BimServerClient;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.gui.controls.SProjectTreeNode;
import org.bimserver.interfaces.objects.SObjectState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class CobieSatelliteGuiHelper
{
	private static final int BIMSERVER_ROOT_PARENTID = -1;
	public static void populateRevisionTable(JTable table, ServiceInterface serviceInterface, SProject project)
	{
		for(long revisionId:project.getRevisions())
		{
			try
			{
				SRevision revision = serviceInterface.getRevision(revisionId);
				
			}
			catch (ServerException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (UserException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static List<SProject> getTopLevelProjects(
			ServiceInterface serviceInterface) throws ServerException,
			UserException
	{
		List<SProject> projects = serviceInterface.getAllProjects();
		ArrayList<SProject> topLevelProjects =
				new ArrayList<SProject>();
		for(SProject project:projects)
		{
			if(project.getParentId()==BIMSERVER_ROOT_PARENTID && project.getState()==SObjectState.ACTIVE)
			{
				topLevelProjects.add(project);
			}
		}
		return topLevelProjects;
	}
	public static List<SProject> getSubProjectsFromOids(List<Long> projectOids, ServiceInterface service)
	{
		ArrayList<SProject> projects = new ArrayList<SProject>();
		for(long oid: projectOids)
		{
			try
			{
				SProject project = service.getProjectByPoid(oid);
				projects.add(project);
			}
			catch (ServerException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (UserException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return projects;
	}
}
