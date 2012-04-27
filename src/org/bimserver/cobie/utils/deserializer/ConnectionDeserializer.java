package org.bimserver.cobie.utils.deserializer;


import java.util.Calendar;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ConnectionType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.cobie.utils.COBieUtility.CobieSheetName;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcDistributionElement;
import org.bimserver.models.ifc2x3tc1.IfcDistributionPort;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPort;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts;

public class ConnectionDeserializer 
{
	private COBieIfcModel model;
	private IfcCommonHandler ifcCommonHandler;
	private COBIEType.Connections connections;

	public ConnectionDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcHandler, COBIEType.Connections cobieConnections)
	{
		this.model = cobieIfcModel;
		this.ifcCommonHandler = ifcHandler;
		this.connections = cobieConnections;
	}
	
	public void deserializeConnections()
	{
		if (connections !=null)
		{
			for(ConnectionType connection : connections.getConnectionArray())
			{
				
				try
				{
					IfcRelConnectsPorts relConn = relConnectsPortsFromConnection(connection);
					CobieSheetName refSheet = COBieUtility.CobieSheetName.valueOf(connection.getSheetName());
					if (refSheet!=null)
					{
						switch(refSheet)
						{
							case Component:
							{
								handleConnectsComponents(connection,relConn);
							}
							default:
							{
								//Do Nothing
							}
						}
					}
				}
				catch(Exception e)
				{
					
				}
			}
		}
	}
	
	private void handleConnectsComponents(ConnectionType connection,IfcRelConnectsPorts relConn) throws Exception
	{
		String compName1 = connection.getRowName1();
		String compName2 = connection.getRowName2();
		String portName1 = connection.getPortName1();
		String portName2 = connection.getPortName2();
		try
		{
			IfcDistributionElement distElement1 = (IfcDistributionElement) model.get(model.getComponentOid(compName1));
			IfcDistributionElement distElement2 = (IfcDistributionElement) model.get(model.getComponentOid(compName2));
			IfcDistributionPort distPort1 = distributionPortByName(portName1,distElement1,connection.getCreatedBy(),connection.getCreatedOn());
			IfcDistributionPort distPort2 = distributionPortByName(portName2,distElement2,connection.getCreatedBy(),connection.getCreatedOn());
			relConn.setRelatingPort(distPort1);
			relConn.setRelatedPort(distPort2);
			model.add(relConn,ifcCommonHandler.getOidProvider());
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	private  IfcRelConnectsPorts relConnectsPortsFromConnection(ConnectionType connection)
	{
		IfcRelConnectsPorts relConnectsPorts = Ifc2x3tc1Factory.eINSTANCE.createIfcRelConnectsPorts();
		relConnectsPorts.setName(connection.getName());
		relConnectsPorts.setDescription(connection.getDescription());
		relConnectsPorts.setOwnerHistory(ownerHistoryFromConnection(connection));
		relConnectsPorts.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(connection.getExtIdentifier()));
		return relConnectsPorts;
	}
	
	private IfcOwnerHistory ownerHistoryFromConnection(ConnectionType connection)
	{
		IfcOwnerHistory ownerHistory = this
				.ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(connection.getCreatedBy(), connection.getCreatedOn());
		return ownerHistory;
	}
	
	private IfcDistributionPort distributionPortByName(String name,IfcDistributionElement product,String createdBy,Calendar createdOn)
	{
		IfcDistributionPort distPort = Ifc2x3tc1Factory.eINSTANCE.createIfcDistributionPort();
		distPort.setName(name);
		distPort.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailAndTimestamp(createdBy, createdOn));
		distPort.setGlobalId(this.ifcCommonHandler.getGuidHandler().newGuid());
		long distPortOid = model.add(distPort,this.ifcCommonHandler.getOidProvider());
		model.add(relConnectsPortFromPortAndElement((IfcDistributionPort) model.get(distPortOid),product),ifcCommonHandler.getOidProvider());
		return (IfcDistributionPort) model.get(distPortOid);
	}
	
	private IfcRelConnectsPortToElement relConnectsPortFromPortAndElement(IfcPort port, IfcDistributionElement product)
	{
		IfcRelConnectsPortToElement portToComponent = Ifc2x3tc1Factory.eINSTANCE.createIfcRelConnectsPortToElement();
		String portToElementName = port.getName() + " PortToElement";
		portToComponent.setName(portToElementName);
		portToComponent.setGlobalId(ifcCommonHandler.getGuidHandler().newGuid());
		portToComponent.setRelatedElement(product);
		portToComponent.setRelatingPort(port);
		return portToComponent;
	}
	
	
	
}
