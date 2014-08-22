package org.erdc.cobie.shared;

import org.erdc.cobie.shared.utility.StringTable;
import org.erdc.cobie.shared.utility.StringUtils;

public enum WarrantyCategory implements StringTable
{
	LABOR("Labor"),
	PARTS("Parts");

	private final String string;
	
	private WarrantyCategory(String s)
	{
		this.string = s;
	}
	
	public static WarrantyCategory valueOfString(String warrantyCategory)
	{
		WarrantyCategory returnValue = null;
		for(WarrantyCategory warrantyCategoryEnum : WarrantyCategory.values())
		{
			if(warrantyCategoryEnum.toString().equalsIgnoreCase(warrantyCategory))
			{
				returnValue = warrantyCategoryEnum;
				break;
			}
		}
		return returnValue;
	}
	
	
	@Override
	public String format(Object... args)
	{
		return String.format(string, args);
	}

	@Override
	public String postfix(String s)
	{
		return StringUtils.concatenate(string, s, Common.TEXT_SEPARATOR.toString());
	}

	@Override
	public String prefix(String s)
	{
		return StringUtils.concatenate(s, string, Common.TEXT_SEPARATOR.toString());
	}

	@Override
	public String toString()
	{
		return string;
	}

}
