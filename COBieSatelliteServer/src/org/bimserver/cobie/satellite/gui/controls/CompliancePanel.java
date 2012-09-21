package org.bimserver.cobie.satellite.gui.controls;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker.StateValue;

import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.tasks.ComplianceTask;
import org.bimserver.cobie.satellite.tasks.DeserializeToCOBieLiteTask;
import org.bimserver.cobie.satellite.tasks.ApplicationTask;
import org.bimserver.shared.cobie.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompliancePanel extends COBieApplicationTaskPanel<ComplianceTask>
{
	private static final String PROGRESS_MESSAGE_FILE_NOT_LOADED = "An error occured, COBie file not loaded.  Select another file.";
	private static final String PROGRESS_MESSAGE_FILE_LOADED = "COBie File Loaded, Press Submit to Run Compliance Report";
	private static final String PROGRESS_MESSAGE_INTERMMEDIATE_PROGRESS = "Loading COBie file...if successfully loaded press 'Submit' to Perform Check";
	private static final String PROPERTY_NAME_ACTION_WORKER_STATE = "state";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE_INITIALIZATION_ERROR = "An exception occured while initializing a COBie compliance transformation, consult log for details";
	private JButton btnCheck;
	private final static  Logger LOGGER = LoggerFactory.getLogger(CompliancePanel.class);
	private JProgressBar progressBar;
	private JLabel lblProgress;
	private COBieFilePanel cobieFileLoaderPanel;
	private ComplianceTask complianceTask;
	private CobieSatelliteServer satelliteServer;
	public CompliancePanel(final CobieSatelliteServer satelliteServer) 
	{
		this.satelliteServer = satelliteServer;
		setMinimumSize(new Dimension(599, 206));
		
		
		JLabel lblCompliance = new JLabel("COBie Compliance");

	
		lblCompliance.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCheck = new JButton("Submit");
		
		btnCheck.addActionListener(CompliancePanel.this);
		
		
		progressBar = new JProgressBar();
		super.setProgressBar(progressBar);
		
		lblProgress = new JLabel();
		lblProgress.setText("label");
		lblProgress.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblProgress.setLabelFor(progressBar);
		super.setProgressTextArea(lblProgress);
		initializeProgressComponents();
		
		JLabel lblSelectCobieFile = new JLabel("Select COBie File");
		
		 cobieFileLoaderPanel = new COBieFilePanel(satelliteServer);
		 cobieFileLoaderPanel.setPreferredSize(new Dimension(450, 111));
		 cobieFileLoaderPanel.addPropertyChangeListener(CompliancePanel.this);
		 GroupLayout groupLayout_1 = (GroupLayout) cobieFileLoaderPanel.getLayout();
		 groupLayout_1.setAutoCreateContainerGaps(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCheck))
								.addComponent(lblProgress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(207)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCompliance)
										.addComponent(lblSelectCobieFile)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(cobieFileLoaderPanel, GroupLayout.PREFERRED_SIZE, 518, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblCompliance)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSelectCobieFile)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cobieFileLoaderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCheck))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblProgress)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		

	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			CobieFileChoser fc = new CobieFileChoser(COBIE_FILE_TYPE.COBieCompliance);
			int returnval =fc.showSaveDialog(CompliancePanel.this);
			if (returnval == JFileChooser.APPROVE_OPTION)
			{
				 complianceTask =
						new ComplianceTask(cobieFileLoaderPanel.getCOBie(),fc.getSelectedFileWithFilterExtension().
								getAbsolutePath(),
										super.getInformable(),false);
				super.executeInstantiatedTask(complianceTask);
			}

		}
		catch(Exception e1)
		{
			handleError(ERROR_MESSAGE_INITIALIZATION_ERROR,
					e1, LOGGER,false);
		}
		
	}

	@Override
	public ComplianceTask getCOBieSatelliteApplicationTask()
	{
		return complianceTask;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		super.propertyChange(event);
		if(event.getSource()==this.cobieFileLoaderPanel)
		{
			if(event.getPropertyName().equals(COBieApplicationTaskPanel.PROPERTY_NAME_TASK_PANEL_STATE))
			{
				TaskPanelStateValue oldState = (TaskPanelStateValue) event.getOldValue();
				TaskPanelStateValue newState = (TaskPanelStateValue) event.getNewValue();
				switch(newState)
				{
					case TaskDone:
						
						if(cobieFileLoaderPanel.getPrimaryTask().isCancelled())
						{
							btnCheck.setEnabled(false);
							showFailedFileLoad();
						}
						else
						{
							btnCheck.setEnabled(true);
							showSuccessfulFileLoad();
						}
						break;
					case Initialized:
						btnCheck.setEnabled(false);
						showIntermmediateProgress();
						break;
					case TaskStarted:
						btnCheck.setEnabled(false);
						showIntermmediateProgress();
						break;
				}
			}
		}
		
	}
	
	private void showIntermmediateProgress()
	{
		super.updateTextArea(PROGRESS_MESSAGE_INTERMMEDIATE_PROGRESS);
		super.getProgressTextArea().setVisible(true);
	}
	
	private void showSuccessfulFileLoad()
	{
		super.updateTextArea(PROGRESS_MESSAGE_FILE_LOADED);
		super.getProgressTextArea().setVisible(true);
	}
	
	private void showFailedFileLoad()
	{
		super.updateTextArea(PROGRESS_MESSAGE_FILE_NOT_LOADED);
		super.getProgressTextArea().setVisible(true);
	}


	@Override
	public JComponent[] getDefaultToggleComponents()
	{
		return new JComponent[]{btnCheck};
	}

}
