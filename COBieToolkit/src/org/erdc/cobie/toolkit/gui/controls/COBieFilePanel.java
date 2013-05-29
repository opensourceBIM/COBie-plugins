package org.erdc.cobie.toolkit.gui.controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker;

import org.erdc.cobie.shared.PluginUtilities.OutgingFileType;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.erdc.cobie.toolkit.CobieToolkit;
import org.erdc.cobie.toolkit.tasks.DeserializeToCOBieSheetXMLDataTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieFilePanel extends COBieApplicationTaskPanel<DeserializeToCOBieSheetXMLDataTask>
{

    private static final String FILE_INPUT_DIALOG = "Chose Input File";
    private static final String TRANSFORM_EXCEPTION_MESSAGE = "An exception occured while initializing the transformation task";
    private static final String FILE_IMPORT_BUTTON_TEXT = "Import";
    private static final long serialVersionUID = 1L;
    private static final ArrayList<OutgingFileType> SUPPORTED_INPUT_FILES = supportedInputFiles();
    private final static Logger LOGGER = LoggerFactory.getLogger(COBieFilePanel.class);

    private static ArrayList<OutgingFileType> supportedInputFiles()
    {
        return new ArrayList<OutgingFileType>(Arrays.asList(OutgingFileType.COBie, OutgingFileType.Ifc));
    }

    private JButton btnBrowse;
    private DeserializeToCOBieSheetXMLDataTask cobieSheetXMLDataTask;
    private JLabel lblProgress;
    private JProgressBar progressBar;
    private JTextField txtFilePath;
    private CobieToolkit cobieToolkit;

    public COBieFilePanel(final CobieToolkit cobieToolkit)
    {
        super();
        setMaximumSize(new Dimension(615, 89));
        this.cobieToolkit = cobieToolkit;
        setMinimumSize(new Dimension(615, 89));
        txtFilePath = new JTextField();
        txtFilePath.setBackground(Color.WHITE);
        txtFilePath.setEditable(false);
        txtFilePath.setColumns(10);
        btnBrowse = new JButton(FILE_IMPORT_BUTTON_TEXT);
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
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
                groupLayout
                        .createSequentialGroup()
                        .addGroup(
                                groupLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(lblProgress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(progressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFilePath, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnBrowse)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
                groupLayout
                        .createSequentialGroup()
                        .addGroup(
                                groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtFilePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBrowse)).addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(18)
                        .addComponent(lblProgress).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        setLayout(groupLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnBrowse)
        {
            handleDeserializeCOBie();
        }
    }

    public COBIEDocument getCOBie()
    {
        COBIEDocument cobieDocument = null;
        if ((cobieSheetXMLDataTask != null) && (cobieSheetXMLDataTask.getState() == SwingWorker.StateValue.DONE))
        {
            try
            {
                cobieDocument = cobieSheetXMLDataTask.get();

            } catch (Exception e)
            {

            }
        }
        return cobieDocument;
    }

    @Override
    public DeserializeToCOBieSheetXMLDataTask getCOBieSatelliteApplicationTask()
    {

        return cobieSheetXMLDataTask;
    }

    public DeserializeToCOBieSheetXMLDataTask getCOBieSheetXMLDataTask()
    {
        return cobieSheetXMLDataTask;
    }

    @Override
    public JComponent[] getDefaultToggleComponents()
    {
        return new JComponent[]
        {
                btnBrowse, txtFilePath
        };
    }

    private void handleDeserializeCOBie()
    {
        CobieFileChoser fileChoser = new CobieFileChoser(SUPPORTED_INPUT_FILES);
        fileChoser.initializeCurrentDirectory(cobieToolkit);
        int response = fileChoser.showDialog(COBieFilePanel.this, FILE_INPUT_DIALOG);

        if (response == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                txtFilePath.setText(fileChoser.getSelectedFile().getAbsolutePath());
                cobieSheetXMLDataTask = new DeserializeToCOBieSheetXMLDataTask(cobieToolkit, fileChoser.getCurrentCOBieFileFilter()
                        .getCobieFileType(), fileChoser.getSelectedFile(), super.getInformable(), false);
                cobieToolkit.setLastDirectoryAccessed(fileChoser.getCurrentDirectory());

                try
                {

                    super.executeInstantiatedTask(cobieSheetXMLDataTask);
                    // btnSave.setEnabled(true);
                } catch (Exception ex)
                {
                    // btnSave.setEnabled(false);
                }

            } catch (Exception e1)
            {
                handleError(TRANSFORM_EXCEPTION_MESSAGE, e1, LOGGER, false);
            }
        }
    }

}
