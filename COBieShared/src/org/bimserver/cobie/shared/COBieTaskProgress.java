package org.bimserver.cobie.shared;

public class COBieTaskProgress
{
	private String progressText;
	private String currentAction;
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
		currentAction = "";
	}
	
	public COBieTaskProgress(String message, String currentAction)
	{
		setSubTaskName(currentAction);
		setProgressText(message);
	}

	public String getTaskName()
	{
		return currentAction;
	}

	public void setSubTaskName(String currentAction)
	{
		this.currentAction = currentAction;
	}
}
