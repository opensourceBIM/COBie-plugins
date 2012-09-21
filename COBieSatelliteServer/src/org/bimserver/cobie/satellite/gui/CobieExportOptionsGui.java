package org.bimserver.cobie.satellite.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFrame;

import org.bimserver.cobie.cobieserializersettings.COBieExportOptionsDocument;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class CobieExportOptionsGui extends JDialog implements ActionListener
{
	
	private static final String ROW_LIMIT_TEXTBOX_LABEL = "Spreadsheet Row Limit";
	private static final String CANCEL_BUTTON_TEXT = "Cancel";
	private static final String SUBMIT_BUTTON_TEXT = "Submit";
	private static final int ROW_LIMIT_UPPER_BOUND = Integer.MAX_VALUE;
	private static final int ROW_LIMIT_LOWER_BOUND = 1;
	/**
	 * 
	 */
	private COBieExportOptionsDocument cobieExportOptionsDocument;
	private CobieSatelliteGui cobieSatelliteGui;
	private JFormattedTextField txtRowLimit;
	JButton btnSave,btnCancel;
	private static final long serialVersionUID = -2989732594180355473L;
	private static final String FRAME_TITLE = "COBie Spreadsheet Export Options";
	private JLabel lblSpreadsheetRowLimit_1;
	public CobieExportOptionsGui(final CobieSatelliteGui cobieSatelliteGui)
	{
		setResizable(false);
		this.cobieSatelliteGui = cobieSatelliteGui;
		initJDialogOptions();
		initActionControls();
		lblSpreadsheetRowLimit_1 = new JLabel(ROW_LIMIT_TEXTBOX_LABEL);
		lblSpreadsheetRowLimit_1.setLabelFor(txtRowLimit);
		initCobieExportOptionsDocument();
		initCobieExportOptionsControls();
		setupLayout(lblSpreadsheetRowLimit_1);
		setLocationRelativeTo(cobieSatelliteGui);
	}
	private void setupLayout(JLabel lblSpreadsheetRowLimit)
	{
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSpreadsheetRowLimit_1)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtRowLimit, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
							.addGap(170))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblSpreadsheetRowLimit_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtRowLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHonorsVisibility(false);
		getContentPane().setLayout(groupLayout);
		pack();
	}
	private void initJDialogOptions()
	{
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle(FRAME_TITLE);
	}
	private void initActionControls()
	{
		btnSave = new JButton(SUBMIT_BUTTON_TEXT);
		btnCancel = new JButton(CANCEL_BUTTON_TEXT);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	private void initCobieExportOptionsControls()
	{
		initRowLimitTextBox();
		
	}
	private void initRowLimitTextBox()
	{
		long currentRowLimit = getCurrentRowLimit();
		NumberFormat txtBoxFormat = getTextBoxFormat();
		txtRowLimit = new JFormattedTextField(txtBoxFormat);
		txtRowLimit.setText(String.valueOf(currentRowLimit));
		
	}
	private NumberFormat getTextBoxFormat()
	{
		NumberFormat txtBoxNumberFormat =
				NumberFormat.getIntegerInstance();
		return txtBoxNumberFormat;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnSave)
		{
			handleSaveClick();
		}
		else if (e.getSource()==btnCancel)
		{
			handleCancelClick();
		}
	}
	private void handleCancelClick()
	{
		setVisible(false);
		
	}
	private void handleSaveClick()
	{
		long oldValue = getCurrentRowLimit();
		long newValue;
		try
		{
			newValue = rowLimitFromTextBoxValue();
			if(validRowLimit(newValue) && oldValue!=newValue)
			{
				setSpreadsheetRowLimit(newValue);
				applyChanges();
				
			}
		}
		catch(Exception ex)
		{

		}
		setVisible(false);
	}
	private long getCurrentRowLimit()
	{
		return cobieExportOptionsDocument.getCOBieExportOptions().getSpreadsheetOptions().getRowLimit();
	}
	
	private boolean validRowLimit(long newValue)
	{
		boolean valid = (newValue>ROW_LIMIT_LOWER_BOUND && newValue<ROW_LIMIT_UPPER_BOUND);

		return valid;
	}
	private long rowLimitFromTextBoxValue() throws Exception
	{
		String textBoxContents = getSpreadSheetRowLimitEntry();
		int textBoxValue;
		try
		{
			Number txtBoxValueGeneric = NumberFormat.getIntegerInstance().parse(textBoxContents);
			textBoxValue =  txtBoxValueGeneric.intValue();
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return textBoxValue;
	}
	
	private String getSpreadSheetRowLimitEntry()
	{
		return txtRowLimit.getText();
	}
	public COBieExportOptionsDocument getCobieExportOptionsDocument()
	{
		return cobieExportOptionsDocument;
	}
	
	private void setSpreadsheetRowLimit(long rowLimit)
	{
		cobieExportOptionsDocument.getCOBieExportOptions().getSpreadsheetOptions().setRowLimit(rowLimit);
	}
	
	private void applyChanges()
	{
		try
		{
			cobieExportOptionsDocument.save(cobieSatelliteGui.getSatelliteServer().getCobieExportOptionsFile());
		}
		catch(Exception ex)
		{
			
		}
	}
	
	private void initCobieExportOptionsDocument()
	{
		try
		{
			cobieExportOptionsDocument =
					COBieExportOptionsDocument.Factory.parse(cobieSatelliteGui.getSatelliteServer().getCobieExportOptionsFile());
		}
		catch(Exception ex)
		{
			
		}
	}
	public CobieSatelliteGui getCobieSatelliteGui()
	{
		return cobieSatelliteGui;
	}
}
