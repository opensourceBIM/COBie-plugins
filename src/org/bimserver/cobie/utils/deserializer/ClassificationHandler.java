package org.bimserver.cobie.utils.deserializer;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcClassificationReference;
import org.bimserver.models.ifc2x3.IfcObjectDefinition;
import org.bimserver.models.ifc2x3.IfcRelAssociatesClassification;
import org.bimserver.plugins.serializers.OidProvider;

public class ClassificationHandler
{
	protected static final String fs_ClassificationReferenceName = "REFERENCE TO:  %s";
	protected static final String fs_ClassificationAssociationName = "ASSOCIATION FROM (%s) to (%s)";
	private OidProvider CobieOidProvider;
	private COBieIfcModel model;
	private IfcGuidHandler guidProvider;
	private Map<String,Long> classificationReferenceNameToOid;
	private Map<String,Long> classificationReferenceNameToRelAssociatesOid;
	public ClassificationHandler(COBieIfcModel cobieIfcModel, IfcGuidHandler ifcGuidProvider, OidProvider oidProvider)
	{
		model = cobieIfcModel;
		guidProvider = ifcGuidProvider;
		CobieOidProvider = oidProvider;
		classificationReferenceNameToOid = new HashMap<String,Long>();
		classificationReferenceNameToRelAssociatesOid = new HashMap<String,Long>();
	}
	
	
	public void addClassificationReferenceToObject(
			IfcClassificationReference classificationReference,
			IfcObjectDefinition targetObject)
	{
		IfcRelAssociatesClassification classificationAssociation;
		String classificationRefName = classificationReference.getName();
		if (classificationReferenceNameToRelAssociatesOid.containsKey(classificationRefName))
				classificationAssociation = 
				(IfcRelAssociatesClassification) model.get(classificationReferenceNameToRelAssociatesOid.get(classificationRefName));
		else
		{
			classificationAssociation = Ifc2x3Factory.eINSTANCE
					.createIfcRelAssociatesClassification();
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
		targetObject.getHasAssociations().add(classificationAssociation);
	}
	
	
	private String getClassificationAssociationName(
			IfcClassificationReference reference, IfcObjectDefinition object)
	{
		String refName = reference.getName();
		String objName = object.getName();
		String assocName = String.format(ClassificationHandler.fs_ClassificationAssociationName,
				refName, objName);
		return assocName;
	}


	public IfcClassificationReference classificationReferenceFromString(
			String category)
	{
		IfcClassificationReference classification;
		if (COBieUtility.isNA(category))
			classification = null;
		else
		{
			if (this.classificationReferenceNameToOid.containsKey(category))
				classification = (IfcClassificationReference) model.get(classificationReferenceNameToOid.get(category));
			else
			{
				classification = Ifc2x3Factory.eINSTANCE
					.createIfcClassificationReference();
				classification.setName(category);
				classification.setItemReference(category);
				classification.setLocation(category);
				long classOid = model.add(classification,this.CobieOidProvider);
				classificationReferenceNameToOid.put(category, classOid);
			}
		}
		return classification;
	}
}
