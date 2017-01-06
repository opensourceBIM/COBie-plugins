package org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.deserialization.cobietab.COBieIfcModel;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRoot;

public class ClassificationHandler
{
    private class ClassificationCodeAndName
    {
        public String classificationCode;
        public String classificationName;
    }

    protected static final String fs_ClassificationReferenceName = "REFERENCE TO:  %s";
    protected static final String fs_ClassificationAssociationName = "ASSOCIATION FROM (%s) to (%s)";
    private static final String BAMIE_CLASSIFICATION_SOURCE = "bSa";
    private static final String BAMIE_CLASSIFICATION_EDITION = "beta";

    private static final String BAMIE_CLASSIFICATION_NAME = "BAMie";

    private static String classificationReferenceNameFromCategoryToken(String category)
    {

        String classificationName = "";
        if (COBieUtility.isNA(category))
        {
            classificationName = "";
        } else
        {
            if (category.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
            {

                String[] splitString = category.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
                for (int i = 1; i < splitString.length; i++)
                {
                    classificationName += splitString[i].trim() + COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR;
                }
                if (classificationName.endsWith(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
                {
                    classificationName = COBieUtility.getCOBieString(classificationName.substring(0, classificationName.length() - 1));
                }
            } else
            {
                classificationName = category;
            }
        }
        return classificationName;
    }

    public static boolean isBAMieClassificationReference(IfcClassificationReference classificationReference)
    {
        boolean isBAMie = false;
        if (classificationReference.isSetReferencedSource())
        {
            IfcClassification classification = classificationReference.getReferencedSource();
            if (classification.getName().equals(BAMIE_CLASSIFICATION_NAME))
            {
                isBAMie = true;
            }
        }
        return isBAMie;
    }

    public static boolean isBAMieRelAssociatesClassification(IfcRelAssociatesClassification classificationReference)
    {
        boolean isBAMie = false;
        if (classificationReference.getRelatingClassification() instanceof IfcClassificationReference)
        {
            isBAMie = isBAMieClassificationReference((IfcClassificationReference)classificationReference.getRelatingClassification());
        }
        return isBAMie;
    }

    public static String normalizeCategoryString(String category)
    {

        String classificationName = "";
        if (category.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
        {

            String[] splitString = category.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
            for (int i = 0; i < splitString.length; i++)
            {
                classificationName += splitString[i].trim() + COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR;
            }
            if (classificationName.endsWith(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
            {
                classificationName = COBieUtility.getCOBieString(classificationName.substring(0, classificationName.length() - 1));
            }
        } else
        {
            classificationName = category;
        }
        return classificationName;
    }

    public static String objectTypeFromCategoryString(String category)
    {
        String classificationName = "";

        if (category.contains(COBieUtility.getCOBieDelim()))
        {
            ArrayList<String> classificationNames = new ArrayList<String>();
            for (String splitString : category.split(COBieUtility.getCOBieDelim()))
            {
                classificationNames.add(classificationReferenceNameFromCategoryToken(splitString));
            }
            classificationName = COBieUtility.delimittedStringFromArrayList(classificationNames);
        } else
        {
            classificationName = classificationReferenceNameFromCategoryToken(category);
        }
        return classificationName;
    }

    private OidProvider CobieOidProvider;
    private COBieIfcModel model;

    private OwnerHistoryHandler ownerHistoryHandler;

    private IfcGuidHandler guidProvider;
    private Map<String, Long> classificationReferenceNameToOid;

    private Map<String, Long> classificationReferenceNameToRelAssociatesOid;

    private IfcClassification bamieClassification;

    public ClassificationHandler(COBieIfcModel cobieIfcModel, IfcGuidHandler ifcGuidProvider, OidProvider oidProvider,
            OwnerHistoryHandler ownerHistoryHandler) throws IfcModelInterfaceException
    {
        model = cobieIfcModel;
        guidProvider = ifcGuidProvider;
        CobieOidProvider = oidProvider;
        classificationReferenceNameToOid = new HashMap<String, Long>();
        this.ownerHistoryHandler = ownerHistoryHandler;
        classificationReferenceNameToRelAssociatesOid = new HashMap<String, Long>();
        initializeBamieClassification();
    }

    public void addClassificationReferenceToObject(IfcClassificationReference classificationReference, IfcRoot targetObject)
            throws IfcModelInterfaceException
    {
        IfcRelAssociatesClassification classificationAssociation;
        String classificationRefName = classificationReference.getName();
        if (classificationReferenceNameToRelAssociatesOid.containsKey(classificationRefName))
        {
            classificationAssociation = (IfcRelAssociatesClassification)model.get(classificationReferenceNameToRelAssociatesOid
                    .get(classificationRefName));
        } else
        {
            classificationAssociation = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAssociatesClassification();
            if (targetObject.getOwnerHistory() != null)
            {
                classificationAssociation.setOwnerHistory(targetObject.getOwnerHistory());
            } else
            {
                classificationAssociation.setOwnerHistory(ownerHistoryHandler.DefaultOwnerHistory());
            }
            classificationAssociation.setGlobalId(guidProvider.newGuid().getWrappedValue());
            classificationAssociation.setRelatingClassification(classificationReference);
            classificationAssociation.setName(getClassificationAssociationName(classificationReference, targetObject));
            long tmpOid = model.add(classificationAssociation, CobieOidProvider);
            classificationReferenceNameToRelAssociatesOid.put(classificationRefName, tmpOid);
            classificationAssociation = (IfcRelAssociatesClassification)model.get(tmpOid);
        }
        classificationAssociation.getRelatedObjects().add(targetObject);
        if (targetObject instanceof IfcObjectDefinition)
        {
            ((IfcObjectDefinition)targetObject).getHasAssociations().add(classificationAssociation);
        } else if (targetObject instanceof IfcPropertySet)
        {
            ((IfcPropertySet)targetObject).getHasAssociations().add(classificationAssociation);
        }
    }

    private IfcClassificationReference classificationReferenceFromString(String category) throws IfcModelInterfaceException
    {
        IfcClassificationReference classification;
        String classificationName, classificationItemReference, classificationLocation;
        if (COBieUtility.isNA(category))
        {
            classification = null;
        } else if (classificationReferenceNameToOid.containsKey(category))
        {
            classification = (IfcClassificationReference)model.get(classificationReferenceNameToOid.get(category));
        } else
        {
            classification = Ifc2x3tc1Factory.eINSTANCE.createIfcClassificationReference();
            if (category.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
            {

                String[] splitString = category.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
                classificationItemReference = COBieUtility.getCOBieString(splitString[0]);
                classificationName = "";
                for (int i = 1; i < splitString.length; i++)
                {
                    classificationName += splitString[i] + COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR;
                }
                if (classificationName.endsWith(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
                {
                    classificationName = COBieUtility.getCOBieString(classificationName.substring(0, classificationName.length() - 1));
                }
                classificationLocation = COBieUtility.getCOBieString(category);
            } else
            {
                classificationName = category;
                classificationItemReference = category;
                classificationLocation = category;
            }
            classification.setName(classificationName);
            classification.setItemReference(classificationItemReference);
            classification.setLocation(classificationLocation);
            long classOid = model.add(classification, CobieOidProvider);
            classificationReferenceNameToOid.put(category, classOid);
        }
        return classification;
    }

    private void classificationReferencesFromNameAndCodeCategory(String categoryString, ArrayList<IfcClassificationReference> classificationReferences)
            throws IfcModelInterfaceException
    {
        // TODO: Fix this so that it handles commas properly
        String[] nameCategoryTokens = categoryString.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
        List<ClassificationCodeAndName> codeNames = getCodeNamePairs(nameCategoryTokens);
        for (ClassificationCodeAndName codeAndName : codeNames)
        {
            String reformedCategoryString = codeAndName.classificationCode + COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR
                    + codeAndName.classificationName;
            IfcClassificationReference classificationReference = classificationReferenceFromString(reformedCategoryString);
            if (classificationReference != null)
            {
                classificationReferences.add(classificationReference);
            }
        }
    }

    public List<IfcClassificationReference> classificationReferencesFromString(String categoryString) throws IfcModelInterfaceException
    {
        ArrayList<IfcClassificationReference> classificationReferences = new ArrayList<IfcClassificationReference>();
        if (isClassificationCodeAndName(categoryString))
        {
            classificationReferencesFromNameAndCodeCategory(categoryString, classificationReferences);
        } else
        {
            classificationReferencesFromUnstructuredCategory(categoryString, classificationReferences);
        }

        return classificationReferences;
    }

    private void classificationReferencesFromUnstructuredCategory(
            String categoryString,
            ArrayList<IfcClassificationReference> classificationReferences) throws IfcModelInterfaceException
    {
        ArrayList<String> categoryStrings = COBieUtility.arrayListFromDelimString(categoryString);
        for (String category : categoryStrings)
        {
            IfcClassificationReference classificationReference = classificationReferenceFromString(category);
            if (classificationReference != null)
            {
                classificationReferences.add(classificationReference);
            }

        }
    }

    private void complexClassificationCodeNames(String[] nameCategoryTokens, List<ClassificationCodeAndName> codeNames)
    {
        int tokenCount = nameCategoryTokens.length;
        int tokenIndexBounds = tokenCount - 1;
        for (int i = 0; i < tokenIndexBounds; i++)
        {
            ClassificationCodeAndName codeName = new ClassificationCodeAndName();
            int leftTokenIndex = i;
            int rightTokenIndex = i + 1;

            String leftToken = nameCategoryTokens[leftTokenIndex];
            String rightToken = nameCategoryTokens[rightTokenIndex];
            String listDelimiter = COBieUtility.getCOBieDelim();
            int nextLeftIndex = rightTokenIndex + 1;
            // this doesn't work on the last entry because of the nextLefftIndex
            // check...that is unecessary
            if (rightToken.contains(listDelimiter) && (nextLeftIndex < tokenCount))
            {
                ArrayList<String> commaSplit = COBieUtility.arrayListFromDelimString(rightToken);
                commaSplit.remove(commaSplit.size() - 1);
                rightToken = COBieUtility.delimittedStringFromArrayList(commaSplit);
            }

            if (leftToken.contains(listDelimiter) && (i > 0))
            {
                ArrayList<String> commaSplit = COBieUtility.arrayListFromDelimString(leftToken);
                leftToken = commaSplit.get(commaSplit.size() - 1);
            }

            codeName.classificationCode = leftToken;
            codeName.classificationName = rightToken;
            codeNames.add(codeName);
        }

    }

    public IfcClassification getBamieClassification()
    {
        return bamieClassification;
    }

    private String getClassificationAssociationName(IfcClassificationReference reference, IfcRoot object)
    {
        String refName = reference.getName();
        String objName = object.getName();
        String assocName = String.format(ClassificationHandler.fs_ClassificationAssociationName, refName, objName);
        return COBieUtility.getCOBieString(assocName);
    }

    private List<ClassificationCodeAndName> getCodeNamePairs(String[] nameCategoryTokens)
    {
        List<ClassificationCodeAndName> codeNames = new ArrayList<ClassificationHandler.ClassificationCodeAndName>();
        int tokenCount = nameCategoryTokens.length;
        if (tokenCount <= 2)
        {
            if (tokenCount == 2)
            {
                simpleClassificationCodeName(nameCategoryTokens, codeNames);
            } else if (tokenCount == 1)
            {
                simpleClassificationCodeName(new String[]
                {
                        nameCategoryTokens[0], nameCategoryTokens[0]
                }, codeNames);
            }
        } else
        {
            complexClassificationCodeNames(nameCategoryTokens, codeNames);
        }
        return codeNames;
    }

    private void initializeBamieClassification() throws IfcModelInterfaceException
    {
        IfcClassification classification = COBieIfcUtility.ifcFactory.createIfcClassification();
        classification.setSource(BAMIE_CLASSIFICATION_SOURCE);
        classification.setEdition(BAMIE_CLASSIFICATION_EDITION);
        classification.setName(BAMIE_CLASSIFICATION_NAME);
        model.add(classification, CobieOidProvider);
        setBamieClassification(classification);
    }

    private boolean isClassificationCodeAndName(String categoryString)
    {
        String[] splitString = categoryString.split(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR);
        boolean evaluation = true;
        if ((splitString == null) || (splitString.length <= 1))
        {
            evaluation = false;
        } else
        {
            for (String string : splitString)
            {
                // we want to test if it's empty or null only, but can be "n/a"
                if (COBieUtility.isNA(string) && !COBieUtility.COBieNA.equals(string))
                {
                    evaluation = false;
                }
            }
        }
        return evaluation;
    }

    public void setBamieClassification(IfcClassification bamieClassification)
    {
        this.bamieClassification = bamieClassification;
    }

    private void simpleClassificationCodeName(String[] nameCategoryTokens, List<ClassificationCodeAndName> codeNames)
    {
        ClassificationCodeAndName codeName = new ClassificationCodeAndName();
        codeName.classificationCode = nameCategoryTokens[0];
        codeName.classificationName = nameCategoryTokens[1];
        codeNames.add(codeName);
    }
}
