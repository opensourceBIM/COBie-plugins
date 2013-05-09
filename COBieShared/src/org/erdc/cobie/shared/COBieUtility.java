package org.erdc.cobie.shared;

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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.erdc.cobie.utils.stringwriters.IfcPropertyToCOBieString;
import org.erdc.cobie.utils.stringwriters.IfcRelationshipsToCOBie;
import org.erdc.cobie.utils.stringwriters.IfcSingleValueToCOBieString;
import org.erdc.cobie.utils.stringwriters.IfcUnitToCOBieString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;

public class COBieUtility
{
    private static final String SPACE = " ";
    private static final List<String> DATE_FORMATS = new ArrayList<String>(Arrays.asList("yyyy-MM-dd", "MM-dd-yyyy", "MMM. d, yyyy", "MMMM d, yyyy"));
    protected static enum ClassificationLiterals
    {
        Category, Assembly_Code, Assembly_Description, OmniClass_Number, OmniClass_Title, Uniclass_Code, Uniclass_Description, Category_Code, Category_Description, Classification_Code, Classification_Description
    }

    public enum COBieIDMAction
    {
        Ignore, Include
    }

    public enum CobieSheetName
    {
        Assembly, Attribute, Component, Connection, Contact, Document, Facility, Floor, Job, Resource, Space, Spare, System, Type, Zone, Impact, Coordinate, Issue
    }

    public enum InformationCobieSheetName
    {
        Instruction, PickLists
    }

    private static final String CATEGORYCODE_CATEGORYDESCRIPTION_SEPARATOR = ": ";
    private static final String WHITESPACE = SPACE;
    private static final String ENUM_SPACE_CHAR = "_";
    public static final Locale LOCALE = Locale.US;;
    public static final String CLASSIFICATION_REFERENCE_NAME_SEPARATOR = ":";
    private static final String SINGLE_QUOTE = "'";
    private static final String SINGLE_QUOTE_REPLACEMENT = "''";
    public static final String BIMSERVER_NUMERIC_NULL = "null";
    private static final Logger LOGGER = LoggerFactory.getLogger(COBieUtility.class);
    private static final String DefaultEmailAddress = "anonymous@anonymous.com";
    protected static final String ImplementationClassSuffix = "impl";;
    protected static final String COBieDateFormatString = "%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS";;
    public static final Ifc2x3tc1Factory ifcFactory = Ifc2x3tc1Factory.eINSTANCE;
    public static HashMap<CobieSheetName, String> cobieSheetNameToPlural = createPluralCobieSheetMap();

    public static HashMap<String, CobieSheetName> CobiePluralNameToCobieSheetName = createSheetNameToPluralMap();;
    public static final String COBieNA = "n/a";
    protected static final String COBieDelim = ",";
    protected static final String COBieUnkown = "unkown";
    private static final String SINGLE_QUOTE_REGEX = "\\b'\\b|\\b’\\b";

    public static ArrayList<String> arrayListFromDelimString(String delimString)
    {
        ArrayList<String> splitStrings = new ArrayList<String>();
        if (delimString != null)
        {
            if (delimString.contains(COBieUtility.getCOBieDelim()))
            {
                String[] splitStrArray = delimString.split(COBieUtility.getCOBieDelim());
                for (String splitStr : splitStrArray)
                {
                    splitStrings.add(splitStr.trim());
                }
            } else
            {
                splitStrings.add(delimString);
            }
        }
        return splitStrings;
    }

    public static Calendar calendarFromString(String dateTimeString)
    {
        String tmpDateTimeString = COBieUtility.getCOBieString(dateTimeString);
        tmpDateTimeString.replace("-", "-");
        Calendar cal = new XmlCalendar();
        try
        {
            cal = new XmlCalendar(tmpDateTimeString);
        } catch (Exception e)
        {
            cal = tryParsingCalendar(dateTimeString);
            if(cal==null)
                cal = currentTimeAsCalendar();
        }
        return cal;
    }

    private static Calendar tryParsingCalendar(String dateTimeString)
    {
        Calendar calendar = null;
        dateFormatLoop:
        for(String formatString : DATE_FORMATS)
        {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            try
            {
                calendar = new XmlCalendar(format.parse(dateTimeString));
                break dateFormatLoop;
            } catch (ParseException e)
            {
            }
        }
        return calendar;
    }

    public static Calendar calendarFromStringWithException(String dateTimeString) throws Exception
    {
        String tmpDateTimeString = COBieUtility.getCOBieString(dateTimeString);
        tmpDateTimeString.replace("-", "-");
        Calendar cal = new XmlCalendar();
        try
        {
            cal = new XmlCalendar(tmpDateTimeString);
        } catch (Exception e)
        {
            throw e;
        }
        return cal;
    }

