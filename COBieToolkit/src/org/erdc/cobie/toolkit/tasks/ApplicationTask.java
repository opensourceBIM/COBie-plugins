package org.erdc.cobie.toolkit.tasks;

import java.util.List;

import javax.swing.SwingWorker;

import org.erdc.cobie.shared.bimserver.COBieTaskProgress;
import org.erdc.cobie.shared.bimserver.Informable;

public abstract class ApplicationTask<T> extends SwingWorker<T, COBieTaskProgress>
{

	private static final int TASK_PAUSE_TIME_MS = 1000;
	private static final String MESSAGE_TASK_MESSAGE_DELIM = ": ";
	private static final String MESSAGE_DELIM_PROGRESS = "% Done ";
	private Informable informable;
	private boolean requiresRunningBiMServer;

	public ApplicationTask(Informable informable,boolean requiresRunningBiMServer)
	{
		super();
		setRequiresRunningBiMServer(requiresRunningBiMServer);
		this.informable = informable;
	}
	

	
	public void handleExecutionException(COBieTaskProgress message)
	{
		setProgress(0);
		publish(message);
		cancel(true);
		//sleep();
		
	}

	protected void sleep()
	{
		try
		{
			Thread.sleep(TASK_PAUSE_TIME_MS);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void process(List<COBieTaskProgress> chunks)
	{
		for (COBieTaskProgress message : chunks)
		{
			String messageText = message.getProgressText();
			if (message.getTaskName()!=null && message.getTaskName().length()>0)
			{
				
				if (messageText!=null && messageText.length()>0)
					message.setProgressText(String.valueOf(this.getProgress()+MESSAGE_DELIM_PROGRESS+message.getTaskName()+MESSAGE_TASK_MESSAGE_DELIM+message.getProgressText()));
				else 
					message.setProgressText(String.valueOf(this.getProgress()+MESSAGE_DELIM_PROGRESS+message.getTaskName()));
			}
			else
			{
				if (messageText!=null && messageText.length()>0)
					message.setProgressText(String.valueOf(this.getProgress())+MESSAGE_DELIM_PROGRESS+MESSAGE_TASK_MESSAGE_DELIM+message.getProgressText());
				else
					message.setProgressText(String.valueOf(this.getProgress()+MESSAGE_DELIM_PROGRESS+message.getTaskName()));
			}
			informable.messageChanged(message);
		}
	}
	

 
	
	public boolean isBusy()
	{
		return (getState()==StateValue.STARTED);
	}



	public boolean isRequiresRunningBiMServer()
	{
		return requiresRunningBiMServer;
	}



	protected void setRequiresRunningBiMServer(boolean requiresRunningBiMServer)
	{
		this.requiresRunningBiMServer = requiresRunningBiMServer;
	}
	

}
