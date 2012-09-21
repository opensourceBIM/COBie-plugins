package org.bimserver.cobie.utils.serializer.sheetserializers;
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
import java.util.Calendar;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.cobielite.ConnectionType;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPort;
import org.bimserver.models.ifc2x3tc1.IfcRelConnects;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsElements;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPortToElement;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsPorts;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.COBieUtility.CobieSheetName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IfcToConnection 
{
	private static final CobieSheetName sheetName = CobieSheetName.Connection;
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcToConnection.class);
	public static void writeConnections(COBIEType cType, IfcModelInterface model)
	{
		LogHandler loggerHandler = new LogHandler(sheetName,LOGGER);
		loggerHandler.sheetWriteBegin();
		COBIEType.Connections connections;
		String name = "";
		String createdBy = "";
		Calendar createdOn;
		String connectionType = "";
		String sheetName = "";
		String realizingElement="";
		String rowName1 = "";
		String rowName2 = "";
		String portName1 = "";
		String portName2 = "";
		String extSystem = "";
		String extObject = "";
		String extIdentifier = "";
		String description = "";
		IfcOwnerHistory oh;
		ConnectionType tempConnection;
		try
		{
			connections = cType.getConnections();
			if (connections==null || connections.isNil())
				connections = cType.addNewConnections();
		}
		catch(Exception ex)
		{
			connections = cType.addNewConnections();
		}
		for(IfcRelConnects rel : model.getAllWithSubTypes(IfcRelConnects.class))
		{
			if (rel instanceof IfcRelConnectsPorts || 
					((rel instanceof IfcRelConnectsPortToElement)&& shouldIncludeConnectsPortToElement((IfcRelConnectsPortToElement)rel)))
			{
				try
				{			
					oh = rel.getOwnerHistory();
					name = COBieUtility.getCOBieString(rel.getName());
					createdBy = COBieUtility.getEmailFromOwnerHistory(oh);
					createdOn = IfcToContact.getCreatedOn(oh.getCreationDate());
					connectionType = IfcToConnection.connectionTypeFromRelConnects(rel);
					sheetName = IfcToConnection.sheetNameFromRelConnects(rel);
					rowName1 = IfcToConnection.rowName1FromRelConnects(rel);
					rowName2 = IfcToConnection.rowName2FromRelConnects(rel);
					realizingElement = IfcToConnection.realizingElementFromRelConnects(rel);
					portName1 = IfcToConnection.portName1FromRelConnects(rel);
					portName2 = IfcToConnection.portName2FromRelConnects(rel);
					extSystem = COBieUtility.getApplicationName(oh);
					extObject = COBieUtility.extObjectFromRelationship(rel);
					extIdentifier = COBieUtility.identifierFromRelationship(rel);
					description = IfcToConnection.descriptionFromRelConnects(rel);
					
					tempConnection = connections.addNewConnection();
					tempConnection.setName(name);
					tempConnection.setCreatedBy(createdBy);
					tempConnection.setCreatedOn(createdOn);
					tempConnection.setConnectionType(connectionType);
					tempConnection.setSheetName(sheetName);
					tempConnection.setRowName1(rowName1);
					tempConnection.setRowName2(rowName2);
					tempConnection.setRealizingElement(realizingElement);
					tempConnection.setPortName1(portName1);
					tempConnection.setPortName2(portName2);	
					tempConnection.setExtSystem(extSystem);
					tempConnection.setExtObject(extObject);
					tempConnection.setExtIdentifier(extIdentifier);
					tempConnection.setDescription(description);
					loggerHandler.rowWritten();	
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					loggerHandler.error(ex);
					
				}
				
			}
		}
		loggerHandler.sheetWritten();
	}
	private static boolean shouldIncludeConnectsPortToElement(
			IfcRelConnectsPortToElement rel)
	{
		String rowName1 = relatedElementNameFromConnectsPortToElement(rel);
		String rowName2 = getRelatingPortElementNameFromRelConnectsPortToElement(rel);
		return !(rowName1==null||rowName2==null ||rowName1.equals(rowName2));
	}
	//IfcRelConnectsElements or IfcRelConnectsPorts
	protected static String nameFromRelConnects(IfcRelConnects connects)
	{
		String name ="";
		name = connects.getName();
		if (name==null || name.length()==0)
			name = connects.getGlobalId().getWrappedValue();
		return COBieUtility.getCOBieString(name);
	}
	
	protected static String connectionTypeFromRelConnects(IfcRelConnects connects)
	{
		String connectionType = "";
		if(connects instanceof IfcRelConnectsPorts)
		{
			IfcRelConnectsPorts connectsPorts =
					(IfcRelConnectsPorts) connects;
			if(connectsPorts.getRelatingPort()!=null && connectsPorts.getRelatingPort().isSetObjectType())
				connectionType = connectsPorts.getRelatingPort().getObjectType();
			else if (connectsPorts.getRelatingPort()!=null && connectsPorts.getRelatingPort().isSetObjectType())
				connectionType = connectsPorts.getRelatedPort().getObjectType();
		}
		else if (connects instanceof IfcRelConnectsPortToElement)
		{
			IfcRelConnectsPortToElement portToElement =
					(IfcRelConnectsPortToElement) connects;
			if(portToElement.getRelatingPort()!=null && portToElement.getRelatingPort().isSetObjectType())
				connectionType = portToElement.getRelatingPort().getObjectType();
			else if(portToElement.getRelatedElement()!=null && portToElement.getRelatedElement().isSetObjectType())
				connectionType = portToElement.getRelatedElement().getObjectType();
		}
		else if (connects instanceof IfcRelConnectsElements)
		{
			IfcRelConnectsElements connectsElements =
					(IfcRelConnectsElements) connects;
			if(connectsElements.getRelatingElement()!=null && connectsElements.getRelatingElement().isSetObjectType())
				connectionType = connectsElements.getRelatingElement().getObjectType();
			else if (connectsElements.getRelatedElement()!=null && connectsElements.getRelatedElement().isSetObjectType())
				connectionType = connectsElements.getRelatedElement().getObjectType();
		}
		if(COBieUtility.isNA(connectionType))
		{
			connectionType = connects.getDescription();
			if(COBieUtility.isNA(connectionType))
				connectionType = connects.getName();
		}
		
		return COBieUtility.getCOBieString(connectionType);
	}
	
	protected static String sheetNameFromRelConnects(IfcRelConnects connects)
	{
		String sheetName="";
		String predefinedType = "";
		if (connects instanceof IfcRelConnectsElements)
		{
			IfcElement relatingElement =
					((IfcRelConnectsElements) connects).getRelatingElement();
			predefinedType = COBieUtility.valueOfAttribute(relatingElement, "PredefinedType");
			if (predefinedType != null && predefinedType.length()>0)
			{
				sheetName = COBieUtility.CobieSheetName.Type.toString();
			}
			else
				sheetName = COBieUtility.CobieSheetName.Component.toString();

		}
		else if (connects instanceof IfcRelConnectsPorts)
		{
			sheetName = COBieUtility.CobieSheetName.Component.toString();
		}
		else if (connects instanceof IfcRelConnectsPortToElement)
		{
			sheetName = COBieUtility.CobieSheetName.Component.toString();
		}
		return COBieUtility.getCOBieString(sheetName);
	}
	
	protected static String rowName1FromRelConnects(IfcRelConnects connects)
	{
		String rowName1 = "";
		if (connects instanceof IfcRelConnectsElements)
		{
			IfcRelConnectsElements relConnElem =
					(IfcRelConnectsElements) connects;
			rowName1 = relConnElem.getRelatingElement().getName();
		}
		else if (connects instanceof IfcRelConnectsPorts)
		{
			IfcRelConnectsPorts relConnPorts =
					(IfcRelConnectsPorts) connects;
			rowName1 = relatingElementNameFromRelConnectsPorts(relConnPorts);
			
		}
		else if (connects instanceof IfcRelConnectsPortToElement)
		{
			IfcRelConnectsPortToElement relConnPortToElement =
					(IfcRelConnectsPortToElement) connects;
			rowName1 = getRelatingPortElementNameFromRelConnectsPortToElement(relConnPortToElement);
		}
		return COBieUtility.getCOBieString(rowName1);
	}
	
	private static String getRelatingPortElementNameFromRelConnectsPortToElement(
			IfcRelConnectsPortToElement relConnPortToElement)
	{
		String portElementName = "";
		if(relConnPortToElement.getRelatingPort()!=null)
		{
			IfcPort relatingPort = relConnPortToElement.getRelatingPort();
			if(relatingPort.isSetContainedIn())
			{
				IfcRelConnectsPortToElement portToElement =
						relatingPort.getContainedIn();
				if(portToElement.getRelatedElement()!=null)
					portElementName = portToElement.getRelatedElement().getName();
			}
		}
		return COBieUtility.getCOBieString(portElementName);
	}
	protected static String rowName2FromRelConnects(IfcRelConnects connects)
	{
		String rowName2 ="";
		if (connects instanceof IfcRelConnectsElements)
		{
			IfcRelConnectsElements relConnElem =
					(IfcRelConnectsElements) connects;
			rowName2 = relConnElem.getRelatedElement().getName();
		}
		else if (connects instanceof IfcRelConnectsPorts)
		{
			IfcRelConnectsPorts relConnPorts =
					(IfcRelConnectsPorts) connects;
			rowName2 = relatedElementNameFromRelConnectsPorts(relConnPorts);
		}
		else if (connects instanceof IfcRelConnectsPortToElement)
		{
			IfcRelConnectsPortToElement connectsPortToElement =
					(IfcRelConnectsPortToElement) connects;
			rowName2 = relatedElementNameFromConnectsPortToElement(connectsPortToElement);
		}
		return COBieUtility.getCOBieString(rowName2);
	}
	
	private static String relatedElementNameFromConnectsPortToElement(
			IfcRelConnectsPortToElement connectsPortToElement)
	{
		String name = "";
		IfcElement relatedElement = connectsPortToElement.getRelatedElement();
		if(relatedElement!=null)
			name = relatedElement.getName();
		return name;
	}
	protected static String relatingElementNameFromRelConnectsPorts(IfcRelConnectsPorts relPorts)
	{
		String name = "";
		IfcPort relatingPort = relPorts.getRelatingPort();
		if(relatingPort!=null && relatingPort.getContainedIn() != null && relatingPort.getContainedIn().getRelatedElement() != null)
			name = relatingPort.getContainedIn().getRelatedElement().getName();
		return name;
	}
	
	protected static String relatedElementNameFromRelConnectsPorts(IfcRelConnectsPorts relPorts)
	{
		String name = "";
		IfcPort relatedPort = relPorts.getRelatedPort();
		if(relatedPort!=null && relatedPort.getContainedIn() != null && relatedPort.getContainedIn().getRelatedElement() != null)
			name = relatedPort.getContainedIn().getRelatedElement().getName();
		return name;
	}
	
	protected static String realizingElementFromRelConnects(IfcRelConnects connects)
	{
		String realizingElement = "";
		if (connects instanceof IfcRelConnectsPorts)
		{
			IfcRelConnectsPorts relConnPorts =
					(IfcRelConnectsPorts) connects;
			if (relConnPorts.getRealizingElement()!=null)
				realizingElement = relConnPorts.getRealizingElement().getName();
			else
				realizingElement = null;
		}
		return COBieUtility.getCOBieString(realizingElement);
	}
	
	protected static String portName1FromRelConnects(IfcRelConnects connects)
	{
		String portName1 = "";
		if (connects instanceof IfcRelConnectsPorts)
		{
			IfcRelConnectsPorts relConnPorts =
					(IfcRelConnectsPorts) connects;
			if (relConnPorts.getRelatingPort()!=null)
				portName1 = relConnPorts.getRelatingPort().getName();
			else portName1 = null;
		}
		return COBieUtility.getCOBieString(portName1);
	}
	
	protected static String portName2FromRelConnects(IfcRelConnects connects)
	{
		String portName2 = "";
		if (connects instanceof IfcRelConnectsPorts)
		{
			IfcRelConnectsPorts relConnPorts =
					(IfcRelConnectsPorts) connects;
			if (relConnPorts.getRelatedPort()!=null)
				portName2 = relConnPorts.getRelatedPort().getName();
			else portName2 = null;
		}
		return COBieUtility.getCOBieString(portName2);
	}
	
	protected static String descriptionFromRelConnects(IfcRelConnects connects)
	{
		String description = "";
		if(connects.isSetDescription())
			description = connects.getDescription();
		else
			description = connects.getName();
		return COBieUtility.getCOBieString(description);
	}
	
}