    private static String categoryStringFromClassificationReference(IfcClassificationReference classificationReference)
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
            classification = itemReference + CLASSIFICATION_REFERENCE_NAME_SEPARATOR + name;
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

    static protected String categoryStringFromPropertyNameValueMap(
            Map<String, String> propertyNamePropertyValue,
            Map<String, String> categoryCodeToCategoryDescriptionPropertyNames)
    {
        String category = "";
        String categoryCode = "";
        String categoryDescription = "";
        ArrayList<String> categories = new ArrayList<String>();
        ArrayList<String> classificationPropertyNames = getClassificationPropertyNames();
        for (String key : categoryCodeToCategoryDescriptionPropertyNames.keySet())
        {
            categoryCode = "";
            categoryDescription = "";
            if (propertyNamePropertyValue.containsKey(key))
            {
                categoryCode = propertyNamePropertyValue.get(key);
                if (propertyNamePropertyValue.containsKey(categoryCodeToCategoryDescriptionPropertyNames.get(key)))
                {
                    categoryDescription = propertyNamePropertyValue.get(categoryCodeToCategoryDescriptionPropertyNames.get(key));
                }
                if ((categoryCode.length() > 0) && (categoryDescription.length() > 0))
                {
                    category += categoryCode + CATEGORYCODE_CATEGORYDESCRIPTION_SEPARATOR + categoryDescription;
                } else if (categoryCode.length() > 0)
                {
                    category += categoryCode;
                }
                categories.add(category);
            }
        }
        category = COBieUtility.delimittedStringFromArrayList(categories);
        if (COBieUtility.isNA(category))
        {
            category = COBieUtility.cobieStringFromStringMap(propertyNamePropertyValue, classificationPropertyNames);
        }

        return category;
    }

    private static String categoryStringFromRelAssociatesClassification(IfcRelAssociates assoc)
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

    static protected boolean classHasField(Object o, String fieldName)
    {

        boolean hasField = false;
        for (java.lang.reflect.Field slot : o.getClass().getFields())
        {
            if (slot.getName().toLowerCase().trim().equals(fieldName.toLowerCase()))
            {
                hasField = true;
            }
        }
        return hasField;
    }

