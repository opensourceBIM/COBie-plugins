package org.bimserver.cobie.utils.Deserializer;

import org.bimserver.cobie.plugins.COBieIfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcPropertySet;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.plugins.serializers.OidProvider;
import org.openifc.guidcompressor.GuidCompressor;

public class IfcGuidHandler
{
	private OidProvider CobieOidProvider;
	private COBieIfcModel model;
	
	public IfcGuidHandler(COBieIfcModel ifcModel, OidProvider oidProvider)
	{
		this.CobieOidProvider = oidProvider;
		this.model = ifcModel;
	}

	public IfcGloballyUniqueId newGuid()
	{
		model.indexGuids();
		IfcGloballyUniqueId guid = Ifc2x3Factory.eINSTANCE
				.createIfcGloballyUniqueId();
		String wrappedValue = GuidCompressor.getNewIfcGloballyUniqueId();
		guid.setWrappedValue(wrappedValue);
		boolean exists = false;
		int count = 0;
		try
		{
			exists = model.contains(wrappedValue);
			while (exists || count > 10)
			{
				wrappedValue = GuidCompressor.getNewIfcGloballyUniqueId();
				exists = model.contains(wrappedValue);
				count++;
			}
			guid.setWrappedValue(wrappedValue);
		} catch (Exception e)
		{

		}
		model.add(guid, this.CobieOidProvider);
		return guid;
	}
	
	public IfcGloballyUniqueId guidFromExternalIdentifier(
			String externalIdentifier)
	{
		IfcGloballyUniqueId guid = Ifc2x3Factory.eINSTANCE
				.createIfcGloballyUniqueId();
		model.indexGuids();
		try
		{
			if (externalIdentifier.length() == 22
					&& !model.contains(externalIdentifier))
			{
				guid.setWrappedValue(externalIdentifier);
				model.add(guid, this.CobieOidProvider);
			} else
			{
				guid = newGuid();
			}
		} catch (Exception e)
		{
			guid = newGuid();
		}

		return guid;
	}
	
	public static boolean isValidGuid(String guid)
	{
		if (guid != null && guid.length() > 0)
			return true;
		else
			return false;
	}
	
	public boolean guidInModelAndIsPropertySet(String guid)
	{
		boolean isInModelAndIsPropertySet = false;
		if (model.contains(guid))
		{
			IfcRoot rootObj = model.get(guid);
			if (rootObj instanceof IfcPropertySet)
				isInModelAndIsPropertySet = true;
		}
		return isInModelAndIsPropertySet;
	}
	
	
}
