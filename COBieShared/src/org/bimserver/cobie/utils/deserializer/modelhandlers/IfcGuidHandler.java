package org.bimserver.cobie.utils.deserializer.modelhandlers;

import java.util.HashMap;


import org.bimserver.cobie.utils.deserializer.COBieIfcModel;
import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EObject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.cobie.GuidCompressor;


public class IfcGuidHandler
{
	private OidProvider CobieOidProvider;
	private COBieIfcModel model;
	private HashMap<String,Long> guidToOid;
	public IfcGuidHandler(COBieIfcModel ifcModel, OidProvider oidProvider)
	{
		this.CobieOidProvider = oidProvider;
		this.model = ifcModel;
		guidToOid = (HashMap<String, Long>) model.getGuidToOid();
	}

	public IfcGloballyUniqueId newGuid()
	{
		//model.indexGuids();
		IfcGloballyUniqueId guid = Ifc2x3tc1Factory.eINSTANCE
				.createIfcGloballyUniqueId();
		String wrappedValue = GuidCompressor.getNewIfcGloballyUniqueId();
		guid.setWrappedValue(wrappedValue);
		boolean exists = false;
		int count = 0;
		try
		{
		//	exists = model.contains(wrappedValue);
			exists = guidIsInModel(wrappedValue);
			while (exists || count > 10)
			{
				wrappedValue = GuidCompressor.getNewIfcGloballyUniqueId();
				//exists = model.contains(wrappedValue);
				exists = guidIsInModel(wrappedValue);
				count++;
			}
			guid.setWrappedValue(wrappedValue);
		} catch (Exception e)
		{

		}
		//Long tmpOid = model.add(guid, this.CobieOidProvider);
		//guidToOid.put(guid.getWrappedValue(),tmpOid);
		return guid;
	}
	
	public IfcGloballyUniqueId guidFromExternalIdentifier(
			String externalIdentifier)
	{
		IfcGloballyUniqueId guid;
	//	model.indexGuids();
		try
		{
			if (guidIsInModel(externalIdentifier))
			{
				IfcRoot rootObject = (IfcRoot) model.get(guidToOid.get(externalIdentifier));	
				guid = rootObject.getGlobalId();
			}
			else if (isValidGuid(externalIdentifier) )//!model.contains(externalIdentifier))
			{
				guid = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
				guid.setWrappedValue(externalIdentifier);
			//	Long tmpOid = model.add(guid, this.CobieOidProvider);
				//guidToOid.put(externalIdentifier, tmpOid);
			}
			else
				guid = newGuid();
		} catch (Exception e)
		{
			guid = newGuid();
		}

		return guid;
	}
	
	public IfcGloballyUniqueId guidFromExternalIdentifier(
			String externalIdentifier,boolean isAttribute)
	{
		IfcGloballyUniqueId guid;
		if (isAttribute)
		{
			try
			{
				if (guidIsInModel(externalIdentifier))
				{
					IdEObject candidatePropertySet =
							model.get(guidToOid.get(externalIdentifier));
					if (candidatePropertySet instanceof IfcPropertySet)
					{
		
						IfcPropertySet pSet = (IfcPropertySet) candidatePropertySet;
						guid = pSet.getGlobalId();
					}
					else
						guid = newGuid();
					
				}
				else if (isValidGuid(externalIdentifier) )//!model.contains(externalIdentifier))
				{
					guid = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
					guid.setWrappedValue(externalIdentifier);
					//Long tmpOid = model.add(guid, this.CobieOidProvider);
					//guidToOid.put(externalIdentifier, tmpOid);
				}
				else
					guid = newGuid();
			} catch (Exception e)
			{
				guid = newGuid();
			}
		}
		else
			guid = guidFromExternalIdentifier(externalIdentifier);
		return guid;
	}
	
	public static boolean isValidGuid(String guid)
	{
		return GuidCompressor.isValidGuid(guid);
	}
	
	public boolean guidInModelAndIsAttachedToPropertySet(String guid)
	{
		//model.indexGuids();
		//return model.contains(guid);
		
		boolean isInModel = guidIsInModel(guid);
		boolean isAttachedToPsetInModel = false;
		if (isInModel)
		{
			long guidOid = guidToOid.get(guid);
			IdEObject candidatePropertySet = model.get(guidOid);
				
			if (candidatePropertySet instanceof IfcPropertySet)
			{
				IfcPropertySet pSet = (IfcPropertySet) candidatePropertySet;
				/*long tmpOid = pSet.getOid();
				if (model.contains(tmpOid))
					isAttachedToPsetInModel = true;*/
				if (!isAttachedToPsetInModel)
					isAttachedToPsetInModel = (pSet.getPropertyDefinitionOf().size()>0 || pSet.getDefinesType().size()>0);
			}
						
		}
		
		return isInModel && isAttachedToPsetInModel;
	}
	
	public boolean guidIsInModel(String guid)
	{
		return guidToOid.containsKey(guid);
	}
	
	
	
	public IfcPropertySet getPropertySetFromGuid(String guid)
	{
		IfcPropertySet pSet = null;
		boolean isInModel = guidIsInModel(guid);
		if (isInModel)
		{
			long objOid = guidToOid.get(guid);
			IdEObject obj = model.get(objOid);

			if (obj instanceof IfcPropertySet)
			{
				pSet = (IfcPropertySet) obj;
			}				
		}
		
		return pSet;
	}
	
}
