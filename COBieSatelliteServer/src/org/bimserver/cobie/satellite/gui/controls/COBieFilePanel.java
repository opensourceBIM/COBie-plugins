package org.bimserver.cobie.satellite.gui.controls;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.tasks.COBieTaskProgress;
import org.bimserver.cobie.satellite.tasks.DeserializeToCOBieLiteTask;
import org.bimserver.cobie.satellite.tasks.ApplicationTask;
import org.bimserver.cobie.satellite.tasks.DeserializeToCOBieLiteTask.TaskStep;
import org.bimserver.cobie.satellite.utils.JComponentCollection;
import org.bimserver.shared.cobie.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.bimserver.shared.cobie.compare.COBieCompareState;
import org.bimserver.shared.cobie.merge.COBieMergeIDMItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

public class COBieFilePanel extends 
COBieApplicationTaskPanel<DeserializeToCOBieLiteTask>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SAVE_AS_TRANSFORM_BUTTON_TEXT = "Save as COBieLite";
	private static final ArrayList<COBIE_FILE_TYPE> SUPPORTED_INPUT_FILES = 
			new ArrayList<COBIE_FILE_TYPE>(Arrays.asList(COBIE_FILE_TYPE.COBie,COBIE_FILE_TYPE.COBieLite,COBIE_FILE_TYPE.Ifc));
		
	private final static  Logger LOGGER = LoggerFactory.getLogger(COBieFilePanel.class);
	private JButton btnBrowse;
	private DeserializeToCOBieLiteTask cobieLiteTask;
	private JLabel lblProgress;
	private JProgressBar progressBar;
	private JTextField txtFilePath;
	private CobieSatelliteServer satelliteServer;
	public COBieFilePanel(final CobieSatelliteServer satelliteServer) 
	{
		super();
		this.satelliteServer = satelliteServer;
		setMinimumSize(new Dimension(462, 141));
		txtFilePath = new JTextField();
		txtFilePath.setEditable(false);
		txtFilePath.setColumns(10);
		btnBrowse = new JButton("...");
		btnBrowse.addActionListener(COBieFilePanel.this);
		
		progressBar = new JProgressBar();
		super.setProgressBar(progressBar);
		lblProgress = new JLabel();
		lblProgress.setText("label");
		lblProgress.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblProgress.setLabelFor(progressBar);
		super.setProgressTextArea(lblProgress);
		initializeProgressComponents();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
							.addGap(25))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtFilePath, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnBrowse)
							.addGap(25))
						.addComponent(lblProgress, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFilePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse))
					.addGap(18)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblProgress)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btnBrowse)
		{
			handleDeserializeCOBie();	
		}
	}


	
	private void handleDeserializeCOBie()
	{
		//CobieFileChoser fc = new CobieFileChoser(COBIE_FILE_TYPE.COBie);
		CobieFileChoser fc = new CobieFileChoser(SUPPORTED_INPUT_FILES);
		int response = fc.showDialog(COBieFilePanel.this, "Chose COBie File");
	
		if (response == JFileChooser.APPROVE_OPTION)
		{
			try
			{					
				txtFilePath.setText(fc.getSelectedFile().getAbsolutePath());
				 cobieLiteTask =
						new DeserializeToCOBieLiteTask(satelliteServer,fc.getCurrentCOBieFileFilter().getCobieFileType(),fc.getSelectedFile(),
								super.getInformable(),false);
				
				try
				{

					super.executeInstantiatedTask(cobieLiteTask);
					//btnSave.setEnabled(true);
				}
				catch(Exception ex)
				{
					//btnSave.setEnabled(false);
				}

			}
			catch(Exception e1)
			{
				handleError("An exception occured while initializing the COBie to COBieLite transformation task",
						e1,LOGGER,false);
			}
		}
	}
	
	public COBIEDocument getCOBie()
	{
		COBIEDocument cobieDocument = null;
		if (cobieLiteTask !=null && 
				cobieLiteTask.getState()==SwingWorker.StateValue.DONE)
		{
			try
			{
				cobieDocument = cobieLiteTask.get();

			}
			catch(Exception e)
			{
				
			}
		}
		return cobieDocument;
	}
	
	public DeserializeToCOBieLiteTask getCobieLiteTask()
	{
		return cobieLiteTask;
	}

	
	private void exportCOBieLite()
	{
		CobieFileChoser fc = new CobieFileChoser(COBIE_FILE_TYPE.COBieLite);
		int response = fc.showSaveDialog(COBieFilePanel.this);
	
		if (response == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				this.cobieLiteTask.get().save(fc.getSelectedFileWithFilterExtension());
			}
			catch (IOException e)
			{
				handleError("An exception occured while saving COBieLite",
						e,LOGGER,false);
				e.printStackTrace();
			}
			catch (InterruptedException e)
			{
				handleError("An exception occured while saving COBieLite",
						e,LOGGER,false);
				e.printStackTrace();
			}
			catch (ExecutionException e)
			{
				handleError("An exception occured while saving COBieLite",
						e,LOGGER,false);
				e.printStackTrace();
			}
		}
	}




	@Override
	public JComponent[] getDefaultToggleComponents()
	{
		return new JComponent[]{btnBrowse,txtFilePath};
	}


	@Override
	public DeserializeToCOBieLiteTask getCOBieSatelliteApplicationTask()
	{

		return this.cobieLiteTask;
	}

	
}
