package org.erdc.cobie.sheetxmldata.parsers.spreadsheetml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.JobType;
import org.erdc.cobie.utils.stringwriters.COBieStringHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobParser extends Parser
{
    public JobParser(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(cobie, workbook, cobieStringWriter);
    }

    public static enum JobColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, Status, TypeName, Description, Duration, DurationUnit, Start, TaskStartUnit, Frequency, FrequencyUnit, ExtSystem, ExtObject, ExtIdentifier, TaskNumber, Priors, ResourceNames
    }

    public static ArrayList<String> JobColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category", "Status",
            "TypeName", "Description", "Duration", "DurationUnit", "Start", "TaskStartUnit", "Frequency", "FrequencyUnit", "ExtSystem", "ExtObject",
            "ExtIdentifier", "TaskNumber", "Priors", "ResourceNames"));

    public JobParser(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    };

    @Override
    protected List<String> getColumnNames()
    {
        return JobColumnNames;
    }

    @Override
    protected Logger getLogger()
    {
        return LoggerFactory.getLogger(JobParser.class);
    }

    @Override
    protected String getWorksheetName()
    {
        return CobieSheetName.Job.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Jobs jobs = getCobie().addNewJobs();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String jobName = "";
        String jobCreatedBy = "";
        String jobCreatedOnString = "";
        Calendar jobCreatedOn;
        String jobCategory = "";
        String jobStatus = "";
        String jobTypeName = "";
        String jobDescription = "";
        String jobDuration = "";
        String jobDurationUnit = "";
        String jobStart = "";
        String jobTaskStartUnit = "";
        String jobFrequency = "";
        String jobFrequencyUnit = "";
        String jobExtSystem = "";
        String jobExtObject = "";
        String jobExtIdentifier = "";
        String jobTaskNumber = "";
        String jobPriors = "";
        String jobResourceNames = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxStatus;
        int idxTypeName;
        int idxDescription;
        int idxDuration;
        int idxDurationUnit;
        int idxStart;
        int idxTaskStartUnit;
        int idxFrequency;
        int idxFrequencyUnit;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxTaskNumber;
        int idxPriors;
        int idxResourceNames;
        idxName = columnDictionary.get(JobColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(JobColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(JobColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(JobColumnNameLiterals.Category.toString());
        idxStatus = columnDictionary.get(JobColumnNameLiterals.Status.toString());
        idxTypeName = columnDictionary.get(JobColumnNameLiterals.TypeName.toString());
        idxDescription = columnDictionary.get(JobColumnNameLiterals.Description.toString());
        idxDuration = columnDictionary.get(JobColumnNameLiterals.Duration.toString());
        idxDurationUnit = columnDictionary.get(JobColumnNameLiterals.DurationUnit.toString());
        idxStart = columnDictionary.get(JobColumnNameLiterals.Start.toString());
        idxTaskStartUnit = columnDictionary.get(JobColumnNameLiterals.TaskStartUnit.toString());
        idxFrequency = columnDictionary.get(JobColumnNameLiterals.Frequency.toString());
        idxFrequencyUnit = columnDictionary.get(JobColumnNameLiterals.FrequencyUnit.toString());
        idxExtSystem = columnDictionary.get(JobColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(JobColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(JobColumnNameLiterals.ExtIdentifier.toString());
        idxTaskNumber = columnDictionary.get(JobColumnNameLiterals.TaskNumber.toString());
        idxPriors = columnDictionary.get(JobColumnNameLiterals.Priors.toString());
        idxResourceNames = columnDictionary.get(JobColumnNameLiterals.ResourceNames.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                JobType tmpJob = jobs.addNewJob();
                if (idxName > -1)
                {
                    jobName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    jobCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    jobCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    jobCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxStatus > -1)
                {
                    jobStatus = rowData.getCellAt(idxStatus).getData$();
                }
                if (idxTypeName > -1)
                {
                    jobTypeName = rowData.getCellAt(idxTypeName).getData$();
                }
                if (idxDescription > -1)
                {
                    jobDescription = rowData.getCellAt(idxDescription).getData$();
                }
                if (idxDuration > -1)
                {
                    jobDuration = rowData.getCellAt(idxDuration).getData$();
                }
                if (idxDurationUnit > -1)
                {
                    jobDurationUnit = rowData.getCellAt(idxDurationUnit).getData$();
                }
                if (idxStart > -1)
                {
                    jobStart = rowData.getCellAt(idxStart).getData$();
                }
                if (idxTaskStartUnit > -1)
                {
                    jobTaskStartUnit = rowData.getCellAt(idxTaskStartUnit).getData$();
                }
                if (idxFrequency > -1)
                {
                    jobFrequency = rowData.getCellAt(idxFrequency).getData$();
                }
                if (idxFrequencyUnit > -1)
                {
                    jobFrequencyUnit = rowData.getCellAt(idxFrequencyUnit).getData$();
                }
                if (idxExtSystem > -1)
                {
                    jobExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    jobExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    jobExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxTaskNumber > -1)
                {
                    jobTaskNumber = rowData.getCellAt(idxTaskNumber).getData$();
                }
                if (idxPriors > -1)
                {
                    jobPriors = rowData.getCellAt(idxPriors).getData$();
                }
                if (idxResourceNames > -1)
                {
                    jobResourceNames = rowData.getCellAt(idxResourceNames).getData$();
                }
                jobCreatedOn = getCobieStringHandler().calendarFromString(jobCreatedOnString);
                tmpJob.setName(cobieStringHandler.getCOBieString(jobName));
                tmpJob.setCreatedBy(cobieStringHandler.getCOBieString(jobCreatedBy));
                tmpJob.setCreatedOn(jobCreatedOn);
                tmpJob.setCategory(cobieStringHandler.getCOBieString(jobCategory));
                tmpJob.setStatus(cobieStringHandler.getCOBieString(jobStatus));
                tmpJob.setTypeName(cobieStringHandler.getCOBieString(jobTypeName));
                tmpJob.setDescription(cobieStringHandler.getCOBieString(jobDescription));
                tmpJob.setDuration(cobieStringHandler.getCOBieString(jobDuration));
                tmpJob.setDurationUnit(cobieStringHandler.getCOBieString(jobDurationUnit));
                tmpJob.setStart(cobieStringHandler.getCOBieString(jobStart));
                tmpJob.setTaskStartUnit(cobieStringHandler.getCOBieString(jobTaskStartUnit));
                tmpJob.setFrequency(cobieStringHandler.getCOBieString(jobFrequency));
                tmpJob.setFrequencyUnit(cobieStringHandler.getCOBieString(jobFrequencyUnit));
                tmpJob.setExtSystem(cobieStringHandler.getCOBieString(jobExtSystem));
                tmpJob.setExtObject(cobieStringHandler.getCOBieString(jobExtObject));
                tmpJob.setExtIdentifier(cobieStringHandler.getCOBieString(jobExtIdentifier));
                tmpJob.setTaskNumber(cobieStringHandler.getCOBieString(jobTaskNumber));
                tmpJob.setPriors(cobieStringHandler.getCOBieString(jobPriors));
                tmpJob.setResourceNames(cobieStringHandler.getCOBieString(jobResourceNames));
            }
        }
    }

}
