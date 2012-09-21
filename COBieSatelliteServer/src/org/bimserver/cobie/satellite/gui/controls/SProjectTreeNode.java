package org.bimserver.cobie.satellite.gui.controls;

import javax.swing.tree.DefaultMutableTreeNode;

import org.bimserver.interfaces.objects.SProject;

public class SProjectTreeNode extends DefaultMutableTreeNode
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SProject project;

	public SProjectTreeNode(String name)
	{
		// TODO Auto-generated constructor stub
		super(name);
	}

	public SProject getProject()
	{
		return project;
	}

	public void setProject(SProject project)
	{
		this.project = project;
	}

}
