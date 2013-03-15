package org.erdc.cobie.toolkit.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.erdc.cobie.toolkit.CobieToolkit;
import org.erdc.cobie.toolkit.ControlTextItem;
import org.erdc.cobie.toolkit.gui.controls.BiMServerModelLabelRenderer;

public class IDMOptionsGui extends JDialog implements ActionListener
{
	private static final ControlTextItem NO_IDM_OPTION = new ControlTextItem("None", "None","Allow import of all IFC entities.","");
	private static final String SUBMIT_TEXT = "Submit";
	private static final String FRAME_TITLE = "Object IDM Options";
	private JButton btnSubmit,btnCancel;
	private JComboBox cbIDM;
	private JLabel lblDescription;
	private CobieToolkit cobieToolkit;
	private JLabel lblSelectedObjectInformation;
	private JTextArea txtIgnoredEntities;
	private JScrollPane scrollPane;
	public IDMOptionsGui(final CobieToolkitGui cobieToolkitGui) 
	{
		setMinimumSize(new Dimension(485, 382));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		this.cobieToolkit = cobieToolkitGui.getCobieToolkit();
		setTitle(FRAME_TITLE);
		lblDescription = new JLabel("");
		initializeIgnoredEntitiesTextArea();
		cbIDM = new JComboBox();
		txtIgnoredEntities = new JTextArea();
		txtIgnoredEntities.setWrapStyleWord(true);
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(txtIgnoredEntities);
		txtIgnoredEntities.setLineWrap(true);
		txtIgnoredEntities.setEditable(false);
		populateIDMComboBox();
		populateTextBoxAndLabel();
		repaint();
		lblDescription.setLabelFor(cbIDM);
		cbIDM.addActionListener(this);
		btnSubmit = new JButton(SUBMIT_TEXT);
		btnSubmit.addActionListener(this);
		
		lblSelectedObjectInformation = new JLabel("Selected Object Information Delivery Manual");
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		

		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSubmit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectedObjectInformation)
								.addComponent(cbIDM, 0, 385, Short.MAX_VALUE)
								.addComponent(lblDescription)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))))
					.addGap(44))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSelectedObjectInformation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbIDM, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(26))
		);
		JLabel lblIgnoredEntities = new JLabel("Ignored Entities");
		scrollPane.setColumnHeaderView(lblIgnoredEntities);
		lblIgnoredEntities.setLabelFor(scrollPane);

		groupLayout.setHonorsVisibility(false);
		
		getContentPane().setLayout(groupLayout);
		pack();
		setLocationRelativeTo(cobieToolkitGui);
	}

	private void populateTextBoxAndLabel()
	{
		ControlTextItem selectedTxtItem = cobieToolkit.getSelectedControlTextItem();
		String description,longDescription;
		if(selectedTxtItem==null)
		{
			description = NO_IDM_OPTION.getToolTip();
			longDescription = "";
		}
		else
		{
			description = selectedTxtItem.getToolTip();
			longDescription = selectedTxtItem.getLongDescription();
		}
		lblDescription.setText(description);
		txtIgnoredEntities.setText(longDescription);
		
	}

	private void initializeIgnoredEntitiesTextArea()
	{
	}

	private void populateIDMComboBox()
	{
		addNullItem();
		for(ControlTextItem controlTextItem:
			cobieToolkit.getControlTextItemToIDMPlugin().keySet())
		{
			cbIDM.addItem(controlTextItem);
		}
		cbIDM.setRenderer(new BiMServerModelLabelRenderer());
		setSelectedComboBoxItemAsSelectedCobieServerIDM();
	}

	private void addNullItem()
	{
		cbIDM.addItem(NO_IDM_OPTION);
		
	}

	private void setSelectedComboBoxItemAsSelectedCobieServerIDM()
	{
		ControlTextItem selectedTextItem = cobieToolkit.getSelectedControlTextItem();
		if(selectedTextItem==null)
			selectedTextItem = NO_IDM_OPTION;
		cbIDM.setSelectedItem(selectedTextItem);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btnSubmit)
		{
			handleBtnSubmitClick(e);
		}
		else if (e.getSource()==cbIDM)
		{
			handleChangedIDM(e);
		}
		else if (e.getSource()==btnCancel)
		{
			handleBtnCancelClick(e);
		}
		
	}

	private void handleBtnCancelClick(ActionEvent e)
	{
		setVisible(false);
		setSelectedComboBoxItemAsSelectedCobieServerIDM();
		
	}

	private void handleChangedIDM(ActionEvent e)
	{
		if(cbIDM.getSelectedItem() instanceof ControlTextItem)
		{
			ControlTextItem cntrlTextItem = (ControlTextItem) cbIDM.getSelectedItem();
			lblDescription.setText(cntrlTextItem.getToolTip());
			txtIgnoredEntities.setText(cntrlTextItem.getLongDescription());
		}
		else
		{
			lblDescription.setText("");
			txtIgnoredEntities.setText("");
		}
		repaint();
	}
	
	private ObjectIDMPlugin getSelectedPlugin()
	{
		ObjectIDMPlugin selectedPlugin = null;
		Object selectedItem = cbIDM.getSelectedItem();
		if(selectedItem instanceof ControlTextItem)
		{
			ControlTextItem selectedTextItem = (ControlTextItem) selectedItem;
			selectedPlugin =
					cobieToolkit.getControlTextItemToIDMPlugin().get(selectedTextItem);
		}
		return selectedPlugin;
	}

	private void handleBtnSubmitClick(ActionEvent e)
	{
		if(cbIDM.getSelectedItem()==NO_IDM_OPTION)
			cobieToolkit.selectIDM(null);
		else
			cobieToolkit.selectIDM(getSelectedPlugin());
		setVisible(false);
	}
}
