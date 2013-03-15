package org.erdc.cobie.toolkit.gui.controls;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.erdc.cobie.toolkit.ControlTextItem;
import org.erdc.cobie.toolkit.SRevisionAndSProject;

public class BiMServerModelLabelRenderer extends JLabel implements
		ListCellRenderer
{

	ListCellRenderer defaultRenderer;
	private Object underlyingItem;
	public BiMServerModelLabelRenderer()
	{
		this.setOpaque(true);
	}
	
	public BiMServerModelLabelRenderer(ListCellRenderer renderer)
	{
		defaultRenderer = renderer;
		this.setOpaque(true);
	}
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus)
	{
		setUnderlyingItem(value);
		 setLabelText(value);
		 Color background;
         Color foreground;

         if (isSelected) 
         {
             background = list.getSelectionBackground();
             foreground = list.getSelectionForeground();
         }

       else 
       {
        	 background = list.getBackground();
             foreground = list.getForeground();
       };

       setBackground(background);
       setForeground(foreground);
       return this;
	}
	
	private void setLabelText(Object value)
	{

		this.setText(getLabelText(value));
	}
	
	private String getLabelText(Object value)
	{
		String labelText = "";
		if (value instanceof SRevision)
		{
			SRevision revision = (SRevision) value;
			labelText = getRevisionLabelString(revision);
		}
		else if (value instanceof SProject)
		{
			SProject project = (SProject) value;
			labelText = getProjectLabelString(project);
		}
		else if (value instanceof SRevisionAndSProject)
		{
			SRevisionAndSProject revisionProject =
					(SRevisionAndSProject) value;
			labelText = getRevisionProjectLabelString(revisionProject);
		}
		else if(value instanceof ControlTextItem)
		{
			ControlTextItem controlTextItem = (ControlTextItem) value;
			labelText = controlTextItem.getKey();
		}
		return labelText;
	}
	
	private String getRevisionProjectLabelString(
			SRevisionAndSProject revisionProject)
	{
		// TODO Auto-generated method stub
		return 			getRevisionLabelString(revisionProject.getRevision())+": "+
				getProjectLabelString(revisionProject.getProject());
	
	}

	private String getRevisionLabelString(SRevision revision)
	{
		return String.valueOf(revision.getId());
	}
	
	private String getProjectLabelString(SProject project)
	{
		return project.getName();
	}

	public Object getUnderlyingItem()
	{
		return underlyingItem;
	}

	private void setUnderlyingItem(Object underlyingItem)
	{
		this.underlyingItem = underlyingItem;
	}

}
