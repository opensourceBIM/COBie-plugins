package org.bimserver.cobie.satellite.gui;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.client.ConnectionException;
import org.bimserver.client.notifications.NotificationLogger;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.CobieSatelliteServerSettings;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.utils.SwingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bimserver.cobie.satellite.utils.JComponentCollection;
import org.bimserver.cobie.satellite.activities.Activity;
import org.bimserver.cobie.satellite.activities.RevisionRefreshActivity;
import org.bimserver.cobie.satellite.gui.controls.COBieFileUtilitiesPanel;
import java.awt.Dimension;

import org.bimserver.cobie.satellite.gui.controls.COBieFilePanel;
import org.bimserver.cobie.satellite.gui.controls.CompliancePanel;
import org.bimserver.cobie.satellite.gui.controls.FileComparePanel;
import org.bimserver.cobie.satellite.gui.controls.BiMServerComparePanel;
import org.bimserver.cobie.satellite.gui.controls.CobieExportPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class CobieSatelliteGui extends JFrame implements ActionListener
{

	private static final String ICON_FILENAME = "logo_small.png";
	private static final String MAIN_PANEL_TITLE = "BiMServer COBie Satellite";
	private static final String SETTINGS_FILENAME = "settings.xml";
	private static final String SETTINGS_FILEPATH = "lib/settings.xml";
	private static final String MERGE_RULES_PATH = "lib/MergeRules";
	private static final String FILE_UTILS_PANEL_TITLE = "COBie File Utilities";
	private static final String COMPARE_BIMSERVER_PANEL_TITLE = "Compare BiMServer Models";
	private static final String BIM_SERVER_NOTIFICATIONS_PANEL_TITLE = "BiMServer Notifications";
	private static final String OPTIONS_MENU_TEXT = "Options";
	private static final String OBJECT_IDM_ITEM_TEXT = "Object IDM (Ignored Entities)";
	private static final String BUTTON_CONNECT_TO_BIMSERVER_CONNECTED = "Disconnect";
	private static final String BUTTON_CONNECT_TO_BIM_SERVER_DISCONNECTED = "Connect to BimServer";
	private static final long serialVersionUID = -5428454520760923784L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CobieSatelliteGui.class);
	protected static final String APP_NAME = "COBie BIMserver Satellite";
	private CobieSatelliteServer satelliteServer;
	private JMenuItem menuItemIDM;
	private JMenuItem mntmCobieSpreadsheetExport;
	private CobieSatelliteServerSettings settings;
	private NotificationLogger notificationsLogger;
	private boolean bimServerConnected;
	private JComponentCollection bimServerDependentComponents;
	private COBieFileUtilitiesPanel cobieFileUtilitiesPanel;

	
	public static void main(String[] args) 
	{
		CobieSatelliteServer satelliteServer = new CobieSatelliteServer();
		satelliteServer.registerActivity(new RevisionRefreshActivity());
		new CobieSatelliteGui(satelliteServer);
	}

	private void initializeBimServerDependentControls()
	{
		bimServerDependentComponents = new JComponentCollection();
	}
	

	public CobieSatelliteGui(final CobieSatelliteServer satelliteServer) {
		setMinimumSize(new Dimension(690, 807));
		this.satelliteServer = satelliteServer;
		SwingUtil.setLookAndFeelToNice();
		try {
			setIconImage(ImageIO.read(getClass().getResource(ICON_FILENAME)));
		} catch (IOException e) {
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(690, 807);
		setTitle("COBie Challenge Tools beta (8.20.2012)");
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());

		initializeSettings();
		initializeCOBieMergeRules();
		JPanel top = makeTopPanel();

		getContentPane().add(top, BorderLayout.NORTH);
		JTabbedPane tabber = new JTabbedPane();
		getContentPane().add(tabber, BorderLayout.CENTER);
		
		cobieFileUtilitiesPanel = new COBieFileUtilitiesPanel(this.satelliteServer);
		cobieFileUtilitiesPanel.setMinimumSize(new Dimension(575, 577));
		JScrollPane fileUtilsScrollPane =
				new JScrollPane();
		fileUtilsScrollPane.add(cobieFileUtilitiesPanel);
		fileUtilsScrollPane.setViewportView(cobieFileUtilitiesPanel);
		tabber.addTab(FILE_UTILS_PANEL_TITLE, null, fileUtilsScrollPane, null);
						
		
		initializeBimServerDependentControls();
		bimServerDependentComponents.disableAllControls();
		initializeNotificationsLogger(satelliteServer);
		

		evaluateAutoConnect();		

	}

	private JPanel makeTopPanel()
	{
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		JMenuBar menuBar = new JMenuBar();
		top.add(menuBar);
		
		JMenu menuOptions = new JMenu(OPTIONS_MENU_TEXT);
		menuBar.add(menuOptions);
		
		menuItemIDM = new JMenuItem(OBJECT_IDM_ITEM_TEXT);
		menuItemIDM.addActionListener(this);
		menuOptions.add(menuItemIDM);
		
		mntmCobieSpreadsheetExport = new JMenuItem("COBie Spreadsheet Export");
		mntmCobieSpreadsheetExport.addActionListener(this);
		menuOptions.add(mntmCobieSpreadsheetExport);
		return top;
	}

	private void initializeNotificationsLogger(
			final CobieSatelliteServer satelliteServer)
	{
		notificationsLogger = new NotificationLogger(new PrintWriter(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				//notificationsTextArea.append(new String(new char[] { (char) b }));
			}
		}));
		
		for (Activity activity : satelliteServer.getActivities()) 
		{
			if(activity instanceof RevisionRefreshActivity)
			{
				//((RevisionRefreshActivity) activity).addCOBieSatelliteTaskPanel(biMServerComparePanel);
			}
		}
	}

	private void evaluateAutoConnect()
	{
		if (settings.isAutoConnect()) {
			try {
				connect(settings);	
			} catch (ConnectionException e) {
				LOGGER.error("", e);
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error connecting", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	

	private void initializeCOBieMergeRules()
	{
		File mergeRulesDir =
				new File(MERGE_RULES_PATH);
		if (mergeRulesDir.exists()&&mergeRulesDir.isDirectory())
			this.satelliteServer.loadMergeRules(mergeRulesDir);
	}

	private void initializeSettings()
	{
		File settingsFile = new File(SETTINGS_FILENAME);
		if(!settingsFile.exists())
			try
		{
			copyfile(SETTINGS_FILEPATH, SETTINGS_FILENAME);
		}
		catch(Exception ex)
		{
			
		}
		if (settingsFile.exists()) {
			try {
				loadSettings(settingsFile);
			} catch (JAXBException e) {
				LOGGER.error("", e);
			}
		}
		if (settings == null) {
			settings = new CobieSatelliteServerSettings();
			
		}
	}

	private void loadSettings(File settingsFile) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(CobieSatelliteServerSettings.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		settings = (CobieSatelliteServerSettings) unmarshaller.unmarshal(settingsFile);
	}
	
	public CobieSatelliteServer getSatelliteServer() {
		return satelliteServer;
	}

	public void connect(CobieSatelliteServerSettings settings) throws ConnectionException {
		satelliteServer.connect(settings, notificationsLogger);
		setBimServerConnected(true);
	}

	public boolean getBimServerConnected()
	{
		return bimServerConnected;
	}

	public void setBimServerConnected(boolean connected)
	{
		this.bimServerConnected = connected;
	}
	 private static void copyfile(String srFile, String dtFile) throws IOException{
		  try{
		  File f1 = new File(srFile);
		  File f2 = new File(dtFile);
		  InputStream in = new FileInputStream(f1);
		  
		  //For Append the file.
		//  OutputStream out = new FileOutputStream(f2,true);

		  //For Overwrite the file.
		  OutputStream out = new FileOutputStream(f2);

		  byte[] buf = new byte[1024];
		  int len;
		  while ((len = in.read(buf)) > 0){
		  out.write(buf, 0, len);
		  }
		  in.close();
		  out.close();
		  System.out.println("File copied.");
		  }
		  catch(FileNotFoundException ex){
			  throw ex;
		  }
		  catch(IOException e){
		   throw e;  
		  }
		  }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==menuItemIDM)
		{
			handleMenuItemIDMAction(e);
		}
		else if(e.getSource()==mntmCobieSpreadsheetExport)
		{
			handleMenuItemSpreadsheetExportOptions();
		}
		
	}
	
	private void handleMenuItemSpreadsheetExportOptions()
	{
		CobieExportOptionsGui cobieExportOptions = new CobieExportOptionsGui(CobieSatelliteGui.this);
		cobieExportOptions.setVisible(true);
		
	}

	private void handleMenuItemIDMAction(ActionEvent e)
	{
		
		IDMOptionsGui idmGUI = new IDMOptionsGui(CobieSatelliteGui.this);
		idmGUI.setVisible(true);
	}

	private void handleConnectDisconnectButtonAction(ActionEvent e)
	{
		if (!getBimServerConnected()) {
			ConnectionBugWarningDialog disconnectFrame = 
					new ConnectionBugWarningDialog(CobieSatelliteGui.this,
							ConnectionBugWarningDialog.ConnectionRequest.connect);
			disconnectFrame.setVisible(true);
			ConnectFrame connectFrame = new ConnectFrame(CobieSatelliteGui.this, settings);
			connectFrame.setVisible(true);
						
		} 
		else 
		{
			
			try
			{
				satelliteServer.disconnect();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			setBimServerConnected(false);
			ConnectionBugWarningDialog disconnectFrame = 
					new ConnectionBugWarningDialog(CobieSatelliteGui.this,
							ConnectionBugWarningDialog.ConnectionRequest.disconnect);
			disconnectFrame.setVisible(true);
		}
	}
	

}