    private static String classificationFromPropertySets(IfcObjectDefinition ifcObj)
    {
        Map<String, String> classificationTuples = getClassificationTuples();
        ArrayList<String> classificationNames = getClassificationPropertyNames();
        String classification = "";
        if (ifcObj instanceof IfcObject)
        {
            Map<String, String> masterMap = new HashMap<String, String>();

            IfcObject obj = (IfcObject)ifcObj;
            for (IfcRelDefines def : obj.getIsDefinedBy())
            {
                Map<String, String> tmpValueMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(def, classificationNames);
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
            masterMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(obj, classificationNames);
            classification = COBieUtility.categoryStringFromPropertyNameValueMap(masterMap, classificationTuples);
        }
        return classification;
    }

    public static IfcPropertyToCOBieString cobiePsetStringFromStringMap(
            Map<String, IfcPropertyToCOBieString> valMap,
            ArrayList<String> prioritizedPropertyNames)
    {
        IfcPropertyToCOBieString cString = null;
        IfcPropertyToCOBieString tmpVal = null;
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

    public static IfcPropertyToCOBieString cobiePsetStringFromStringMapAllowNA(
            Map<String, IfcPropertyToCOBieString> valMap,
            ArrayList<String> prioritizedPropertyNames)
    {
        IfcPropertyToCOBieString cString = null;
        IfcPropertyToCOBieString tmpVal = null;
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

    public static int cobiePsetStringRankingFromStringMap(Map<String, IfcPropertyToCOBieString> valMap, ArrayList<String> prioritizedPropertyNames)
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

    public static CobieSheetName CobieSheetNameEnumFromString(String sheetName) throws Exception
    {
        CobieSheetName enumSheetName;
        String casedSheetName = ToCOBieCase(sheetName);
        try
        {
            enumSheetName = CobieSheetName.valueOf(casedSheetName);
        } catch (Exception e)
        {
            throw e;
        }
        return enumSheetName;
    }

    public static CobieSheetName cobieSheetNameFromString(String sheetName)
    {
        CobieSheetName cobieSheetName = null;
        for (CobieSheetName tmpCobieSheetName : CobieSheetName.values())
        {
            if (sheetName.trim().equals(tmpCobieSheetName.name()))
            {
                cobieSheetName = tmpCobieSheetName;
                break;
            }
        }
        return cobieSheetName;
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

            if (value instanceof org.eclipse.emf.common.util.Enumerator)
            {
                Enumerator enumeratorValue = (Enumerator)value;
                attributeVal = enumeratorValue.getLiteral();
            }
        }

        return attributeVal;
    }

    public static String cobieStringFromStringMap(Map<String, String> valMap)
    {
        String cString = "";
        String tmpVal = "";
        ArrayList<String> concattedStrings = new ArrayList<String>();
        if (!valMap.isEmpty())
        {
            for (String key : valMap.keySet())
            {
                tmpVal = valMap.get(key);
                if (!concattedStrings.contains(tmpVal) && !isNA(tmpVal))
                {
                    cString += tmpVal + COBieUtility.COBieDelim;
                    concattedStrings.add(tmpVal);
                }
            }
            if (cString.endsWith(COBieUtility.COBieDelim))
            {
                cString = cString.substring(0, cString.length() - COBieUtility.COBieDelim.length());
            }
        }
        return COBieUtility.getCOBieString(cString);
    }

    public static String cobieStringFromStringMap(Map<String, String> valMap, ArrayList<String> prioritizedPropertyNames)
    {
        String cString = "";
        String tmpVal = "";
        for (String prioritizedPropertyName : prioritizedPropertyNames)
        {
            if (valMap.keySet().contains(prioritizedPropertyName))
            {
                tmpVal = valMap.get(prioritizedPropertyName);
                if ((tmpVal.length() > 0) && (cString.length() == 0))
                {
                    cString = tmpVal;
                }
            }
        }
        return COBieUtility.getCOBieString(cString);
    }

    public static int cobieStringRankingFromStringMap(Map<String, String> valMap, ArrayList<String> prioritizedPropertyNames)
    {
        int rank = -1;

        String cString = "";
        String tmpVal = "";
        for (String prioritizedPropertyName : prioritizedPropertyNames)
        {
            if (valMap.keySet().contains(prioritizedPropertyName))
            {
                tmpVal = valMap.get(prioritizedPropertyName);
                if ((tmpVal.length() > 0) && (cString.length() == 0))
                {
                    rank = prioritizedPropertyNames.size() - prioritizedPropertyNames.indexOf(prioritizedPropertyName);
                }
            }
        }
        return rank;
    }

    private static HashMap<CobieSheetName, String> createPluralCobieSheetMap()
    {
        HashMap<CobieSheetName, String> pluralNameMap = new HashMap<CobieSheetName, String>();
        pluralNameMap.put(CobieSheetName.Assembly, "Assemblies");
        pluralNameMap.put(CobieSheetName.Attribute, "Attributes");
        pluralNameMap.put(CobieSheetName.Component, "Components");
        pluralNameMap.put(CobieSheetName.Connection, "Connections");
        pluralNameMap.put(CobieSheetName.Contact, "Contacts");
        pluralNameMap.put(CobieSheetName.Document, "Documents");
        pluralNameMap.put(CobieSheetName.Facility, "Facilities");
        pluralNameMap.put(CobieSheetName.Floor, "Floors");
        pluralNameMap.put(CobieSheetName.Job, "Jobs");
        pluralNameMap.put(CobieSheetName.Resource, "Resources");
        pluralNameMap.put(CobieSheetName.Space, "Spaces");
        pluralNameMap.put(CobieSheetName.Spare, "Spares");
        pluralNameMap.put(CobieSheetName.System, "Systems");
        pluralNameMap.put(CobieSheetName.Type, "Types");
        pluralNameMap.put(CobieSheetName.Zone, "Zones");
        pluralNameMap.put(CobieSheetName.Impact, "Impacts");
        pluralNameMap.put(CobieSheetName.Coordinate, "Coordinates");
        pluralNameMap.put(CobieSheetName.Issue, "Issues");

        return pluralNameMap;
    }

    private static HashMap<String, CobieSheetName> createSheetNameToPluralMap()
    {
        HashMap<String, CobieSheetName> pluralNameMap = new HashMap<String, CobieSheetName>();
        pluralNameMap.put("Assemblies", CobieSheetName.Assembly);
        pluralNameMap.put("Attributes", CobieSheetName.Attribute);
        pluralNameMap.put("Components", CobieSheetName.Component);
        pluralNameMap.put("Connections", CobieSheetName.Connection);
        pluralNameMap.put("Contacts", CobieSheetName.Contact);
        pluralNameMap.put("Documents", CobieSheetName.Document);
        pluralNameMap.put("Facilities", CobieSheetName.Facility);
        pluralNameMap.put("Floors", CobieSheetName.Floor);
        pluralNameMap.put("Jobs", CobieSheetName.Job);
        pluralNameMap.put("Resources", CobieSheetName.Resource);
        pluralNameMap.put("Spaces", CobieSheetName.Space);
        pluralNameMap.put("Spares", CobieSheetName.Spare);
        pluralNameMap.put("Systems", CobieSheetName.System);
        pluralNameMap.put("Types", CobieSheetName.Type);
        pluralNameMap.put("Zones", CobieSheetName.Zone);
        pluralNameMap.put("Impacts", CobieSheetName.Impact);
        pluralNameMap.put("Coordinates", CobieSheetName.Coordinate);
        pluralNameMap.put("Issues", CobieSheetName.Issue);

        return pluralNameMap;
    }

    public static Calendar currentTimeAsCalendar()
    {
        return Calendar.getInstance();
    }

    public static String delimittedStringFromArrayList(ArrayList<String> stringList, boolean allowDuplicates, boolean allowNA)
    {

        String strChildren = "";
        ArrayList<String> copyList = new ArrayList<String>();
        for (String entry : stringList)
        {
            if (!copyList.contains(entry))
            {
                copyList.add(entry);
            }
        }
        for (String child : stringList)
        {
            if ((allowDuplicates || (!allowDuplicates && copyList.contains(child))) && (allowNA || (!allowNA && !isNA(child))))
            {
                strChildren += child + COBieDelim;
                if (!allowDuplicates)
                {
                    copyList.remove(child);
                }
            }

        }
        if (strChildren.endsWith(COBieDelim))
        {
            strChildren = strChildren.substring(0, strChildren.length() - COBieDelim.length());
        }
        return strChildren;
    }

    public static String delimittedStringFromArrayList(List<String> stringList)
    {
        String strChildren = "";
        for (String child : stringList)
        {
            strChildren += child + COBieDelim;
        }
        if (strChildren.endsWith(COBieDelim))
        {
            strChildren = strChildren.substring(0, strChildren.length() - COBieDelim.length());
        }
        return strChildren;
    }

    public static String delimittedStringSpacedFromArrayList(List<String> stringList)
    {
        String strChildren = "";
        String delimSpaced = COBieDelim + WHITESPACE;
        for (String child : stringList)
        {
            strChildren += child + delimSpaced;
        }
        if (strChildren.endsWith(delimSpaced))
        {
            strChildren = strChildren.substring(0, strChildren.length() - delimSpaced.length());
        }
        return strChildren;
    }

    static public Map<String, String> elementMapFromXMLObject(XmlObject xml)
    {
        Map<String, String> elementMap = new HashMap<String, String>();
        XMLStreamReader rdr = xml.newXMLStreamReader();
        String keyName = "";
        String keyVal = "";
        boolean lastWasStartElement = false;
        int attCount = 0;
        try
        {

            while (rdr.hasNext())
            {
                try
                {
                    attCount = rdr.getAttributeCount();
                } catch (Exception ex)
                {
                    attCount = 0;
                }
                if (attCount > 0)
                {
                    for (int i = 0; i < attCount; i++)
                    {
                        keyName = rdr.getAttributeLocalName(i);
                        keyVal = rdr.getAttributeValue(i);
                        if (!elementMap.containsKey(keyName))
                        {
                            elementMap.put(keyName, escape(keyVal));
                        }
                        lastWasStartElement = false;
                    }
                }
                if (rdr.isStartElement())
                {
                    keyName = rdr.getLocalName();
                    lastWasStartElement = true;

                } else if (rdr.isCharacters() && lastWasStartElement)
                {
                    if (isElementADateTime(xml, keyName))
                    {
                        keyVal = COBieUtility.stringFromXmlDateTime(xml, keyName);

                    } else
                    {
                        keyVal = rdr.getText();
                    }
                    if (!elementMap.containsKey(keyName))
                    {
                        elementMap.put(keyName, escape(keyVal));
                    }
                    lastWasStartElement = false;
                } else
                {
                    lastWasStartElement = false;
                }

                rdr.next();
            }
        } catch (XMLStreamException e)
        {
            LOGGER.error("", e);
        }
        return elementMap;
    }

    /**
     * Returns a string from the startsWithStrings array that returns true on
     * evaluationString.endsWith, if no match is found then a null is returned.
     * 
     * @param evaluationString
     *            String to evaluate
     * @param startsWithStrings
     *            Items to use in evaluationString.EndsWith
     * @param caseSensitive
     *            Evaluate endswith as case sensitive or not
     * @return
     */
    public static String endsWithOneOf(String evaluationString, ArrayList<String> startsWithStrings, boolean caseSensitive)
    {
        String startsWith = null;
        if (caseSensitive)
        {
            for (String startsWithString : startsWithStrings)
            {
                if (evaluationString.startsWith(startsWithString))
                {
                    startsWith = startsWithString;
                }
            }
        } else
        {
            for (String startsWithString : startsWithStrings)
            {
                if (evaluationString.toLowerCase().startsWith(startsWithString.toLowerCase()))
                {
                    startsWith = startsWithString;
                }
            }
        }
        return startsWith;
    }

    public static String escape(String text)
    {
        XmlString value = XmlString.Factory.newInstance();
        value.setStringValue(text);
        String returnValue = value.getStringValue();
        return returnValue;
    }

    public static String extObjectFromObjectDef(IfcObjectDefinition obj)
    {
        String className = obj.getClass().getSimpleName();
        if (className.toLowerCase().endsWith(ImplementationClassSuffix))
        {
            className = className.substring(0, className.length() - ImplementationClassSuffix.length());
        }
        return className;
    }

    public static String extObjectFromRelationship(IfcRelationship obj)
    {
        String className = obj.getClass().getSimpleName();
        if (className.toLowerCase().endsWith(ImplementationClassSuffix))
        {
            className = className.substring(0, className.length() - ImplementationClassSuffix.length());
        }
        return className;
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

    public static String getApplicationName(IfcOwnerHistory oh)
    {
        String strApp = "";
        IfcApplication ifcApp = oh.getOwningApplication();
        strApp = ifcApp.getApplicationFullName();
        return getCOBieString(strApp);
    }

    static private ArrayList<String> getClassificationPropertyNames()
    {
        ArrayList<String> names = new ArrayList<String>();
        for (ClassificationLiterals classificationLiteral : ClassificationLiterals.values())
        {
            names.add(classificationLiteral.name().replace(ENUM_SPACE_CHAR, WHITESPACE));
        }
        return names;
    }

    static private Map<String, String> getClassificationTuples()
    {
        String A1 = ClassificationLiterals.Assembly_Code.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String A2 = ClassificationLiterals.Assembly_Description.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String B1 = ClassificationLiterals.Category_Code.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String B2 = ClassificationLiterals.Category_Description.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String C1 = ClassificationLiterals.Classification_Code.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String C2 = ClassificationLiterals.Classification_Description.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String D1 = ClassificationLiterals.OmniClass_Number.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String D2 = ClassificationLiterals.OmniClass_Title.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String E1 = ClassificationLiterals.Uniclass_Code.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        String E2 = ClassificationLiterals.Uniclass_Description.toString().replace(ENUM_SPACE_CHAR, WHITESPACE);
        Map<String, String> map = new HashMap<String, String>();
        map.put(A1, A2);
        map.put(B1, B2);
        map.put(C1, C2);
        map.put(D1, D2);
        map.put(E1, E2);
        return map;
    }

    static public String getCOBieDelim()
    {
        return COBieDelim;
    }

    public static String getCOBieString(String text)
    {
        String strReturn = COBieNA;
        if (((text != null) && (text.length() > 0)))
        {
            strReturn = text.trim();
            if (text.endsWith(getCOBieDelim()))
            {
                strReturn = getCOBieString(text.substring(0, text.length() - 1));
            }
        }
        if (isNA(strReturn))
        {
            strReturn = COBieNA;
        }
        if (!isNA(strReturn))
        {
            strReturn = replaceSpecialCharacters(strReturn);
            getXMLEncodedString(text);
            getXMLDecodedString(text);
        }

        return strReturn;
    }

    public static Calendar getDefaultCalendar()
    {
        return currentTimeAsCalendar();
    }

    public static String getEmailFromOwnerHistory(IfcOwnerHistory oh)
    {
        IfcPersonAndOrganization personOrg = oh.getOwningUser();
        return getCOBieString(getEmailFromPersonAndOrganization(personOrg));
    }

    public static String getEmailFromOrganization(IfcOrganization org)
    {
        String strEmail = "";
        EList<IfcAddress> organizationAddresses = org.getAddresses();
        String organizationEmail = getEmailsFromAddresses(organizationAddresses);
        strEmail = organizationEmail;
        return getCOBieString(strEmail);
    }
    public static String getEmailFromPersonAndOrganization(IfcPersonAndOrganization personOrg)
    {
        String strEmail = "";
        IfcPerson person = personOrg.getThePerson();
        String givenName = person.getGivenName();
        if ((givenName == null) || (givenName.length() == 0))
        {
            givenName = COBieUnkown;
        }
        String familyName = person.getFamilyName();
        if ((familyName == null) || (familyName.length() == 0))
        {
            familyName = COBieUnkown;
        }
        IfcOrganization org = personOrg.getTheOrganization();
        String orgName = org.getName();
        if ((orgName == null) || (orgName.length() == 0))
        {
            orgName = COBieUnkown;
        }
        EList<IfcAddress> pAddresses = person.getAddresses();
        EList<IfcAddress> oAddresses = org.getAddresses();
        String pEmail = getEmailsFromAddresses(pAddresses);
        String oEmail = getEmailsFromAddresses(oAddresses);
        String pID = person.getId();
        String oID = org.getId();
        if ((pEmail != null) && (pEmail.length() > 0) && (pEmail != COBieNA))
        {
            strEmail = pEmail;
        } else if ((oEmail != null) && (oEmail.length() > 0) && (oEmail != COBieNA))
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
        return getCOBieString(strEmail);
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
        return getCOBieString(emailAddress);

    }

    public static <T extends Enum<T>> List<String> getEnumLiteralsAsStringList(Class<T> enumClass)
    {
        ArrayList<String> names = null;
        try
        {
            T[] items = enumClass.getEnumConstants();
            Method accessor = enumClass.getMethod("getDisplayValue");

            names = new ArrayList<String>(items.length);
            for (T item : items)
            {
                names.add(accessor.invoke(item).toString());
            }

        } catch (NoSuchMethodException ex)
        {
            // Didn't actually implement getDisplayValue().
        } catch (InvocationTargetException ex)
        {
            // getDisplayValue() threw an exception.
        } catch (IllegalArgumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return names;
    }

    public static ArrayList<String> getEnumValueList(XmlString xmlString)
    {
        ArrayList<String> values = new ArrayList<String>();
        SchemaStringEnumEntry valArr[] = xmlString.schemaType().getStringEnumEntries();
        for (SchemaStringEnumEntry val : valArr)
        {
            values.add(val.getString());
        }
        return values;
    }

    public static String getFirstDerivedUnitStringInProjectContext(IfcModelInterface model, IfcDerivedUnitEnum unitType)
    {
        String unitString = COBieNA;
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
                            if ((derivedUnit.getUnitType() == unitType) && isNA(unitString))
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
        String unitString = COBieNA;
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
                            if ((namedUnit.getUnitType() == unitType) && isNA(unitString))
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

    private static String addSpaceAfterClassificationCodeDelim(String classification)
    {
        StringBuilder stringBuilder = new StringBuilder();
        if(classification.contains(COBieUtility.CLASSIFICATION_REFERENCE_NAME_SEPARATOR))
        {
            char[] classificationSymbols = classification.toCharArray();
            for(int i =0; i < classificationSymbols.length; i++)
            {
                char classificationSymbol = classificationSymbols[i];         
                stringBuilder.append(classificationSymbol);
                if (i+1 < classificationSymbols.length)
                {
                    char nextSymbol = classificationSymbols[i+1];
                    if(CLASSIFICATION_REFERENCE_NAME_SEPARATOR.toCharArray()[0] == classificationSymbol && nextSymbol!=' ')
                        stringBuilder.append(SPACE);
                }
  
            }
                
        }
        else
            stringBuilder = new StringBuilder(classification);
        return stringBuilder.toString();
    }

    public static IfcClassificationReference getObjectClassificationReference(IfcObjectDefinition ifcObj)
    {
        IfcClassificationReference classificationReference = null;
        getClassificationTuples();
        getClassificationPropertyNames();
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
        Map<String, String> classificationTuples = getClassificationTuples();
        ArrayList<String> classificationNames = getClassificationPropertyNames();
        EList<IfcRelAssociates> associations = ifcObj.getHasAssociations();
        if ((associations == null) || (associations.size() <= 0))
        {
            associations = searchAllClassificationReferencesForPropertySetAssociation(ifcObj, model);
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
                    classification += ifcClass.getName() + COBieDelim;
                } else if (classNot instanceof IfcClassificationReference)
                {
                    IfcClassificationReference classRef = (IfcClassificationReference)classNot;
                    String referencedSource = COBieUtility.COBieNA;
                    if (classRef.isSetReferencedSource())
                    {
                        referencedSource = classRef.getReferencedSource().getName();
                        classification += classRef.getReferencedSource().getName() + COBieDelim;
                    } else if (COBieUtility.isNA(referencedSource))
                    {
                        classification += classRef.getItemReference() + COBieDelim;
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
                Map<String, String> tmpValueMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(def, classificationNames);
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
            masterMap = IfcRelationshipsToCOBie.propertyStringsFromTypeObject(obj, classificationNames);
            classification = COBieUtility.categoryStringFromPropertyNameValueMap(masterMap, classificationTuples);
        }
        return COBieUtility.getCOBieString(classification);
    }

    public static String getRelDefinesByTypeClassification(IfcRelDefinesByType relDefType)
    {
        String classification = "";
        Map<String, String> masterMap = new HashMap<String, String>();
        Map<String, String> classificationTuples = getClassificationTuples();
        ArrayList<String> classificationNames = getClassificationPropertyNames();

        Map<String, String> tmpValueMap = IfcRelationshipsToCOBie.propertyStringsFromRelDefines(relDefType, classificationNames);
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

    public static String getXMLDecodedString(String text)
    {
        String xmlEncodedString = "";
        xmlEncodedString = StringEscapeUtils.unescapeXml(text);
        return xmlEncodedString;
    }

    public static String getXMLEncodedString(String text)
    {
        String xmlEncodedString = "";
        xmlEncodedString = StringEscapeUtils.escapeXml(text);
        return xmlEncodedString;
    }

    public static String identifierFromObject(IfcObject obj)
    {
        String ID = "";
        if (obj != null)
        {
            ID = obj.getGlobalId();
        }
        return COBieUtility.getCOBieString(ID);
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

    public static Calendar ifcTimeStampAsCalendar(int timestamp)
    {
        long secondsSinceNineteenSeventy = (long)timestamp * (long)1000;
        Date date = new Date(secondsSinceNineteenSeventy);
        Calendar calTimestamp = new org.apache.xmlbeans.XmlCalendar(date);
        return calTimestamp;

    }

    static public boolean isElementADateTime(XmlObject xml, String elementName)
    {
        boolean isADateTime = false;
        XmlObject[] selectedObjs = xml.selectPath(elementName);
        if (selectedObjs.length == 1)
        {
            XmlObject selectedObj = selectedObjs[0];
            if ((selectedObj instanceof Calendar) || (selectedObj instanceof XmlCalendar) || (selectedObj instanceof XmlDateTime))
            {
                isADateTime = true;
                XmlDateTime xDateTime = (XmlDateTime)selectedObj;
                @SuppressWarnings("unused")
                String formattedDateTime = String.format(COBieDateFormatString, xDateTime.getCalendarValue());
            }
        }
        return isADateTime;
    }

    public static boolean isInformationSheet(String sheetName)
    {
        boolean isInformation = false;
        if (sheetName.equalsIgnoreCase(InformationCobieSheetName.Instruction.name())
                || sheetName.equalsIgnoreCase(InformationCobieSheetName.PickLists.name()))
        {
            isInformation = true;
        }
        return isInformation;
    }

    public static boolean isNA(List<String> stringList)
    {
        boolean allNA = true;
        for (String tmpString : stringList)
        {
            if (!isNA(tmpString))
            {
                allNA = false;
            }
        }
        return allNA;
    }

    public static boolean isNA(String str)
    {
        return (isNullOrEmpty(str) || str.equalsIgnoreCase(COBieNA) || str.equalsIgnoreCase(BIMSERVER_NUMERIC_NULL));
    }

    public static boolean isNullOrEmpty(String str)
    {
        return ((str == null) || str.isEmpty());
    }

    public static boolean isValueSetAsStringNA(IfcReal durationReal)
    {
        return (durationReal.getWrappedValueAsString() != null) && durationReal.getWrappedValueAsString().equals(COBieNA);
    }

    public static Map<String, IfcPropertyToCOBieString> psetStringsFromAttributes(EObject root, ArrayList<String> attributeNames, boolean exclusive)
    {
        Map<String, IfcPropertyToCOBieString> attributeVals = new HashMap<String, IfcPropertyToCOBieString>();
        String attributeVal = null;
        if (exclusive)
        {
            EList<EStructuralFeature> classFeatures = root.eClass().getEAllStructuralFeatures();
            for (EStructuralFeature feature : classFeatures)
            {
                String featureName = feature.getName();
                if (!attributeNames.contains(featureName))
                {
                    attributeVal = COBieUtility.cobieStringFromFeature(root, feature);
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

    private static String replaceSpecialCharacters(String strReturn)
    {
        strReturn = CharMatcher.ASCII.retainFrom(strReturn);
        strReturn = strReturn.replaceAll(SINGLE_QUOTE_REGEX, SINGLE_QUOTE_REPLACEMENT);
        strReturn = strReturn.replace(SINGLE_QUOTE_REPLACEMENT, SINGLE_QUOTE);
        // This considers the possibility that we may have encoded single quotes
        // ('') incoming mixed with single quotes
        // Thus we normalize the string by first replacing all double quotes
        // with singles, and then replace
        // A regular expression match would be better though
        strReturn = strReturn.replace(SINGLE_QUOTE, SINGLE_QUOTE_REPLACEMENT);
        // strReturn = strReturn.replace(APOSTROPHE, SINGLE_QUOTE_REPLACEMENT);
        // strReturn = strReturn.replace(FORWARD_SLASH, FORWARD_SLASH_REPLACE);
        // strReturn = strReturn.replace(NON_STANDARD_DASH, DASH);
        return strReturn;
    }

    private static EList<IfcRelAssociates> searchAllClassificationReferencesForPropertySetAssociation(IfcPropertySet ifcObj, IfcModelInterface model)
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

    /**
     * Returns a string from the startsWithStrings array that returns true on
     * evaluationString.StartsWith, if no match is found then a null is
     * returned.
     * 
     * @param evaluationString
     *            String to evaluate
     * @param startsWithStrings
     *            Items to use in evaluationString.StartsWith
     * @param caseSensitive
     *            Evaluate startswith as case sensitive or not
     * @return
     */
    public static String startsWithOneOf(String evaluationString, ArrayList<String> startsWithStrings, boolean caseSensitive)
    {
        String startsWith = null;
        if (caseSensitive)
        {
            for (String startsWithString : startsWithStrings)
            {
                if (evaluationString.startsWith(startsWithString))
                {
                    startsWith = startsWithString;
                }
            }
        } else
        {
            for (String startsWithString : startsWithStrings)
            {
                if (evaluationString.toLowerCase().startsWith(startsWithString.toLowerCase()))
                {
                    startsWith = startsWithString;
                }
            }
        }
        return startsWith;
    }

    public static boolean stringContainsOneOf(String testString, ArrayList<String> tokens)
    {
        boolean contains = false;
        for (String tmpTok : tokens)
        {
            if (testString.contains(tmpTok))
            {
                contains = true;
            }
        }
        return contains;

    }

    public static boolean stringContainsOneOf(String testString, ArrayList<String> tokens, boolean caseSensitive)
    {
        boolean contains = false;
        if (caseSensitive)
        {
            for (String tmpTok : tokens)
            {
                if (testString.contains(tmpTok))
                {
                    contains = true;
                }
            }
        } else
        {
            for (String tmpTok : tokens)
            {
                if (testString.toLowerCase().contains(tmpTok.toLowerCase()))
                {
                    contains = true;
                }
            }
        }
        return contains;

    }

    static public String stringFromXmlDateTime(XmlObject xml, String elementName)
    {
        XmlObject[] selectedObjs = xml.selectPath(elementName);
        String formattedDate = "";
        if (selectedObjs.length == 1)
        {
            XmlObject selectedObj = selectedObjs[0];
            if ((selectedObj instanceof Calendar) || (selectedObj instanceof XmlCalendar) || (selectedObj instanceof XmlDateTime))
            {
                XmlDateTime xDateTime = (XmlDateTime)selectedObj;
                formattedDate = String.format(COBieDateFormatString, xDateTime.getCalendarValue());
            }
        }
        return formattedDate;
    }

    public static String ToCOBieCase(String string)
    {
        String cobieCaseString = "";
        String charString;
        char[] stringCharArray = string.toCharArray();
        for (int i = 0; i < stringCharArray.length; i++)
        {
            charString = String.valueOf(stringCharArray[i]);
            if (i == 0)
            {
                cobieCaseString += charString.toUpperCase();
            } else
            {
                cobieCaseString += charString.toLowerCase();
            }
        }
        return cobieCaseString;
    }

    public static String trimImplFromClassNameString(String simpleClassName)
    {
        if (simpleClassName.toLowerCase().endsWith("impl"))
        {
            simpleClassName = simpleClassName.substring(0, simpleClassName.length() - 4);
        }
        return simpleClassName;
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
                    attributeVal = COBieUtility.cobieStringFromFeature(root, feature);
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
                attributeVals.put(attributeName, COBieUtility.valueOfAttribute(root, attributeName));
            }
        }

        return attributeVals;
    }

    public static String DateStringFromMonthDayYear(int month, int day, int year)
    {
        return "";
    }

    public static String hashFromString(String hash) throws NoSuchAlgorithmException
    {
        MessageDigest msgDigest = MessageDigest.getInstance("MD5");
        byte[] msgContents = hash.getBytes();
        byte[] hashedContents = msgDigest.digest(msgContents);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashedContents.length; i++)
        {
            sb.append(Integer.toString((hashedContents[i] & 0xff) + 0x100, 16).substring(1));
        }
        hash = sb.toString();
        return hash;
    }

    public static Calendar getCurrentTimeCalendar()
    {
        Calendar cal = Calendar.getInstance();
        Date StartTime = cal.getTime();
        Calendar calStart = new org.apache.xmlbeans.XmlCalendar(StartTime);
        return calStart;
    }
    

}
