package org.bimserver.cobie.shared.deserialization.cobietab;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.cobie.shared.cobietab.key.KeyedAttributeType;
import org.bimserver.cobie.shared.cobietab.key.KeyedCoordinateType;
import org.bimserver.cobie.shared.cobietab.key.KeyedDocumentType;
import org.bimserver.cobie.shared.cobietab.key.KeyedJobType;
import org.bimserver.cobie.shared.deserialization.DeserializerStaticStrings;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.ClassificationHandler;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.shared.serialization.util.IfcToFacility;
import org.bimserver.cobie.shared.serialization.util.IfcToFloor;
import org.bimserver.cobie.shared.serialization.util.IfcToSpace;
import org.bimserver.cobie.shared.serialization.util.IfcToType;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.OidProvider;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcConstructionEquipmentResource;
import org.bimserver.models.ifc2x3tc1.IfcConstructionProductResource;
import org.bimserver.models.ifc2x3tc1.IfcDocumentInformation;
import org.bimserver.models.ifc2x3tc1.IfcElementCompositionEnum;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcSystem;
import org.bimserver.models.ifc2x3tc1.IfcTask;
import org.bimserver.models.ifc2x3tc1.IfcTypeObject;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.IfcZone;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.CoordinateType;
import org.nibs.cobie.tab.DocumentType;
import org.nibs.cobie.tab.JobType;
import org.nibs.cobie.tab.SystemType;

public class COBieIfcModel extends IfcModel
{

    private static final IfcElementCompositionEnum DEFAULT_ELEMENT_COMPOSITION_TYPE = IfcElementCompositionEnum.ELEMENT;
    private static final String IFC_DOOR_ENTITY_NAME = "IfcDoor";
    private static final String IFC_WINDOW_ENTITY_NAME = "IfcWindow";
    private static final String SINGLE_QUOTE_REPLACEMENT = "''";

    private static ArrayList<String> getAllowMultipeSpaceComponentTypes()
    {
        ArrayList<String> allowList = new ArrayList<String>();
        allowList.add(IFC_WINDOW_ENTITY_NAME);
        allowList.add(IFC_DOOR_ENTITY_NAME);
        return allowList;
    }

    public static String toSafeIfcString(String ifcString)
    {
        String safeIfcString = "";
        safeIfcString = ifcString.replace("'", SINGLE_QUOTE_REPLACEMENT);
        return safeIfcString;
    }

    private Map<String, Long> applicationNameToOid;
    private Map<KeyedAttributeType, Long> attributeToOid;

    private IfcBuilding building;

    private ArrayList<String> componentNamesAssignedToASpace;

    private ArrayList<String> componentNamesNotInSpaces;

    private Map<String, Long> componentNameToOid;

    private Map<KeyedCoordinateType, Long> coordinateToOid;

    private Map<String, Long> EmailToIfcOwnerHistoryOid;
    private Map<String, Long> EmailToPersonAndOrganizationOid;

    private Map<String, Long> enumerationNameToOid;

    private Map<String, Long> FacilityNameToOid;

    private Long firstFacilityOid;

    private Map<String, Long> FloorNameToOid;
    private Map<String, ArrayList<String>> FloorNameToSpaceNames;
    private Map<String, Long> guidToOid;

    private Map<KeyedJobType, Long> jobToOid;
    private Map<String, Long> jobNameToOid;
    private Map<String, Long> resourceNameToOid;
    private Map<String, ArrayList<String>> spaceNameToComponentNames;
    private Map<String, Long> SpaceNameToOid;
    private Map<String, Long> spareNameToOid;
    private Map<String, Long> systemNameCategoryToOid;
    private Map<String, Long> systemNameToOid;
    private Map<String, ArrayList<String>> typeNameToComponentNames;

    private Map<String, Long> TypeNameToOid;

    private Map<String, Long> zoneNameCategoryToOid;
    private HashMap<String, Long> assemblyNameToOid;
    private Map<String, Long> documentKeyToOid;

    public COBieIfcModel()
    {
    	super();
        initializeHashMaps();
    }

    public COBieIfcModel(int size)
    {
        super(size);
        initializeHashMaps();
    }

    public long add(IdEObject eObject, OidProvider<Long> oidProvider) throws IfcModelInterfaceException
    {
        long oid;

        cleanupStringsForIfc(eObject);

        if (eObject instanceof IfcValue)
        {
            oid = -1;

        }

        else
        {
            oid = oidProvider.newOid(null);

            if (!this.contains(eObject))
            {
                this.add(oid, eObject);
                added(eObject, oid);
            }

        }

        return oid;
    }

