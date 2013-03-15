package org.erdc.cobie.toolkit.gui.controls;

import javax.swing.JTable;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.interfaces.ServiceInterface;

public class SProjectJTable extends JTable
{
	private ServiceInterface service;
	public ServiceInterface getService()
	{
		return service;
	}

	public void setService(ServiceInterface service)
	{
		this.service = service;
	}


	private SProject project;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SProjectJTable()
	{
		super();
	}
	
	public SProjectJTable(SProject project,ServiceInterface service)
	{
		super();
		this.service = service;
		this.project = project;

	}
	
	public void setProject(SProject project)
	{
		this.project = project;
		dataBind();
		
	}
	
	public void clearTable()
	{
		this.setModel(new SProjectTableModel());
	}
	
	public SProjectJTable(ServiceInterface service)
	{
		super();
		this.service = service;

	}
	
	
	public void dataBind()
	{
		SProjectTableModel tblModel =
				new SProjectTableModel(project,service);
		this.setModel(tblModel);
	}
	
	 
    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
    		return false;
        }
    

}
