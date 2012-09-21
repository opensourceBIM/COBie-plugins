package org.bimserver.cobie.satellite.gui;

import javax.swing.JFrame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnectionBugWarningDialog extends JDialog implements ActionListener
{
	private static final String WARNING_MESSAGE_DISCONNECT = "Warning:\r\nThere is a known issue that can occur when you try to re-connect to BiMServer after disconnecting.  If you wish to re-connect you are encouraged to restart this application.";
	private static final String WARNING_MESSAGE_CONNECT = "Warning:\r\nThere is a known issue that may occur when you attempt to connect to a server that does not exist or is not started...If you fail to connect and then try to connect again after starting the BiMServer you may get an exception.  If you fail to connect you are encouraged to restart the application if you wish to connect to a BiMServer";
	public enum ConnectionRequest  {connect,disconnect};
	public ConnectionBugWarningDialog(final CobieSatelliteGui satelliteGui,ConnectionRequest connectOrDisconnect) {
		setAlwaysOnTop(true);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setTitle("");
	
		JTextArea txtrWarningThereIs = new JTextArea();
		txtrWarningThereIs.setBorder(null);
		txtrWarningThereIs.setBackground(UIManager.getColor("Label.background"));
		txtrWarningThereIs.setWrapStyleWord(true);
		txtrWarningThereIs.setLineWrap(true);
		
		txtrWarningThereIs.setEditable(false);
		switch(connectOrDisconnect)
		{
		case connect:
			setTitle("Connection warning");
			txtrWarningThereIs.setText(WARNING_MESSAGE_CONNECT);
			break;
		case disconnect:
			setTitle("Disconnect Warning");
			txtrWarningThereIs.setText(WARNING_MESSAGE_DISCONNECT);
			break;
		
		}
		JButton btnClose = new JButton("OK");
		btnClose.addActionListener(ConnectionBugWarningDialog.this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(199)
							.addComponent(btnClose))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(txtrWarningThereIs, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrWarningThereIs, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnClose)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		getContentPane().setLayout(groupLayout);
		pack();
		setLocationRelativeTo(satelliteGui);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
}
