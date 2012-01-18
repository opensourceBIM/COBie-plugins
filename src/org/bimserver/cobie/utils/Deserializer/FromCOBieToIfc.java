package org.bimserver.cobie.utils.Deserializer;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.plugins.COBieOidProviderImpl;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import cobieLite.COBIEType;

public class FromCOBieToIfc
{
	private static final Map<String, EClassifier> classes = initClasses();
	private static final Map<String, EClassifier> typeClasses = initTypeClasses();
	private COBieIfcModel model;
	private COBIEType COBie;
	private Map<String, ArrayList<String>> FloorNameToSpaceNames;
	private Map<String, ArrayList<String>> spaceNameToComponentNames;
	private Map<String, ArrayList<String>> typeNameToComponentNames;
	private Map<String, Long> FacilityNameToOid;
	private Map<String, Long> FloorNameToOid;
	private Map<String, Long> SpaceNameToOid;
	private Map<String, Long> TypeNameToOid;
	private Map<String, Long> componentNameToOid;
	private long FirstFacilityOid;
	protected COBieOidProviderImpl CobieOidProvider;
	private ContactDeserializer contactDeserializer;
	private FacilityDeserializer facilityDeserializer;
	private FloorDeserializer floorDeserializer;
	private SpaceDeserializer spaceDeserializer;
	private IfcCommonHandler ifcCommonHandler;
	private TypeDeserializer typeDeserializer;
	private ComponentDeserializer componentDeserializer;
   private AttributeDeserializer attributeDeserializer;
	public FromCOBieToIfc(COBIEType cobie)
	{
		init(cobie);
	}

	private void init(COBIEType cobie)
	{
		model = new COBieIfcModel();
		initializeSheetMaps();
		COBie = cobie;
		CobieOidProvider = new COBieOidProviderImpl(model);
		ifcCommonHandler = new IfcCommonHandler(model, CobieOidProvider);		
		contactDeserializer = new ContactDeserializer(cobie.getContacts(), model, ifcCommonHandler);
		facilityDeserializer = new FacilityDeserializer(model, ifcCommonHandler, cobie.getFacilities());
		floorDeserializer = new FloorDeserializer(model,cobie.getFloors(),ifcCommonHandler);
		spaceDeserializer = new SpaceDeserializer(model, ifcCommonHandler, cobie.getSpaces());
		typeDeserializer = new TypeDeserializer(model,ifcCommonHandler,cobie.getTypes());
		componentDeserializer = new ComponentDeserializer(model,ifcCommonHandler,cobie.getComponents());
		attributeDeserializer = new AttributeDeserializer(model,ifcCommonHandler,cobie.getAttributes());
	}
	

	private static Map<String, EClassifier> initClasses()
	{
		HashMap<String, EClassifier> classes = new HashMap<String, EClassifier>(
				Ifc2x3Package.eINSTANCE.getEClassifiers().size());
		for (EClassifier classifier : Ifc2x3Package.eINSTANCE.getEClassifiers())
		{
			classes.put(classifier.getName().toUpperCase(), classifier);
		}
		return classes;
	}

	private static Map<String, EClassifier> initTypeClasses()
	{
		HashMap<String, EClassifier> classes = new HashMap<String, EClassifier>(
				Ifc2x3Package.eINSTANCE.getEClassifiers().size());
		for (EClassifier classifier : Ifc2x3Package.eINSTANCE.getEClassifiers())
		{
			classes.put(classifier.getName().toUpperCase(), classifier);
		}
		return classes;
	}

	private void initializeSheetMaps()
	{
		FacilityNameToOid = new HashMap<String, Long>();
		FloorNameToOid = new HashMap<String, Long>();
		SpaceNameToOid = new HashMap<String, Long>();
		TypeNameToOid = new HashMap<String, Long>();
		FloorNameToSpaceNames = new HashMap<String, ArrayList<String>>();
		componentNameToOid = new HashMap<String, Long>();
		spaceNameToComponentNames = new HashMap<String, ArrayList<String>>();
		typeNameToComponentNames = new HashMap<String, ArrayList<String>>();
	}

	public IfcModelInterface getModel()
	{
		return model;
	}

	public COBIEType getCOBie()
	{
		return COBie;
	}

	public COBieIfcModel getModelFromCOBie()
	{
		contactDeserializer.deserializeContacts();
		facilityDeserializer.deserializeFacilities();
		floorDeserializer.deserializeFloors();
		spaceDeserializer.deserializeSpaces();
		typeDeserializer.deserializeTypes();
		componentDeserializer.deserializeComponents();
		attributeDeserializer.deserializeAttributes();
		return model;
	}

	protected static IdEObject newIdEObject(String name)
	{
		IdEObject object = null;
		EClass classifier = (EClass) classes.get(name.toUpperCase());
		if (classifier != null)
			object = (IdEObject) Ifc2x3Factory.eINSTANCE.create(classifier);
		return object;
	}
}
