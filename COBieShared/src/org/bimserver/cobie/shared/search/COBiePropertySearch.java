package org.bimserver.cobie.shared.search;

import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.search.algorithm.StringDistanceCalculator;
import org.bimserver.cobie.shared.search.algorithm.StringDistanceCalculator.EditDistanceAlgorithmEnum;
import org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility.ComparisonType;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;

public class COBiePropertySearch extends ModelSearchEngine<IfcRoot, String, IfcProperty>
{
    private static final EditDistanceAlgorithmEnum DEFAULT_SEARCH_ALGORITHM = EditDistanceAlgorithmEnum.Levenshtein;

    private EditDistanceAlgorithmEnum distanceAlgorithm;

    public COBiePropertySearch(List<String> searchTerms, IfcRoot searchTarget)
    {
        super(searchTerms, searchTarget);
    }

    public double getBestMatchDistance()
    {
        return getBestMatch().getDistance();
    }

    public String getBestMatchSearchString()
    {
        return getBestMatch().getSearchTerm();
    }

    @Override
    public Map<String, COBieSearchHit<String, IfcProperty>> getSearchHits()
    {
        return searchHits;
    }

    @Override
    public IfcRoot getSearchTarget()
    {
        return searchTarget;
    }

    @Override
    protected void init()
    {
        super.init();
        setDistanceAlgorithm(DEFAULT_SEARCH_ALGORITHM);
    }

    @Override
    public boolean matchMetsThreshold()
    {
        boolean hit = false;
        if ((bestMatch != null) && (bestMatch.getSearchHit() != null))
        {
            String searchStringLower = bestMatch.getSearchTerm().toLowerCase().trim();
            String compareStringLower = bestMatch.getSearchHit().getName().toLowerCase();
            ComparisonType compareType = org.bimserver.cobie.shared.utility.ifc.IfcRelationshipUtility
                    .getComparisonTypeFromPropertySearchString((bestMatch.getSearchTerm()));
            switch (compareType)
            {
                case StartsWith:
                    if (compareStringLower.startsWith(searchStringLower))
                    {
                        hit = true;
                    }
                    break;
                case EndsWith:
                    if (compareStringLower.endsWith(searchStringLower))
                    {
                        hit = true;
                    }
                    break;
                case Contains:
                    if (compareStringLower.contains(searchStringLower))
                    {
                        hit = true;
                    }
                    break;
                case Equals:
                    if (compareStringLower.equalsIgnoreCase(searchStringLower))
                    {
                        hit = true;
                    }
                    break;
                default:
                    hit = false;
                    break;
            }
        }

        return hit;
    }

    @Override
    protected void search()
    {
        if (searchTarget instanceof IfcObject)
        {
            IfcObject ifcObject = (IfcObject)searchTarget;
            for (IfcRelDefines defines : ifcObject.getIsDefinedBy())
            {
                if (defines instanceof IfcRelDefinesByProperties)
                {
                    IfcRelDefinesByProperties definesByProperties = (IfcRelDefinesByProperties)defines;
                    searchDefinesByProperties(definesByProperties);
                }
            }
        } else if (searchTarget instanceof IfcTypeObject)
        {
            IfcTypeObject typeObject = (IfcTypeObject)searchTarget;
            for (IfcPropertySetDefinition propertySet : typeObject.getHasPropertySets())
            {
                searchPropertySetDefinition(propertySet);
            }
        }

    }

    private void searchDefinesByProperties(IfcRelDefinesByProperties definesByProperties)
    {
        IfcPropertySetDefinition propertySetDefinition = definesByProperties.getRelatingPropertyDefinition();
        searchPropertySetDefinition(propertySetDefinition);
    }

    private void searchProperty(IfcProperty property)
    {
        String propertyName = property.getName();
        for (String searchString : getPrioritizedSearchTerms())
        {
            double minDistance = searchHits.get(searchString).getDistance();
            double tmpDistance = StringDistanceCalculator.getEditDistance(searchString, propertyName, distanceAlgorithm);
            if (tmpDistance < minDistance)
            {
                setNewKeywordBestMatch(searchString, property, tmpDistance);
            }
        }
    }

    private void searchPropertySet(IfcPropertySet propertySet)
    {
        for (IfcProperty property : propertySet.getHasProperties())
        {
            searchProperty(property);
        }
    }

    private void searchPropertySetDefinition(IfcPropertySetDefinition propertySetDefinition)
    {
        if (propertySetDefinition instanceof IfcPropertySet)
        {
            IfcPropertySet propertySet = (IfcPropertySet)propertySetDefinition;
            searchPropertySet(propertySet);
        }
    }

    public void setDistanceAlgorithm(EditDistanceAlgorithmEnum distanceAlgorithm)
    {
        this.distanceAlgorithm = distanceAlgorithm;
    }

    @Override
    public void setSearchTarget(IfcRoot searchTarget)
    {
        this.searchTarget = searchTarget;
    }

}