    public long addComponent(IfcProduct product, ComponentType component, IfcCommonHandler ifcCommonHandler) throws IfcModelInterfaceException
    {
        long oid = ifcCommonHandler.getOidProvider().newOid(null);

        this.add(oid, product);

        componentAdded(product, oid, component, ifcCommonHandler);
        return oid;
    }
    
    public long addDocument(IfcDocumentInformation documentInformation, DocumentType document, IfcCommonHandler ifcCommonHandler) throws IfcModelInterfaceException
    {
        long oid = ifcCommonHandler.getOidProvider().newOid(null);
        
        this.add(oid, documentInformation);
        
        documentAdded(document, oid);
        return oid;
    }

    // up to TWO coordinates per productDefinitionShape
    public long addCoordinates(List<CoordinateType> coordinates, IfcProductDefinitionShape productDefinitionShape, OidProvider<Long> oidProvider)
            throws IfcModelInterfaceException
    {
        long oid = oidProvider.newOid(null);

        this.add(oid, productDefinitionShape);
        coordinateAdded(productDefinitionShape, oid, coordinates);

        return oid;
    }

    private void added(IdEObject eObject, Long oid)
    {
        if (eObject instanceof IfcRoot)
        {
            ifcRootAdded((IfcRoot)eObject, oid);
        }
        if (eObject instanceof IfcSpatialStructureElement)
        {
            spatialStructureElementAdded((IfcSpatialStructureElement)eObject, oid);
        }
        if (eObject instanceof IfcApplication)
        {
            applicationAdded((IfcApplication)eObject, oid);
        }
        if (eObject instanceof IfcPersonAndOrganization)
        {
            contactAdded((IfcPersonAndOrganization)eObject, oid);
        } else if (eObject instanceof IfcOwnerHistory)
        {
            createdByAdded((IfcOwnerHistory)eObject, oid);
        } else if (eObject instanceof IfcBuilding)
        {
            facilityAdded((IfcBuilding)eObject, oid);
        } else if (eObject instanceof IfcBuildingStorey)
        {
            floorAdded((IfcBuildingStorey)eObject, oid);
        } else if (eObject instanceof IfcSpace)
        {
            spaceAdded((IfcSpace)eObject, oid);
        } else if (eObject instanceof IfcRelAggregates)
        {
            relAggregatesAdded((IfcRelAggregates)eObject);
        } else if (eObject instanceof IfcTypeObject)
        {
            typeAdded((IfcTypeObject)eObject, oid);
        } else if (eObject instanceof IfcZone)
        {
            zoneAdded((IfcZone)eObject, oid);
        } else if (eObject instanceof IfcPropertyEnumeration)
        {
            enumerationAdded((IfcPropertyEnumeration)eObject, oid);
        } else if (eObject instanceof IfcConstructionProductResource)
        {
            constructionProductResourceAdded((IfcConstructionProductResource)eObject, oid);
        } else if (eObject instanceof IfcConstructionEquipmentResource)
        {
            constructionEquipmentResourceAdded((IfcConstructionEquipmentResource)eObject, oid);
        }
    }

    public long addJob(IfcTask task, JobType job, IfcCommonHandler ifcCommonHandler) throws IfcModelInterfaceException
    {
        long oid = ifcCommonHandler.getOidProvider().newOid(null);

        this.add(oid, task);

        jobAdded(task, oid, new KeyedJobType(job));
        return oid;
    }

    public long addSystem(IfcSystem system, SystemType cobieSystem, IfcCommonHandler ifcCommonHandler) throws IfcModelInterfaceException
    {
        long oid = ifcCommonHandler.getOidProvider().newOid(null);

        this.add(oid, system);

        systemAdded(system, oid, cobieSystem);
        return oid;
    }

    private void applicationAdded(IfcApplication eObject, Long oid)
    {
        applicationNameToOid.put(eObject.getApplicationFullName(), oid);

    }

    private void assignComponentToSpace(ComponentType component)
    {

        String componentName = component.getName();
        String spaceName = component.getSpace();
        boolean compAllowsMultipleSpaces = multipleSpacesAllowed(component);
        handleAssignComponentToSpace(componentName, spaceName, compAllowsMultipleSpaces);

    }

    private void assignComponentToType(ComponentType component)
    {
        ArrayList<String> typeComponents = new ArrayList<String>();
        String componentName = component.getName();
        String typeName = component.getTypeName();
        if (!COBieUtility.isNA(typeName) && TypeNameToOid.containsKey(typeName))
        {
            if (typeNameToComponentNames.containsKey(typeName))
            {
                typeComponents = typeNameToComponentNames.get(typeName);
            }
            if (!typeComponents.contains(componentName))
            {
                typeComponents.add(componentName);
                typeNameToComponentNames.put(typeName, typeComponents);
            }
        }
    }

