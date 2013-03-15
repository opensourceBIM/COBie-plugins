package org.erdc.cobie.toolkit.gui.controls;

import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.erdc.cobie.toolkit.gui.CobieToolkitGuiHelper;

public class BimServerModelTree extends JTree
{

	/**
	 * 
	 */
	private static final String DEFAULT_JTREE_ROOT_NAME = "BiMServer Models";

	private static final long serialVersionUID = 1L;
	private ServiceInterface service;
	
	public ServiceInterface getService()
	{
		return service;
	}

	public void setService(ServiceInterface service)
	{
		this.service = service;
	}

	public BimServerModelTree()
	{
		super();
	}
	
	public BimServerModelTree(ServiceInterface service)
	{
		super();
		this.service = service;
		dataBind();
	}
	

	public void dataBind()
	{
		try
		{
			if (service == null)
			{
				throw new UserException("BiMServer Service Interface has not been instantiated");
			}
			DefaultMutableTreeNode treeNode =
					new DefaultMutableTreeNode(DEFAULT_JTREE_ROOT_NAME);
			DefaultTreeModel treeModel = new DefaultTreeModel(treeNode); 
			List<SProject> projects = CobieToolkitGuiHelper.getTopLevelProjects(service);
			processProjectHierarchy(treeNode,projects);
			setModel(treeModel);
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


	
	private void processProjectHierarchy(DefaultMutableTreeNode node, List<SProject> projects)
	{
		for(SProject project: projects)
		{
			List<Long> subProjects = project.getSubProjects();
			SProjectTreeNode child =
					new SProjectTreeNode(project.getName());
			child.setProject(project);
			node.add(child);
			if (subProjects.size()>0)
				processProjectHierarchy(child,CobieToolkitGuiHelper.getSubProjectsFromOids(project.getSubProjects(),service));
		}
	}
	
	
}
