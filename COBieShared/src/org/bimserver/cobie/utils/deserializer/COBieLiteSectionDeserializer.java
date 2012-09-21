package org.bimserver.cobie.utils.deserializer;

import org.bimserver.cobie.utils.deserializer.modelhandlers.IfcCommonHandler;
import org.bimserver.emf.IdEObject;

public abstract class COBieLiteSectionDeserializer<T,X,K extends IdEObject>
{
	protected IfcCommonHandler ifcCommonHandler;
	protected COBieIfcModel model;
	protected T cobieLiteSection;
	protected int deserializedElementCount;
	protected int deserializedElementErrorCount;
	protected Iterable<X> cobieLiteSectionIterable;
	
	public COBieLiteSectionDeserializer(IfcCommonHandler ifcCommonHandler, 
			COBieIfcModel model, T cobieLiteSection)
	{
		this.ifcCommonHandler = ifcCommonHandler;
		this.model = model;
		this.cobieLiteSection = cobieLiteSection;
		cobieLiteSectionIterable = cobieLiteSectionIterableFromCOBieLiteSection(cobieLiteSection);
	}
	
	protected abstract Iterable cobieLiteSectionIterableFromCOBieLiteSection(T cobieLiteSection);
	
	/**
	 * Initialize K from X
	 *
	 * @param single COBieLite element (e.g. ContactType, ComponentType, etc)
	 * @return Instantiated Ifc object 
	 */
	protected abstract K initializeIfcFromCOBieLite(X cobieElement) throws Exception;
	
	/**
	 * Deserialize COBie to Ifc
	 */
	protected void deserialize()
	{
		if (cobieLiteSectionIterable!=null)
		{
			for(X cobieLiteElement:cobieLiteSectionIterable)
			{
				if(!cobieLiteElementIsInModel(cobieLiteElement))
				try
				{
					K ifcObject = initializeIfcFromCOBieLite(cobieLiteElement);
					if (ifcObject!=null)
					{
						initializeAndAddPropertySetsToModel(ifcObject,cobieLiteElement);
						long newObjectOid = addObjectToModel(ifcObject,cobieLiteElement);
						initializeAndAddClassificationsToModel(ifcObject,cobieLiteElement);
						intializeAndAddRelationshipsToModel(ifcObject,cobieLiteElement);
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	

	protected abstract long addObjectToModel(K ifcObject,X cobieLiteElement);
	
	/**
	 * Instantiate IfcClassificatoin objects.
	 *
	 * @param ifcObject the ifc object
	 * @param cobieLiteElement the cobie lite element
	 * @throws Exception the exception
	 */
	protected abstract void initializeAndAddClassificationsToModel(K ifcObject,X cobieLiteElement) throws Exception;
	
	/**
	 * Instantiate IfcPropertySets and adds them to the model
	 */
	protected abstract void initializeAndAddPropertySetsToModel(K ifcObject,X cobieLiteElement) throws Exception;
	
	/**
	 * Relates Ifc entities and adds them to a model in t
	 */
	protected abstract void intializeAndAddRelationshipsToModel(K ifcObject,X cobieLiteElement) throws Exception;
	
	/**
	 * returns true if element exists in model, false otherwise
	 */
	protected abstract boolean cobieLiteElementIsInModel(X cobieLiteElement);
	
}
