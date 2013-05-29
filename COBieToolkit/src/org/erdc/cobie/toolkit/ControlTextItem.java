package org.erdc.cobie.toolkit;

public class ControlTextItem
{
    private static final int HASH_OFFSET = 217;// Arbitrary number used to
    private String key;
    private String displayText;
    private String toolTip;
    private String longDescription;

    public ControlTextItem(String key, String displayText, String toolTip, String longDescription)
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
        if (obj == this)
        {
            isEqual = true;
        } else if ((obj != null) && (obj.getClass() == this.getClass()))
        {
            ControlTextItem castedObj = (ControlTextItem)obj;
            isEqual = (castedObj.getKey().equals(getKey()));
        }
        return isEqual;
    }

    public String getDisplayText()
    {
        return displayText;
    }

    public String getKey()
    {
        return key;
    }

    public String getLongDescription()
    {
        return longDescription;
    }

    public String getToolTip()
    {
        return toolTip;
    }

    @Override
    public int hashCode()
    {
        return HASH_OFFSET + (getKey() == null ? 0 : getKey().hashCode());
    }

    public void setDisplayText(String displayText)
    {
        this.displayText = displayText;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setLongDescription(String longDescription)
    {
        this.longDescription = longDescription;
    }

    public void setToolTip(String toolTip)
    {
        this.toolTip = toolTip;
    }

}
