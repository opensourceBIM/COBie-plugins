package org.bimserver.cobie.utils.StringWriters;
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
public class DeserializerStaticStrings 
{
	private static final String FloorHeightPropertyName = "Storey Height";
	private static final String FloorHeightPropertyDescription = "Floor Height";
	private static final String DefaultRelCobieDefinesByProperties ="Associated COBie attributes";
	private static final String ApplicationName = "BIMServer COBie Deserializer";
	private static final String ProjectRelAggregatesName = "Project Container";
	private static final String ProjectRelAggregatesDescription = "Project Contains Sites";
	private static final String SiteRelAggregatesName = "Site Container";
	private static final String SiteRelAggregatesDescription = "Site Contains Building";
	private static final String BuildingRelAggregatesName = "Building Container";
	private static final String BuildingRelAggregatesDescription = "Building Contains Storeys";
	private static final String StoreyRelAggregatesName = "Storey Container";
	private static final String StoreyRelAggregatesDescription = "Storey Contains Spaces";
	private static final String ComponentRelDefinesByTypeName = "Component Type Relation";
	private static final String ComponentRelDefinesByTypeDescription = "Component is defined by type";
	private static final String COBieOrgName = "BIMServer.org";
	private static final String COBieOrgDescription = "BIMServer.org";
	private static final String COBieOrgId = "tbd organization";
	private static final String DefaultPersonName = "BIMServer.org";
	private static final String DefaultEmail = "contact@bimserver.org";
	private static final String DefaultWWW = "http://bimserver.org";
	private static final String DefaultOrgPostalBox = "PO Box 49";
	private static final String DefaultOrgCountry = "The Netherlands";
	private static final String DefaultPostalCode = "2600 AA";
	private static final String DefaultState = "Delft";
	private static final String DefaultPhone = "+31 88 866 31 06";
	public static String getProjectRelAggregatesName() {
		return ProjectRelAggregatesName;
	}
	public static String getProjectRelAggregatesDescription() {
		return ProjectRelAggregatesDescription;
	}
	public static String getSiteRelAggregatesName() {
		return SiteRelAggregatesName;
	}
	public static String getSiteRelAggregatesDescription() {
		return SiteRelAggregatesDescription;
	}
	public static String getBuildingRelAggregatesName() {
		return BuildingRelAggregatesName;
	}
	public static String getBuildingRelAggregatesDescription() {
		return BuildingRelAggregatesDescription;
	}
	public static String getStoreyRelAggregatesName() {
		return StoreyRelAggregatesName;
	}
	public static String getStoreyRelAggregatesDescription() {
		return StoreyRelAggregatesDescription;
	}
	public static String getDefaultApplicationName() {
		return ApplicationName;
	}
	public static String getCOBieOrgName() {
		return COBieOrgName;
	}
	public static String getCOBieOrgDescription() {
		return COBieOrgDescription;
	}
	public static String getCOBieOrgId() {
		return COBieOrgId;
	}
	public static String getDefaultPersonName() {
		return DefaultPersonName;
	}
	public static String getDefaultEmail() {
		return DefaultEmail;
	}
	public static String getDefaultWWW() {
		return DefaultWWW;
	}
	public static String getDefaultOrgPostalBox() {
		return DefaultOrgPostalBox;
	}
	public static String getDefaultOrgCountry() {
		return DefaultOrgCountry;
	}
	public static String getDefaultPostalCode() {
		return DefaultPostalCode;
	}
	public static String getDefaultState() {
		return DefaultState;
	}
	public static String getDefaultPhone() {
		return DefaultPhone;
	}
	public static String getDefaultRelCOBieDefinesByPropertiesName() {
		return DefaultRelCobieDefinesByProperties;
	}
	public static String getFloorHeightPropertyName() {
		return FloorHeightPropertyName;
	}
	public static String getFloorHeightPropertyDescription() {
		return FloorHeightPropertyDescription;
	}
	public static String getComponentRelDefinesByTypeName()
	{
		return ComponentRelDefinesByTypeName;
	}
	public static String getComponentRelDefinesByTypeDescription()
	{
		return ComponentRelDefinesByTypeDescription;
	}
}
