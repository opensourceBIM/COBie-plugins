package org.bimserver.cobie.shared.transform.spreadsheetml.cobietab;

/******************************************************************************

 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.util.ArrayList;
import java.util.Calendar;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.shared.COBieTokenUtility;
import org.bimserver.cobie.shared.COBieTokenUtility.AssemblyColumnNameLiterals;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.nibs.cobie.tab.AssemblyType;
import org.nibs.cobie.tab.COBIEType;

public class AssemblyTransformer extends SpreadsheetMLTransformer
{
   

    public AssemblyTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }

    public AssemblyTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected ArrayList<String> getColumnNames()
    {
        return COBieTokenUtility.AssemblyColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Assembly.toString();
    }

    @Override
    protected void write()
    {
        COBIEType.Assemblies assemblies = getTarget().addNewAssemblies();

        String assemblyName = "";
        String assemblyCreatedBy = "";
        String assemblyCreatedOnString = "";
        Calendar assemblyCreatedOn;
        String assemblySheetName = "";
        String assemblyParentName = "";
        String assemblyChildNames = "";
        String assemblyAssemblyType = "";
        String assemblyExtSystem = "";
        String assemblyExtObject = "";
        String assemblyExtIdentifier = "";
        String assemblyDescription = "";

        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxSheetName;
        int idxParentName;
        int idxChildNames;
        int idxAssemblyType;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        idxName = getColumnDictionary().get(AssemblyColumnNameLiterals.Name.toString());
        idxCreatedBy = getColumnDictionary().get(AssemblyColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = getColumnDictionary().get(AssemblyColumnNameLiterals.CreatedOn.toString());
        idxSheetName = getColumnDictionary().get(AssemblyColumnNameLiterals.SheetName.toString());
        idxParentName = getColumnDictionary().get(AssemblyColumnNameLiterals.ParentName.toString());
        idxChildNames = getColumnDictionary().get(AssemblyColumnNameLiterals.ChildNames.toString());
        idxAssemblyType = getColumnDictionary().get(AssemblyColumnNameLiterals.AssemblyType.toString());
        idxExtSystem = getColumnDictionary().get(AssemblyColumnNameLiterals.ExtSystem.toString());
        idxExtObject = getColumnDictionary().get(AssemblyColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = getColumnDictionary().get(AssemblyColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = getColumnDictionary().get(AssemblyColumnNameLiterals.Description.toString());

        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : getWorksheet().getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                AssemblyType tmpAssembly = assemblies.addNewAssembly();
                if (idxName > -1)
                {
                    assemblyName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    assemblyCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    assemblyCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxSheetName > -1)
                {
                    assemblySheetName = rowData.getCellAt(idxSheetName).getData$();
                }
                if (idxParentName > -1)
                {
                    assemblyParentName = rowData.getCellAt(idxParentName).getData$();
                }
                if (idxChildNames > -1)
                {
                    assemblyChildNames = rowData.getCellAt(idxChildNames).getData$();
                }
                if (idxAssemblyType > -1)
                {
                    assemblyAssemblyType = rowData.getCellAt(idxAssemblyType).getData$();
                }
                if (idxExtSystem > -1)
                {
                    assemblyExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    assemblyExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    assemblyExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    assemblyDescription = rowData.getCellAt(idxDescription).getData$();
                }
                assemblyCreatedOn = getCobieStringHandler().calendarFromString(assemblyCreatedOnString);

                tmpAssembly.setName(cobieStringHandler.getCOBieString(assemblyName));
                tmpAssembly.setCreatedBy(cobieStringHandler.getCOBieString(assemblyCreatedBy));
                tmpAssembly.setCreatedOn(assemblyCreatedOn);
                tmpAssembly.setSheetName(cobieStringHandler.getCOBieString(assemblySheetName));
                tmpAssembly.setParentName(cobieStringHandler.getCOBieString(assemblyParentName));
                tmpAssembly.setChildNames(cobieStringHandler.getCOBieString(assemblyChildNames));
                tmpAssembly.setAssemblyType(cobieStringHandler.getCOBieString(assemblyAssemblyType));
                tmpAssembly.setExtSystem(cobieStringHandler.getCOBieString(assemblyExtSystem));
                tmpAssembly.setExtObject(cobieStringHandler.getCOBieString(assemblyExtObject));
                tmpAssembly.setExtIdentifier(cobieStringHandler.getCOBieString(assemblyExtIdentifier));
                tmpAssembly.setDescription(cobieStringHandler.getCOBieString(assemblyDescription));
            }
        }

    }
}
