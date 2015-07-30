package org.bimserver.cobie.shared.transform.cobietab.cobielite;

import java.util.ArrayList;
import java.util.List;











import org.bimserver.cobie.shared.cobietab.IndexedCOBie;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.ContactKeyType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SpaceKeyType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemAssignmentCollectionType;
import org.buildingsmartalliance.docs.nbims03.cobie.core.SystemKeyType;

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
            newContact.setContactEmailReference(expression);
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
