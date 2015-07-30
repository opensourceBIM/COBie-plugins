package org.bimserver.cobie.shared.deserialization.cobietab;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bimserver.cobie.shared.SensorControllerConnection;
import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.shared.utility.COBieIfcUtility;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcControllerType;
import org.bimserver.models.ifc2x3tc1.IfcControllerTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcDistributionElement;
import org.bimserver.models.ifc2x3tc1.IfcDistributionPort;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcFlowDirectionEnum;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPort;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelConnects;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsElements;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3tc1.IfcSensorType;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ConnectionType;
import org.nibs.cobie.tab.DocumentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionDeserializer
{
    private static final String BAMIE_ERROR = "An error occured while deserializing a BAMie Connection...";
    private static final String TYPICAL_CONNECTION_ERROR = "An error occured while deserializing a connection...";
    private static final String BAMIE_DEFINES_BY_TYPE_RELATION_SUFFIX = " defines by type relationship";
    public static final String BAMIE_VIRTUAL_CONTROLLER_TYPE_RELATION_PREFIX = "BAMie:  Virtual Controller Type";
    public static final String VIRTUAL_CONTROLLER_TYPE_PREFIX = "BAMie:  Virtual Controller ";
    private static final String VIRTUAL_CONTROLLER_TYPE_MIDDLE_NAME = " for ";
    private static final String REL_AGGREGATES_CONTROLLERS_NAME_MIDDLE = ", and child controller, ";
    private static final String REL_AGGREGATES_CONTROLLER_NAME_PREFIX = "Aggregates relationships between parent controller, ";
    public static final String VIRTUAL_CONTROLLER_NAME_PREFIX = "BAMie:  Data point for sensor ";
    private static final String VIRTUAL_CONTROLLER_OBJECT_TYPE = "DATA";
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionDeserializer.class);

    public static boolean connectsControllerAndSensor(ConnectionType connection, COBieIfcModel model)
    {
        boolean connectsControllerToSensor = false;
        String sheetName = connection.getSheetName();
        String rowName1 = connection.getRowName1();
        String rowName2 = connection.getRowName2();
        if (isAComponentConnection(sheetName, rowName1, rowName2, model))
        {
            IfcProduct product1 = (IfcProduct)model.get(model.getComponentOid(rowName1));
            IfcProduct product2 = (IfcProduct)model.get(model.getComponentOid(rowName2));
            IfcSensorType sensorType = ComponentDeserializer.getSensorTypeInformationFromProduct(product1);
            if (sensorType == null)
            {
                sensorType = ComponentDeserializer.getSensorTypeInformationFromProduct(product2);
            }
            IfcControllerType controllerType = ComponentDeserializer.getControllerTypeInformationFromProduct(product1);
            if (controllerType == null)
            {
                ComponentDeserializer.getControllerTypeInformationFromProduct(product2);
            }

            if ((controllerType != null) && (sensorType != null))
            {
                connectsControllerToSensor = true;
            }
        }
        return connectsControllerToSensor;
    }

    public static boolean isAComponentConnection(String sheetName, String rowName1, String rowName2, COBieIfcModel cobieIfcModel)
    {
        return sheetName.equalsIgnoreCase(COBieUtility.CobieSheetName.Component.name()) && cobieIfcModel.containsComponent(rowName1)
                && cobieIfcModel.containsComponent(rowName2);
    }

    private static boolean portInElement(IfcElement element, IfcElement portElement)
    {
        return (element.getGlobalId() != null) && (portElement.getGlobalId() != null) && (element.getGlobalId().equals(portElement.getGlobalId()));
    }

    private static boolean portIsInEitherElement(IfcElement element1, IfcElement element2, IfcElement port1Element)
    {
        return portInElement(element1, port1Element) || portInElement(element2, port1Element);
    }

    public static IfcRelConnectsPorts relConnectsPortsBetweenTwoElements(IfcElement element1, IfcElement element2, COBieIfcModel cobieModel)
    {
        IfcRelConnectsPorts connectsPort = null;
        for (IfcRelConnectsPorts candidateRelation : cobieModel.getAllWithSubTypes(IfcRelConnectsPorts.class))
        {
            IfcPort port1 = candidateRelation.getRelatedPort();
            IfcPort port2 = candidateRelation.getRelatingPort();
            if (port1.isSetContainedIn() && port2.isSetContainedIn())
            {
                IfcElement port1Element = port1.getContainedIn().getRelatedElement();
                IfcElement port2Element = port2.getContainedIn().getRelatedElement();
                if ((port1Element != null) && (port2Element != null))
                {
                    boolean port1Match = portIsInEitherElement(element1, element2, port1Element);
                    boolean port2Match = portIsInEitherElement(element1, element2, port2Element);
                    if (port1Match && port2Match)
                    {
                        connectsPort = candidateRelation;
                    }
                }
            }

        }
        return connectsPort;
    }

    private COBieIfcModel model;

    private IfcCommonHandler ifcCommonHandler;

    private COBIEType.Connections connections;

    private List<ConnectionType> bamieConnections;

    public ConnectionDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcHandler, COBIEType.Connections cobieConnections)
    {
        model = cobieIfcModel;
        ifcCommonHandler = ifcHandler;
        connections = cobieConnections;
        bamieConnections = new ArrayList<ConnectionType>();
    }

    private void aggregateVirtualController(IfcProduct controller, IfcProduct childController, IfcOwnerHistory ownerHistory)
            throws IfcModelInterfaceException
    {
        IfcRelAggregates aggregatesRelationship = COBieIfcUtility.ifcFactory.createIfcRelAggregates();
        String name = getRelAggregatesControllersName(controller, childController);
        aggregatesRelationship.setName(name);
        aggregatesRelationship.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
        aggregatesRelationship.setRelatingObject(controller);
        aggregatesRelationship.getRelatedObjects().add(childController);
        aggregatesRelationship.setOwnerHistory(ownerHistory);
        model.add(aggregatesRelationship, ifcCommonHandler.getOidProvider());
    }

    private boolean connectsControllerAndSensor(ConnectionType connection)
    {
        return connectsControllerAndSensor(connection, model);
    }

    private IfcDistributionPort createDistributionPort(
            String portName,
            IfcDistributionElement product,
            String createdBy,
            Calendar createdOn,
            String extSystem) throws IfcModelInterfaceException
    {
        IfcDistributionPort distPort = Ifc2x3tc1Factory.eINSTANCE.createIfcDistributionPort();
        distPort.setName(portName);
        IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(createdBy, createdOn,
                extSystem);
        distPort.setOwnerHistory(ownerHistory);
        distPort.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
        long distPortOid = model.add(distPort, ifcCommonHandler.getOidProvider());
        IfcRelConnectsPortToElement connectsPortToElement = relConnectsPortFromPortAndElement(distPort, product, ownerHistory, distPortOid);
        distPort.setContainedIn(connectsPortToElement);
        return (IfcDistributionPort)model.get(distPortOid);
    }

    private IfcDistributionElement createVirtualController(SensorControllerConnection sensorControllerConnection) throws IfcModelInterfaceException
    {
        IfcDistributionElement virtualController = COBieIfcUtility.ifcFactory.createIfcDistributionElement();
        String controllerName = getVirtualControllerName(sensorControllerConnection);
        virtualController.setName(controllerName);
        virtualController.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
        virtualController.setOwnerHistory(sensorControllerConnection.getController().getOwnerHistory());
        IfcRelDefinesByType definesByType = getVirtualControllerTypeRelationship(sensorControllerConnection, virtualController, controllerName);
        virtualController.setObjectType(VIRTUAL_CONTROLLER_OBJECT_TYPE);
        virtualController.getIsDefinedBy().add(definesByType);
        return virtualController;
    }

    private void deserializeBAMieConnection(ConnectionType bamieConnection, DocumentType sensorDocument) throws IfcModelInterfaceException
    {
        List<IfcClassificationReference> classificationReferences = ifcCommonHandler.getClassificationHandler().classificationReferencesFromString(
                sensorDocument.getDirectory());

        IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                bamieConnection.getCreatedBy(), bamieConnection.getCreatedOn(), bamieConnection.getExtSystem());
        SensorControllerConnection sensorControllerConnection = new SensorControllerConnection(bamieConnection.schemaType(), bamieConnection, model);
        IfcProduct controller = sensorControllerConnection.getController();
        IfcDistributionElement virtualController = createVirtualController(sensorControllerConnection);
        virtualController.setName(sensorDocument.getName());
        model.add(virtualController, ifcCommonHandler.getOidProvider());
        for (IfcClassificationReference classificationReference : classificationReferences)
        {
            classificationReference.setReferencedSource(ifcCommonHandler.getClassificationHandler().getBamieClassification());
            ifcCommonHandler.getClassificationHandler().addClassificationReferenceToObject(classificationReference, virtualController);
        }
        aggregateVirtualController(controller, virtualController, ownerHistory);
    }

    public void deserializeBAMieConnections(List<DocumentType> bamieDocuments)
    {
        for (ConnectionType bamieConnection : bamieConnections)
        {
            if (connectsControllerAndSensor(bamieConnection))
            {
                try
                {
                    DocumentType sensorDocument = findMatchingSensorDocument(bamieDocuments, bamieConnection);
                    if (sensorDocument != null)
                    {
                        deserializeBAMieConnection(bamieConnection, sensorDocument);
                    }
                } catch (Exception ex)
                {
                    LOGGER.error(BAMIE_ERROR + ex.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
	public void deserializeConnections()
    {
        if (connections != null)
        {
            for (ConnectionType connection : connections.getConnectionArray())
            {
                if (isConnectionBAMie(connection))
                {
                    bamieConnections.add(connection);
                }

                try
                {
                    handleTypicalConnection(connection);
                } catch (Exception ex)
                {
                    LOGGER.error(TYPICAL_CONNECTION_ERROR + ex.getMessage());
                }

            }
        }
    }

    public DocumentType findMatchingSensorDocument(List<DocumentType> bamieDocuments, ConnectionType connection)
    {
        DocumentType document = null;
        String sheetName = connection.getSheetName();
        String rowName1 = connection.getRowName1();
        String rowName2 = connection.getRowName2();

        if (isAComponentConnection(sheetName, rowName1, rowName2))
        {
            IfcProduct component1 = (IfcProduct)model.get(model.getComponentOid(rowName1));
            IfcProduct component2 = (IfcProduct)model.get(model.getComponentOid(rowName2));
            String sensorRowName = "";
            if (ComponentDeserializer.isProductASensor(component1))
            {
                sensorRowName = rowName1;
            } else if (ComponentDeserializer.isProductASensor(component2))
            {
                sensorRowName = rowName2;
            }
            for (DocumentType candidateDocument : bamieDocuments)
            {
                if (candidateDocument.getSheetName().equalsIgnoreCase(COBieUtility.CobieSheetName.Component.name())
                        && candidateDocument.getRowName().equalsIgnoreCase(sensorRowName))
                {
                    document = candidateDocument;
                }
            }
        }
        return document;
    }

    private String getRelAggregatesControllersName(IfcProduct controller, IfcProduct childController)
    {
        return TypeDeserializer.BAMIE_TYPE_CATEGORY_PREFIX + REL_AGGREGATES_CONTROLLER_NAME_PREFIX + controller.getName()
                + REL_AGGREGATES_CONTROLLERS_NAME_MIDDLE + childController.getName();
    }

    private String getVirtualControllerName(SensorControllerConnection sensorControllerConnection)
    {
        String name = TypeDeserializer.BAMIE_TYPE_CATEGORY_PREFIX + VIRTUAL_CONTROLLER_NAME_PREFIX + sensorControllerConnection.getSensor().getName();
        return name;
    }

    private IfcControllerType getVirtualControllerType(IfcDistributionElement virtualController, SensorControllerConnection sensorControllerConnection)
            throws IfcModelInterfaceException
    {
        IfcControllerType controllerType = COBieIfcUtility.ifcFactory.createIfcControllerType();
        String name = VIRTUAL_CONTROLLER_TYPE_PREFIX + VIRTUAL_CONTROLLER_TYPE_MIDDLE_NAME + virtualController.getName();
        controllerType.setName(name);
        controllerType.setOwnerHistory(virtualController.getOwnerHistory());
        controllerType.setPredefinedType(IfcControllerTypeEnum.FLOATING);
        controllerType.setElementType(BAMIE_VIRTUAL_CONTROLLER_TYPE_RELATION_PREFIX);
        controllerType.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
        model.add(controllerType, ifcCommonHandler.getOidProvider());
        return controllerType;

    }

    private IfcRelDefinesByType getVirtualControllerTypeRelationship(
            SensorControllerConnection sensorControllerConnection,
            IfcDistributionElement virtualController,
            String controllerName) throws IfcModelInterfaceException
    {
        IfcControllerType controllerType = getVirtualControllerType(virtualController, sensorControllerConnection);
        IfcRelDefinesByType definesByType = COBieIfcUtility.ifcFactory.createIfcRelDefinesByType();
        String typeRelationshipName = VIRTUAL_CONTROLLER_NAME_PREFIX + " " + controllerName + BAMIE_DEFINES_BY_TYPE_RELATION_SUFFIX;
        definesByType.setName(typeRelationshipName);
        definesByType.setOwnerHistory(virtualController.getOwnerHistory());
        definesByType.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
        definesByType.setDescription(typeRelationshipName);
        definesByType.setRelatingType(controllerType);
        model.add(definesByType, ifcCommonHandler.getOidProvider());
        return definesByType;
    }

    private void handleConnectsComponents(ConnectionType connection, IfcRelConnects relConn) throws IfcModelInterfaceException
    {

        if (relConn instanceof IfcRelConnectsPorts)
        {
            handleRelConnectsPorts(connection, (IfcRelConnectsPorts)relConn);
        } else if (relConn instanceof IfcRelConnectsPortToElement)
        {
            handleRelConnectsPortToElement(connection, (IfcRelConnectsPortToElement)relConn);
        } else if (relConn instanceof IfcRelConnectsElements)
        {
            handleRelConnectsElements(connection, (IfcRelConnectsElements)relConn);
        }

    }

    private void handleRelConnectsElements(ConnectionType connection, IfcRelConnectsElements connectsElements) throws IfcModelInterfaceException
    {
        String compName1 = connection.getRowName1();
        String compName2 = connection.getRowName2();
        IfcElement component1 = (IfcElement)model.get(model.getComponentOid(compName1));
        IfcElement component2 = (IfcElement)model.get(model.getComponentOid(compName2));
        if (!component1.isSetObjectType())
        {
            component1.setObjectType(connection.getConnectionType());
        }
        if (!component2.isSetObjectType())
        {
            component2.setObjectType(connection.getConnectionType());
        }
        connectsElements.setRelatingElement(component1);
        connectsElements.setRelatedElement(component2);
        model.add(connectsElements, ifcCommonHandler.getOidProvider());

    }

    private void handleRelConnectsPorts(ConnectionType connection, IfcRelConnectsPorts connectsPorts) throws IfcModelInterfaceException
    {
        String compName1 = connection.getRowName1();
        String compName2 = connection.getRowName2();
        String portName1 = connection.getPortName1();
        String portName2 = connection.getPortName2();
        IfcDistributionElement distElement1 = (IfcDistributionElement)model.get(model.getComponentOid(compName1));
        IfcDistributionElement distElement2 = (IfcDistributionElement)model.get(model.getComponentOid(compName2));
        IfcDistributionPort distPort1 = createDistributionPort(portName1, distElement1, connection.getCreatedBy(), connection.getCreatedOn(),
                connection.getExtSystem());
        IfcDistributionPort distPort2 = createDistributionPort(portName2, distElement2, connection.getCreatedBy(), connection.getCreatedOn(),
                connection.getExtSystem());
        distPort1.setFlowDirection(IfcFlowDirectionEnum.SOURCE);
        distPort2.setFlowDirection(IfcFlowDirectionEnum.SINK);
        distPort1.setObjectType(connection.getConnectionType());
        distPort2.setObjectType(connection.getConnectionType());
        connectsPorts.setRelatingPort(distPort1);
        connectsPorts.setRelatedPort(distPort2);
        model.add(connectsPorts, ifcCommonHandler.getOidProvider());
        distPort1.getConnectedTo().add(connectsPorts);
        distPort2.getConnectedFrom().add(connectsPorts);
    }

    private void handleRelConnectsPortToElement(ConnectionType connection, IfcRelConnectsPortToElement connectsPortsToElement)
            throws IfcModelInterfaceException
    {
        String compName1 = connection.getRowName1();
        String compName2 = connection.getRowName2();
        String portName = "";
        IfcProduct component1 = (IfcProduct)model.get(model.getComponentOid(compName1));
        IfcProduct component2 = (IfcProduct)model.get(model.getComponentOid(compName2));
        IfcDistributionElement theDistributionElement = null;
        IfcElement theElement = null;
        if (component1 instanceof IfcDistributionElement)
        {
            theDistributionElement = (IfcDistributionElement)component1;
            portName = compName1;
        } else
        {
            theElement = (IfcElement)component1;
        }
        if (component2 instanceof IfcDistributionElement)
        {
            theDistributionElement = (IfcDistributionElement)component2;
            portName = compName2;
        } else
        {
            theElement = (IfcElement)component2;
        }
        IfcDistributionPort thePort = createDistributionPort(portName, theDistributionElement, connection.getCreatedBy(), connection.getCreatedOn(),
                connection.getExtSystem());
        thePort.setObjectType(connection.getConnectionType());
        if (!theElement.isSetObjectType())
        {
            theElement.setObjectType(connection.getConnectionType());
        }
        connectsPortsToElement.setRelatedElement(theElement);
        connectsPortsToElement.setRelatingPort(thePort);
        thePort.setContainedIn(connectsPortsToElement);
        model.add(connectsPortsToElement, ifcCommonHandler.getOidProvider());

    }

    private void handleTypicalConnection(ConnectionType connection) throws Exception
    {
        IfcRelConnects relConn = relConnectsPortsFromConnection(connection);
        CobieSheetName refSheet = COBieUtility.CobieSheetName.valueOf(connection.getSheetName());
        if (refSheet != null)
        {
            switch (refSheet)
            {
                case Component:
                {
                    handleConnectsComponents(connection, relConn);
                }
                default:
                {
                    // Do Nothing
                }
            }
        }
    }

    private boolean isAComponentConnection(String sheetName, String rowName1, String rowName2)
    {
        return isAComponentConnection(sheetName, rowName1, rowName2, model);
    }

    public boolean isConnectionBAMie(ConnectionType connection)
    {
        boolean connectionIsBAMie = false;
        String componentNameOne = connection.getRowName1();
        String componentNameTwo = connection.getRowName2();
        String sheetName = connection.getSheetName();
        if (isAComponentConnection(sheetName, componentNameOne, componentNameTwo))
        {
            IfcProduct componentOne = (IfcProduct)model.get(model.getComponentOid(componentNameOne));
            IfcProduct componentTwo = (IfcProduct)model.get(model.getComponentOid(componentNameTwo));
            if (ComponentDeserializer.isIfcProductBAMie(componentOne) || ComponentDeserializer.isIfcProductBAMie(componentTwo))
            {
                connectionIsBAMie = true;
            }
        }
        return connectionIsBAMie;
    }

    private IfcOwnerHistory ownerHistoryFromConnection(ConnectionType connection) throws IfcModelInterfaceException
    {
        IfcOwnerHistory ownerHistory = ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                connection.getCreatedBy(), connection.getCreatedOn(), connection.getExtSystem());
        return ownerHistory;
    }

    private IfcRelConnects relConnectsFromConnection(ConnectionType connection)
    {
        IfcRelConnects relConnects = null;
        if (isAComponentConnection(connection.getSheetName(), connection.getRowName1(), connection.getRowName2()))
        {
            IfcProduct row1Component = (IfcProduct)model.get(model.getComponentOid(connection.getRowName1()));
            IfcProduct row2Component = (IfcProduct)model.get(model.getComponentOid(connection.getRowName2()));
            if ((row1Component instanceof IfcDistributionElement) && (row2Component instanceof IfcDistributionElement))
            {
                relConnects = COBieIfcUtility.ifcFactory.createIfcRelConnectsPorts();
            } else if ((row1Component instanceof IfcDistributionElement) || (row2Component instanceof IfcDistributionElement))
            {
                relConnects = COBieIfcUtility.ifcFactory.createIfcRelConnectsPortToElement();

            } else
            {
                relConnects = COBieIfcUtility.ifcFactory.createIfcRelConnectsElements();
            }
        }
        relConnects.setName(connection.getName());
        relConnects.setDescription(connection.getDescription());
        try
        {
            relConnects.setOwnerHistory(ownerHistoryFromConnection(connection));
        } catch (IfcModelInterfaceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        relConnects.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(connection.getExtIdentifier()).getWrappedValue());
        return relConnects;
    }

    private IfcRelConnectsPortToElement relConnectsPortFromPortAndElement(IfcPort port, IfcElement product, IfcOwnerHistory ownerHistory, long portOid)
            throws IfcModelInterfaceException
    {
        IfcRelConnectsPortToElement portToComponent = Ifc2x3tc1Factory.eINSTANCE.createIfcRelConnectsPortToElement();
        String portToElementName = port.getName() + " PortToElement";
        portToComponent.setName(portToElementName);
        portToComponent.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid().getWrappedValue());
        portToComponent.setRelatedElement(product);
        portToComponent.setRelatingPort(port);
        portToComponent.setOwnerHistory(ownerHistory);
        model.add(portToComponent, ifcCommonHandler.getOidProvider());
        return portToComponent;
    }

    private IfcRelConnects relConnectsPortsFromConnection(ConnectionType connection)
    {
        IfcRelConnects relConnectsPorts = relConnectsFromConnection(connection);
        // relConnectsPorts.setName(connection.getName());
        // relConnectsPorts.setDescription(connection.getDescription());
        // relConnectsPorts.setOwnerHistory(ownerHistoryFromConnection(connection));
        // relConnectsPorts.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(connection.getExtIdentifier()));
        return relConnectsPorts;
    }

}
