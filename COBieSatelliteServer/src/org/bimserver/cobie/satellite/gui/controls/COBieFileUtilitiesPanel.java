package org.bimserver.cobie.satellite.gui.controls;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;

public class COBieFileUtilitiesPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CobieSatelliteServer satelliteServer;
	public COBieFileUtilitiesPanel(final CobieSatelliteServer satelliteServer) {
		setMinimumSize(new Dimension(647, 662));
		
		CobieExportPanel cobieImportExportPanel = new CobieExportPanel(satelliteServer);
		GroupLayout groupLayout_1 = (GroupLayout) cobieImportExportPanel.getLayout();
		groupLayout_1.setAutoCreateGaps(true);
		groupLayout_1.setHonorsVisibility(false);
		


		FileComparePanel cobieFileComparePanel = new FileComparePanel(satelliteServer);
		GroupLayout groupLayout_2 = (GroupLayout) cobieFileComparePanel.getLayout();
		groupLayout_2.setHonorsVisibility(false);
		
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(cobieImportExportPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
						.addComponent(cobieFileComparePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(cobieImportExportPanel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cobieFileComparePanel, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		setLayout(groupLayout);
	}
}
