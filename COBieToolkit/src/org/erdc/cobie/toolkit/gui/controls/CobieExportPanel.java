package org.erdc.cobie.toolkit.gui.controls;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;

import org.erdc.cobie.toolkit.CobieToolkit;
import org.erdc.cobie.toolkit.tasks.COBieSheetXMLDataExportTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.io.File;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class CobieExportPanel extends COBieApplicationTaskPanel<COBieSheetXMLDataExportTask>
{
	private static final String EXPORT_ERROR_MESSAGE = "An error occured while executing export task. ";
	private static final String HEADER_TEXT = "Import/Export/Report";
	private static final String LBL_PROGRESS_TEXT = "Progress";
	private static final String BTN_EXPORT_TEXT = "Export/Report";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CobieExportPanel.class);
	private static final String PROGRESS_MESSAGE_INTERMMEDIATE_PROGRESS = "Parsing Input File";
	private static final String PROGRESS_MESSAGE_FILE_LOADED = "File Loaded as COBie";
	private static final String PROGRESS_MESSAGE_FILE_NOT_LOADED = 
				"An error occured while parsing the file, please select another file";
	private CobieToolkit cobieToolkit;
	private JProgressBar progressBar;
	private JLabel lblProgress;
	private JButton btnExport;
	private COBieSheetXMLDataExportTask cobieSheetXMLExportTask;
	private COBieFilePanel cobieFilePanel;
	public CobieExportPanel(final CobieToolkit cobieToolkit)
	{
		super();
		setMinimumSize(new Dimension(627, 183));
		setMaximumSize(new Dimension(627, 183));
		
		cobieFilePanel = new COBieFilePanel(cobieToolkit);
		cobieFilePanel.setPreferredSize(new Dimension(615, 89));
		cobieFilePanel.addPropertyChangeListener(CobieExportPanel.this);
		
		btnExport = new JButton(BTN_EXPORT_TEXT);
		btnExport.addActionListener(CobieExportPanel.this);
		 progressBar = new JProgressBar();
		
		lblProgress = new JLabel(LBL_PROGRESS_TEXT);
		
		JLabel lblImportexport = new JLabel(HEADER_TEXT);
		lblImportexport.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnExport))
						.addComponent(lblImportexport, Alignment.LEADING)
						.addComponent(cobieFilePanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(572))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblProgress)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblImportexport)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cobieFilePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExport)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblProgress)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		init(cobieToolkit);
	}

	private void init(CobieToolkit satelliteServer)
	{
		this.cobieToolkit = satelliteServer;
		super.setProgressBar(progressBar);
		super.setProgressTextArea(lblProgress);
		initializeProgressComponents();
		btnExport.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnExport)
		{
			SerializerFileChoser fileChoser =
					new SerializerFileChoser(cobieToolkit);
			fileChoser.initializeCurrentDirectory(cobieToolkit);
			int returnval =fileChoser.showSaveDialog(CobieExportPanel.this);
			if (returnval == JFileChooser.APPROVE_OPTION)
			{
				File outputFile = fileChoser.getSelectedFileWithFilterExtension();
				cobieSheetXMLExportTask = 
						new COBieSheetXMLDataExportTask(getInformable(), false,fileChoser.getCurrentSerializerFileFilter().getSerializerPlugin(),
								cobieToolkit.getPluginManager(),
								this.cobieFilePanel.getCOBie(),
								outputFile);
				
				try
				{
					executeInstantiatedTask(cobieSheetXMLExportTask);
					cobieToolkit.setLastDirectoryAccessed(fileChoser.getCurrentDirectory());
				}
				catch(Exception ex)
				{
					this.handleError(EXPORT_ERROR_MESSAGE,ex,
							LOGGER, false);
				}
			}
		}
		
	}

	@Override
	public JComponent[] getDefaultToggleComponents()
	{
		return new JComponent[]{btnExport};
	}

	@Override
	public COBieSheetXMLDataExportTask getCOBieSatelliteApplicationTask()
	{
		return cobieSheetXMLExportTask;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		super.propertyChange(event);
		if(event.getSource()==this.cobieFilePanel)
		{
			if(event.getPropertyName().
					equals(COBieApplicationTaskPanel.PROPERTY_NAME_TASK_PANEL_STATE))
			{
				TaskPanelStateValue oldState = (TaskPanelStateValue) event.getOldValue();
				TaskPanelStateValue newState = (TaskPanelStateValue) event.getNewValue();
				switch(newState)
				{
					case TaskDone:
						
						if(cobieFilePanel.getPrimaryTask().isCancelled())
						{
							btnExport.setEnabled(false);
							showFailedFileLoad();
						}
						else
						{
							btnExport.setEnabled(true);
							showSuccessfulFileLoad();
						}
						break;
					case Initialized:
						btnExport.setEnabled(false);
						showIntermmediateProgress();
						break;
					case TaskStarted:
						btnExport.setEnabled(false);
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
}
