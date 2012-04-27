package org.bimserver.cobie.utils.deserializer;

import java.util.HashMap;

import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.plugins.serializers.OidProvider;
import org.eclipse.emf.ecore.EObject;
import org.openifc.guidcompressor.GuidCompressor;

public class IfcGuidHandler
{
	private OidProvider CobieOidProvider;
	private COBieIfcModel model;
	private HashMap<String,Long> guidToOid;
	public IfcGuidHandler(COBieIfcModel ifcModel, OidProvider oidProvider)
	{
		this.CobieOidProvider = oidProvider;
		this.model = ifcModel;
		guidToOid = new HashMap<String,Long>();
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
		Long tmpOid = model.add(guid, this.CobieOidProvider);
		guidToOid.put(guid.getWrappedValue(),tmpOid);
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
				guid = (IfcGloballyUniqueId) model.get(guidToOid.get(externalIdentifier));
			else if (isValidGuid(externalIdentifier) )//!model.contains(externalIdentifier))
			{
				guid = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
				guid.setWrappedValue(externalIdentifier);
				Long tmpOid = model.add(guid, this.CobieOidProvider);
				guidToOid.put(externalIdentifier, tmpOid);
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
					if (model.get(guidToOid.get(externalIdentifier)) instanceof IfcPropertySet)
						guid = (IfcGloballyUniqueId) model.get(guidToOid.get(externalIdentifier));
					else
						guid = newGuid();
					
				}
				else if (isValidGuid(externalIdentifier) )//!model.contains(externalIdentifier))
				{
					guid = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
					guid.setWrappedValue(externalIdentifier);
					Long tmpOid = model.add(guid, this.CobieOidProvider);
					guidToOid.put(externalIdentifier, tmpOid);
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
		//TODO:  add the appropriate condition
		if (guid != null && guid.length() ==22)
			return true;
		else
			return false;
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
			IdEObject candidateGuid = model.get(guidOid);
			if (candidateGuid instanceof IfcGloballyUniqueId)
			{
				IfcGloballyUniqueId ifcGuid = (IfcGloballyUniqueId) candidateGuid;
				for (EObject obj : ifcGuid.eCrossReferences())
				{
					if (obj instanceof IfcPropertySet)
					{
						IfcPropertySet pSet = (IfcPropertySet) obj;
						/*long tmpOid = pSet.getOid();
						if (model.contains(tmpOid))
							isAttachedToPsetInModel = true;*/
						if (!isAttachedToPsetInModel)
						isAttachedToPsetInModel = (pSet.getPropertyDefinitionOf().size()>0);
					}
						
				}
			}
		}
		
		return isInModel && isAttachedToPsetInModel;
	}
	
	public boolean guidIsInModel(String guid)
	{
		return guidToOid.containsKey(guid);
	}
	
	public boolean guidIsInModelAndAttachedToObjectInModel(String guid)
	{
		boolean isInModel = guidIsInModel(guid);
		boolean isAttachedToObjectInModel = false;
		if (isInModel)
		{
			long guidOid = guidToOid.get(guid);
			IdEObject candidateGuid = model.get(guidOid);
			if (candidateGuid instanceof IfcGloballyUniqueId)
			{
				IfcGloballyUniqueId ifcGuid = (IfcGloballyUniqueId) candidateGuid;
				for (EObject obj : ifcGuid.eCrossReferences())
				{
						IfcPropertySet pSet = (IfcPropertySet) obj;
						long tmpOid = pSet.getOid();
						if (model.contains(tmpOid))
							isAttachedToObjectInModel = true;
						
				}
					
			}
		}
		
		return isInModel && isAttachedToObjectInModel;
	}
	
	public IfcPropertySet getPropertySetFromGuid(String guid)
	{
		IfcPropertySet pSet = null;
		boolean isInModel = guidIsInModel(guid);
		if (isInModel)
		{
			long guidOid = guidToOid.get(guid);
			IdEObject candidateGuid = model.get(guidOid);
			if (candidateGuid instanceof IfcGloballyUniqueId)
			{
				IfcGloballyUniqueId ifcGuid = (IfcGloballyUniqueId) candidateGuid;
				for (EObject obj : ifcGuid.eCrossReferences())
				{
					if (obj instanceof IfcPropertySet)
					{
						pSet = (IfcPropertySet) obj;
					}
						
				}
			}
		}
		
		return pSet;
	}
	
}