    private void assignSpaceToFloor(IfcSpace space, IfcBuildingStorey floor)
    {
        ArrayList<String> floorSpaces = new ArrayList<String>();
        String spaceName = IfcToSpace.nameFromSpace(space);
        String floorName = IfcToFloor.nameFromBuildingStorey(floor);
        if ((floorName != null) && (floorName.length() > 0) && containsFloor(floorName))
        {
            if (FloorNameToSpaceNames.containsKey(floorName))
            {
                floorSpaces = FloorNameToSpaceNames.get(floorName);
            }
            floorSpaces.add(spaceName);
            FloorNameToSpaceNames.put(floorName, floorSpaces);
        }
    }

    private void cleanupStringsForIfc(IdEObject eObject)
    {
        /*
         * for(EStructuralFeature
         * feature:eObject.eClass().getEStructuralFeatures()) { Class<?>
         * instanceClass = feature.getEType().getInstanceClass();
         * if(instanceClass==String.class); { try { EStructuralFeature
         * wrappedValueFeature =
         * feature.eClass().getEStructuralFeature(WRAPPED_VALUE);
         * 
         * if(wrappedValueFeature!=null) { String stringVal = (String)
         * eObject.eGet(wrappedValueFeature); String ifcString =
         * String.valueOf(stringVal); ifcString = toSafeIfcString(ifcString);
         * eObject.eSet(feature, ifcString); }
         * 
         * } catch(Exception ex) { ex.printStackTrace(); }
         * 
         * } }
         */
    }

    private void componentAdded(IfcProduct product, Long oid, ComponentType component, IfcCommonHandler ifcCommonHandler)
    {
        if (!containsComponent(product.getName()))
        {
            componentNameToOid.put(product.getName(), oid);
            assignComponentToSpace(component);
            assignComponentToType(component);
        }
    }

    private void constructionEquipmentResourceAdded(IfcConstructionEquipmentResource eObject, Long oid)
    {
        String resourceName = eObject.getName();
        if (!containsResource(resourceName))
        {
            resourceNameToOid.put(resourceName, oid);
        }

    }

    private void constructionProductResourceAdded(IfcConstructionProductResource eObject, Long oid)
    {
        String spareName = eObject.getName();
        if (!containsSpare(spareName))
        {
            spareNameToOid.put(spareName, oid);
        }
    }

    private void contactAdded(IfcPersonAndOrganization personOrg, Long oid)
    {
        String email = COBieIfcUtility.getEmailFromPersonAndOrganization(personOrg);
        if (!containsContact(email))
        {
            EmailToPersonAndOrganizationOid.put(email, oid);
        }
    }

    public boolean containsApplication(String applicationName)
    {
        return applicationNameToOid.containsKey(applicationName);
    }

    public boolean containsComponent(String componentName)
    {
        return componentNameToOid.containsKey(componentName);
    }

    public boolean containsContact(String email)
    {
        return EmailToPersonAndOrganizationOid.containsKey(email);
    }

    public boolean containsCoordinate(CoordinateType coordinate)
    {
        boolean containsCoord = false;
        containsCoord = coordinateToOid.containsKey(new KeyedCoordinateType(coordinate));
        return containsCoord;
    }

    public boolean containsCreatedBy(String email)
    {
        return EmailToIfcOwnerHistoryOid.containsKey(email);
    }

    public boolean containsEnumeration(String enumName)
    {
        return enumerationNameToOid.containsKey(enumName);
    }

    public boolean containsFacility(String facilityName)
    {
        return FacilityNameToOid.containsKey(facilityName);
    }

    public boolean containsFloor(String floorName)
    {
        return FloorNameToOid.containsKey(floorName);
    }

    public boolean containsJob(JobType job)
    {
        return jobToOid.containsKey(new KeyedJobType(job));
    }

    public boolean containsResource(String resourceName)
    {
        return resourceNameToOid.containsKey(resourceName);
    }

    public boolean containsSpace(String spaceName)
    {
        return SpaceNameToOid.containsKey(spaceName);
    }

    public boolean containsSpare(String spareName)
    {
        return spareNameToOid.containsKey(spareName);
    }

    public boolean containsSystem(String systemKey)
    {
        return systemNameCategoryToOid.containsKey(systemKey);
    }

    public boolean containsTask(String taskName)
    {
        return jobToOid.containsKey(taskName);
    }

    public boolean containsType(String typeName)
    {
        return TypeNameToOid.containsKey(typeName);
    }

    public boolean containsZone(String zoneName)
    {
        return (zoneNameCategoryToOid.containsKey(zoneName));
    }

    private void coordinateAdded(IfcProductDefinitionShape productDefinitionShape, long oid, List<CoordinateType> coordinates)
    {
        for (CoordinateType coordinate : coordinates)
        {
            coordinateToOid.put(new KeyedCoordinateType(coordinate), oid);
        }

    }

