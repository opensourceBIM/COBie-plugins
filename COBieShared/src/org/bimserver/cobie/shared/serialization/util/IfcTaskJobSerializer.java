package org.bimserver.cobie.shared.serialization.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.serialization.IfcCobieSerializer;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
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
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.COBIEType.Jobs;
import org.nibs.cobie.tab.JobType;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public class IfcTaskJobSerializer extends
		IfcCobieSerializer<JobType, COBIEType.Jobs, IfcTask> 
{
	
	public IfcTaskJobSerializer(Jobs cobieSection, IfcModelInterface model,
			SettingsType settings) 
	{
		super(cobieSection, model, settings);
	}

	@Override
	protected List<IfcTask> getTopLevelModelObjects() 
	{
		return model.getAll(IfcTask.class);
	}

	@Override
	protected List<JobType> serializeModelObject(IfcTask task) 
	{
		List<JobType> jobs = new ArrayList<>();
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
        
        name = nameFromTask(task);
        oh = task.getOwnerHistory();
        createdBy = COBieIfcUtility.getEmailFromOwnerHistory(oh);
        createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
        category = IfcTaskJobSerializer.categoryFromTask(task);
        status = IfcTaskJobSerializer.statusFromTask(task);
        typeName = IfcTaskJobSerializer.typeNameFromTask(task);
        description = IfcTaskJobSerializer.descriptionFromTask(task);
        duration = durationFromTask(task);
        durationUnit = durationUnitFromTask(task);
        start = startFromTask(task);
        taskStartUnit = taskStartUnitFromTask(task);
        frequency = frequencyFromTask(task);
        frequencyUnit = frequencyUnitFromTask(task);
        extSystem = COBieIfcUtility.getApplicationName(oh);
        extIdentifier = COBieIfcUtility.extIdFromRoot(task);
        extObject = COBieIfcUtility.extObjectFromObjectDef(task);
        taskNumber = IfcTaskJobSerializer.taskNumberFromTask(task);
        priors = IfcTaskJobSerializer.priorsFromTask(task);
        resourceNames = IfcTaskJobSerializer.resourceNamesFromTask(task);

        JobType job = getCobieSection().addNewJob();
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
        jobs.add(job);
		return jobs;
	}
	
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

    private String durationFromTask(IfcTask task)
    {
        String frequency = "";
        Map<String, String> tmpPropMap = new HashMap<String, String>();
        Map<String, String> propertyStringMap = new HashMap<String, String>();
        ArrayList<String> freqPropNames = getDurationPropertyNames();
        for (IfcRelDefines defines : task.getIsDefinedBy())
        {
            if (defines instanceof IfcRelDefinesByProperties)
            {
                tmpPropMap = IfcRelationshipUtility.propertyStringsFromRelDefines(defines, freqPropNames);
                propertyStringMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropMap, propertyStringMap);
            }
        }
        frequency = COBieUtility.cobieStringFromStringMap(propertyStringMap, freqPropNames);
        return COBieUtility.getCOBieString(frequency);
    }

    private String durationUnitFromTask(IfcTask task)
    {
        String durationUnit = "";

        ArrayList<String> typePNames = getDurationPropertyNames();
        IfcPropertyStringTransformer pSetString = IfcRelationshipUtility.getHighestRankingPsetStringFromRelDefinesList(task.getIsDefinedBy(),
                typePNames, false);
        if ((pSetString != null) && (pSetString instanceof IfcSingleValueToCOBieString))
        {
            durationUnit = ((IfcSingleValueToCOBieString)pSetString).getUnitString();
        }
        return COBieUtility.getCOBieString(durationUnit);
    }

    private ArrayList<String> getDurationPropertyNames() 
    {
    	ArrayList<String> propertyNames = new ArrayList<>();
        if(getSettings() != null &&
        		getSettings().getJobSettings() != null
        		&& getSettings().getJobSettings().getDurationPropertyNames() != null &&
        		getSettings().getJobSettings().getDurationPropertyNames().getName() != null)
        {
        	propertyNames.addAll(getSettings().getJobSettings().getDurationPropertyNames().getName());
        }
        return propertyNames;
	}

	private String frequencyFromTask(IfcTask task)
    {
        String frequency = "";
        Map<String, String> tmpPropMap = new HashMap<String, String>();
        Map<String, String> propertyStringMap = new HashMap<String, String>();
        ArrayList<String> freqPropNames = getFrequencyPropertyNames();
        for (IfcRelDefines defines : task.getIsDefinedBy())
        {
            if (defines instanceof IfcRelDefinesByProperties)
            {
                tmpPropMap = IfcRelationshipUtility.propertyStringsFromRelDefines(defines, freqPropNames);
                propertyStringMap = IfcPropertyStringTransformer.mergePropertyStrings(tmpPropMap, propertyStringMap);
            }
        }
        frequency = COBieUtility.cobieStringFromStringMap(propertyStringMap, freqPropNames);
        return COBieUtility.getCOBieString(frequency);
    }

    private String frequencyUnitFromTask(IfcTask task)
    {
        String frequencyUnit = "";

        ArrayList<String> typePNames = getFrequencyPropertyNames();
        IfcPropertyStringTransformer pSetString = IfcRelationshipUtility.getHighestRankingPsetStringFromRelDefinesList(task.getIsDefinedBy(),
                typePNames, false);
        if ((pSetString != null) && (pSetString instanceof IfcSingleValueToCOBieString))
        {
            frequencyUnit = ((IfcSingleValueToCOBieString)pSetString).getUnitString();
        }
        return COBieUtility.getCOBieString(frequencyUnit);
    }

    private ArrayList<String> getFrequencyPropertyNames()
    {
    	ArrayList<String> propertyNames = new ArrayList<>();
        if(getSettings() != null &&
        		getSettings().getJobSettings() != null
        		&& getSettings().getJobSettings().getFrequencyPropertyNames() != null &&
        		getSettings().getJobSettings().getFrequencyPropertyNames().getName() != null)
        {
        	propertyNames.addAll(getSettings().getJobSettings().getFrequencyPropertyNames().getName());
        }
        return propertyNames;
    }

    private ArrayList<String> getStartPropertyNames()
    {
    	ArrayList<String> propertyNames = new ArrayList<>();
        if(getSettings() != null &&
        		getSettings().getJobSettings() != null
        		&& getSettings().getJobSettings().getStartPropertyNames() != null &&
        		getSettings().getJobSettings().getStartPropertyNames().getName() != null)
        {
        	propertyNames.addAll(getSettings().getJobSettings().getStartPropertyNames().getName());
        }
        return propertyNames;
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

    private String startFromTask(IfcTask task)
    {
        String start = "";
        ArrayList<String> startPropNames = getStartPropertyNames();
        start = IfcRelationshipUtility.getHighestRankingPropertyStringFromRelDefinesList(task.getIsDefinedBy(), startPropNames, false);
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

    private String taskStartUnitFromTask(IfcTask task)
    {
        String taskStartUnitFromTask = "";

        ArrayList<String> typePNames = getStartPropertyNames();
        IfcPropertyStringTransformer pSetString = IfcRelationshipUtility.getHighestRankingPsetStringFromRelDefinesList(task.getIsDefinedBy(),
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

}
