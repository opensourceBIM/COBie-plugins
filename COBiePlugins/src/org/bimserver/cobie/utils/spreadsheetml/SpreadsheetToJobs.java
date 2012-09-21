package org.bimserver.cobie.utils.spreadsheetml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.JobType;
import org.bimserver.shared.cobie.COBieUtility;

public class SpreadsheetToJobs
{
	public static ArrayList<String> JobColumnNames = new ArrayList<String>(
			Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
					"Status", "TypeName", "Description", "Duration",
					"DurationUnit", "Start", "TaskStartUnit", "Frequency",
					"FrequencyUnit", "ExtSystem", "ExtObject", "ExtIdentifier",
					"TaskNumber", "Priors", "ResourceNames"));

	public static enum JobColumnNameLiterals
	{
		Name, CreatedBy, CreatedOn, Category, Status, TypeName, Description, Duration, DurationUnit, Start, TaskStartUnit, Frequency, FrequencyUnit, ExtSystem, ExtObject, ExtIdentifier, TaskNumber, Priors, ResourceNames
	};

	public static ArrayList<String> getJobColumns()
	{
		return JobColumnNames;
	}

	public static void writeJobsToCOBie(COBIEType cType, Workbook workbook)
	{
		COBIEType.Jobs jobs = cType.addNewJobs();
		Worksheet sheet = workbook.getWorksheet(COBieUtility.CobieSheetName.Job
				.toString());
		Map<String, Integer> columnDictionary = COBieSpreadSheet
				.GetWorksheetColumnDictionary(sheet, getJobColumns());
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
		idxCreatedBy = columnDictionary.get(JobColumnNameLiterals.CreatedBy
				.toString());
		idxCreatedOn = columnDictionary.get(JobColumnNameLiterals.CreatedOn
				.toString());
		idxCategory = columnDictionary.get(JobColumnNameLiterals.Category
				.toString());
		idxStatus = columnDictionary.get(JobColumnNameLiterals.Status
				.toString());
		idxTypeName = columnDictionary.get(JobColumnNameLiterals.TypeName
				.toString());
		idxDescription = columnDictionary.get(JobColumnNameLiterals.Description
				.toString());
		idxDuration = columnDictionary.get(JobColumnNameLiterals.Duration
				.toString());
		idxDurationUnit = columnDictionary
				.get(JobColumnNameLiterals.DurationUnit.toString());
		idxStart = columnDictionary.get(JobColumnNameLiterals.Start.toString());
		idxTaskStartUnit = columnDictionary
				.get(JobColumnNameLiterals.TaskStartUnit.toString());
		idxFrequency = columnDictionary.get(JobColumnNameLiterals.Frequency
				.toString());
		idxFrequencyUnit = columnDictionary
				.get(JobColumnNameLiterals.FrequencyUnit.toString());
		idxExtSystem = columnDictionary.get(JobColumnNameLiterals.ExtSystem
				.toString());
		idxExtObject = columnDictionary.get(JobColumnNameLiterals.ExtObject
				.toString());
		idxExtIdentifier = columnDictionary
				.get(JobColumnNameLiterals.ExtIdentifier.toString());
		idxTaskNumber = columnDictionary.get(JobColumnNameLiterals.TaskNumber
				.toString());
		idxPriors = columnDictionary.get(JobColumnNameLiterals.Priors
				.toString());
		idxResourceNames = columnDictionary
				.get(JobColumnNameLiterals.ResourceNames.toString());
		int rowIdx;
		int firstRowIdx = sheet.firstRow;
		for (Row rowData : sheet.getRows())
		{
			rowIdx = rowData.getIndex();
			if (rowIdx > firstRowIdx)
			{
				JobType tmpJob = jobs.addNewJob();
				if (idxName > -1)
					jobName = rowData.getCellAt(idxName).getData$();
				if (idxCreatedBy > -1)
					jobCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
				if (idxCreatedOn > -1)
					jobCreatedOnString = rowData.getCellAt(idxCreatedOn)
							.getData$();
				if (idxCategory > -1)
					jobCategory = rowData.getCellAt(idxCategory).getData$();
				if (idxStatus > -1)
					jobStatus = rowData.getCellAt(idxStatus).getData$();
				if (idxTypeName > -1)
					jobTypeName = rowData.getCellAt(idxTypeName).getData$();
				if (idxDescription > -1)
					jobDescription = rowData.getCellAt(idxDescription)
							.getData$();
				if (idxDuration > -1)
					jobDuration = rowData.getCellAt(idxDuration).getData$();
				if (idxDurationUnit > -1)
					jobDurationUnit = rowData.getCellAt(idxDurationUnit)
							.getData$();
				if (idxStart > -1)
					jobStart = rowData.getCellAt(idxStart).getData$();
				if (idxTaskStartUnit > -1)
					jobTaskStartUnit = rowData.getCellAt(idxTaskStartUnit)
							.getData$();
				if (idxFrequency > -1)
					jobFrequency = rowData.getCellAt(idxFrequency).getData$();
				if (idxFrequencyUnit > -1)
					jobFrequencyUnit = rowData.getCellAt(idxFrequencyUnit)
							.getData$();
				if (idxExtSystem > -1)
					jobExtSystem = rowData.getCellAt(idxExtSystem).getData$();
				if (idxExtObject > -1)
					jobExtObject = rowData.getCellAt(idxExtObject).getData$();
				if (idxExtIdentifier > -1)
					jobExtIdentifier = rowData.getCellAt(idxExtIdentifier)
							.getData$();
				if (idxTaskNumber > -1)
					jobTaskNumber = rowData.getCellAt(idxTaskNumber).getData$();
				if (idxPriors > -1)
					jobPriors = rowData.getCellAt(idxPriors).getData$();
				if (idxResourceNames > -1)
					jobResourceNames = rowData.getCellAt(idxResourceNames)
							.getData$();
				jobCreatedOn = COBieUtility
						.calendarFromString(jobCreatedOnString);
				tmpJob.setName(COBieUtility.getCOBieString(jobName));
				tmpJob.setCreatedBy(COBieUtility.getCOBieString(jobCreatedBy));
				tmpJob.setCreatedOn(jobCreatedOn);
				tmpJob.setCategory(COBieUtility.getCOBieString(jobCategory));
				tmpJob.setStatus(COBieUtility.getCOBieString(jobStatus));
				tmpJob.setTypeName(COBieUtility.getCOBieString(jobTypeName));
				tmpJob.setDescription(COBieUtility
						.getCOBieString(jobDescription));
				tmpJob.setDuration(COBieUtility.getCOBieString(jobDuration));
				tmpJob.setDurationUnit(COBieUtility
						.getCOBieString(jobDurationUnit));
				tmpJob.setStart(COBieUtility.getCOBieString(jobStart));
				tmpJob.setTaskStartUnit(COBieUtility
						.getCOBieString(jobTaskStartUnit));
				tmpJob.setFrequency(COBieUtility.getCOBieString(jobFrequency));
				tmpJob.setFrequencyUnit(COBieUtility
						.getCOBieString(jobFrequencyUnit));
				tmpJob.setExtSystem(COBieUtility.getCOBieString(jobExtSystem));
				tmpJob.setExtObject(COBieUtility.getCOBieString(jobExtObject));
				tmpJob.setExtIdentifier(COBieUtility
						.getCOBieString(jobExtIdentifier));
				tmpJob.setTaskNumber(COBieUtility.getCOBieString(jobTaskNumber));
				tmpJob.setPriors(COBieUtility.getCOBieString(jobPriors));
				tmpJob.setResourceNames(COBieUtility
						.getCOBieString(jobResourceNames));
			}
		}
	}

}
