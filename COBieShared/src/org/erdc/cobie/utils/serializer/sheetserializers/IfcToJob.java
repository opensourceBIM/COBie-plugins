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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelSequence;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcTask;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.JobType;
import org.erdc.cobie.utils.stringwriters.IfcPropertyToCOBieString;
import org.erdc.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.erdc.cobie.utils.stringwriters.IfcSingleValueToCOBieString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcToJob
{
    private static final Logger LOGGER = LoggerFactory.getLogger(IfcToJob.class);
    private static final CobieSheetName sheetName = CobieSheetName.Job;
    private final static String TASK_DURATION_PROPERTY_NAME = "TaskDuration";
    private static final ArrayList<String> _startPropertyNames = new ArrayList<String>(Arrays.asList("TaskStartDate"));
    private static final ArrayList<String> _frequencyPropertyNames = new ArrayList<String>(Arrays.asList("TaskInterval"));
    private static final ArrayList<String> _DURATION_PROPERTY_NAMES = new ArrayList<String>(Arrays.asList(TASK_DURATION_PROPERTY_NAME));

    private static String categoryFromTask(IfcTask task)
    {
        String category = task.getObjectType();
        return COBieUtility.getCOBieString(category);
    }

    private static String descriptionFromTask(IfcTask task)
    {
        String description = task.getDescription();
        if ((description == null) || description.isEmpty())
        {
            description = task.getName();
        }
        return COBieUtility.getCOBieString(description);
    }

    private static String durationFromTask(IfcTask task)
    {
        String frequency = "";
        Map<String, String> tmpPropMap = new HashMap<String, String>();
        Map<String, String> propertyStringMap = new HashMap<String, String>();
        ArrayList<String> freqPropNames = IfcToJob._DURATION_PROPERTY_NAMES;
        for (IfcRelDefines defines : task.getIsDefinedBy())
        {
            if (defines instanceof IfcRelDefinesByProperties)
            {
                tmpPropMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(defines, freqPropNames);
                propertyStringMap = IfcPropertyToCOBieString.mergePropertyStrings(tmpPropMap, propertyStringMap);
            }
        }
        frequency = COBieUtility.cobieStringFromStringMap(propertyStringMap, freqPropNames);
        return COBieUtility.getCOBieString(frequency);
    }

    private static String durationUnitFromTask(IfcTask task)
    {
        String durationUnit = "";

        ArrayList<String> typePNames = IfcToJob._DURATION_PROPERTY_NAMES;
        IfcPropertyToCOBieString pSetString = IfcRelationshipsToCOBie.getHighestRankingPsetStringFromRelDefinesList(task.getIsDefinedBy(),
                typePNames, false);
        if ((pSetString != null) && (pSetString instanceof IfcSingleValueToCOBieString))
        {
            durationUnit = ((IfcSingleValueToCOBieString)pSetString).getUnitString();
        }
        return COBieUtility.getCOBieString(durationUnit);
    }

    private static String frequencyFromTask(IfcTask task)
    {
        String frequency = "";
        Map<String, String> tmpPropMap = new HashMap<String, String>();
        Map<String, String> propertyStringMap = new HashMap<String, String>();
        ArrayList<String> freqPropNames = IfcToJob.getFrequencyPropertyNames();
        for (IfcRelDefines defines : task.getIsDefinedBy())
        {
            if (defines instanceof IfcRelDefinesByProperties)
            {
                tmpPropMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(defines, freqPropNames);
                propertyStringMap = IfcPropertyToCOBieString.mergePropertyStrings(tmpPropMap, propertyStringMap);
            }
        }
        frequency = COBieUtility.cobieStringFromStringMap(propertyStringMap, freqPropNames);
        return COBieUtility.getCOBieString(frequency);
    }

    private static String frequencyUnitFromTask(IfcTask task)
    {
        String frequencyUnit = "";

        ArrayList<String> typePNames = IfcToJob.getFrequencyPropertyNames();
        IfcPropertyToCOBieString pSetString = IfcRelationshipsToCOBie.getHighestRankingPsetStringFromRelDefinesList(task.getIsDefinedBy(),
                typePNames, false);
        if ((pSetString != null) && (pSetString instanceof IfcSingleValueToCOBieString))
        {
            frequencyUnit = ((IfcSingleValueToCOBieString)pSetString).getUnitString();
        }
        return COBieUtility.getCOBieString(frequencyUnit);
    }

    private static ArrayList<String> getFrequencyPropertyNames()
    {
        return _frequencyPropertyNames;
    }

    private static ArrayList<String> getStartPropertyNames()
    {
        return _startPropertyNames;
    }

    private static String nameFromTask(IfcTask task)
    {
        return COBieUtility.getCOBieString(task.getName());
    }

    private static String priorsFromTask(IfcTask task)
    {
        String priors = "";
        ArrayList<String> priorStrings = new ArrayList<String>();
        for (IfcRelSequence relSequence : task.getIsSuccessorFrom())
        {
            if (relSequence.getRelatedProcess() instanceof IfcTask)
            {
                IfcTask priorTask = (IfcTask)relSequence.getRelatingProcess();
                String priorTaskId = priorTask.getTaskId();
                if (!COBieUtility.isNA(priorTaskId))
                {
                    priorStrings.add(priorTask.getTaskId());
                }
            }
        }
        priors = COBieUtility.delimittedStringFromArrayList(priorStrings);
        if (COBieUtility.isNA(priors))
        {
            priors = task.getTaskId();
        }
        return COBieUtility.getCOBieString(priors);
    }

    private static String resourceNamesFromTask(IfcTask task)
    {
        String resourceNames = "";
        ArrayList<String> resourceArray = new ArrayList<String>();
        for (IfcRelAssignsToProcess assignsToProcess : task.getOperatesOn())
        {

            for (IfcRoot relatedObject : assignsToProcess.getRelatedObjects())
            {
                if (relatedObject instanceof IfcConstructionEquipmentResource)
                {
                    resourceArray.add(relatedObject.getName());
                }
            }
        }
        resourceNames = COBieUtility.delimittedStringFromArrayList(resourceArray);
        return COBieUtility.getCOBieString(resourceNames);
    }

    private static String startFromTask(IfcTask task)
    {
        String start = "";
        ArrayList<String> startPropNames = IfcToJob.getStartPropertyNames();
        start = IfcRelationshipsToCOBie.getHighestRankingPropertyStringFromRelDefinesList(task.getIsDefinedBy(), startPropNames, false);
        return COBieUtility.getCOBieString(start);
    }

    private static String statusFromTask(IfcTask task)
    {
        String status = task.getStatus();
        return COBieUtility.getCOBieString(status);
    }

    private static String taskNumberFromTask(IfcTask task)
    {
        String taskNumber = task.getTaskId();
        return COBieUtility.getCOBieString(taskNumber);
    }

    private static String taskStartUnitFromTask(IfcTask task)
    {
        String taskStartUnitFromTask = "";

        ArrayList<String> typePNames = IfcToJob.getStartPropertyNames();
        IfcPropertyToCOBieString pSetString = IfcRelationshipsToCOBie.getHighestRankingPsetStringFromRelDefinesList(task.getIsDefinedBy(),
                typePNames, false);
        if ((pSetString != null) && (pSetString instanceof IfcSingleValueToCOBieString))
        {
            taskStartUnitFromTask = ((IfcSingleValueToCOBieString)pSetString).getUnitString();
        }
        return COBieUtility.getCOBieString(taskStartUnitFromTask);
    }

    private static String typeNameFromTask(IfcTask task)
    {
        String typeNames = "";
        ArrayList<String> typeNamesArray = new ArrayList<String>();

        for (IfcRelAssignsToProcess assignsToProcess : task.getOperatesOn())
        {

            for (IfcRoot relatedObject : assignsToProcess.getRelatedObjects())
            {
                if (relatedObject instanceof IfcTypeObject)
                {
                    typeNamesArray.add(relatedObject.getName());
                }
            }
        }
        typeNames = COBieUtility.delimittedStringFromArrayList(typeNamesArray);
        return COBieUtility.getCOBieString(typeNames);
    }

    public static void writeJobs(COBIEType cobie, IfcModelInterface model)
    {
        LogHandler loggerHandler = new LogHandler(sheetName, LOGGER);
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
        String extObject;
        String extIdentifier;
        String taskNumber;
        String priors;
        String resourceNames;
        try
        {
            jobs = cobie.getJobs();
            if ((jobs == null) || jobs.isNil())
            {
                jobs = cobie.addNewJobs();
            }
        } catch (Exception ex)
        {
            jobs = cobie.addNewJobs();
        }
        for (IfcTask task : model.getAll(IfcTask.class))
        {
            try
            {

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
                extObject = COBieUtility.extObjectFromObjectDef(task);
                taskNumber = IfcToJob.taskNumberFromTask(task);
                priors = IfcToJob.priorsFromTask(task);
                resourceNames = IfcToJob.resourceNamesFromTask(task);

                JobType job = jobs.addNewJob();
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
                job.setExtObject(extObject);
                job.setTaskNumber(taskNumber);
                job.setPriors(priors);
                job.setResourceNames(resourceNames);
                loggerHandler.rowWritten();
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
            }

        }
        loggerHandler.sheetWritten();
    }
}
