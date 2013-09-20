package org.erdc.cobie;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

public class JavaVersionWarning extends JDialog implements ActionListener
{
	
	/**
     * 
     */
    private static final long serialVersionUID = 3878719665664674345L;

    public JavaVersionWarning()
	{
		setResizable(false);
		setMinimumSize(new Dimension(615, 337));
		setMaximumSize(new Dimension(615, 337));
		
		JTextArea txtrWarningTheJava = new JTextArea();
		txtrWarningTheJava.setBackground(SystemColor.menu);
		txtrWarningTheJava.setWrapStyleWord(true);
		txtrWarningTheJava.setLineWrap(true);
		txtrWarningTheJava.setText("Warning:  \r\n\r\nThe Java Virtual Machine that is currently running this starter application is a 32-bit Version.  \r\n\r\nFor best results, it is recommended that you change the JVM_HOME settings in the COBieToolkit starter from the \"default\" value to the path of a 64-bit Java 1.6 JRE or JDK using the Browse button.  \r\n\r\nOn 64-bit Windows machines  you may find the 64-bit Java directory in locations such as\r\n C:\\Program Files\\Java\\Jre1.6 or C:\\Program Files\\Java\\jdk1.6.0_25\r\n\r\nThe COBieToolkit will run on 32-bit Java 1.6, but you will be limited to approximately \r\n1.5GB of available heap size space which may be insuficient for running large models.");
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtrWarningTheJava, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(263)
							.addComponent(btnOk)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrWarningTheJava, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnOk)
					.addGap(12))
		);
		getContentPane().setLayout(groupLayout);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		dispose();
		
	}
}
