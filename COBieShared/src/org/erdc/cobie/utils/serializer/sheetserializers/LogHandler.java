package org.erdc.cobie.utils.serializer.sheetserializers;

/******************************************************************************
 * Copyright (C) 2011  ERDC
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
import java.util.HashMap;
import java.util.Map;

import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.slf4j.Logger;

public class LogHandler
{
    private Logger LOGGER;
    protected static final String formatStringWritingCobie = "COBie Serializer: Writing %s Sheet";
    protected static final String formatStringWrittenCobie = "COBie Serializer: %d %s written, %d errors.";
    protected static final String formatStringBasicCobieError = "COBie Serializer: An exception occured when attempting to derive a %s from the model - %s";
    protected static final String overLimitMessage = "More than 64,000 rows extracted, and only the first 64,000 will be written to the spreadsheetML file.";

    public Map<CobieSheetName, String> sheetNamePlurals;
    private CobieSheetName SheetName;
    private String PluralSheetName;
    private String SingularSheetName;
    private int rowCount;
    private int errorCount;

    public LogHandler(CobieSheetName sheet, Logger sheetLogger)
    {
        LOGGER = sheetLogger;
        sheetNamePlurals = new HashMap<CobieSheetName, String>();
        rowCount = 0;
        errorCount = 0;
        SheetName = sheet;
        initializePlurals();
        SingularSheetName = sheet.toString();
        PluralSheetName = sheetNamePlurals.get(sheet);
    }

    public LogHandler(LogHandler existingCobieStringBuilder)
    {
        rowCount = existingCobieStringBuilder.rowCount;
        errorCount = existingCobieStringBuilder.errorCount;
        SheetName = existingCobieStringBuilder.SheetName;
        PluralSheetName = existingCobieStringBuilder.PluralSheetName;
        sheetNamePlurals = new HashMap<CobieSheetName, String>();
        LOGGER = existingCobieStringBuilder.LOGGER;
        initializePlurals();
    }

    public String error(Exception ex)
    {
        errorCount++;
        String errorString = String.format(formatStringBasicCobieError, SingularSheetName, ex.getMessage());
        LOGGER.error(errorString);
        return errorString;
    }

    private void initializePlurals()
    {
        sheetNamePlurals.put(CobieSheetName.Assembly, "Assemblies");
        sheetNamePlurals.put(CobieSheetName.Attribute, "Attributes");
        sheetNamePlurals.put(CobieSheetName.Component, "Components");
        sheetNamePlurals.put(CobieSheetName.Connection, "Connections");
        sheetNamePlurals.put(CobieSheetName.Contact, "Contacts");
        sheetNamePlurals.put(CobieSheetName.Document, "Documents");
        sheetNamePlurals.put(CobieSheetName.Facility, "Facilities");
        sheetNamePlurals.put(CobieSheetName.Floor, "Floors");
        sheetNamePlurals.put(CobieSheetName.Job, "Jobs");
        sheetNamePlurals.put(CobieSheetName.Resource, "Resources");
        sheetNamePlurals.put(CobieSheetName.Space, "Spaces");
        sheetNamePlurals.put(CobieSheetName.Spare, "Spares");
        sheetNamePlurals.put(CobieSheetName.System, "Systems");
        sheetNamePlurals.put(CobieSheetName.Type, "Types");
        sheetNamePlurals.put(CobieSheetName.Zone, "Zones");
        sheetNamePlurals.put(CobieSheetName.Impact, "Impacts");
        sheetNamePlurals.put(CobieSheetName.Coordinate, "Coordinates");
        sheetNamePlurals.put(CobieSheetName.Issue, "Issues");
    }

    public String rowWritten()
    {
        String rowWrittenStr = "";
        rowCount++;
        return rowWrittenStr;
    }

    public String sheetWriteBegin()
    {
        String beginString = String.format(formatStringWritingCobie, SingularSheetName);
        LOGGER.info(beginString);
        return beginString;
    }

    public String sheetWritten()
    {
        String writtenString = String.format(formatStringWrittenCobie, rowCount, PluralSheetName, errorCount);
        if (rowCount > 64000)
        {
            writtenString += "." + "\n" + LogHandler.overLimitMessage;
        }
        LOGGER.info(writtenString);
        return writtenString;
    }
}
