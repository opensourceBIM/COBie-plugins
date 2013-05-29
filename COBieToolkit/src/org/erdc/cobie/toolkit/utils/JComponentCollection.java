package org.erdc.cobie.toolkit.utils;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JComponent;

public class JComponentCollection extends ArrayList<JComponent>
{
	/**
     * 
     */
    private static final long serialVersionUID = -7970475468781232921L;

    public JComponentCollection()
	{
		super();
	}
	public void disableAllControls()
	{
		for(JComponent component:this)
		{
			component.setEnabled(false);
		}
	}
	public void enableAllControls()
	{
		for(JComponent component:this)
		{
			component.setEnabled(true);
		}
	}
	
	@Override
	public boolean add(JComponent component)
	{
		addComopnentAndChildrenToCollection(component);
		return true;
		
	}
	
	private void addComopnentAndChildrenToCollection(JComponent component)
	{
		super.add(component);
		
		for(Component genericComponent:component.getComponents())
		{
			if (genericComponent instanceof JComponent)
			{
				addComopnentAndChildrenToCollection((JComponent)genericComponent);
			}
		}
	}
}
