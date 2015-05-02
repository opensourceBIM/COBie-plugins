package org.bimserver.cobie.shared.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.xmlbeans.XmlCalendar;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.EmptyStringMode;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.InvalidDateTimeStringMode;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.SpecialCharacterMode;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.TrailingDelimiterMode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.common.base.CharMatcher;
public class COBieStringHandler
{
    private static final String XSI_NIL = "xsi:nil";
    private static final String CREATED_ON = "CreatedOn";
    private static final String SINGLE_QUOTE = "'";
    private static final String SINGLE_QUOTE_REPLACEMENT = "''";
    private static final String SINGLE_QUOTE_REGEX = "\\b'\\b|\\b’\\b";
    private COBieStringHandlerSettings settings;
    public static final String COBieNA = "n/a";
    public static final String BIMSERVER_NUMERIC_NULL = "null";
    protected static final String COBieDelim = ",";
    protected static final String COBieDateFormatString = "%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS";
    private static final List<String> DATE_FORMATS = new ArrayList<String>(Arrays.asList("yyyy-MM-dd", "MM-dd-yyyy", "MMM. d, yyyy", "MMMM d, yyyy"));
    public static String getCOBieDelim()
    {
        return COBieDelim;
    }
    
    public COBieStringHandlerSettings getSettings()
    {
        return settings;
    }

    public void setSettings(COBieStringHandlerSettings settings)
    {
        this.settings = settings;
    }
    
    public COBieStringHandler(COBieStringHandlerSettings settings)
    {
        setSettings(settings);
    }
    
    public COBieStringHandler()
    {
        this(new COBieStringHandlerSettings(EmptyStringMode.REPLACE_WITH_NA, SpecialCharacterMode.REMOVE, TrailingDelimiterMode.REMOVE, InvalidDateTimeStringMode.SET_TO_CURRENT_DATETIME));
    }
    

    
    public String getCOBieString(String text)
    {
       
        String strReturn = (text != null) ? text : "";
        if ((text != null) && (text.length() > 0))
        {
            strReturn = text.trim();
            if (text.endsWith(COBieDelim) && (settings.getTrailingDelimiterMode() == TrailingDelimiterMode.REMOVE))
            {
                strReturn = getCOBieString(text.substring(0, text.length() - 1));
            }
        }
        if (isNA(strReturn) && (settings.getEmptyStringMode() == COBieStringHandlerSettings.EmptyStringMode.REPLACE_WITH_NA) )
        {
            strReturn = COBieNA;
        }
        if (isNA(strReturn))
        {
            if(settings.getSpecialCharacterMode() == COBieStringHandlerSettings.SpecialCharacterMode.REMOVE)
                strReturn = replaceSpecialCharacters(strReturn);
        }
        return strReturn;
    }
    
    public static boolean isNullOrEmpty(String str)
    {
        return ((str == null) || str.isEmpty());
    }
    
    public boolean isNA(String str)
    {
        return (isNullOrEmpty(str) || str.equalsIgnoreCase(COBieNA) || str.equalsIgnoreCase(BIMSERVER_NUMERIC_NULL));
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

    public Calendar calendarFromString(String dateTimeString)
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
            {
                switch(getSettings().getInvalidDateTimeStringMode())
                {
                    case SET_TO_CURRENT_DATETIME:
                        cal = COBieUtility.currentTimeAsCalendar();
                        break;
                    case SET_TO_MIN_DATETIME:
                        cal = new XmlCalendar();
                        break;
                    case SET_TO_NULL:
                        cal = null;
                        break;
                    default:
                        cal = COBieUtility.currentTimeAsCalendar();
                        break;
                    
                }
                
            }
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

    public void setCreatedOnTextOnNullCalendar(Calendar calendar, String createdOnText, Element cobieElement)
    {
        if(calendar == null && createdOnText!=null && createdOnText.length()>0)
        {
            for(int i=0; i < cobieElement.getChildNodes().getLength(); i ++)
            {
                Node childNode = cobieElement.getChildNodes().item(i);
                if(childNode.getNodeName().equalsIgnoreCase(CREATED_ON))
                {
                    if(childNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element) childNode;
                        element.setAttribute(XSI_NIL, "false");
                        element.appendChild(element.getOwnerDocument().createTextNode(createdOnText));
                    }
                }
            }
        }
    }
    
}
