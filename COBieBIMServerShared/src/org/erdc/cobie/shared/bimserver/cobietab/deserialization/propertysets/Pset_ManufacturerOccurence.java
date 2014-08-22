package org.erdc.cobie.shared.bimserver.cobietab.deserialization.propertysets;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcPropertySetImpl;
import org.erdc.cobie.sheetxmldata.ComponentType;

public class Pset_ManufacturerOccurence extends IfcPropertySetImpl
{
    public static enum ManufacturerOccurenceField
    {
        SerialNumber, BarCode
    }

    public static final String pSetName = " Pset_ManufacturerOccurrence";
    public static final String pSetDescription = "Defines properties of individual instances of manufactured products that may be given by the manufacturer.";
    private static final Map<ManufacturerOccurenceField, String> PropertyDescriptions = new HashMap<ManufacturerOccurenceField, String>()
    {
        /**
                 * 
                 */
        private static final long serialVersionUID = 1L;

        {
            put(ManufacturerOccurenceField.SerialNumber, "The serial number assigned to an occurrence of a product");
            put(ManufacturerOccurenceField.BarCode, "The identity of the bar code given to an occurrence of the product");

        }
    };

    public Pset_ManufacturerOccurence()
    {
        super();
        setDirectAttributes();
        initializeSingleValueAttributes();
    }

    public Pset_ManufacturerOccurence(ComponentType component)
    {
        this();
        setSerialNumber(component);
        setBarCode(component);

    }

    public void initializeSingleValueAttributes()
    {
        for (ManufacturerOccurenceField field : ManufacturerOccurenceField.values())
        {

            IfcPropertySingleValue sVal = Ifc2x3tc1Factory.eINSTANCE.createIfcPropertySingleValue();
            sVal.setName(field.toString());
            sVal.setDescription(PropertyDescriptions.get(field));
            getHasProperties().add(sVal);

        }
    }

    private void setBarCode(ComponentType component)
    {
        IfcIdentifier barcodeLbl = PropertyUtility.initializeIdentifier(component.getBarCode());
        PropertySetUtility.setPropertySetPropertyValueOfName(ManufacturerOccurenceField.BarCode.toString(), this, barcodeLbl);
    }

    public void setDirectAttributes()
    {
        setName(pSetName);
        setDescription(pSetDescription);
    }

    private void setSerialNumber(ComponentType component)
    {
        IfcIdentifier serialLbl = PropertyUtility.initializeIdentifier(component.getSerialNumber());
        PropertySetUtility.setPropertySetPropertyValueOfName(ManufacturerOccurenceField.SerialNumber.toString(), this, serialLbl);
    }

}
