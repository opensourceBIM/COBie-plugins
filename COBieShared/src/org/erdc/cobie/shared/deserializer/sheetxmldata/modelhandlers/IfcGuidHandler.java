package org.erdc.cobie.shared.deserializer.sheetxmldata.modelhandlers;

import java.util.HashMap;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.OidProvider;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.erdc.cobie.shared.GuidCompressor;
import org.erdc.cobie.shared.deserializer.sheetxmldata.COBieIfcModel;

public class IfcGuidHandler
{
    public static IfcGloballyUniqueId asGlobalId(String globalId)
    {
        IfcGloballyUniqueId guid;
        guid = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
        guid.setWrappedValue(globalId);
        return guid;
    }

    public static boolean isValidGuid(String guid)
    {
        return GuidCompressor.isValidGuid(guid);
    }

    private COBieIfcModel model;

    private HashMap<String, Long> guidToOid;

    public IfcGuidHandler(COBieIfcModel ifcModel, OidProvider<Long> oidProvider)
    {
        model = ifcModel;
        guidToOid = (HashMap<String, Long>)model.getGuidToOid();
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
                pSet = (IfcPropertySet)obj;
            }
        }

        return pSet;
    }

    public IfcGloballyUniqueId guidFromExternalIdentifier(String externalIdentifier)
    {
        IfcGloballyUniqueId guid;
        try
        {
            if (isValidGuid(externalIdentifier))
            {
                guid = asGlobalId(externalIdentifier);

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

    public IfcGloballyUniqueId guidFromExternalIdentifier(String externalIdentifier, boolean isAttribute)
    {
        IfcGloballyUniqueId guid;
        if (isAttribute)
        {
            try
            {
                if (guidIsInModel(externalIdentifier))
                {
                    IdEObject candidatePropertySet = model.get(guidToOid.get(externalIdentifier));
                    if (candidatePropertySet instanceof IfcPropertySet)
                    {

                        IfcPropertySet pSet = (IfcPropertySet)candidatePropertySet;
                        guid = IfcGuidHandler.asGlobalId(pSet.getGlobalId());
                    } else
                    {
                        guid = newGuid();
                    }

                } else if (isValidGuid(externalIdentifier))
                {
                    guid = asGlobalId(externalIdentifier);
                } else
                {
                    guid = newGuid();
                }
            } catch (Exception e)
            {
                guid = newGuid();
            }
        } else
        {
            guid = guidFromExternalIdentifier(externalIdentifier);
        }
        return guid;
    }

    public boolean guidInModelAndIsAttachedToPropertySet(String guid)
    {
        boolean isInModel = guidIsInModel(guid);
        boolean isAttachedToPsetInModel = false;
        if (isInModel)
        {
            long guidOid = guidToOid.get(guid);
            IdEObject candidatePropertySet = model.get(guidOid);

            if (candidatePropertySet instanceof IfcPropertySet)
            {
                IfcPropertySet pSet = (IfcPropertySet)candidatePropertySet;
                if (!isAttachedToPsetInModel)
                {
                    isAttachedToPsetInModel = ((pSet.getPropertyDefinitionOf().size() > 0) || (pSet.getDefinesType().size() > 0));
                }
            }

        }

        return isInModel && isAttachedToPsetInModel;
    }

    public boolean guidIsInModel(String guid)
    {
        return guidToOid.containsKey(guid);
    }

    public IfcGloballyUniqueId newGuid()
    {
        IfcGloballyUniqueId guid = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
        String wrappedValue = GuidCompressor.getNewIfcGloballyUniqueId();
        guid.setWrappedValue(wrappedValue);
        boolean exists = false;
        int count = 0;
        try
        {
            exists = guidIsInModel(wrappedValue);
            while (exists || (count > 10))
            {
                wrappedValue = GuidCompressor.getNewIfcGloballyUniqueId();
                exists = guidIsInModel(wrappedValue);
                count++;
            }
            guid.setWrappedValue(wrappedValue);
        } catch (Exception e)
        {

        }
        return guid;
    }

}