    private void createdByAdded(IfcOwnerHistory ownerHistory, Long oid)
    {
        String email = COBieIfcUtility.getEmailFromOwnerHistory(ownerHistory);
        contactAdded(ownerHistory.getOwningUser(), oid);
        if (!containsCreatedBy(email))
        {
            EmailToIfcOwnerHistoryOid.put(email, oid);
        }
    }

    private void enumerationAdded(IfcPropertyEnumeration enumeration, Long oid)
    {
        String enumName = enumeration.getName();
        if (enumName != null)
        {
            if (!enumerationNameToOid.containsKey(enumName))
            {
                enumerationNameToOid.put(enumName, oid);
            }
        }
    }

    private void facilityAdded(IfcBuilding facility, Long oid)
    {
        String name = IfcToFacility.nameFromBuildign(facility);
        if (getFacilityCount() == 0)
        {
            firstFacilityOid = oid;
        }
        if (!FacilityNameToOid.containsKey(name))
        {
            FacilityNameToOid.put(name, oid);
        }

    }

    private void floorAdded(IfcBuildingStorey floor, Long oid)
    {
        String floorName = floor.getName();
        if (!FloorNameToOid.containsKey(floorName))
        {
            FloorNameToOid.put(floorName, oid);
        }
    }

    private void floorAggregateAdded(IfcRelAggregates relAggregates)
    {
        IfcBuildingStorey buildingStorey = (IfcBuildingStorey)relAggregates.getRelatingObject();
        for (IfcObjectDefinition obj : relAggregates.getRelatedObjects())
        {
            if (obj instanceof IfcSpace)
            {
                IfcSpace tmpSpace = (IfcSpace)obj;
                assignSpaceToFloor(tmpSpace, buildingStorey);
            }
        }
    }

    public void forceAllObjectsAsDelegateLoaded()
    {
        for (IdEObject value : getValues())
        {
            ((IdEObjectImpl)value).setLoaded();
        }
    }

    public long getApplicationOid(String applicationName)
    {
        return applicationNameToOid.get(applicationName);
    }

    public HashMap<String, Long> getAssemblyNameToOid()
    {
        return assemblyNameToOid;
    }

    public Long getAssemblyOidByName(String assemblyName)
    {
        long oid = -1;
        if (assemblyNameToOid.containsKey(assemblyName))
        {
            oid = assemblyNameToOid.get(assemblyName);
        }
        return oid;
    }

    public Map<KeyedAttributeType, Long> getAttributeToOid()
    {
        return attributeToOid;
    }

    public IfcBuilding getBuilding()
    {
        return building;
    }

    public Long getComponentOid(String componentName)
    {
        if (componentNameToOid.containsKey(componentName))
        {
            return componentNameToOid.get(componentName);
        } else
        {
            return null;
        }
    }

    public IfcPersonAndOrganization getContact(String email)
    {
        if (containsContact(email))
        {
            return (IfcPersonAndOrganization)get(EmailToPersonAndOrganizationOid.get(email));
        } else
        {
            return null;
        }
    }

    public Long getContactOid(String email)
    {
        if (EmailToPersonAndOrganizationOid.containsKey(email))
        {
            return EmailToPersonAndOrganizationOid.get(email);
        } else
        {
            return null;
        }
    }

    public Map<KeyedCoordinateType, Long> getCoordinateToOid()
    {
        return coordinateToOid;
    }

    public Map<String, Long> getEmailToIfcOwnerHistoryOid()
    {
        return EmailToIfcOwnerHistoryOid;
    }

    public Map<String, Long> getEnumerationNameToOid()
    {
        return enumerationNameToOid;
    }

    public long getEnumerationOid(String enumName)
    {
        if (containsEnumeration(enumName))
        {
            return enumerationNameToOid.get(enumName);
        } else
        {
            return -1;
        }
    }

    public IfcApplication getExtSystem(String applicationName)
    {
        if (applicationNameToOid.containsKey(applicationName))
        {
            return (IfcApplication)get(applicationNameToOid.get(applicationName));
        } else
        {
            return null;
        }
    }

    public int getFacilityCount()
    {
        return FacilityNameToOid.size();
    }

    public Map<String, Long> getFacilityNameToOid()
    {
        return FacilityNameToOid;
    }

    public Long getFacilityOid(String facilityName)
    {
        if (FacilityNameToOid.containsKey(facilityName))
        {
            return FacilityNameToOid.get(facilityName);
        } else
        {
            return null;
        }
    }

    public IfcBuilding getFirstFacility()
    {
        return (IfcBuilding)get(getFirstFacilityOid());
    }

    public Long getFirstFacilityOid()
    {
        return firstFacilityOid;
    }

