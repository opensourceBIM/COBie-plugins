package com.prairiesky.transform.template;

import java.io.File;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Workbook;
import org.bimserver.cobie.shared.transform.Transformer;
import org.nibs.cobie.tab.COBIEDocument;
import org.nibs.cobie.tab.COBIEType;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;
import com.prairiesky.transform.template.schema.cobietab.AssemblyTable;
import com.prairiesky.transform.template.schema.cobietab.AttributeTable;
import com.prairiesky.transform.template.schema.cobietab.ComponentTable;
import com.prairiesky.transform.template.schema.cobietab.ConnectionTable;
import com.prairiesky.transform.template.schema.cobietab.ContactTable;
import com.prairiesky.transform.template.schema.cobietab.CoordinateTable;
import com.prairiesky.transform.template.schema.cobietab.DocumentTable;
import com.prairiesky.transform.template.schema.cobietab.FacilityTable;
import com.prairiesky.transform.template.schema.cobietab.FloorTable;
import com.prairiesky.transform.template.schema.cobietab.ImpactTable;
import com.prairiesky.transform.template.schema.cobietab.IssueTable;
import com.prairiesky.transform.template.schema.cobietab.JobTable;
import com.prairiesky.transform.template.schema.cobietab.ResourceTable;
import com.prairiesky.transform.template.schema.cobietab.SpaceTable;
import com.prairiesky.transform.template.schema.cobietab.SpareTable;
import com.prairiesky.transform.template.schema.cobietab.SystemTable;
import com.prairiesky.transform.template.schema.cobietab.TypeTable;
import com.prairiesky.transform.template.schema.cobietab.ZoneTable;
import com.prairiesky.transform.template.schema.productinstallation.TableCollection;

public class CobieTabToCobieXLSXTransformer extends
		Transformer<COBIEDocument, Workbook>
{

	private final Workbook blankTemplate; 
	
	
	public CobieTabToCobieXLSXTransformer(COBIEDocument source, Workbook target, Workbook blankTemplate)
	{
		super(source, target);
		this.blankTemplate = blankTemplate;
	}
	
	public Workbook getBlankTemplate()
	{ 
		return blankTemplate; 
	}


	@Override
	public Workbook transform()
	{
		TableCollection tables = new TableCollection(Arrays.asList(
				new ContactTable(),
				new FacilityTable(),
				new FloorTable(),
				new SpaceTable(),
				new ZoneTable(),
				new TypeTable(),
				new ComponentTable(),
				new SystemTable(),
				new AssemblyTable(),
				new ConnectionTable(),
				new SpareTable(),
				new ResourceTable(),
				new JobTable(),
				new ImpactTable(),
				new DocumentTable(),
				new AttributeTable(),
				new CoordinateTable(),
				new IssueTable()));
		populateTables(tables);
		TableWorkbookTransform transformer =
				new TableWorkbookTransform(tables, getTarget(), getBlankTemplate());
		setTarget(transformer.transform());
		return getTarget();
		
	}

	private void populateTables(TableCollection tables)
	{
		if(getSource() != null && getSource().getCOBIE() != null)
		{
			COBIEType cobie = getSource().getCOBIE();
			for(SpreadsheetTemplateTable table : tables.getTables())
			{
				table.populateFromCobie(getSource());
			}
		}
		
		
	}

}
