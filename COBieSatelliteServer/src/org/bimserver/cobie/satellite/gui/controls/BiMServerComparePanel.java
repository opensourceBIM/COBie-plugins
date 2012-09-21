package org.bimserver.cobie.satellite.gui.controls;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.cobie.satellite.SRevisionAndSProject;
import org.bimserver.cobie.satellite.tasks.BiMServerCompareTask;
import org.bimserver.cobie.satellite.tasks.CompareTask;
import org.bimserver.cobie.satellite.tasks.ApplicationTask;
import org.bimserver.cobie.satellite.utils.JComponentCollection;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.cobie.COBieSharedUtilities.COBIE_FILE_TYPE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiMServerComparePanel extends COBieSatelliteTaskPanel<BiMServerCompareTask> implements TreeSelectionListener

{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BiMServerComparePanel.class);
	private static final String VALIDATION_ERROR_PREFIX_COMPARE = "Compare not performed";
	private static final String VALIDATION_ERROR_MESSAGE_MODELS_SAME = VALIDATION_ERROR_PREFIX_COMPARE+", baseline and revision are the same";
	private BimServerModelTree modelTree;
	private JSplitPane splitPane_1;
	private JLabel lblRevision;
	private JComboBox cbRevision1;
	private JLabel lblRevision2;
	private JComboBox cbRevision2;
	private JButton btnCompare;
	private SProjectJTable tblRevisions;

	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblProgress;
	BiMServerCompareTask compareTask;
	private JProgressBar progressBar;
	private BiMServerModelLabelRenderer cobieControlRenderer;
	public void setCOBieSatelliteServer(CobieSatelliteServer cobieSatelliteServer)
	{
		this.setCOBieSatelliteServer(cobieSatelliteServer);
		//initializeProjectTable(cobieSatelliteServer);
		tblRevisions.setService(cobieSatelliteServer.getBimServerGuiClient().getServiceInterface());
		
	}
	public BiMServerComparePanel(final CobieSatelliteServer cobieSatelliteServer,
			boolean requiresRunningBiMServer)
	{
		
		super(cobieSatelliteServer,requiresRunningBiMServer);

		cobieControlRenderer = new BiMServerModelLabelRenderer();
		
		modelTree = new BimServerModelTree();


		lblRevision = new JLabel("Compare Baseline Model");
		
		cbRevision1 = new JComboBox();
		
		lblRevision2 = new JLabel("To Revised Model");
		
		cbRevision2 = new JComboBox();
		
		btnCompare = new JButton("Compare");
		
		 progressBar = new JProgressBar();
		 


		lblProgress =  new JLabel();
		lblProgress.setText("New label");
		super.setProgressBar(progressBar);
		super.setProgressTextArea(lblProgress);
		initializeProgressComponents();
		
		btnCompare.addActionListener(BiMServerComparePanel.this);
		
		
		initializeProjectTable(cobieSatelliteServer);;
		tblRevisions.setFillsViewportHeight(true);
		tblRevisions.setRowSelectionAllowed(false);
		tblRevisions = new SProjectJTable(cobieSatelliteServer.getBimServerGuiClient().getServiceInterface());
		tblRevisions.setFillsViewportHeight(true);
		super.setProgressTextArea(lblProgress);
		super.setProgressBar(progressBar);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(modelTree);
		JScrollPane scrollPaneRevisions = new JScrollPane();
		scrollPaneRevisions.setViewportView(tblRevisions);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPaneRevisions, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRevision)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cbRevision2, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbRevision1, Alignment.TRAILING, 0, 211, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
										.addComponent(btnCompare)
										.addComponent(lblProgress, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRevision2)))
					.addGap(4))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRevision)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbRevision1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCompare))
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblRevision2)
									.addComponent(cbRevision2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblProgress, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(scrollPaneRevisions, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addGap(6))
		);
		setLayout(groupLayout);
	//	scrollPaneRevisionsTable.set
		
		initializeDisconnectedModelTree();
		initializeToggleComponents();

	}
	public void initializeProjectTable(CobieSatelliteServer cobieSatelliteServer)
	{
		//tblRevisions = new SProjectJTable();
		try
		{
			tblRevisions = new SProjectJTable(cobieSatelliteServer.getBimServerClient().getServiceInterface());
		}
		catch(Exception e)
		{
			tblRevisions = new SProjectJTable();
		}
	}
	
	@Override
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		if(!enabled)
			initializeDisconnectedControls();
	}
	
	private void initializeDisconnectedControls()
	{
		initializeDisconnectedModelTree();
		clearListBoxes();
		tblRevisions.clearTable();
	}
	
	private void clearListBoxes()
	{
		cbRevision1.removeAllItems();
		cbRevision2.removeAllItems();
	}
	
	public void connect(CobieSatelliteServer satelliteServer)
	{
		setCOBieSatelliteServer(satelliteServer);
		
		populateProjectTree();
	}
	
	private void initializeDisconnectedModelTree()
	{
		modelTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("BiMServerModels (Connect to Populate)") {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
				}
			}
		));
	}
	

	public void populateProjectTree()
	{
		try
		{
			modelTree.setService(super.getSatelliteServer().getBimServerGuiClient().getServiceInterface());
			modelTree.dataBind();
		}
		catch(Exception e)
		{
			
		}
		modelTree.addTreeSelectionListener(BiMServerComparePanel.this);
		modelTree.setVisible(true);

	}

	
	public void valueChanged(TreeSelectionEvent e)
	{
		Object obj = modelTree.getLastSelectedPathComponent();
		if (obj instanceof SProjectTreeNode)
		{
			SProjectTreeNode projectNode =
					(SProjectTreeNode) obj;
			tblRevisions.setProject(projectNode.getProject());
			populateRevisionComboBoxes();
		}
		
	}
	
	private SRevision getSelectedBaselineRevision()
	{
		SRevision revision = null;
		Object cb1SelectedItem = this.cbRevision1.getSelectedItem();
		if (cb1SelectedItem instanceof SRevision)
			revision = (SRevision) cb1SelectedItem;
		else if (cb1SelectedItem instanceof SRevisionAndSProject)
		{
			SRevisionAndSProject revisionProject =
					(SRevisionAndSProject) cb1SelectedItem;
			revision = revisionProject.getRevision();
		}
		return revision;
	}
	
	private SRevision getSelectedTargetRevision()
	{
		SRevision revision = null;
		Object cb2SelectedItem = this.cbRevision2.getSelectedItem();
		if (cb2SelectedItem instanceof SRevision)
			revision = (SRevision) cb2SelectedItem;
		else if (cb2SelectedItem instanceof SRevisionAndSProject)
		{
			SRevisionAndSProject revisionProject =
					(SRevisionAndSProject) cb2SelectedItem;
			revision = revisionProject.getRevision();
		}
		return revision;
	}
	
	private void populateRevisionComboBoxes()
	{
		clearRevisionComboBoxes();
		TableModel tblModel = tblRevisions.getModel();
		if (tblModel instanceof SProjectTableModel)
		{
			SProjectTableModel projectTblModel =
					(SProjectTableModel) tblModel;
			ArrayList<SRevisionAndSProject> revisions = projectTblModel.getRevisionsWithTheirProjects();
			if (revisions!=null && revisions.size()>0)
			{

				for(SRevisionAndSProject revision:revisions)
				{
					cbRevision1.addItem(revision);
					cbRevision2.addItem(revision);
				}
			}
		}
		
		cbRevision1.setRenderer(cobieControlRenderer);
		cbRevision2.setRenderer(cobieControlRenderer);
	}

	public void clearRevisionComboBoxes()
	{
		cbRevision1.removeAll();
		cbRevision2.removeAll();
		cbRevision1.removeAllItems();
		cbRevision2.removeAllItems();
	}
	private String getNullRevisionSelectionText(SRevision baseline,SRevision target)
	{
		String errorMessage=VALIDATION_ERROR_PREFIX_COMPARE;
		if (baseline==null)
			errorMessage+="Baseline model is null";
		if(target==null)
		{
			errorMessage +=", Revision model is null";
		}
		return errorMessage;
	}
	private String getNullRevisionSelectionText(long baseline,long target)
	{
		String errorMessage=VALIDATION_ERROR_PREFIX_COMPARE;
		if (baseline==0L)
			errorMessage+="Baseline model is null";
		if(target==0L)
		{
			errorMessage +=", Revision model is null";
		}
		return errorMessage;
	}
	
	public boolean validateComparison()
	{
		long roid1,roid2;
		SRevision baselineRevision = getSelectedBaselineRevision();
		SRevision targetRevision = getSelectedTargetRevision();
		boolean canPerformCompare = true;
		if (baselineRevision==null || targetRevision==null)
		{
			canPerformCompare = false;
			String error = getNullRevisionSelectionText(baselineRevision,targetRevision);
			handleValidationError(error,false);
		}
		if (canPerformCompare)
		{
			roid1 = getSelectedBaselineRevision().getOid();
			roid2 = getSelectedTargetRevision().getOid();
			if (roid1==0L || roid2==0L)
			{
				canPerformCompare=false;
				String error = getNullRevisionSelectionText(roid1,roid2);
				handleValidationError(error,false);
			}
			if (roid1==roid2)
			{
				canPerformCompare=false;
				handleValidationError(VALIDATION_ERROR_MESSAGE_MODELS_SAME,false);
			}
		}
		
		
		return canPerformCompare;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (validateComparison())
		{
			long roid1 = getSelectedBaselineRevision().getOid();
			long roid2 = getSelectedTargetRevision().getOid();
			CobieFileChoser fc = new CobieFileChoser(COBIE_FILE_TYPE.COBieCompareReport);
			int returnVal = fc.showSaveDialog(BiMServerComparePanel.this);
		
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{	
					 compareTask =
							new BiMServerCompareTask(super.getSatelliteServer(), roid1, roid2, 
									fc.getSelectedFileWithFilterExtension().getAbsolutePath(),getInformable(),true);
					try
					{
						super.executeInstantiatedTask(compareTask);
					}
					catch (Exception e1)
					{
						// TODO Auto-generated catch block
						handleError("An exception occured while initializing compare task",e1,LOGGER,false);
					}
			}
		}
	
	}
	

	@Override
	public BiMServerCompareTask getCOBieSatelliteApplicationTask()
	{
		return compareTask;
	}
	@Override
	public void onConnect()
	{
		tblRevisions.setService(getSatelliteServer().getBimServerGuiClient().getServiceInterface());
		populateProjectTree();
		
	}
	@Override
	public void onDisconnect()
	{

		initializeDisconnectedModelTree();
		clearListBoxes();
		tblRevisions.clearTable();
	}
	@Override
	public void refresh()
	{
		populateProjectTree();
		
		
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}
	@Override
	public JComponent[] getDefaultToggleComponents()
	{
		return new JComponent[]{btnCompare,modelTree,cbRevision1,cbRevision2};
	}
}
