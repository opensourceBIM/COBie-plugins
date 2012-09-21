package org.bimserver.cobie.utils.deserializer;

import org.bimserver.cobie.cobielite.COBIEType;
import org.eclipse.emf.ecore.EObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface COBieLiteToIfcConvertable.  
 *
 * @param <T> One of the COBIEType interfaces that represent COBie worksheets (e.g. COBIEType.Contacts, COBIEType.Components,...)
 * @param <K> The base Ifc type that will store data from each element in T
 */
public interface COBieLiteToIfcConvertable<T,K>
{
	
	/**
	 * Deserialize COBie to Ifc
	 */
	void deserialize();
	
	/**
	 * Initialize K from T
	 *
	 * @param single COBieLite element (e.g. ContactType, ComponentType, etc)
	 * @return Instantiated Ifc object 
	 */
	K initializeIfcFromCOBieLite(T cobieLiteElement) throws Exception;
	
	/**
	 * Instantiate IfcRelationship objects
	 */
	void instantiateRelationships (K ifcObject,T cobieLiteElement) throws Exception;
	
	/**
	 * Instantiate IfcClassificatoin objects
	 */
	void instantiateClassifications(K ifcObject,T cobieLiteElement) throws Exception;
	
	/**
	 * Instantiate IfcPropertySets and adds them to the model
	 */
	 void initializeAndAddPropertySetsToModel(K ifcObject,T cobieLiteElement,COBieIfcModel model) throws Exception;
	
	/**
	 * Relates Ifc entities and adds them to a model in t
	 */
	void relateObjectsAndAddToModel(K ifcObject,T cobieLiteElement,COBieIfcModel model) throws Exception;
	
	/**
	 * returns true if element exists in model, false otherwise
	 */
	boolean cobieLiteElementIsInModel(K cobieLiteElement,COBieIfcModel model);
}
