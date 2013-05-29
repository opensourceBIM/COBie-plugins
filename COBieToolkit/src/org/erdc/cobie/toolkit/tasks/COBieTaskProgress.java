package org.erdc.cobie.toolkit.tasks;

public class COBieTaskProgress
{
	private String progressText;
	private String currentSubTask;
	public String getProgressText()
	{
		return progressText;
	}

	public void setProgressText(String progressText)
	{
		this.progressText = progressText;
	}
	
	public COBieTaskProgress(String message)
	{
		setProgressText(message);
		currentSubTask = "";
	}
	
	public COBieTaskProgress(String message, String currentSubTask)
	{
		setSubTaskName(currentSubTask);
		setProgressText(message);
	}

	public String getTaskName()
	{
		return currentSubTask;
	}

	public void setSubTaskName(String subTaskName)
	{
		this.currentSubTask = subTaskName;
	}
}
