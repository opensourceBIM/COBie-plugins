package org.bimserver.cobie.shared.utility;

/******************************************************************************

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
import java.io.InputStream;
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
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.nibs.cobie.tab.AttributeType;
import org.nibs.cobie.tab.COBIEType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;

public class COBieUtility
{
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

    public static final String SPACE = " ";

    private static final List<String> DATE_FORMATS = new ArrayList<String>(Arrays.asList("yyyy-MM-dd", "MM-dd-yyyy", "MMM. d, yyyy", "MMMM d, yyyy"));

    private static final String CATEGORYCODE_CATEGORYDESCRIPTION_SEPARATOR = ": ";
    private static final String WHITESPACE = SPACE;
    private static final String ENUM_SPACE_CHAR = "_";
    public static final Locale LOCALE = Locale.US;;
    public static final String CLASSIFICATION_REFERENCE_NAME_SEPARATOR = ":";
    private static final String SINGLE_QUOTE = "'";
    private static final String SINGLE_QUOTE_REPLACEMENT = "''";
    public static final String BIMSERVER_NUMERIC_NULL = "null";
    private static final Logger LOGGER = LoggerFactory.getLogger(COBieUtility.class);
    public static final String ImplementationClassSuffix = "impl";
    protected static final String COBieDateFormatString = "%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS";
    public static HashMap<CobieSheetName, String> cobieSheetNameToPlural = createPluralCobieSheetMap();

    public static HashMap<String, CobieSheetName> CobiePluralNameToCobieSheetName = createSheetNameToPluralMap();
    public static final String COBieNA = "n/a";
    public static final String COBieDelim = ",";
    public static final String COBieUnkown = "unkown";
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
            if (cal == null)
            {
                cal = currentTimeAsCalendar();
            }
        }
        return cal;
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

    public static String categoryStringFromPropertyNameValueMap(
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
                if (!COBieUtility.isNA(categoryCode) && !COBieUtility.isNA(categoryDescription))
                {
                    category += categoryCode + CATEGORYCODE_CATEGORYDESCRIPTION_SEPARATOR + categoryDescription;
                } 
                else if (!COBieUtility.isNA(categoryCode))
                {
                    category += categoryCode;
                }
                if(!COBieUtility.isNA(category))
                {
                	categories.add(category);
                }
            }
        }
        category = COBieUtility.delimittedStringFromArrayList(categories);
        if (COBieUtility.isNA(category))
        {
            category = COBieUtility.cobieStringFromStringMap(propertyNamePropertyValue, classificationPropertyNames);
        }

        return category;
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

    public static ArrayList<String> getClassificationPropertyNames()
    {
        ArrayList<String> names = new ArrayList<String>();
        for (ClassificationLiterals classificationLiteral : ClassificationLiterals.values())
        {
            names.add(classificationLiteral.name().replace(ENUM_SPACE_CHAR, WHITESPACE));
        }
        return names;
    }

    public static Map<String, String> getClassificationTuples()
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

    public static Calendar getCurrentTimeCalendar()
    {
        Calendar cal = Calendar.getInstance();
        Date StartTime = cal.getTime();
        Calendar calStart = new org.apache.xmlbeans.XmlCalendar(StartTime);
        return calStart;
    }

    public static Calendar getDefaultCalendar()
    {
        return currentTimeAsCalendar();
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

        } catch (InvocationTargetException ex)
        {

        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
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

 
    public static boolean isValidSchemaDocument(InputStream inputStream, SchemaType type)
    {
        boolean valid = false;
        try
        {
            CloseShieldInputStream inputStreamCopy = new CloseShieldInputStream(inputStream);
            org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(inputStreamCopy, type, null);
            valid = true;
            inputStreamCopy.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return valid;
    }

    public static String replaceSpecialCharacters(String strReturn)
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
                if (xDateTime.getCalendarValue().getTimeInMillis() <= 0)
                {
                	formattedDate = COBieUtility.COBieNA;
                }
                else
                {
                	formattedDate = String.format(COBieDateFormatString, xDateTime.getCalendarValue());
                }
            }
        }
        return formattedDate;
    }
    
    static public String StringFromCalendar(Calendar calendar)
    {
    	String formattedDate = "";
    	if(calendar != null)
    	{
    		if (calendar.getTime().getTime() <= 0)
            {
            	formattedDate = COBieUtility.COBieNA;
            }
            else
            {
            	formattedDate = String.format(COBieDateFormatString, calendar);
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

    private static Calendar tryParsingCalendar(String dateTimeString)
    {
        Calendar calendar = null;
        dateFormatLoop: for (String formatString : DATE_FORMATS)
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


    /***
     * This function checks the string to see if it is a valid date.  If it is a valid date then
     * it will be set to n/a if it is equal to or before the Java Epoch datetime (1969)
     * @param dateString
     * @return
     */
	public static String NormalizeDateString(String dateString) 
	{
		String returnValue = dateString;
		try 
		{
			Calendar calendar = COBieUtility.calendarFromStringWithException(dateString);
			if(calendar.getTimeInMillis() <=0)
			{
				returnValue = COBieUtility.COBieNA;
			}
			
		} catch (Exception e) 
		{
			//do nothing
		}
		return returnValue;
	}

	public static Predicate<AttributeType> getAttributeSheetRowFilter(String sheetName, String rowName)
	{
		return p -> p.getSheetName() != null && p.getSheetName().equalsIgnoreCase(sheetName) &&
				p.getRowName() != null && p.getRowName().equalsIgnoreCase(rowName);
	}

   public static Predicate<AttributeType> getAttributeNameSheetRowFilter(String attributeName, String sheetName, String rowName)
   {
	   return getAttributeSheetRowFilter(sheetName, rowName).and(p -> p.getName() != null && p.getName().equalsIgnoreCase(attributeName));
   }
   
   public static Optional<AttributeType> getSheetRowAttribute(String attributeName, String sheetName, String rowName, COBIEType cobie)
   {
	   return getFirstAttributeMatch(getAttributeNameSheetRowFilter(attributeName, sheetName, rowName), cobie);
   }
   public static List<AttributeType> getAllAttributeMatches(Predicate<AttributeType> predicate, COBIEType cobie)
   {
	   return cobie.getAttributes().getAttributeList().stream().filter(predicate).collect(Collectors.toList());
   }
   
   public static Optional<AttributeType> getFirstAttributeMatch(Predicate<AttributeType> predicate, COBIEType cobie)
   {
	   return cobie.getAttributes().getAttributeList().stream().filter(predicate).findFirst();
   }

}