    public Long getFirstMatchingJobNameOid(String jobName)
    {
        long oid = -1;
        if (jobNameToOid.containsKey(jobName))
        {
            oid = jobNameToOid.get(jobName);
        }
        return oid;
    }

    public Long getFirstMatchingSystemOidByName(String name)
    {
        long oid = -1;
        if (systemNameToOid.containsKey(name))
        {
            oid = systemNameToOid.get(name);
        }
        return oid;
    }

    public IfcBuildingStorey getFloorByName(String floorName)
    {
        if (containsFloor(floorName))
        {
            return (IfcBuildingStorey)get(FloorNameToOid.get(floorName));
        } else
        {
            return null;
        }
    }

    public int getFloorCount()
    {
        return FloorNameToOid.size();
    }

    public ArrayList<String> getFloorNames()
    {
        ArrayList<String> floorNames = new ArrayList<String>();
        for (String key : FloorNameToOid.keySet())
        {
            floorNames.add(key);
        }
        return floorNames;
    }

    public Long getFloorOid(String floorName)
    {
        if (FloorNameToOid.containsKey(floorName))
        {
            return FloorNameToOid.get(floorName);
        } else
        {
            return null;
        }
    }

    public ArrayList<String> getFloorSpaceNames(String floorName)
    {
        if (FloorNameToSpaceNames.containsKey(floorName))
        {
            return FloorNameToSpaceNames.get(floorName);
        } else
        {
            return null;
        }
    }

    public Map<String, Long> getGuidToOid()
    {
        return guidToOid;
    }

    public Map<KeyedJobType, Long> getJobKeyToOid()
    {
        return jobToOid;
    }

    public Map<String, Long> getJobNameToOid()
    {
        return jobNameToOid;
    }

    public Long getJobOid(JobType job)
    {
        KeyedJobType keyedJob = new KeyedJobType(job);
        if (jobToOid.containsKey(keyedJob))
        {
            return jobToOid.get(keyedJob);
        } else
        {
            return null;
        }
    }

    public IfcOwnerHistory getOwnerHistory(String email)
    {
        if (containsCreatedBy(email))
        {
            return (IfcOwnerHistory)get(EmailToIfcOwnerHistoryOid.get(email));
        } else
        {
            return null;
        }
    }

    public Long getResourceOid(String resourceName)
    {
        if (containsResource(resourceName))
        {
            return resourceNameToOid.get(resourceName);
        } else
        {
            return null;
        }
    }

    public IfcSpace getSpaceFromName(String spaceName)
    {
        return (IfcSpace)get(SpaceNameToOid.get(spaceName));
    }

    public Long getSpaceOid(String spaceName)
    {
        return SpaceNameToOid.get(spaceName);
    }

    public Map<String, Long> getSpareNameToOid()
    {
        return spareNameToOid;
    }

    public Map<String, Long> getSystemNameToOid()
    {
        return systemNameToOid;
    }

    public Long getTypeOid(String typeName)
    {
        if (TypeNameToOid.containsKey(typeName))
        {
            return TypeNameToOid.get(typeName);
        } else
        {
            return null;
        }
    }

    public long getZoneOid(String zoneName)
    {
        return (zoneNameCategoryToOid.get(zoneName));
    }

    private void handleAssignComponentToSpace(String componentName, String spaceName, boolean compAllowsMultipleSpaces)
    {
        if (!COBieUtility.isNA(spaceName))
        {
            ArrayList<String> spaceComponents = new ArrayList<String>();
            if (SpaceNameToOid.containsKey(spaceName))
            {
                if (spaceNameToComponentNames.containsKey(spaceName))
                {
                    spaceComponents = spaceNameToComponentNames.get(spaceName);
                } else
                {
                    spaceComponents = new ArrayList<String>();
                }
                if (!spaceComponents.contains(componentName))
                {
                    spaceComponents.add(componentName);
                    spaceNameToComponentNames.put(spaceName, spaceComponents);
                    if (!componentNamesAssignedToASpace.contains(componentName))
                    {
                        componentNamesAssignedToASpace.add(componentName);
                    }
                    if (componentNamesNotInSpaces.contains(componentName))
                    {
                        componentNamesNotInSpaces.remove(componentName);
                    }
                }
            } else if (compAllowsMultipleSpaces && spaceName.contains(COBieUtility.getCOBieDelim()))
            {
                ArrayList<String> spaceNames = COBieUtility.arrayListFromDelimString(spaceName);
                for (String tmpSpaceName : spaceNames)
                {
                    handleAssignComponentToSpace(componentName, tmpSpaceName, false);
                }
            }

            else
            {
                if (!componentNamesAssignedToASpace.contains(componentName))
                {
                    componentNamesNotInSpaces.add(componentName);
                }
            }

        } else
        {
            if (!componentNamesAssignedToASpace.contains(componentName))
            {
                componentNamesNotInSpaces.add(componentName);
            }
        }
    }

