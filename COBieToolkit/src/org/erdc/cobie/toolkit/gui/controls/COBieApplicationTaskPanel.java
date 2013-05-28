package org.erdc.cobie.toolkit.gui.controls;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.erdc.cobie.toolkit.tasks.ApplicationTask;
import org.erdc.cobie.toolkit.tasks.COBieTaskProgress;
import org.erdc.cobie.toolkit.tasks.Informable;
import org.erdc.cobie.toolkit.utils.JComponentCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class COBieApplicationTaskPanel<T> extends JPanel
implements ActionListener, PropertyChangeListener
{

	public enum TaskPanelStateValue {Initialized,TaskStarted,TaskDone}
	private TaskPanelStateValue state;
	public static final String PROPERTY_NAME_SWING_WORKER_PROGRESS = "progress";
	public static final String PROPERTY_NAME_TASK_PANEL_STATE = "state";
	public enum PROGRESS_TEXTAREA_TYPE {textbox,label};
	private static final long serialVersionUID = 1L;
	private JComponentCollection taskComponents;
	private JProgressBar progressBar;
	private JComponent progressTextArea;
	private ApplicationTask<T> primaryTask;
	private Informable informable;
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieApplicationTaskPanel.class);
	public COBieApplicationTaskPanel()
	{
		 setInformable(new Informable()
		 {
		      @Override
		      public void messageChanged(COBieTaskProgress message){
		    	  updateTextArea(message.getProgressText());
		      }
		 });
		 setState(TaskPanelStateValue.Initialized);
	}
	
	public abstract JComponent[] getDefaultToggleComponents();
	
	
	    protected void updateTextArea(String text)
		{
			if (progressTextArea instanceof JTextArea)
			{
				JTextArea progressJTextArea =
						(JTextArea) progressTextArea;

			    	progressJTextArea.append(text);
			    	

			}
			else if (progressTextArea instanceof JLabel)
			{
				JLabel progressLabel =
						(JLabel) progressTextArea;
				progressLabel.setText(text);
				LOGGER.info(text);
			}

		}	 
		 
	@SuppressWarnings("unchecked")
    public final void executeInstantiatedTask(@SuppressWarnings("rawtypes") ApplicationTask cobieTask) throws Exception
	{
		try
		{
			setPrimaryTask(cobieTask);
			initializeToggleComponents();
			taskComponents.disableAllControls();	
			cobieTask.execute();
			updateTextArea("");
			progressBar.setValue(0);
			makeProgressComponentsVisible();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void makeProgressComponentsVisible()
	{
		progressTextArea.setEnabled(true);
		progressTextArea.setVisible(true);
		progressBar.setEnabled(true);
		progressBar.setVisible(true);
	}
	
	public final void initializeProgressComponents()
	{
		progressTextArea.setVisible(false);
		progressBar.setVisible(false);
	}
	
	
	@Override 
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		if(primaryTask!=null && primaryTask instanceof BimServerComponentConnectable)
		{
			if(primaryTask.isBusy())
				primaryTask.cancel(true);
		}
	}
	
	public JComponentCollection getToggleComponents()
	{
		return taskComponents;
	}
	public void setToggleComponents(JComponentCollection toggleComponents)
	{
		this.taskComponents = toggleComponents;
	}
	public JProgressBar getProgressBar()
	{
		return progressBar;
	}
	public void setProgressBar(JProgressBar progressBar)
	{
		this.progressBar = progressBar;
	}
	public JComponent getProgressTextArea()
	{
		return progressTextArea;
	}
	public void setProgressTextArea(JComponent progressTextArea)
	{
		this.progressTextArea = progressTextArea;
	}
	

	private void momentarilyShowProgressTextArea()
	{
		progressTextArea.setVisible(true);
//		progressTextArea.updateUI();
	/*	try
		{
			Thread.sleep(ERROR_SHOW_DURATION_MILLISECONDS);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//progressTextArea.setVisible(false);
	}
	
	public void handleValidationError(String messagePrefix, boolean appendTextArea)
	{
		try
		{
			if (progressTextArea instanceof JLabel)
			{
				JLabel textComponent =
						(JLabel) progressTextArea;
				if (appendTextArea)
					textComponent.setText(textComponent.getText()+messagePrefix);
				else
					textComponent.setText(messagePrefix);
			}
			else if (progressTextArea instanceof JTextArea)
			{
				JTextArea textComponent =
						(JTextArea) progressTextArea;
				if (appendTextArea)
					textComponent.setText(textComponent.getText()+messagePrefix);
				else
					textComponent.setText(messagePrefix);
			}

			momentarilyShowProgressTextArea();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
	
	public void handleError(String messagePrefix,Exception e,Logger logger,boolean appendTextArea)
	{
		try
		{
			handleValidationError(messagePrefix,appendTextArea);
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		try
		{
			logger.error(messagePrefix+":  "+e.getMessage());
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		e.printStackTrace();
			
	}
	public ApplicationTask<T> getPrimaryTask()
	{
		return primaryTask;
	}
	public void setPrimaryTask(ApplicationTask<T> primaryTask)
	{
		this.primaryTask = primaryTask;
		primaryTask.addPropertyChangeListener(COBieApplicationTaskPanel.this);
	}
	
	public abstract T getCOBieSatelliteApplicationTask();
 


	public final void initializeToggleComponents()
	{
		taskComponents = new JComponentCollection();
		JComponent[] defaultToggleComponents =
				getDefaultToggleComponents();
		for(JComponent component:defaultToggleComponents)
			taskComponents.add(component);
		
	}

	
	public void propertyChange(PropertyChangeEvent event)
	{
		if(event.getSource()==this.primaryTask)
		{
			if(event.getPropertyName().equals(PROPERTY_NAME_SWING_WORKER_PROGRESS))
			{
				updateProgress(event);
			}
			else if (event.getPropertyName().equals(PROPERTY_NAME_TASK_PANEL_STATE))
			{
				updateState(event);
			}
		}
	}

    private void updateState(PropertyChangeEvent event)
    {
        SwingWorker.StateValue state =
        		(SwingWorker.StateValue) event.getNewValue();
        switch(state)
        {
        	case DONE:
        	{
        		if (primaryTask.isCancelled())
        			defaultCancelActions();
        		else
        			defaultDoneControlActions();
        		setState(TaskPanelStateValue.TaskDone);
        		break;
        	}
        	case PENDING:
        		setState(TaskPanelStateValue.TaskStarted);
        		break;
        	case STARTED:
        		setState(TaskPanelStateValue.TaskStarted);
        		break;
        
        }
    }

    private void updateProgress(PropertyChangeEvent event)
    {
        int newProgress = (Integer) event.getNewValue();
        progressBar.setValue(newProgress);
    }
	public void takeAShortNap()
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void defaultDoneControlActions()
	{

		taskComponents.enableAllControls();
		takeAShortNap();
		hideProgressControls();
		
	}
	
	public void hideProgressControls()
	{
		progressTextArea.setVisible(false);
		progressBar.setVisible(false);
	}
	
	private void defaultCancelActions()
	{
		if(Thread.currentThread().getState()!=Thread.State.TIMED_WAITING)
			takeAShortNap();
		taskComponents.enableAllControls();
		
		hideProgressControls();
	}

	

	public Informable getInformable()
	{
		return informable;
	}

	public void setInformable(Informable informable)
	{
		this.informable = informable;
	}

	public TaskPanelStateValue getState()
	{
		return state;
	}

	private void setState(TaskPanelStateValue state)
	{
		TaskPanelStateValue oldState = this.state;
		this.state = state;
		firePropertyChange(PROPERTY_NAME_TASK_PANEL_STATE,oldState,state);
	}


}
