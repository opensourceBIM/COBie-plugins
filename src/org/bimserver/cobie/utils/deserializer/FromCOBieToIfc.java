package org.bimserver.cobie.utils.deserializer;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.cobie.cobielite.COBIEType;
import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.cobie.plugins.COBieOidProviderImpl;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;


public class FromCOBieToIfc
{
	private static final Map<String, EClassifier> classes = initClasses();
	private COBieIfcModel model;
	private COBIEType COBie;
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
