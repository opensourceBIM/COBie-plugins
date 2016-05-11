package com.prairiesky.transform.template;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bimserver.cobie.shared.transform.Transformer;
import org.nibs.cobie.tab.COBIEDocument;

import com.prairiesky.transform.template.schema.SpreadsheetTemplateTable;
import com.prairiesky.transform.template.schema.productinstallation.ContactLookupTable;
import com.prairiesky.transform.template.schema.productinstallation.GeneralInstalledProductTable;
import com.prairiesky.transform.template.schema.productinstallation.SpaceLookupTable;
import com.prairiesky.transform.template.schema.productinstallation.TableCollection;
import com.prairiesky.transform.template.schema.productinstallation.TypeLookupTable;

public class CobieToGeneralProductXLSXTransform extends
		Transformer<COBIEDocument, Workbook>
{

	private final Workbook blankFormattedWorkbookTemplate;
	public CobieToGeneralProductXLSXTransform(COBIEDocument source,
			Workbook target, Workbook blankFormattedTemplate)
	{
		super(source, target);
		this.blankFormattedWorkbookTemplate = blankFormattedTemplate;
	}

	@Override
	public Workbook transform()
	{
		Workbook result = null;
		List<SpreadsheetTemplateTable> tables = new ArrayList<>();
		GeneralInstalledProductTable products =
				new GeneralInstalledProductTable();
		products.populateFromCobie(getSource());
		ContactLookupTable contacts =
				new ContactLookupTable();
		contacts.populateFromCobie(getSource());
		TypeLookupTable types =
				new TypeLookupTable();
		types.populateFromCobie(getSource());
		SpaceLookupTable spaces =
				new SpaceLookupTable();
		spaces.populateFromCobie(getSource());
		tables.add(products);
		tables.add(contacts);
		tables.add(spaces);
		tables.add(types);
		TableWorkbookTransform transform = new 
				TableWorkbookTransform(new TableCollection(tables), new XSSFWorkbook(), getBlankFormattedWorkbookTemplate());
		result = transform.transform();
		return result;
	}

	public Workbook getBlankFormattedWorkbookTemplate()
	{
		return blankFormattedWorkbookTemplate;
	}
	
	

}
