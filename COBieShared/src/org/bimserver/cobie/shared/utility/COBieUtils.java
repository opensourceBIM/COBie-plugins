package org.bimserver.cobie.shared.utility;

import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.nibs.cobie.tab.COBIEBaseType;
import org.nibs.cobie.tab.ComponentType;
import org.nibs.cobie.tab.FloorType;
import org.nibs.cobie.tab.SpaceType;
import org.nibs.cobie.tab.ZoneType;

public class COBieUtils
{
    // TODO There might be a better way to do this some day. As of now, this
    // method only supports SpaceTypes, FloorTypes, and ZoneTypes.
    public static IfcProduct getMatchingProduct(List<? extends IfcProduct> products, COBIEBaseType type)
    {
        IfcProduct matchingProduct = null;

        for (IfcProduct product : products)
        {
            if (matches(product, type))
            {
                matchingProduct = product;
            }
        }

        return matchingProduct;
    }

    public static IfcProduct getProduct(IfcModelInterface model, COBIEBaseType type, Class<? extends IfcProduct> ifcClass)
    {
        List<? extends IfcProduct> ifcProducts = model.getAllWithSubTypes(ifcClass);
        return COBieUtils.getMatchingProduct(ifcProducts, type);
    }

    /**
     * Tests whether the supplied IfcProduct matches the supplied COBIEBaseType.
     * As of now, this method only works for FloorType, SpaceType,
     * ComponentType, and ZoneTypes.
     * 
     * @param product
     *            The IfcProduct to compare.
     * @param type
     *            The COBIEBaseType to compare.
     * @return true if the supplied values match.
     */
    static boolean matches(IfcProduct product, COBIEBaseType type)
    {
        boolean matches = false;

        String globalId = "";
        String extId = "";

        if (type instanceof SpaceType)
        {
            globalId = product.getGlobalId();
            extId = ((SpaceType)type).getExtIdentifier();
        }

        else if (type instanceof FloorType)
        {
            globalId = product.getGlobalId();
            extId = ((FloorType)type).getExtIdentifier();
        }

        else if (type instanceof ZoneType)
        {
            globalId = product.getGlobalId();
            extId = ((ZoneType)type).getExtIdentifier();
        }

        else if (type instanceof ComponentType)
        {
            globalId = product.getGlobalId();
            extId = ((ComponentType)type).getExtIdentifier();
        }

        else
        {
            throw new IllegalArgumentException(
                    "This method only supports the following COBIEBaseTypes: FloorType, SpaceType, ZoneType, ComponentType");
        }

        if (!COBieUtility.isNullOrEmpty(globalId) && !COBieUtility.isNullOrEmpty(extId))
        {
            matches = globalId.equals(extId);
        }

        return matches;
    }
}
