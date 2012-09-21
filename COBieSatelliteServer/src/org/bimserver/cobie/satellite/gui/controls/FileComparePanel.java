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
import javax.swing.LayoutStyle.ComponentPlacement;

import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.gui.controls.COBieApplicationTaskPanel.TaskPanelStateValue;
import org.bimserver.cobie.satellite.tasks.CompareTask;
import org.bimserver.cobie.satellite.tasks.ApplicationTask;
import org.bimserver.shared.cobie.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileComparePanel extends COBieApplicationTaskPanel<CompareTask>
{

	private static final String INFORMATION_PANEL_HEADER = "COBie Compare";
	private static final String INFORMATION_PROMPT_SUBMIT_BUTTON = "Compare";
	private static final String INFORMATION_MESSAGE_REVISED_DOCUMENT = "Select Revised COBie Document";
	private static final String INFORMATION_PROMPT_BASELINE_DOCUMENT = "Select Baseline COBie Document";
	private static final String VALIDATION_MESSAGE_REVISION_DOCUMENT_INVALID = "Revision document is invalid";
	private static final String VALIDATION_MESSAGE_BASELINE_DOCUMENT_INVALID = "Baseline document is invalid";
	private static final String PROGRESS_MESSAGE_INITIALIZATION_EXCEPTION = "An exception occured while initializing the Compare task";
	private static final String PROGRESS_MESSAGE_BASELINE_LOADED = "Baseline document loaded...select a revision before running comparison report";
	private static final String PROGRESS_MESSAGE_REVISION_LOADED = "Revision document loaded...select a baseline before running comparison report";
	private static final String PROGRESS_MESSAGE_COMPARE_READY = "Baseline and revision loaded.  Press 'Compare' to run comparison report.";
	private static final String PROGRESS_MESSAGE_INTERMMEDIATE_REVISION_ERROR = "An error occured while loading revision document...select another revision document";
	private static final String PROGRESS_MESSAGE_INTERMMEDIATE_BASELINE_ERROR = "An error occured while loading baseline document...select another baseline document";
	private static final String PROGRESS_MESSAGE_INTERMMEDIATE_REVISION_LOADING = "Loading revision COBie document...";
	private static final String PROGRESS_MESSAGE_INTERMMEDIATE_BASELINE_LOADING = "Loading baseline COBie document...";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private COBIEDocument baselineDocument;
	private COBIEDocument revisedDocument;
	private JButton btnSubmit;
	private JProgressBar progressBar;
	private JLabel lblProgress;
	private CompareTask compareTask;
	private static Logger LOGGER =  LoggerFactory.getLogger(FileComparePanel.class);
	private COBieFilePanel cobieFileLoaderBaseline,cobieFileLoaderRevision;
	private boolean baselineLoaded,revisionLoaded;
	private CobieSatelliteServer satelliteServer;
	public FileComparePanel(final CobieSatelliteServer satelliteServer) 
	{
		this.satelliteServer = satelliteServer;
		revisionLoaded=false;
		baselineLoaded = false;
		setMinimumSize(new Dimension(515, 390));

		JLabel lblNewLabel = new JLabel(INFORMATION_PANEL_HEADER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblBaselineCobieDocument = new JLabel(INFORMATION_PROMPT_BASELINE_DOCUMENT);
		
		cobieFileLoaderBaseline = new COBieFilePanel(satelliteServer);
		cobieFileLoaderBaseline.setAlignmentX(0.0f);
		cobieFileLoaderBaseline.addPropertyChangeListener(FileComparePanel.this);
		JLabel lblNewLabel_1 = new JLabel(INFORMATION_MESSAGE_REVISED_DOCUMENT);
		
		cobieFileLoaderRevision = new COBieFilePanel(satelliteServer);
		cobieFileLoaderRevision.setAlignmentX(0.0f);
		cobieFileLoaderRevision.addPropertyChangeListener(FileComparePanel.this);
		btnSubmit = new JButton(INFORMATION_PROMPT_SUBMIT_BUTTON);
		btnSubmit.setAlignmentY(0.0f);
		btnSubmit.addActionListener(FileComparePanel.this);
		

		
		 progressBar = new JProgressBar();
		 progressBar.setAlignmentY(0.0f);
		 progressBar.setAlignmentX(0.0f);
		progressBar.setMaximumSize(new Dimension(15000, 14));
		 super.setProgressBar(progressBar);
		lblProgress = new JLabel();
		lblProgress.setText("New label");
		lblProgress.setAlignmentY(0.0f);
		super.setProgressTextArea(lblProgress);
		initializeProgressComponents();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBaselineCobieDocument)
								.addComponent(cobieFileLoaderBaseline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(207)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(cobieFileLoaderRevision, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(16)))
					.addGap(30))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProgress, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnSubmit)
							.addGap(44)))
					.addGap(4))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBaselineCobieDocument)
					.addGap(2)
					.addComponent(cobieFileLoaderBaseline, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(cobieFileLoaderRevision, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmit))
					.addGap(13)
					.addComponent(lblProgress, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		CobieFileChoser saveFileChoser = new CobieFileChoser(COBIE_FILE_TYPE.COBieCompareReport);
		int result =
				saveFileChoser.showSaveDialog(FileComparePanel.this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				boolean baselineValid=true,revisionValid = true;
				try
				{
					 baselineDocument =
							cobieFileLoaderBaseline.getCOBie();
					 
				}
				catch(Exception ex)
				{
					baselineValid = false;
				}
				try
				{
					revisedDocument =
							cobieFileLoaderRevision.getCOBie();
				}
				catch(Exception ex)
				{
					revisionValid = false;
				}
				if (baselineValid && revisionValid)
				{
						compareTask =
						new CompareTask
						(baselineDocument, revisedDocument,
								saveFileChoser.getSelectedFileWithFilterExtension().
								getAbsolutePath(),super.getInformable(),false);
	
					super.executeInstantiatedTask(compareTask);
				}
				else
				{
					handleValidationError(getDocumentsInvalidMessage(baselineValid, revisionValid),false);
				}
			}
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				handleError(PROGRESS_MESSAGE_INITIALIZATION_EXCEPTION, e1, LOGGER,false);
			}
		}
		
	}

	public String getDocumentsInvalidMessage(boolean baselineValid,
			boolean revisionValid)
	{
		String baselineMessage = VALIDATION_MESSAGE_BASELINE_DOCUMENT_INVALID;
		String revisionMessage = VALIDATION_MESSAGE_REVISION_DOCUMENT_INVALID;
		String errorMessage = "";
		if(!baselineValid)
			errorMessage+=baselineMessage;
		if(!revisionValid)
		{
			if (errorMessage.length()>0)
				errorMessage+=", "+revisionMessage;
			else
				errorMessage = revisionMessage;
		}
		return errorMessage;
	}


	@Override
	public CompareTask getCOBieSatelliteApplicationTask()
	{
		return compareTask;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		super.propertyChange(event);
		if(event.getSource()==this.cobieFileLoaderBaseline || 
				event.getSource()==this.cobieFileLoaderRevision)
		{
			
			if(event.getPropertyName().equals(COBieApplicationTaskPanel
					.PROPERTY_NAME_TASK_PANEL_STATE))
			{
				TaskPanelStateValue newState = (TaskPanelStateValue) event.getNewValue();
				switch(newState)
				{
					case Initialized:
						break;
					case TaskDone:
						updateIntermmediateProgressDone(event.getSource());
						break;
					case TaskStarted:
						updateIntermmediateProgressStarted(event.getSource());
						break;	
				}
			}
		}
	}
	
	private void updateIntermmediateProgressDone(Object eventSource)
	{
		if(eventSource==this.cobieFileLoaderBaseline)
		{
			if (cobieFileLoaderBaseline.getPrimaryTask().isCancelled())
			{
				baselineLoaded = false;
				super.updateTextArea(PROGRESS_MESSAGE_INTERMMEDIATE_BASELINE_ERROR);
			}
			else
			{
				baselineLoaded = true;
				updateFileLoadedIntermmediateProgress();
			}
		}
		else if (eventSource==this.cobieFileLoaderRevision)
		{
			if(cobieFileLoaderRevision.getPrimaryTask().isCancelled())
			{
				revisionLoaded = false;
				super.updateTextArea(PROGRESS_MESSAGE_INTERMMEDIATE_REVISION_ERROR);
			}
			else
			{
				revisionLoaded = true;
				updateFileLoadedIntermmediateProgress();
			}
		}
	}
	
	private void updateFileLoadedIntermmediateProgress()
	{
		if(revisionLoaded && baselineLoaded)
		{
			super.updateTextArea(PROGRESS_MESSAGE_COMPARE_READY);
		}
		else if (revisionLoaded)
		{
			super.updateTextArea(PROGRESS_MESSAGE_REVISION_LOADED);
		}
		else if (baselineLoaded)
		{
			super.updateTextArea(PROGRESS_MESSAGE_BASELINE_LOADED);
		}
	}
	
	private void updateIntermmediateProgressStarted(Object eventSource)
	{
		if (eventSource==this.cobieFileLoaderBaseline)
		{
			baselineLoaded = false;
			super.updateTextArea(PROGRESS_MESSAGE_INTERMMEDIATE_BASELINE_LOADING);
			super.getProgressTextArea().setVisible(true);
			cobieFileLoaderRevision.setEnabled(false);
		}
		else if (eventSource==this.cobieFileLoaderRevision)
		{
			revisionLoaded = false;
			super.updateTextArea(PROGRESS_MESSAGE_INTERMMEDIATE_REVISION_LOADING);
			super.getProgressTextArea().setVisible(true);
			cobieFileLoaderBaseline.setEnabled(false);
		}
	}

	@Override
	public JComponent[] getDefaultToggleComponents()
	{
		return new JComponent[]{btnSubmit,cobieFileLoaderBaseline,cobieFileLoaderRevision};
	}
		
}