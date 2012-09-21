package org.bimserver.cobie.satellite.gui.controls;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;

import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.tasks.COBieLiteExportTask;
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

public class CobieExportPanel extends COBieApplicationTaskPanel<COBieLiteExportTask>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CobieExportPanel.class);
	private static final String PROGRESS_MESSAGE_INTERMMEDIATE_PROGRESS = "Parsing Input File";
	private static final String PROGRESS_MESSAGE_FILE_LOADED = "File Loaded as COBieLite";
	private static final String PROGRESS_MESSAGE_FILE_NOT_LOADED = 
				"An error occured while parsing the file, please select another file";
	private CobieSatelliteServer satelliteServer;
	private JProgressBar progressBar;
	private JLabel lblProgress;
	private JButton btnExport;
	private COBieLiteExportTask cobieLiteExportTask;
	private COBieFilePanel cobieFilePanel;
	public CobieExportPanel(final CobieSatelliteServer satelliteServer)
	{
		super();
		
		cobieFilePanel = new COBieFilePanel(satelliteServer);
		cobieFilePanel.setPreferredSize(new Dimension(462, 141));
		cobieFilePanel.setMaximumSize(new Dimension(462, 141));
		cobieFilePanel.setMinimumSize(new Dimension(462, 141));
		cobieFilePanel.addPropertyChangeListener(CobieExportPanel.this);
		
		btnExport = new JButton("ExportTo...");
		btnExport.addActionListener(CobieExportPanel.this);
		 progressBar = new JProgressBar();
		
		lblProgress = new JLabel("Progress");
		
		JLabel lblImportexport = new JLabel("Import/Export");
		lblImportexport.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImportexport)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblProgress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cobieFilePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnExport))))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblImportexport)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cobieFilePanel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExport))
					.addGap(18)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblProgress)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		init(satelliteServer);
	}

	private void init(CobieSatelliteServer satelliteServer)
	{
		this.satelliteServer = satelliteServer;
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
			SerializerFileChoser fc =
					new SerializerFileChoser(satelliteServer);
			int returnval =fc.showSaveDialog(CobieExportPanel.this);
			if (returnval == JFileChooser.APPROVE_OPTION)
			{
				File outputFile = fc.getSelectedFileWithFilterExtension();
				cobieLiteExportTask = 
						new COBieLiteExportTask(getInformable(), false,fc.getCurrentSerializerFileFilter().getSerializerPlugin(),
								satelliteServer.getPluginManager(),
								this.cobieFilePanel.getCOBie(),
								outputFile);
				try
				{
					executeInstantiatedTask(cobieLiteExportTask);
				}
				catch(Exception ex)
				{
					this.handleError("An error occured while executing export task...",ex,
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
	public COBieLiteExportTask getCOBieSatelliteApplicationTask()
	{
		return cobieLiteExportTask;
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
