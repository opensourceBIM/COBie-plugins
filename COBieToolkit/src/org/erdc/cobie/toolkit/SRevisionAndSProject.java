package org.erdc.cobie.toolkit;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;

public class SRevisionAndSProject 
{
	private SProject project;
	private SRevision revision;
	public SProject getProject()
	{
		return project;
	}
	
	public SRevision getRevision()
	{
		return revision;
	}
	
	public SRevisionAndSProject(SRevision revision,SProject project)
	{
		this.revision = revision;
		this.project = project;
	}
}
