package org.bimserver.cobie.shared.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.bimserver.cobie.shared.serialization.util.IfcPropertyStringTransformer;
import org.bimserver.cobie.shared.serialization.util.IfcSingleValueToCOBieString;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility;
import org.bimserver.cobie.shared.utility.ifc.IfcUnitToCOBieString;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcAddress;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationNotationSelect;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcDerivedUnit;
import org.bimserver.models.ifc2x3tc1.IfcDerivedUnitEnum;
import org.bimserver.models.ifc2x3tc1.IfcNamedUnit;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRelationship;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcTelecomAddress;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class COBieIfcUtility
{

	static String categoryStringFromClassificationReference(IfcClassificationReference classificationReference)
	{
	    String classification = "";
	    boolean itemReferenceSet = classificationReference.isSetItemReference();
	    String name = COBieUtility.getCOBieString(classificationReference.getName());
	    String itemReference = "";
	    String referencedSource = "";
	    if (classificationReference.isSetReferencedSource())
	    {
	        referencedSource = COBieUtility.getCOBieString(classificationReference.getReferencedSource().getName());
	    }
	    String location = "";
	    if (classificationReference.isSetLocation())
	    {
	        location = COBieUtility.getCOBieString(classificationReference.getLocation());
	    }
	    if (itemReferenceSet)
	    {
	        itemReference = COBieUtility.getCOBieString(classificationReference.getItemReference());
	    }
	    boolean locationIsNA = COBieUtility.isNA(location);
	    boolean referencedSourceIsNA = COBieUtility.isNA(referencedSource);
	    boolean nameIsNA = COBieUtility.isNA(name);
	    boolean nameEqualsItemReference = itemReferenceSet && name.equals(itemReference);
	
	    boolean itemReferenceIsNA = COBieUtility.isNA(itemReference);
	    if (!nameIsNA && !itemReferenceIsNA && !nameEqualsItemReference)
	    {
	        classification = itemReference + COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR + name;
	    } else if (itemReferenceIsNA && !nameIsNA)
	    {
	        classification = name;
	    } else if (!itemReferenceIsNA)
	    {
	        classification = itemReference;
	    } else if (!referencedSourceIsNA)
	    {
	        classification = referencedSource;
	    } else if (!locationIsNA)
	    {
	        classification = location;
	    }
	    return COBieUtility.getCOBieString(classification);
	}

	static String categoryStringFromRelAssociatesClassification(IfcRelAssociates assoc)
	{
	    String classification = "";
	    IfcRelAssociatesClassification relAssoClass = (IfcRelAssociatesClassification)assoc;
	    IfcClassificationNotationSelect classificationNotationSelect = relAssoClass.getRelatingClassification();
	    if (classificationNotationSelect instanceof IfcClassification)
	    {
	        IfcClassification ifcClass = (IfcClassification)classificationNotationSelect;
	        classification = ifcClass.getName();
	    } else if (classificationNotationSelect instanceof IfcClassificationReference)
	    {
	        classification = categoryStringFromClassificationReference((IfcClassificationReference)classificationNotationSelect);
	    }
	    return COBieUtility.getCOBieString(classification);
	}

	public static IfcPropertyStringTransformer cobiePsetStringFromStringMap(
	        Map<String, IfcPropertyStringTransformer> valMap,
	        ArrayList<String> prioritizedPropertyNames)
	{
	    IfcPropertyStringTransformer cString = null;
	    IfcPropertyStringTransformer tmpVal = null;
	    for (String prioritizedPropertyName : prioritizedPropertyNames)
	    {
	        if (valMap.keySet().contains(prioritizedPropertyName))
	        {
	            tmpVal = valMap.get(prioritizedPropertyName);
	            if ((tmpVal != null) && (tmpVal.getValueString().length() > 0) && (cString == null))
	            {
	                cString = tmpVal;
	            }
	        }
	    }
	    return cString;
	}

	public static IfcPropertyStringTransformer cobiePsetStringFromStringMapAllowNA(
	        Map<String, IfcPropertyStringTransformer> valMap,
	        ArrayList<String> prioritizedPropertyNames)
	{
	    IfcPropertyStringTransformer cString = null;
	    IfcPropertyStringTransformer tmpVal = null;
	    for (String prioritizedPropertyName : prioritizedPropertyNames)
	    {
	        if (valMap.keySet().contains(prioritizedPropertyName))
	        {
	            tmpVal = valMap.get(prioritizedPropertyName);
	            if ((tmpVal != null) && (cString == null))
	            {
	                cString = tmpVal;
	            }
	        }
	    }
	    return cString;
	}

	public static int cobiePsetStringRankingFromStringMap(Map<String, IfcPropertyStringTransformer> valMap, ArrayList<String> prioritizedPropertyNames)
	{
	    int rank = -1;
	
	    String cString = "";
	    String tmpVal = "";
	    for (String prioritizedPropertyName : prioritizedPropertyNames)
	    {
	        if (valMap.keySet().contains(prioritizedPropertyName))
	        {
	            tmpVal = valMap.get(prioritizedPropertyName).getValueString();
	            if ((tmpVal.length() > 0) && (cString.length() == 0))
	            {
	                rank = prioritizedPropertyNames.size() - prioritizedPropertyNames.indexOf(prioritizedPropertyName);
	            }
	        }
	    }
	    return rank;
	}

	public static IfcOwnerHistory firstOwnerHistoryFromModel(IfcModelInterface model)
	{
	    IfcOwnerHistory oh = null;
	    ArrayList<IfcOwnerHistory> histories = (ArrayList<IfcOwnerHistory>)model.getAll(IfcOwnerHistory.class);
	    if (histories.size() > 0)
	    {
	        oh = histories.get(0);
	    }
	    return oh;
	}

	public static String getEmailFromOrganization(IfcOrganization org)
	{
	    String strEmail = "";
	    EList<IfcAddress> organizationAddresses = org.getAddresses();
	    String organizationEmail = COBieIfcUtility.getEmailsFromAddresses(organizationAddresses);
	    strEmail = organizationEmail;
	    return COBieUtility.getCOBieString(strEmail);
	}

	public static String getEmailFromOwnerHistory(IfcOwnerHistory oh)
	{
	    IfcPersonAndOrganization personOrg = oh.getOwningUser();
	    return COBieUtility.getCOBieString(getEmailFromPersonAndOrganization(personOrg));
	}

	public static String getEmailFromPersonAndOrganization(IfcPersonAndOrganization personOrg)
	{
	    String strEmail = "";
	    IfcPerson person = personOrg.getThePerson();
	    String givenName = person.getGivenName();
	    if ((givenName == null) || (givenName.length() == 0))
	    {
	        givenName = COBieUtility.COBieUnkown;
	    }
	    String familyName = person.getFamilyName();
	    if ((familyName == null) || (familyName.length() == 0))
	    {
	        familyName = COBieUtility.COBieUnkown;
	    }
	    IfcOrganization org = personOrg.getTheOrganization();
	    String orgName = org.getName();
	    if ((orgName == null) || (orgName.length() == 0))
	    {
	        orgName = COBieUtility.COBieUnkown;
	    }
	    EList<IfcAddress> pAddresses = person.getAddresses();
	    EList<IfcAddress> oAddresses = org.getAddresses();
	    String pEmail = COBieIfcUtility.getEmailsFromAddresses(pAddresses);
	    String oEmail = COBieIfcUtility.getEmailsFromAddresses(oAddresses);
	    String pID = person.getId();
	    String oID = org.getId();
	    if ((pEmail != null) && (pEmail.length() > 0) && (pEmail != COBieUtility.COBieNA))
	    {
	        strEmail = pEmail;
	    } else if ((oEmail != null) && (oEmail.length() > 0) && (oEmail != COBieUtility.COBieNA))
	    {
	        strEmail = oEmail;
	    } else if ((pID != null) && (pID.length() > 0))
	    {
	        strEmail = pID;
	    } else if ((oID != null) && (oID.length() > 0))
	    {
	        strEmail = oID;
	    } else if ((givenName != null) && (familyName != null) && (orgName != null))
	    {
	        strEmail = givenName + familyName + "@" + orgName + ".com";
	    }
	    if (strEmail.length() == 0)
	    {
	        strEmail = DefaultEmailAddress;
	    }
	    return COBieUtility.getCOBieString(strEmail);
	}

	public static String getFirstDerivedUnitStringInProjectContext(IfcModelInterface model, IfcDerivedUnitEnum unitType)
	{
	    String unitString = COBieUtility.COBieNA;
	    for (IfcProject project : model.getAll(IfcProject.class))
	    {
	        if (project.getUnitsInContext() != null)
	        {
	            IfcUnitAssignment unitAssignment = project.getUnitsInContext();
	            if (unitAssignment != null)
	            {
	                for (IfcUnit unit : unitAssignment.getUnits())
	                {
	                    if (unit instanceof IfcDerivedUnit)
	                    {
	                        IfcDerivedUnit derivedUnit = (IfcDerivedUnit)unit;
	                        if ((derivedUnit.getUnitType() == unitType) && COBieUtility.isNA(unitString))
	                        {
	                            unitString = IfcUnitToCOBieString.stringFromUnit(derivedUnit);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return unitString;
	}

	public static String getFirstNamedUnitStringInProjectContext(IfcModelInterface model, IfcUnitEnum unitType)
	{
	    String unitString = COBieUtility.COBieNA;
	    for (IfcProject project : model.getAll(IfcProject.class))
	    {
	        if (project.getUnitsInContext() != null)
	        {
	            IfcUnitAssignment unitAssignment = project.getUnitsInContext();
	            if (unitAssignment != null)
	            {
	                for (IfcUnit unit : unitAssignment.getUnits())
	                {
	                    if (unit instanceof IfcNamedUnit)
	                    {
	                        IfcNamedUnit namedUnit = (IfcNamedUnit)unit;
	                        if ((namedUnit.getUnitType() == unitType) && COBieUtility.isNA(unitString))
	                        {
	                            unitString = IfcUnitToCOBieString.stringFromUnit(namedUnit);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return unitString;
	}

	public static String getObjectClassificationCategoryString(IfcObjectDefinition ifcObj)
	{
	    String classification = "";
	
	    EList<IfcRelAssociates> associations = ifcObj.getHasAssociations();
	    ArrayList<String> classificationAssociationStrings = new ArrayList<String>();
	    for (IfcRelAssociates assoc : associations)
	    {
	        if (assoc instanceof IfcRelAssociatesClassification)
	        {
	            String tmpClassification = categoryStringFromRelAssociatesClassification(assoc);
	            if (!COBieUtility.isNA(tmpClassification))
	            {
	                classificationAssociationStrings.add(tmpClassification);
	            }
	        }
	
	    }
	    classification = COBieUtility.delimittedStringFromArrayList(classificationAssociationStrings);
	    if (COBieUtility.isNA(classification))
	    {
	        classification = classificationFromPropertySets(ifcObj);
	    } else if (COBieUtility.isNA(classification) && (ifcObj instanceof IfcObject))
	    {
	        classification = ((IfcObject)ifcObj).getObjectType();
	    }
	    classification = addSpaceAfterClassificationCodeDelim(classification);
	    return COBieUtility.getCOBieString(classification);
	}
	
	 static protected String cobieStringFromFeature(EObject root, EStructuralFeature sf)
	    {
	        String attributeVal = null;
	        if (sf != null)
	        {
	            Object value = root.eGet(sf);
	            if (value instanceof String)
	            {
	                attributeVal = (String)value;

	            }

	            if (value instanceof Enumerator)
	            {
	            	
	                Enumerator enumeratorValue = (Enumerator)value;
	                attributeVal = enumeratorValue.getLiteral();
	            }
	        }

	        return attributeVal;
	    }
	 
	 	static protected Map<String, String> valuesOfAttributes(EObject root, ArrayList<String> attributeNames, boolean exclusive)
	    {
	        Map<String, String> attributeVals = new HashMap<String, String>();
	        String attributeVal = null;
	        if (exclusive)
	        {
	            EList<EStructuralFeature> classFeatures = root.eClass().getEAllStructuralFeatures();
	            for (EStructuralFeature feature : classFeatures)
	            {
	                String featureName = feature.getName();
	                if (!attributeNames.contains(featureName))
	                {
	                    attributeVal = cobieStringFromFeature(root, feature);
	                    if ((attributeVal != null) && !attributeVals.containsKey(featureName))
	                    {
	                        attributeVals.put(featureName, attributeVal);
	                    }
	                }

	            }
	        } else
	        {
	            for (String attributeName : attributeNames)
	            {
	                attributeVals.put(attributeName, valueOfAttribute(root, attributeName));
	            }
	        }

	        return attributeVals;
	    }
    public static String valueOfAttribute(EObject root, String attributeName)
    {
        // from Leon/Reuben
        // EStructuralFeature predifinedTypeField =
        // product.eClass.getEStructuralFeature("PredefinedType");
        // if (predifinedTypeField != null) {
        // Object value = product.eGet(predifinedTypeField); // This will
        // contain the enum
        // }
        String attributeVal = null;
        EStructuralFeature sf = root.eClass().getEStructuralFeature(attributeName);
        attributeVal = cobieStringFromFeature(root, sf);
        return attributeVal;
    }
	
	public static IfcClassificationReference getObjectClassificationReference(IfcObjectDefinition ifcObj)
	{
	    IfcClassificationReference classificationReference = null;
	    COBieUtility.getClassificationTuples();
	    COBieUtility.getClassificationPropertyNames();
	    EList<IfcRelAssociates> associations = ifcObj.getHasAssociations();
	    for (IfcRelAssociates assoc : associations)
	    {
	        if ((assoc instanceof IfcRelAssociatesClassification) && (classificationReference == null))
	        {
	            IfcRelAssociatesClassification relAssoClass = (IfcRelAssociatesClassification)assoc;
	            IfcClassificationNotationSelect classNot = relAssoClass.getRelatingClassification();
	            if (classNot instanceof IfcClassificationReference)
	            {
	                IfcClassificationReference classRef = (IfcClassificationReference)classNot;
	                classificationReference = classRef;
	
	            }
	        }
	
	    }
	    return classificationReference;
	
	}

	public static String getPropertySetClassification(IfcPropertySet ifcObj, IfcModelInterface model)
	{
	    String classification = "";
	    Map<String, String> classificationTuples = COBieUtility.getClassificationTuples();
	    ArrayList<String> classificationNames = COBieUtility.getClassificationPropertyNames();
	    EList<IfcRelAssociates> associations = ifcObj.getHasAssociations();
	    if ((associations == null) || (associations.size() <= 0))
	    {
	        associations = COBieIfcUtility.searchAllClassificationReferencesForPropertySetAssociation(ifcObj, model);
	    }
	    for (IfcRelAssociates assoc : associations)
	    {
	        if (assoc instanceof IfcRelAssociatesClassification)
	        {
	            IfcRelAssociatesClassification relAssoClass = (IfcRelAssociatesClassification)assoc;
	            IfcClassificationNotationSelect classNot = relAssoClass.getRelatingClassification();
	            if (classNot instanceof IfcClassification)
	            {
	                IfcClassification ifcClass = (IfcClassification)classNot;
	                classification += ifcClass.getName() + COBieUtility.COBieDelim;
	            } else if (classNot instanceof IfcClassificationReference)
	            {
	                IfcClassificationReference classRef = (IfcClassificationReference)classNot;
	                String referencedSource = COBieUtility.COBieNA;
	                if (classRef.isSetReferencedSource())
	                {
	                    referencedSource = classRef.getReferencedSource().getName();
	                    classification += classRef.getReferencedSource().getName() + COBieUtility.COBieDelim;
	                } else if (COBieUtility.isNA(referencedSource))
	                {
	                    classification += classRef.getItemReference() + COBieUtility.COBieDelim;
	                }
	            }
	        }
	    }
	    if ((ifcObj instanceof IfcObject) && ((classification == null) || (classification.length() <= 0)))
	    {
	        Map<String, String> masterMap = new HashMap<String, String>();
	
	        IfcObject obj = (IfcObject)ifcObj;
	        for (IfcRelDefines def : obj.getIsDefinedBy())
	        {
	            Map<String, String> tmpValueMap = IfcRelationshipUtility.propertyStringsFromRelDefines(def, classificationNames);
	            if (!tmpValueMap.isEmpty())
	            {
	                for (String key : tmpValueMap.keySet())
	                {
	                    if (!masterMap.containsKey(key))
	                    {
	                        masterMap.put(key, tmpValueMap.get(key));
	                    }
	                }
	            }
	        }
	        classification = COBieUtility.categoryStringFromPropertyNameValueMap(masterMap, classificationTuples);
	    } else if (IfcTypeObject.class.isInstance(ifcObj) && ((classification == null) || (classification.length() <= 0)))
	    {
	        Map<String, String> masterMap = new HashMap<String, String>();
	        IfcTypeObject obj = (IfcTypeObject)ifcObj;
	        masterMap = IfcRelationshipUtility.propertyStringsFromTypeObject(obj, classificationNames);
	        classification = COBieUtility.categoryStringFromPropertyNameValueMap(masterMap, classificationTuples);
	    }
	    return COBieUtility.getCOBieString(classification);
	}

	public static String extObjectFromObjectDef(IfcObjectDefinition obj)
	{
	    String className = obj.getClass().getSimpleName();
	    if (className.toLowerCase().endsWith(COBieUtility.ImplementationClassSuffix))
	    {
	        className = className.substring(0, className.length() - COBieUtility.ImplementationClassSuffix.length());
	    }
	    return className;
	}

	public static String extObjectFromRelationship(IfcRelationship obj)
	{
	    String className = obj.getClass().getSimpleName();
	    if (className.toLowerCase().endsWith(COBieUtility.ImplementationClassSuffix))
	    {
	        className = className.substring(0, className.length() - COBieUtility.ImplementationClassSuffix.length());
	    }
	    return className;
	}

	public static String getApplicationName(IfcOwnerHistory oh)
	{
	    String strApp = "";
	    IfcApplication ifcApp = oh.getOwningApplication();
	    strApp = ifcApp.getApplicationFullName();
	    return COBieUtility.getCOBieString(strApp);
	}

	static protected String getEmailsFromAddresses(EList<IfcAddress> addresses)
	{
	    String emailAddress = "";
	    for (IfcAddress address : addresses)
	    {
	        if (address.getClass() == IfcTelecomAddressImpl.class)
	        {
	            IfcTelecomAddress tAddress = (IfcTelecomAddress)address;
	            EList<String> eAddresses = tAddress.getElectronicMailAddresses();
	            if (eAddresses.size() > 0)
	            {
	                emailAddress = eAddresses.get(0);
	            }
	        }
	    }
	    return COBieUtility.getCOBieString(emailAddress);
	
	}

	public static String getRelDefinesByTypeClassification(IfcRelDefinesByType relDefType)
	{
	    String classification = "";
	    Map<String, String> masterMap = new HashMap<String, String>();
	    Map<String, String> classificationTuples = COBieUtility.getClassificationTuples();
	    ArrayList<String> classificationNames = COBieUtility.getClassificationPropertyNames();
	
	    Map<String, String> tmpValueMap = IfcRelationshipUtility.propertyStringsFromRelDefines(relDefType, classificationNames);
	    if (!tmpValueMap.isEmpty())
	    {
	        for (String key : tmpValueMap.keySet())
	        {
	            if (!masterMap.containsKey(key))
	            {
	                masterMap.put(key, tmpValueMap.get(key));
	            }
	        }
	    }
	
	    classification = COBieUtility.categoryStringFromPropertyNameValueMap(masterMap, classificationTuples);
	
	    return COBieUtility.getCOBieString(classification);
	}

	public static String identifierFromObjectDefinition(IfcObjectDefinition objDef)
	{
	    String ID = "";
	    ID = objDef.getGlobalId();
	    return COBieUtility.getCOBieString(ID);
	}

	public static String identifierFromRelationship(IfcRelationship rel)
	{
	    String id = rel.getGlobalId();
	    return COBieUtility.getCOBieString(id);
	}

	static EList<IfcRelAssociates> searchAllClassificationReferencesForPropertySetAssociation(IfcPropertySet ifcObj, IfcModelInterface model)
	{
	    EList<IfcRelAssociates> associations = new BasicEList<IfcRelAssociates>();
	    for (IfcRelAssociatesClassification relAssociates : model.getAllWithSubTypes(IfcRelAssociatesClassification.class))
	    {
	        for (IfcRoot relatedObject : relAssociates.getRelatedObjects())
	        {
	            if ((relatedObject != null) && (relatedObject.getGlobalId() != null) && (ifcObj != null) && (ifcObj.getGlobalId() != null)
	                    && relatedObject.getGlobalId().equals(ifcObj.getGlobalId()))
	            {
	                associations.add(relAssociates);
	            }
	        }
	
	    }
	    return associations;
	}

	public static Map<String, IfcPropertyStringTransformer> psetStringsFromAttributes(EObject root, ArrayList<String> attributeNames, boolean exclusive)
	{
	    Map<String, IfcPropertyStringTransformer> attributeVals = new HashMap<String, IfcPropertyStringTransformer>();
	    String attributeVal = null;
	    if (exclusive)
	    {
	        EList<EStructuralFeature> classFeatures = root.eClass().getEAllStructuralFeatures();
	        for (EStructuralFeature feature : classFeatures)
	        {
	            String featureName = feature.getName();
	            if (!attributeNames.contains(featureName))
	            {
	                attributeVal = cobieStringFromFeature(root, feature);
	                if ((attributeVal != null) && !attributeVals.containsKey(featureName))
	                {
	                    if (feature instanceof IfcPropertySingleValue)
	                    {
	                        IfcPropertySingleValue sVal = (IfcPropertySingleValue)feature;
	                        IfcSingleValueToCOBieString sValStr = new IfcSingleValueToCOBieString(sVal);
	                        attributeVals.put(featureName, sValStr);
	                    }
	
	                }
	            }
	
	        }
	    } else
	    {
	        // for(String attributeName : attributeNames)
	        // {
	        // attributeVals.put(attributeName,
	        // COBieUtility.valueOfAttribute(root, attributeName));
	        // }
	    }
	
	    return attributeVals;
	}

	static String classificationFromPropertySets(IfcObjectDefinition ifcObj)
	{
	    Map<String, String> classificationTuples = COBieUtility.getClassificationTuples();
	    ArrayList<String> classificationNames = COBieUtility.getClassificationPropertyNames();
	    String classification = "";
	    if (ifcObj instanceof IfcObject)
	    {
	        Map<String, String> masterMap = new HashMap<String, String>();
	
	        IfcObject obj = (IfcObject)ifcObj;
	        for (IfcRelDefines def : obj.getIsDefinedBy())
	        {
	            Map<String, String> tmpValueMap = IfcRelationshipUtility.propertyStringsFromRelDefines(def, classificationNames);
	            if (!tmpValueMap.isEmpty())
	            {
	                for (String key : tmpValueMap.keySet())
	                {
	                    if (!masterMap.containsKey(key))
	                    {
	                        masterMap.put(key, tmpValueMap.get(key));
	                    }
	                }
	            }
	        }
	        classification = COBieUtility.categoryStringFromPropertyNameValueMap(masterMap, classificationTuples);
	    } else if (IfcTypeObject.class.isInstance(ifcObj) && COBieUtility.isNA(classification))
	    {
	        Map<String, String> masterMap = new HashMap<String, String>();
	        IfcTypeObject obj = (IfcTypeObject)ifcObj;
	        masterMap = IfcRelationshipUtility.propertyStringsFromTypeObject(obj, classificationNames);
	        classification = COBieUtility.categoryStringFromPropertyNameValueMap(masterMap, classificationTuples);
	    }
	    return classification;
	}

	public static String extIdFromRoot(IfcRoot root)
	{
	    return COBieUtility.getCOBieString(root.getGlobalId());
	}

	public static boolean isValueSetAsStringNA(IfcReal durationReal)
	{
	    return (durationReal.getWrappedValueAsString() != null) && durationReal.getWrappedValueAsString().equals(COBieUtility.COBieNA);
	}

	public static final Ifc2x3tc1Factory ifcFactory = Ifc2x3tc1Factory.eINSTANCE;
	private static final String DefaultEmailAddress = "anonymous@anonymous.com";
	private static String addSpaceAfterClassificationCodeDelim(String classification)
	{
	    StringBuilder stringBuilder = new StringBuilder();
	    if (classification.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
	    {
	        char[] classificationSymbols = classification.toCharArray();
	        for (int i = 0; i < classificationSymbols.length; i++)
	        {
	            char classificationSymbol = classificationSymbols[i];
	            stringBuilder.append(classificationSymbol);
	            if ((i + 1) < classificationSymbols.length)
	            {
	                char nextSymbol = classificationSymbols[i + 1];
	                if ((COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR.toCharArray()[0] == classificationSymbol) && (nextSymbol != ' '))
	                {
	                    stringBuilder.append(COBieUtility.SPACE);
	                }
	            }
	
	        }
	
	    } else
	    {
	        stringBuilder = new StringBuilder(classification);
	    }
	    return stringBuilder.toString();
	}

}