    private void ifcRootAdded(IfcRoot eObject, Long oid)
    {
        String guidString = eObject.getGlobalId();

        if (!guidToOid.containsKey(guidString))
        {
            guidToOid.put(guidString, oid);
        }

    }

    private void initializeHashMaps()
    {
        setEmailToIfcOwnerHistoryOid(new HashMap<String, Long>());
        setEmailToPersonAndOrganizationOid(new HashMap<String, Long>());
        setEnumerationNameToOid(new HashMap<String, Long>());
        setUnitNameToOid(new HashMap<String, Long>());
        setFacilityNameToOid(new HashMap<String, Long>());
        setFloorNameToOid(new HashMap<String, Long>());
        setSpaceNameToOid(new HashMap<String, Long>());
        setTypeNameToOid(new HashMap<String, Long>());
        setFloorNameToSpaceNames(new HashMap<String, ArrayList<String>>());
        setComponentNameToOid(new HashMap<String, Long>());
        setSpaceNameToComponentNames(new HashMap<String, ArrayList<String>>());
        setTypeNameToComponentNames(new HashMap<String, ArrayList<String>>());
        setZoneNameToOid(new HashMap<String, Long>());
        setSystemNameCategoryToOid(new HashMap<String, Long>());
        componentNamesNotInSpaces = new ArrayList<String>();
        componentNamesAssignedToASpace = new ArrayList<String>();
        setGuidToOid(new HashMap<String, Long>());
        setResourceNameToOid(new HashMap<String, Long>());
        setSpareNameToOid(new HashMap<String, Long>());
        setJobKeyToOid(new HashMap<KeyedJobType, Long>());
        setCoordinateToOid(new HashMap<KeyedCoordinateType, Long>());
        setApplicationNameToOid(new HashMap<String, Long>());
        setAttributeToOid(new HashMap<KeyedAttributeType, Long>());
        setSystemNameToOid(new HashMap<String, Long>());
        setJobNameToOid(new HashMap<String, Long>());
        documentKeyToOid = new HashMap<String, Long>();

    }

    private void jobAdded(IfcTask task, long oid, KeyedJobType job)
    {
        if (!jobToOid.containsKey(job))
        {
            jobToOid.put(job, oid);
        }
        if (!jobNameToOid.containsKey(job.getCOBieSheetXMLDataElement().getName()))
        {
            jobNameToOid.put(job.getCOBieSheetXMLDataElement().getName(), oid);
        }

    }

    private boolean multipleSpacesAllowed(ComponentType component)
    {
        boolean multipleSpacesAllowed = false;
        if (COBieIfcModel.getAllowMultipeSpaceComponentTypes().contains(component.getExtObject()))
        {
            multipleSpacesAllowed = true;
        }
        return multipleSpacesAllowed;
    }

    private void relAggregatesAdded(IfcRelAggregates relAggregates)
    {
        if (relAggregates.getRelatingObject() instanceof IfcBuildingStorey)
        {
            floorAggregateAdded(relAggregates);
        }
    }

    private void setApplicationNameToOid(Map<String, Long> applicationNameToOid)
    {
        this.applicationNameToOid = applicationNameToOid;
    }

    public void setAssemblyNameToOid(HashMap<String, Long> assemblyNameToOid)
    {
        this.assemblyNameToOid = assemblyNameToOid;
    }

    public void setAttributeToOid(Map<KeyedAttributeType, Long> attributeToOid)
    {
        this.attributeToOid = attributeToOid;
    }

    private void setComponentNameToOid(Map<String, Long> componentNameToOid)
    {
        this.componentNameToOid = componentNameToOid;
    }

