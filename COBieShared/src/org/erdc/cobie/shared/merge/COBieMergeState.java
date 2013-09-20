package org.erdc.cobie.shared.merge;


public class COBieMergeState extends java.awt.Component
{
    public enum MergeMode
    {
        Idle, Initializing, PreparingBaseItems, PreparingRevisionItems, Comparing, Merging, Done
    }

    public static final int NULL_PROGRESS = -1;
    private static final String STATUS_MESSAGE_DEFAULT = "";
    private static final String STATUS_MESSAGE_FORMATSTRING = "COBie Merge(%s): %s";
    // private static final String
    public static final String PROPERTY_NAME_PROGRESS = "progress";
    public static final String PROPERTY_NAME_STATUS_MESSAGE = "statusMessage";
    public static final String PROPERTY_NAME_MODE = "mode";
    private static final long serialVersionUID = -2938814027171706018L;;
    private MergeMode mode;
    private String statusMessage;
    private int progress;

    public COBieMergeState()
    {
        mode = MergeMode.Idle;
        progress = 0;
        statusMessage = STATUS_MESSAGE_DEFAULT;
    }

    public MergeMode getMode()
    {
        return mode;
    }

    public int getProgress()
    {
        return progress;
    }

    public String getStatusMessage()
    {
        return statusMessage;
    }

    public void setMode(MergeMode mode)
    {
        this.mode = mode;
    }

    public void setProgress(int progress)
    {
        this.progress = progress;
    }

    public void setStatusMessageSuffix(String messageSuffix)
    {
        statusMessage = String.format(STATUS_MESSAGE_FORMATSTRING, mode.toString(), messageSuffix);
    }
}
