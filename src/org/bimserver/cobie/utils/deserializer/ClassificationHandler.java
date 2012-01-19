package org.bimserver.cobie.utils.deserializer;

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
	
	public ClassificationHandler(COBieIfcModel cobieIfcModel, IfcGuidHandler ifcGuidProvider, OidProvider oidProvider)
	{
		model = cobieIfcModel;
		guidProvider = ifcGuidProvider;
		CobieOidProvider = oidProvider;
	}
	
	
	public void addClassificationReferenceToObject(
			IfcClassificationReference classificationReference,
			IfcObjectDefinition targetObject)
	{
		model.add(classificationReference, this.CobieOidProvider);
		IfcRelAssociatesClassification classificationAssociation = Ifc2x3Factory.eINSTANCE
				.createIfcRelAssociatesClassification();
		classificationAssociation.setGlobalId(this.guidProvider.newGuid());
		classificationAssociation
				.setRelatingClassification(classificationReference);
		classificationAssociation.setName(this.getClassificationAssociationName(
				classificationReference, targetObject));
		classificationAssociation.getRelatedObjects().add(targetObject);
		long tmpOid = model.add(classificationAssociation, this.CobieOidProvider);
		classificationAssociation = (IfcRelAssociatesClassification) model
				.get(tmpOid);
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


	public static IfcClassificationReference classificationReferenceFromString(
			String category)
	{
		IfcClassificationReference classification = Ifc2x3Factory.eINSTANCE
				.createIfcClassificationReference();
		if (!COBieUtility.isNA(category))
		{
			classification.setName(category);
			classification.setItemReference(category);
			classification.setLocation(category);
		} else
			classification = null;
		return classification;
	}
}
