package org.erdc.cobie.cobielite.parsers.sheetxmldata.dispatchers;

import java.util.ArrayList;
import java.util.List;

import org.erdc.cobie.cobielite.ContactAssignmentCollectionType;
import org.erdc.cobie.cobielite.ContactKeyType;
import org.erdc.cobie.cobielite.SpaceAssignmentCollectionType;
import org.erdc.cobie.cobielite.SpaceKeyType;
import org.erdc.cobie.cobielite.SystemAssignmentCollectionType;
import org.erdc.cobie.cobielite.SystemKeyType;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.cobiesheetxmldata.indices.IndexedCOBie;

public class AssignmentHelper
{
    public static void parseContactAssignments(ContactAssignmentCollectionType contacts, String contactExpression)
    {
        List<String> contactExpressions = new ArrayList<String>();
        if (contactExpression.contains(COBieUtility.getCOBieDelim()))
        {
            contactExpressions = COBieUtility.arrayListFromDelimString(contactExpression);

        } else
        {
            contactExpressions.add(contactExpression);
        }
        for (String expression : contactExpressions)
        {
            ContactKeyType newContact = contacts.addNewContactAssignment();
            newContact.setContactEmail(expression);
        }
    }

    public static void parseSpaceAssignments(SpaceAssignmentCollectionType spaces, String spaceNameExpression, IndexedCOBie indexedCOBie)
    {
        List<String> contactExpressions = new ArrayList<String>();
        if (spaceNameExpression.contains(COBieUtility.getCOBieDelim()))
        {
            contactExpressions = COBieUtility.arrayListFromDelimString(spaceNameExpression);

        } else
        {
            contactExpressions.add(spaceNameExpression);
        }
        for (String expression : contactExpressions)
        {
            SpaceKeyType newSpace = spaces.addNewSpaceAssignment();
            newSpace.setSpaceName(expression);
            try
            {
                String floorName = indexedCOBie.getFloorSpaces().getSpaceFloorName(expression);
                newSpace.setFloorName(floorName);
            } catch (Exception ex)
            {

            }

        }
    }

    public static void parseSystemAssignments(SystemAssignmentCollectionType systemAssignments, String systemNameExpression, IndexedCOBie indexedCOBie)
    {
        List<String> systemNameExpressions = new ArrayList<String>();
        if (systemNameExpression.contains(COBieUtility.getCOBieDelim()))
        {
            systemNameExpressions = COBieUtility.arrayListFromDelimString(systemNameExpression);

        } else
        {
            systemNameExpressions.add(systemNameExpression);
        }
        for (String expression : systemNameExpressions)
        {
            SystemKeyType newSystem = systemAssignments.addNewSystemAssignment();
            newSystem.setSystemName(expression);
        }
    }

}
