package org.bimserver.cobie.utils.deserializer.modelhandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.bimserver.cobie.utils.deserializer.COBieIfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.cobie.COBieUtility;

public class ClassificationHandler
{
	protected static final String fs_ClassificationReferenceName = "REFERENCE TO:  %s";
	protected static final String fs_ClassificationAssociationName = "ASSOCIATION FROM (%s) to (%s)";
	private static final String BAMIE_CLASSIFICATION_SOURCE = "bSa";
	private static final String BAMIE_CLASSIFICATION_EDITION = "beta";
	private static final String BAMIE_CLASSIFICATION_NAME = "BAMie";
	private OidProvider CobieOidProvider;
	private COBieIfcModel model;
	private OwnerHistoryHandler ownerHistoryHandler;
	private IfcGuidHandler guidProvider;
	private Map<String,Long> classificationReferenceNameToOid;
	private Map<String,Long> classificationReferenceNameToRelAssociatesOid;
	private IfcClassification bamieClassification;
	
	public static boolean isBAMieClassificationReference(IfcClassificationReference classificationReference)
	{
		boolean isBAMie = false;
		if(classificationReference.isSetReferencedSource())
		{
			IfcClassification classification =
					classificationReference.getReferencedSource();
			if(classification.getName().equals(BAMIE_CLASSIFICATION_NAME))
				isBAMie = true;
		}
		return isBAMie;
	}
	
	public static boolean isBAMieRelAssociatesClassification(IfcRelAssociatesClassification classificationReference)
	{
		boolean isBAMie = false;
		if(classificationReference.getRelatingClassification() instanceof IfcClassificationReference)
			isBAMie = isBAMieClassificationReference((IfcClassificationReference)classificationReference.getRelatingClassification());
		return isBAMie;
	}
	public ClassificationHandler(COBieIfcModel cobieIfcModel, IfcGuidHandler ifcGuidProvider, 
			OidProvider oidProvider,OwnerHistoryHandler ownerHistoryHandler)
	{
		model = cobieIfcModel;
		guidProvider = ifcGuidProvider;
		CobieOidProvider = oidProvider;
		classificationReferenceNameToOid = new HashMap<String,Long>();
		this.ownerHistoryHandler = ownerHistoryHandler;
		classificationReferenceNameToRelAssociatesOid = new HashMap<String,Long>();
		initializeBamieClassification();
	}
	
	private void initializeBamieClassification()
	{
		IfcClassification classification = COBieUtility.ifcFactory.createIfcClassification();
		classification.setSource(BAMIE_CLASSIFICATION_SOURCE);
		classification.setEdition(BAMIE_CLASSIFICATION_EDITION);
		classification.setName(BAMIE_CLASSIFICATION_NAME);
		model.add(classification,CobieOidProvider);
		this.setBamieClassification(classification);
	}
	
	public void addClassificationReferenceToObject(
			IfcClassificationReference classificationReference,
			IfcRoot targetObject)
	{
		IfcRelAssociatesClassification classificationAssociation;
		String classificationRefName = classificationReference.getName();
		if (classificationReferenceNameToRelAssociatesOid.containsKey(classificationRefName))
				classificationAssociation = 
				(IfcRelAssociatesClassification) model.get(classificationReferenceNameToRelAssociatesOid.get(classificationRefName));
		else
		{
			classificationAssociation = Ifc2x3tc1Factory.eINSTANCE
					.createIfcRelAssociatesClassification();
			if(targetObject.getOwnerHistory()!=null)
				classificationAssociation.setOwnerHistory(targetObject.getOwnerHistory());
			else
			{
				classificationAssociation.setOwnerHistory(ownerHistoryHandler.DefaultOwnerHistory());
			}
			classificationAssociation.setGlobalId(this.guidProvider.newGuid());
			classificationAssociation
					.setRelatingClassification(classificationReference);
			classificationAssociation.setName(this.getClassificationAssociationName(
					classificationReference, targetObject));
			long tmpOid = model.add(classificationAssociation, this.CobieOidProvider);
			classificationReferenceNameToRelAssociatesOid.put(classificationRefName, tmpOid);
			classificationAssociation = (IfcRelAssociatesClassification) model
					.get(tmpOid);
		}
		classificationAssociation.getRelatedObjects().add(targetObject);
		if(targetObject instanceof IfcObjectDefinition)
			((IfcObjectDefinition)targetObject).getHasAssociations().add(classificationAssociation);
		else if(targetObject instanceof IfcPropertySet)
			((IfcPropertySet)targetObject).getHasAssociations().add(classificationAssociation);
	}
	
	
	private String getClassificationAssociationName(
			IfcClassificationReference reference, IfcRoot object)
	{
		String refName = reference.getName();
		String objName = object.getName();
		String assocName = String.format(ClassificationHandler.fs_ClassificationAssociationName,
				refName, objName);
		return COBieUtility.getCOBieString(assocName);
	}


