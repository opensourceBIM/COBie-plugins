package org.erdc.cobie.toolkit;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import org.bimserver.plugins.objectidms.ObjectIDMPlugin;

public class ControlTextItem
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8992708600172622967L;
	private static final int HASH_OFFSET = 217;//Arbitrary number used to 
	private String key;
	private String displayText;
	private String toolTip;
	private String longDescription;
	
	public ControlTextItem(String key, String displayText, String toolTip,String longDescription)
	{
		setKey(key);
		setDisplayText(displayText);
		setToolTip(toolTip);
		setLongDescription(longDescription);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean isEqual = false;
		if (obj==this)
			isEqual = true;
		else
		if((obj != null) && (obj.getClass() == this.getClass()))
		{
			ControlTextItem castedObj =
					(ControlTextItem) obj;
			isEqual =
					(castedObj.getKey().equals(this.getKey()));
		}
		return isEqual;
	}
	
	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getDisplayText()
	{
		return displayText;
	}

	public void setDisplayText(String displayText)
	{
		this.displayText = displayText;
	}

	public String getToolTip()
	{
		return toolTip;
	}

	public void setToolTip(String toolTip)
	{
		this.toolTip = toolTip;
	}

	@Override
	public int hashCode()
	{
		return HASH_OFFSET+(getKey()==null ? 0: getKey().hashCode());
	}

	public String getLongDescription()
	{
		return longDescription;
	}

	public void setLongDescription(String longDescription)
	{
		this.longDescription = longDescription;
	}


}
