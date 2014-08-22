package org.erdc.cobie.shared.cobietab;

import java.util.HashMap;

import org.erdc.cobie.sheetxmldata.COBIEType;
import org.erdc.cobie.sheetxmldata.ResourceType;

public class IndexedCOBie
{
    private TypeComponentIndex typeComponents;
    private FloorSpacesIndex floorSpaces;

    private SheetNameAttributesDocumentsIssuesIndex descriptiveElementIndex;
    private SpaceZonesIndex spaceZones;
    private TypeAssemblyIndex typeAssemblies;
    private TypeJobIndex typeJobs;
    private TypeSpareIndex typeSpares;
    private ComponentAssemblyIndex componentAssemblies;
    private ComponentSpaceIndex componentSpaces;
    private ComponentSystemIndex componentSystems;
    private HashMap<String, ResourceType> resourceIndex;
    private final COBIEType cobie;

    public IndexedCOBie(COBIEType cobie)
    {
        this.cobie = cobie;
        floorSpaces = new FloorSpacesIndex(cobie.getSpaces().getSpaceArray());
        descriptiveElementIndex = new SheetNameAttributesDocumentsIssuesIndex(cobie);
        spaceZones = new SpaceZonesIndex(cobie.getZones().getZoneArray());
        typeComponents = new TypeComponentIndex(cobie.getComponents().getComponentArray());
        typeJobs = new TypeJobIndex(cobie.getJobs().getJobArray());
        typeSpares = new TypeSpareIndex(cobie.getSpares().getSpareArray());
        setComponentAssemblies(new ComponentAssemblyIndex(cobie.getAssemblies().getAssemblyArray()));
        setComponentSpaces(new ComponentSpaceIndex(cobie.getComponents().getComponentArray()));
        setComponentSystems(new ComponentSystemIndex(cobie.getSystems().getSystemArray()));
        setTypeAssemblies(new TypeAssemblyIndex(cobie.getAssemblies().getAssemblyArray()));
        initializeResourceIndex();
    }

    public COBIEType getCobie()
    {
        return cobie;
    }

    public ComponentAssemblyIndex getComponentAssemblies()
    {
        return componentAssemblies;
    }

    public ComponentSpaceIndex getComponentSpaces()
    {
        return componentSpaces;
    }

    public ComponentSystemIndex getComponentSystems()
    {
        return componentSystems;
    }

    public SheetNameAttributesDocumentsIssuesIndex getDescriptiveElementIndex()
    {
        return descriptiveElementIndex;
    }

    public FloorSpacesIndex getFloorSpaces()
    {
        return floorSpaces;
    }

    public HashMap<String, ResourceType> getResourceIndex()
    {
        return resourceIndex;
    }

    public SpaceZonesIndex getSpaceZones()
    {
        return spaceZones;
    }

    public TypeAssemblyIndex getTypeAssemblies()
    {
        return typeAssemblies;
    }

    public TypeComponentIndex getTypeComponents()
    {
        return typeComponents;
    }

    public TypeJobIndex getTypeJobs()
    {
        return typeJobs;
    }

    public TypeSpareIndex getTypeSpares()
    {
        return typeSpares;
    }

    private void initializeResourceIndex()
    {
        resourceIndex = new HashMap<String, ResourceType>();
        if (cobie.getResources() != null)
        {
            for (ResourceType resource : cobie.getResources().getResourceArray())
            {
                resourceIndex.put(resource.getName(), resource);
            }
        }
    }

    public void setComponentAssemblies(ComponentAssemblyIndex componentAssemblies)
    {
        this.componentAssemblies = componentAssemblies;
    }

    public void setComponentSpaces(ComponentSpaceIndex componentSpaces)
    {
        this.componentSpaces = componentSpaces;
    }

    public void setComponentSystems(ComponentSystemIndex componentSystems)
    {
        this.componentSystems = componentSystems;
    }

    public void setDescriptiveElementIndex(SheetNameAttributesDocumentsIssuesIndex descriptiveElementIndex)
    {
        this.descriptiveElementIndex = descriptiveElementIndex;
    }

    public void setFloorSpaces(FloorSpacesIndex floorSpaces)
    {
        this.floorSpaces = floorSpaces;
    }

    public void setResourceIndex(HashMap<String, ResourceType> resourceIndex)
    {
        this.resourceIndex = resourceIndex;
    }

    public void setSpaceZones(SpaceZonesIndex spaceZones)
    {
        this.spaceZones = spaceZones;
    }

    public void setTypeAssemblies(TypeAssemblyIndex typeAssemblies)
    {
        this.typeAssemblies = typeAssemblies;
    }

    public void setTypeJobs(TypeJobIndex typeJobs)
    {
        this.typeJobs = typeJobs;
    }

    public void setTypeSpares(TypeSpareIndex typeSpares)
    {
        this.typeSpares = typeSpares;
    }

}
