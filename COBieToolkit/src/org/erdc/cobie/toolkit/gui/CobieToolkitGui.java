package org.erdc.cobie.toolkit.gui;

/******************************************************************************
 * Copyright (C) 2009-2012 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.LogManager;
import org.bimserver.utils.SwingUtil;
import org.erdc.cobie.shared.utility.FileUtils;
import org.erdc.cobie.toolkit.CobieToolkit;
import org.erdc.cobie.toolkit.CobieToolkitSettings;
import org.erdc.cobie.toolkit.CustomFileAppender;
import org.erdc.cobie.toolkit.gui.controls.COBieFileUtilitiesPanel;
import org.erdc.cobie.toolkit.utils.JComponentCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobieToolkitGui extends JFrame implements ActionListener
{	
	private static final String TITLE_NAME = "COBie Toolkit 1.4.2";
	private static final String ICON_FILENAME = "logo_small.png";
	private static final String SETTINGS_FILENAME = "settings.xml";
	private static final String SETTINGS_FILEPATH = "lib/settings.xml";
	private static final String MERGE_RULES_PATH = "lib/MergeRules";
	private static final String FILE_UTILS_PANEL_TITLE = "COBie File Utilities";
	private static final String OPTIONS_MENU_TEXT = "Options";
	private static final String OBJECT_IDM_ITEM_TEXT = "Object IDM (Ignored Entities)";
	private static final long serialVersionUID = -5428454520760923784L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CobieToolkitGui.class);
	protected static final String APP_NAME = "COBie Toolkit";

	public static void main(String[] args)
	{
		new CobieToolkitGui();
	}

	protected static void setupLogAppender() throws IOException
	{
		File file = new File("cobietoolkit.log");
		CustomFileAppender appender = new CustomFileAppender(file);
		Enumeration<?> currentLoggers = LogManager.getCurrentLoggers();
		LogManager.getRootLogger().addAppender(appender);
		
		while (currentLoggers.hasMoreElements())
		{
			Object nextElement = currentLoggers.nextElement();
			org.apache.log4j.Logger logger2 = (org.apache.log4j.Logger)nextElement;
			logger2.addAppender(appender);
		}
	}

	private final CobieToolkit cobieToolkit;
	private JMenuItem menuItemIDM;
	private JMenuItem mntmCobieSpreadsheetExport;
	private CobieToolkitSettings settings;

	private JComponentCollection bimServerDependentComponents;

	private COBieFileUtilitiesPanel cobieFileUtilitiesPanel;

	public CobieToolkitGui()
	{
		setResizable(false);
		cobieToolkit = new CobieToolkit();
		initializeCobieToolkitGui();
		try
		{
			setupLogAppender();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == menuItemIDM)
		{
			handleMenuItemIDMAction(e);
		}
		else if (e.getSource() == mntmCobieSpreadsheetExport)
		{
			handleMenuItemSpreadsheetExportOptions();
		}

	}

	public CobieToolkit getCobieToolkit()
	{
		return cobieToolkit;
	}

	private void handleMenuItemIDMAction(ActionEvent e)
	{

		IDMOptionsGui idmGUI = new IDMOptionsGui(CobieToolkitGui.this);
		idmGUI.setVisible(true);
	}

	private void handleMenuItemSpreadsheetExportOptions()
	{
		CobieExportOptionsGui cobieExportOptions = new CobieExportOptionsGui(CobieToolkitGui.this);
		cobieExportOptions.setVisible(true);

	}

	private void initializeBimServerDependentControls()
	{
		bimServerDependentComponents = new JComponentCollection();
	}

	private void initializeCOBieMergeRules()
	{
		File mergeRulesDir = new File(MERGE_RULES_PATH);
		if (mergeRulesDir.exists() && mergeRulesDir.isDirectory())
		{
			cobieToolkit.loadMergeRules(mergeRulesDir);
		}
	}

	private void initializeCobieToolkitGui()
	{
		setMinimumSize(new Dimension(500, 400));

		SwingUtil.setLookAndFeelToNice();
		try
		{
			setIconImage(ImageIO.read(getClass().getResource(ICON_FILENAME)));
		}
		catch (IOException e)
		{

		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(664, 673);
		setTitle(TITLE_NAME);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());

		initializeSettings();
		initializeCOBieMergeRules();
		JPanel top = makeTopPanel();

		getContentPane().add(top, BorderLayout.NORTH);
		JTabbedPane tabber = new JTabbedPane();
		getContentPane().add(tabber, BorderLayout.CENTER);

		cobieFileUtilitiesPanel = new COBieFileUtilitiesPanel(cobieToolkit);
		cobieFileUtilitiesPanel.setPreferredSize(new Dimension(649, 545));
		JScrollPane fileUtilsScrollPane = new JScrollPane();
		fileUtilsScrollPane.add(cobieFileUtilitiesPanel);
		fileUtilsScrollPane.setViewportView(cobieFileUtilitiesPanel);
		tabber.addTab(FILE_UTILS_PANEL_TITLE, null, fileUtilsScrollPane, null);

		initializeBimServerDependentControls();
		bimServerDependentComponents.disableAllControls();

	}

	private void initializeSettings()
	{
		File settingsFile = new File(SETTINGS_FILENAME);
		if (!settingsFile.exists())
		{
			try
			{
				FileUtils.copyfile(SETTINGS_FILEPATH, SETTINGS_FILENAME);
			}
			catch (Exception ex)
			{

			}
		}
		if (settingsFile.exists())
		{
			try
			{
				loadSettings(settingsFile);
			}
			catch (JAXBException e)
			{
				LOGGER.error("", e);
			}
		}
		if (settings == null)
		{
			settings = new CobieToolkitSettings();

		}
	}

	private void loadSettings(File settingsFile) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(CobieToolkitSettings.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		settings = (CobieToolkitSettings)unmarshaller.unmarshal(settingsFile);
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
}
