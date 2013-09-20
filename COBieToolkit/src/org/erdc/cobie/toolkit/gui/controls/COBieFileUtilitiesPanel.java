package org.erdc.cobie.toolkit.gui.controls;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.erdc.cobie.toolkit.CobieToolkit;

public class COBieFileUtilitiesPanel extends JPanel
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public COBieFileUtilitiesPanel(final CobieToolkit cobieToolkit)
    {
        setMaximumSize(new Dimension(649, 545));
        setMinimumSize(new Dimension(649, 545));

        CobieExportPanel cobieImportExportPanel = new CobieExportPanel(cobieToolkit);
        cobieImportExportPanel.setPreferredSize(new Dimension(627, 183));
        GroupLayout groupLayout_1 = (GroupLayout)cobieImportExportPanel.getLayout();
        groupLayout_1.setAutoCreateGaps(true);
        groupLayout_1.setHonorsVisibility(false);
        FileComparePanel cobieFileComparePanel = new FileComparePanel(cobieToolkit);
        cobieFileComparePanel.setPreferredSize(new Dimension(633, 309));
        GroupLayout groupLayout_2 = (GroupLayout)cobieFileComparePanel.getLayout();
        groupLayout_2.setHonorsVisibility(false);

        JSeparator separator = new JSeparator();
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
                groupLayout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                                groupLayout
                                        .createParallelGroup(Alignment.LEADING)
                                        .addComponent(cobieFileComparePanel, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cobieImportExportPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(separator, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
                groupLayout.createSequentialGroup().addGap(18)
                        .addComponent(cobieImportExportPanel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(cobieFileComparePanel, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE).addContainerGap()));
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setAutoCreateGaps(true);
        setLayout(groupLayout);
    }
}