    public void setComponentTypeRelations(IfcCommonHandler ifcCommonHandler) throws IfcModelInterfaceException
    {
        ArrayList<String> ComponentNames;
        long TypeOid, ComponentOid, RelOid;
        for (String TypeName : typeNameToComponentNames.keySet())
        {
            TypeOid = TypeNameToOid.get(TypeName);
            IfcTypeObject typeObject = (IfcTypeObject)get(TypeOid);
            ComponentNames = typeNameToComponentNames.get(TypeName);
            IfcRelDefinesByType defByType = Ifc2x3tc1Factory.eINSTANCE.createIfcRelDefinesByType();
            defByType.setName(DeserializerStaticStrings.getComponentRelDefinesByTypeName());
            defByType.setDescription(DeserializerStaticStrings.getComponentRelDefinesByTypeDescription());
            defByType.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
            defByType.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
            defByType.setRelatingType(typeObject);
            String category = IfcToType.categoryFromTypeObject(typeObject);
            String objectType = ClassificationHandler.objectTypeFromCategoryString(category);
            if (ComponentNames != null)
            {
                for (String ComponentName : ComponentNames)
                {
                    ComponentOid = componentNameToOid.get(COBieUtility.getCOBieString(ComponentName));
                    IfcProduct component = (IfcProduct)get(ComponentOid);
                    defByType.getRelatedObjects().add(component);

                }
                RelOid = this.add(defByType, ifcCommonHandler.getOidProvider());
                for (String ComponentName : ComponentNames)
                {
                    ComponentOid = componentNameToOid.get(COBieUtility.getCOBieString(ComponentName));
                    IfcProduct component = (IfcProduct)get(ComponentOid);
                    component.getIsDefinedBy().add((IfcRelDefinesByType)get(RelOid));
                    if (!COBieUtility.isNA(objectType))
                    {
                        component.setObjectType(objectType);
                    }
                }
            }

        }

    }

    private void setCoordinateToOid(Map<KeyedCoordinateType, Long> coordinateToOid)
    {
        this.coordinateToOid = coordinateToOid;
    }

    private void setEmailToIfcOwnerHistoryOid(Map<String, Long> emailToIfcOwnerHistoryOid)
    {
        EmailToIfcOwnerHistoryOid = emailToIfcOwnerHistoryOid;
    }

    private void setEmailToPersonAndOrganizationOid(Map<String, Long> emailToPersonAndOrganizationOid)
    {
        EmailToPersonAndOrganizationOid = emailToPersonAndOrganizationOid;
    }

    private void setEnumerationNameToOid(Map<String, Long> enumerationNameToOid)
    {
        this.enumerationNameToOid = enumerationNameToOid;
    }

    public void setFacilityComponentAggregates(IfcCommonHandler ifcCommonHandler) throws IfcModelInterfaceException
    {
        if ((componentNamesNotInSpaces != null) && (componentNamesNotInSpaces.size() > 0))
        {
            long ComponentOid;
            long FacilityOid = firstFacilityOid;

            IfcBuilding facility = (IfcBuilding)get(FacilityOid);
            IfcRelContainedInSpatialStructure aggregatesFacility = Ifc2x3tc1Factory.eINSTANCE.createIfcRelContainedInSpatialStructure();
            // IfcRelAggregates aggregatesSpace =
            // Ifc2x3tc1Factory.eINSTANCE.createIfcRelAggregates();
            aggregatesFacility.setName("Component in facility");
            aggregatesFacility.setDescription("Component in facility");
            aggregatesFacility.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
            aggregatesFacility.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
            aggregatesFacility.setRelatingStructure(facility);
            // aggregatesSpace.setRelatingObject(Space);

            for (String ComponentName : componentNamesNotInSpaces)
            {
                ComponentOid = componentNameToOid.get(ComponentName);
                IfcProduct component = (IfcProduct)get(ComponentOid);
                // aggregatesSpace.getRelatedObjects().add(component);
                aggregatesFacility.getRelatedElements().add(component);
            }

            this.add(aggregatesFacility, ifcCommonHandler.getOidProvider());
        }

    }

    private void setFacilityNameToOid(Map<String, Long> facilityNameToOid)
    {
        FacilityNameToOid = facilityNameToOid;
    }

    private void setFloorNameToOid(Map<String, Long> floorNameToOid)
    {
        FloorNameToOid = floorNameToOid;
    }

    private void setFloorNameToSpaceNames(Map<String, ArrayList<String>> floorNameToSpaceNames)
    {
        FloorNameToSpaceNames = floorNameToSpaceNames;
    }

    public void setGuidToOid(Map<String, Long> guidToOid)
    {
        this.guidToOid = guidToOid;
    }

    public void setJobKeyToOid(Map<KeyedJobType, Long> jobNameToOid)
    {
        jobToOid = jobNameToOid;
    }

    public void setJobNameToOid(Map<String, Long> jobNameToOid)
    {
        this.jobNameToOid = jobNameToOid;
    }

    public void setResourceNameToOid(Map<String, Long> resourceNameToOid)
    {
        this.resourceNameToOid = resourceNameToOid;
    }