	public List<IfcClassificationReference> classificationReferencesFromString(
			String categoryString)
	{
		ArrayList<IfcClassificationReference> classificationReferences =
			new ArrayList<IfcClassificationReference>();
		ArrayList<String> categoryStrings = COBieUtility.arrayListFromDelimString(categoryString);
		for(String category:categoryStrings)
		{
			IfcClassificationReference classificationReference =
					classificationReferenceFromString(category);
			if(classificationReference!=null)
				classificationReferences.add(classificationReference);
			
		}
		return classificationReferences;
	}
	
	
	
	private IfcClassificationReference classificationReferenceFromString(String category)
	{
		IfcClassificationReference classification;
		String classificationName,classificationItemReference,classificationLocation;
		if (COBieUtility.isNA(category))
			classification = null;
		else if (this.classificationReferenceNameToOid.containsKey(category))
			classification = (IfcClassificationReference) model.get(classificationReferenceNameToOid.get(category));
		else
		{
			classification = Ifc2x3tc1Factory.eINSTANCE
					.createIfcClassificationReference();
			if(category.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
			{
					
					String[] splitString = category.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
					classificationItemReference = COBieUtility.getCOBieString(splitString[0]);
					classificationName = "";
					for(int i=1; i < splitString.length;i++)
						classificationName += splitString[i]+COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR;
					if(classificationName.endsWith(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
						classificationName = COBieUtility.getCOBieString(classificationName.substring(0,classificationName.length()-1));
					classificationLocation = COBieUtility.getCOBieString(category);
			}
			else
			{
					classificationName = category;
					classificationItemReference = category;
					classificationLocation = category;
			}
			classification.setName(classificationName);
			classification.setItemReference(classificationItemReference);
			classification.setLocation(classificationLocation);
			long classOid = model.add(classification,this.CobieOidProvider);
			classificationReferenceNameToOid.put(category, classOid);
		}
		return classification;
	}
	
	private static String classificationReferenceNameFromCategoryToken(String category)
	{
		
		String classificationName="";
		if (COBieUtility.isNA(category))
			classificationName = "";
		else
		{
			if(category.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
			{
					
					String[] splitString = category.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
					for(int i=1; i < splitString.length;i++)
						classificationName += splitString[i].trim()+COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR;
					if(classificationName.endsWith(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
						classificationName = COBieUtility.getCOBieString(classificationName.substring(0,classificationName.length()-1));
			}
			else
			{
					classificationName = category;
			}
		}
		return classificationName;
	}
	
	public static String normalizeCategoryString(String category)
	{
		
			String classificationName = "";
			if(category.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
			{
					
					String[] splitString = category.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
					for(int i=0; i < splitString.length;i++)
						classificationName += splitString[i].trim()+COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR;
					if(classificationName.endsWith(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
						classificationName = COBieUtility.getCOBieString(classificationName.substring(0,classificationName.length()-1));
			}
			else
			{
					classificationName = category;
			}
		return classificationName;
	}
	
	public static String objectTypeFromCategoryString(String category)
	{
		String classificationName = "";
		
		if(category.contains(COBieUtility.getCOBieDelim()))
		{
			ArrayList<String> classificationNames = new ArrayList<String>();
			for(String splitString:category.split(COBieUtility.getCOBieDelim()))
				classificationNames.add(classificationReferenceNameFromCategoryToken(category));
			classificationName = COBieUtility.delimittedStringFromArrayList(classificationNames);
		}
		else
			classificationName = classificationReferenceNameFromCategoryToken(category);
		return classificationName;
	}

	public IfcClassification getBamieClassification()
	{
		return bamieClassification;
	}

	public void setBamieClassification(IfcClassification bamieClassification)
	{
		this.bamieClassification = bamieClassification;
	}
}
