package org.bimserver.cobie.utils.cobiewriters;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.JobType;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.bimserver.models.ifc2x3.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcProcess;
import org.bimserver.models.ifc2x3.IfcRelAssigns;
import org.bimserver.models.ifc2x3.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3.IfcRelAssociates;
import org.bimserver.models.ifc2x3.IfcRelDefines;
import org.bimserver.models.ifc2x3.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.ifc2x3.IfcTask;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToJob 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToJob.class);
	private static final CobieSheetName sheetName = CobieSheetName.Job;
	private final static String _duration = "TaskDuration";
	private final static String _durationUnit = "hour";
	private static final ArrayList<String> _startPropertyNames =
			new ArrayList<String>(Arrays.asList("TaskStartDate"));
	private static final ArrayList<String> _frequencyPropertyNames =
			new ArrayList<String>(Arrays.asList("TaskInterval"));
	
	private final static String _taskStartUnit = COBieUtility.COBieNA;
	private final static String _frequencyUnit = "year";
	private final static String _priors = COBieUtility.COBieNA;
	
	private static ArrayList<String> getStartPropertyNames()
	{
		return _startPropertyNames;
	}
	
	private static ArrayList<String> getFrequencyPropertyNames()
	{
		return _frequencyPropertyNames;
	}
	
	public static void writeJobs(COBIEType cType, IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		COBIEType.Jobs jobs;
		IfcOwnerHistory oh;
		String name;
		String createdBy;
		Calendar createdOn;
		String category;
		String status;
		String typeName;
		String description;
		String duration;
		String durationUnit;
		String start;
		String taskStartUnit;
		String frequency;
		String frequencyUnit;
		String extSystem;
		String extIdentifier;
		String taskNumber;
		String priors;
		String resourceNames;
		try
		{
			jobs = cType.getJobs();
			if (jobs == null || jobs.isNil())
				jobs = cType.addNewJobs();
		}
		catch(Exception ex)
		{
			jobs = cType.addNewJobs();
		}
		for(IfcTask task : model.getAll(IfcTask.class))
		{
			try
			{
				JobType job = jobs.addNewJob();
				name = nameFromTask(task);
				oh = task.getOwnerHistory();
				createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
				createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
				category = IfcToJob.categoryFromTask(task);
				status = IfcToJob.statusFromTask(task);
				typeName = IfcToJob.typeNameFromTask(task);
				description = IfcToJob.descriptionFromTask(task);
				duration = IfcToJob.durationFromTask(task);
				durationUnit = IfcToJob.durationUnitFromTask(task);
				start = IfcToJob.startFromTask(task);
				taskStartUnit = IfcToJob.taskStartUnitFromTask(task);
				frequency = IfcToJob.frequencyFromTask(task);
				frequencyUnit = IfcToJob.frequencyUnitFromTask(task);
				extSystem = COBieUtility.getApplicationName(oh);
				extIdentifier = COBieUtility.getCOBieString(task.getGlobalId().getWrappedValue());
				taskNumber = IfcToJob.taskNumberFromTask(task);
				priors = IfcToJob.priorsFromTask(task);
				resourceNames = IfcToJob.resourceNamesFromTask(task);
						
				job.setName(name);
				job.setCreatedBy(createdBy);
				job.setCreatedOn(createdOn);
				job.setCategory(category);
				job.setStatus(status);
				job.setTypeName(typeName);
				job.setDescription(description);
				job.setDuration(duration);
				job.setDurationUnit(durationUnit);
				job.setStart(start);
				job.setTaskStartUnit(taskStartUnit);
				job.setFrequency(frequency);
				job.setFrequencyUnit(frequencyUnit);
				job.setExtSystem(extSystem);
				job.setExtIdentifier(extIdentifier);
				job.setTaskNumber(taskNumber);
				job.setPriors(priors);
				job.setResourceNames(resourceNames);
				loggerHandler.rowWritten();
			}
			catch(Exception ex)
			{
				loggerHandler.error(ex);
			}
			
		}
		loggerHandler.sheetWritten();
	}

	
	private static String nameFromTask(IfcTask task)
	{
		return COBieUtility.getCOBieString(task.getName());
	}
	
	private static String categoryFromTask(IfcTask task)
	{
		String category = task.getObjectType();
		return COBieUtility.getCOBieString(category);
	}
	
	private static String statusFromTask(IfcTask task)
	{
		String status = task.getStatus();
		return COBieUtility.getCOBieString(status);
	}
	
	private static String typeNameFromTask(IfcTask task)
	{
		String typeNames = "";
		ArrayList<String> typeNamesArray = new ArrayList<String>();
		for(IfcRelAssigns assigns : task.getHasAssignments())
		{
			if (assigns instanceof IfcRelAssignsToProcess)
			{
				IfcRelAssignsToProcess assignsToProcess =
						(IfcRelAssignsToProcess) assigns;
				IfcProcess process = assignsToProcess.getRelatingProcess();
				for (IfcRelAssociates association : process.getHasAssociations())
				{
					for(IfcRoot relatedObject : association.getRelatedObjects())
					{
						if (!(relatedObject instanceof IfcConstructionEquipmentResource))
						{
							typeNamesArray.add(relatedObject.getName());
						}
					}
				}
				for (IfcRelAssigns assignment : process.getHasAssignments())
				{
					for(IfcObjectDefinition relatedObject : assignment.getRelatedObjects())
					{
						typeNamesArray.add(relatedObject.getName());
					}
				}
		
			}
		}
		typeNames = COBieUtility.delimittedStringFromArrayList(typeNamesArray);
		return COBieUtility.getCOBieString(typeNames);
	}
	
	private static String descriptionFromTask(IfcTask task)
	{
		String description = task.getDescription();
		if (description == null || description.isEmpty())
			description = task.getName();
		return COBieUtility.getCOBieString(description);
	}
	
	private static String durationFromTask(IfcTask task)
	{
		String duration = _duration;
		return COBieUtility.getCOBieString(duration);
	}
	
	private static String durationUnitFromTask(IfcTask task)
	{
		String durationUnit = _durationUnit;
		return COBieUtility.getCOBieString(durationUnit);
	}
	
	private static String startFromTask(IfcTask task)
	{
		String start = "";
		Map<String,String> tmpPropMap = new HashMap<String,String>();
		Map<String,String> startPropMap = new HashMap<String,String>();
		ArrayList<String> startPropNames = IfcToJob.getStartPropertyNames();
		for(IfcRelDefines defines : task.getIsDefinedBy())
		{
			if (defines instanceof IfcRelDefinesByProperties)
			{
				tmpPropMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(defines, startPropNames);
				startPropMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropMap, startPropMap);
			}
		}
		return COBieUtility.getCOBieString(start);
	}
	
	private static String taskStartUnitFromTask(IfcTask task)
	{
		String startUnit = _taskStartUnit;
		return COBieUtility.getCOBieString(startUnit);
	}
	
	private static String frequencyFromTask(IfcTask task)
	{
		String frequency = "";
		Map<String,String> tmpPropMap = new HashMap<String,String>();
		Map<String,String> propertyStringMap =
				new HashMap<String,String>();
		ArrayList<String> freqPropNames = IfcToJob.getFrequencyPropertyNames();
		for(IfcRelDefines defines : task.getIsDefinedBy())
		{
			if (defines instanceof IfcRelDefinesByProperties)
			{
				tmpPropMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines
						(defines, freqPropNames);				
				propertyStringMap = IfcRelationshipsToCOBie.mergePropertyStrings(tmpPropMap, propertyStringMap);
			}
		}
		frequency = COBieUtility.cobieStringFromStringMap(propertyStringMap,freqPropNames);
		return COBieUtility.getCOBieString(frequency);
	}
	
	private static String frequencyUnitFromTask(IfcTask task)
	{
		String frequencyUnit = _frequencyUnit;
		return COBieUtility.getCOBieString(frequencyUnit);
	}
	
	private static String taskNumberFromTask(IfcTask task)
	{
		String taskNumber = task.getTaskId();
		return COBieUtility.getCOBieString(taskNumber);
	}
	
	private static String priorsFromTask(IfcTask task)
	{
		String priors = _priors;
		return COBieUtility.getCOBieString(priors);
	}
	
	private static String resourceNamesFromTask(IfcTask task)
	{
		String resourceNames = "";
		ArrayList<String> resourceArray = new ArrayList<String>();
		for(IfcRelAssigns assigns : task.getHasAssignments())
		{
			if (assigns instanceof IfcRelAssignsToProcess)
			{
				IfcRelAssignsToProcess assignsToProcess =
						(IfcRelAssignsToProcess) assigns;
				IfcProcess process = assignsToProcess.getRelatingProcess();
				for (IfcRelAssociates association : process.getHasAssociations())
				{
					for(IfcRoot relatedObject : association.getRelatedObjects())
					{
						if (relatedObject instanceof IfcConstructionEquipmentResource)
						{
							resourceArray.add(relatedObject.getName());
						}
					}
				}
				for (IfcRelAssigns assignment : process.getHasAssignments())
				{
					for(IfcObjectDefinition relatedObject : assignment.getRelatedObjects())
					{
						resourceArray.add(relatedObject.getName());
					}
				}
				
			}
		}
		resourceNames = COBieUtility.delimittedStringFromArrayList(resourceArray);
		return COBieUtility.getCOBieString(resourceNames);
	}
}