    public void setSpaceAggregates(IfcCommonHandler ifcCommonHandler) throws IfcModelInterfaceException
    {
        ArrayList<String> ComponentNames;
        long SpaceOid, ComponentOid;
        for (String SpaceName : spaceNameToComponentNames.keySet())
        {
            if (SpaceNameToOid.containsKey(SpaceName))
            {
                SpaceOid = SpaceNameToOid.get(SpaceName);
                IfcSpace Space = (IfcSpace)get(SpaceOid);
                ComponentNames = spaceNameToComponentNames.get(SpaceName);
                if ((ComponentNames != null) && (ComponentNames.size() > 0))
                {
                    IfcRelContainedInSpatialStructure aggregatesSpace = Ifc2x3tc1Factory.eINSTANCE.createIfcRelContainedInSpatialStructure();
                    // IfcRelAggregates aggregatesSpace =
                    // Ifc2x3tc1Factory.eINSTANCE.createIfcRelAggregates();
                    aggregatesSpace.setName(DeserializerStaticStrings.getStoreyRelAggregatesName() + " for components");
                    aggregatesSpace.setDescription(DeserializerStaticStrings.getStoreyRelAggregatesDescription());
                    aggregatesSpace.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().DefaultOwnerHistory());
                    aggregatesSpace.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
                    aggregatesSpace.setRelatingStructure(Space);
                    // aggregatesSpace.setRelatingObject(Space);

                    for (String ComponentName : ComponentNames)
                    {
                        ComponentOid = componentNameToOid.get(COBieUtility.getCOBieString(ComponentName));
                        IfcProduct component = (IfcProduct)get(ComponentOid);
                        // aggregatesSpace.getRelatedObjects().add(component);
                        aggregatesSpace.getRelatedElements().add(component);
                    }

                    this.add(aggregatesSpace, ifcCommonHandler.getOidProvider());
                }

            }
        }
    }

    private void setSpaceNameToComponentNames(Map<String, ArrayList<String>> spaceNameToComponentNames)
    {
        this.spaceNameToComponentNames = spaceNameToComponentNames;
    }

    private void setSpaceNameToOid(Map<String, Long> spaceNameToOid)
    {
        SpaceNameToOid = spaceNameToOid;
    }

    public void setSpareNameToOid(Map<String, Long> spareNameToOid)
    {
        this.spareNameToOid = spareNameToOid;
    }

    private void setSystemNameCategoryToOid(Map<String, Long> systemNameCategoryToOid)
    {
        this.systemNameCategoryToOid = systemNameCategoryToOid;
    }

    public void setSystemNameToOid(Map<String, Long> systemNameToOid)
    {
        this.systemNameToOid = systemNameToOid;
    }

    private void setTypeNameToComponentNames(Map<String, ArrayList<String>> typeNameToComponentNames)
    {
        this.typeNameToComponentNames = typeNameToComponentNames;
    }

    private void setTypeNameToOid(Map<String, Long> typeNameToOid)
    {
        TypeNameToOid = typeNameToOid;
    }

    private void setUnitNameToOid(Map<String, Long> unitNameToOid)
    {
    }

    public void setZoneNameToOid(Map<String, Long> zoneNameMap)
    {
        zoneNameCategoryToOid = zoneNameMap;
    }

    private void spaceAdded(IfcSpace space, Long oid)
    {
        String spaceName = space.getName();
        if (!SpaceNameToOid.containsKey(spaceName))
        {
            SpaceNameToOid.put(spaceName, oid);
        }
    }

    private void spatialStructureElementAdded(IfcSpatialStructureElement spatialStructureElement, long oid)
    {
        spatialStructureElement.setCompositionType(DEFAULT_ELEMENT_COMPOSITION_TYPE);
    }

    private void systemAdded(IfcSystem eObject, Long oid, SystemType cobieSystem)
    {
        String systemKey = SystemDeserializer.systemKeyFromSystem(cobieSystem);
        if (!systemNameCategoryToOid.containsKey(systemKey))
        {
            systemNameCategoryToOid.put(systemKey, oid);
        }
        if (!systemNameToOid.containsKey(cobieSystem.getName()))
        {
            systemNameToOid.put(cobieSystem.getName(), oid);
        }

    }

    private void typeAdded(IfcTypeObject type, Long oid)
    {
        String typeName = type.getName();
        if (!TypeNameToOid.containsKey(typeName))
        {
            TypeNameToOid.put(typeName, oid);
        }
    }

    private void zoneAdded(IfcZone zone, Long oid)
    {
        String zoneKey = ZoneDeserializer.getZoneKeyFromZone(zone);
        if (!zoneNameCategoryToOid.containsKey(zoneKey))
        {
            zoneNameCategoryToOid.put(zoneKey, oid);
        }
    }
    
    private void documentAdded(DocumentType document, Long oid)
    {
        String documentKey = new KeyedDocumentType(document).getCOBieSheetXMLDataElementKey();
        if(!documentKeyToOid.containsKey(documentKey))
        {
            documentKeyToOid.put(documentKey, oid);
        }
    }

    public boolean containsDocument(DocumentType document)
    {
        return documentKeyToOid.containsKey(new KeyedDocumentType(document).getCOBieSheetXMLDataElementKey());
    }

}
