package org.bimserver.cobie.satellite.gui.controls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.bimserver.cobie.satellite.SRevisionAndSProject;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class SProjectTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> columnNames = new ArrayList<String>(Arrays.asList("Revision","Project","Size","Comments"));
	private SProject project;
	private ArrayList<SRevision> revisions;
	
	private ServiceInterface service;
	public SProjectTableModel()
	{
		super();
		revisions = new ArrayList<SRevision>();
	}
	
	
	
	public SProjectTableModel(SProject project, ServiceInterface service)
	{
		this.service = service;
		this.project = project;
		revisions = new ArrayList<SRevision>();
		populateRevisions(project);
		this.fireTableStructureChanged();
		this.fireTableDataChanged();
	}
	
	public Class getColumnClass(int c) {
	    return getValueAt(0, c).getClass();
	}
	 @Override
	public int getColumnCount()
	{
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	    public String getColumnName(int col) {
		        return columnNames.get(col);
		    }
	
	public ArrayList<SRevision> getRevisions()
	{
		return revisions;
	}
	
	public ArrayList<SRevisionAndSProject> getRevisionsWithTheirProjects()
	{
		ArrayList<SRevisionAndSProject> revisionsWithProjects =
				new ArrayList<SRevisionAndSProject>();
		for(SRevision revision:revisions)
		{
			try
			{
				SProject matchingProject =
						service.getProjectByPoid(revision.getProjectId());
				revisionsWithProjects.add(new SRevisionAndSProject(revision,matchingProject));
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
		return revisionsWithProjects;
	}

	@Override
	public int getRowCount()
	{
		// TODO Auto-generated method stub
		return revisions.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		// TODO Auto-generated method stub
		SRevision revision = revisions.get(rowIndex);
		String returnValue;
		switch(columnIndex)
		{
			case 0:
				returnValue = String.valueOf(revision.getId());
				break;
			case 1:
				returnValue = projectStringFromProjectId(revision.getProjectId());
				break;
			case 2:
				returnValue = String.valueOf(revision.getSize());
				break;
			case 3:
				returnValue = String.valueOf(revision.getComment());
				break;
			default:
				returnValue="";
				break;
		}
		return returnValue;
		
	}
	private void populateRevisions()
	{
		
		List<Long> revisionIds =
				project.getRevisions();

		for(long revisionId:revisionIds)
		{
			try
			{
				SRevision revision =
						service.getRevision(revisionId);

				if (!revisionExists(revision))
					revisions.add(service.getRevision(revisionId));
				
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


	private void populateRevisions(SProject project)
	{
		List<Long> subprojects =
				project.getSubProjects();

			for(long projectId:subprojects)
			{
				SProject subProject;
				try
				{
					subProject = service.getProjectByPoid(projectId);
					populateRevisions(subProject);
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
		


			if (project.getConcreteRevisions().size()>0)
			{
				List<Long> revisionIds =
						project.getRevisions();
				for(long revisionId:revisionIds)
				{
					try
					{
						SRevision revision =
								service.getRevision(revisionId);
						if (!revisionExists(revision))
							revisions.add(service.getRevision(revisionId));
						
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


	}

	private String projectStringFromProjectId(long projectId)
	{
		
		String projectString = "";
		try
		{
			projectString = service.getProjectByPoid(projectId).getName();
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
		catch(Exception e)
		{
			
		}
		return projectString;
	}
	
	
	private boolean revisionExists(SRevision revision)
	{
		boolean exists = false;
		for(SRevision tempRevision:revisions)
		{
			if (revision.getLastConcreteRevisionId()==tempRevision.getLastConcreteRevisionId())
				exists = true;
		}
		return exists;
	}
	


}
