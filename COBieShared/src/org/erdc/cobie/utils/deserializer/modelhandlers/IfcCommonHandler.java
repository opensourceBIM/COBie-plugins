package org.erdc.cobie.utils.deserializer.modelhandlers;

import org.bimserver.emf.OidProvider;
import org.erdc.cobie.utils.deserializer.COBieIfcModel;

public class IfcCommonHandler
{
    private IfcGuidHandler guidHandler;
    private GeometryHandler geometryHandler;
    private OwnerHistoryHandler ownerHistoryHandler;
    private PropertySetHandler propertySetHandler;
    private ClassificationHandler classificationHandler;
    private OidProvider oidHandler;
    private COBieIfcModel model;
    private IfcUnitHandler unitHandler;

    public IfcCommonHandler(COBieIfcModel cobieIfcmodel, OidProvider oidProvider)
    {
        oidHandler = oidProvider;
        model = cobieIfcmodel;
        ownerHistoryHandler = new OwnerHistoryHandler(model, oidProvider);
        guidHandler = new IfcGuidHandler(model, oidProvider);
        classificationHandler = new ClassificationHandler(model, guidHandler, oidProvider, ownerHistoryHandler);
        propertySetHandler = new PropertySetHandler(model, oidProvider, guidHandler, ownerHistoryHandler);
        setUnitHandler(new IfcUnitHandler(oidProvider, cobieIfcmodel, guidHandler));
        setGeometryHandler(new GeometryHandler(oidProvider, cobieIfcmodel, guidHandler));
    }

    public ClassificationHandler getClassificationHandler()
    {
        return classificationHandler;
    }

    public GeometryHandler getGeometryHandler()
    {
        return geometryHandler;
    }

    public IfcGuidHandler getGuidHandler()
    {
        return guidHandler;
    }

    public OidProvider getOidProvider()
    {
        return oidHandler;
    }

    public OwnerHistoryHandler getOwnerHistoryHandler()
    {
        return ownerHistoryHandler;
    }

    public PropertySetHandler getPropertySetHandler()
    {
        return propertySetHandler;
    }

    public IfcUnitHandler getUnitHandler()
    {
        return unitHandler;
    }

    private void setGeometryHandler(GeometryHandler geometryHandler)
    {
        this.geometryHandler = geometryHandler;
    }

    public void setUnitHandler(IfcUnitHandler unitHandler)
    {
        this.unitHandler = unitHandler;
    }

}
