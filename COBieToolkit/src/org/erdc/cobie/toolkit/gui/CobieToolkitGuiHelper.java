package org.erdc.cobie.toolkit.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class CobieToolkitGuiHelper
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
		List<SProject> projects = serviceInterface.getAllProjects(true);
		return projects;
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
