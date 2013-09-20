package org.erdc.cobie.utils.serializer;

import java.util.List;

import org.apache.xmlbeans.XmlObject;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.COBieUtility.CobieSheetName;
import org.erdc.cobie.utils.serializer.sheetserializers.LogHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcCOBieSerializer.
 * 
 * @param <COBIEROWTYPE>
 *            the singular cobie type serialized (e.g. FacilityType)
 * @param <COBIEROWCONTAINERTYPE>
 *            the containing type of the singular COBie elements (e.g.
 *            COBIEType.Facilities)
 * @param <IFCTYPE>
 *            the entry level ifc type
 */
public abstract class IfcCOBieSerializer<COBIEROWTYPE extends XmlObject, COBIEROWCONTAINERTYPE extends XmlObject, IFCTYPE extends IdEObject>
{

    private static final String INTERFACE_IMPL_SUFFIX = "Impl";
    protected COBIEROWCONTAINERTYPE cobieSection;
    private Logger LOGGER;

    protected LogHandler loggerHandler;

    protected IfcModelInterface model;

    protected CobieSheetName sheetName;

    /**
     * Instantiates a new ifccobie serializer.
     * 
     * @param cobieSection
     *            the cobie section
     * @param model
     *            the model
     */
    public IfcCOBieSerializer(COBIEROWCONTAINERTYPE cobieSection, IfcModelInterface model)
    {
        setCobieSection(cobieSection);
        setModel(model);
        init();
    }

    protected COBIEROWCONTAINERTYPE getCobieSection()
    {
        return cobieSection;
    }

    protected Logger getLOGGER()
    {
        return LOGGER;
    }

    protected LogHandler getLoggerHandler()
    {
        return loggerHandler;
    }

    protected IfcModelInterface getModel()
    {
        return model;
    }

    protected CobieSheetName getSheetName()
    {
        return sheetName;
    }

    protected abstract List<IFCTYPE> getTopLevelModelObjects();

    protected void init()
    {
        initializeSheetName();
        setLOGGER(LoggerFactory.getLogger(this.getClass()));
        setLoggerHandler(new LogHandler(sheetName, LOGGER));
    }

    private void initializeSheetName()
    {
        String sheetNamePlural = cobieSection.getClass().getSimpleName();
        if (sheetNamePlural.endsWith(INTERFACE_IMPL_SUFFIX))
        {
            sheetNamePlural = sheetNamePlural.substring(0, sheetNamePlural.length() - 4);
        }
        setSheetName(COBieUtility.CobiePluralNameToCobieSheetName.get(sheetNamePlural));
    }

    public final void serializeIfc()
    {
        loggerHandler.sheetWriteBegin();
        for (IFCTYPE modelObject : getTopLevelModelObjects())
        {
            try
            {
                List<COBIEROWTYPE> newRows = serializeModelObject(modelObject);
                this.loggerHandler.setRowCount(newRows.size());
            } catch (Exception ex)
            {
                loggerHandler.error(ex);
            }
        }
        loggerHandler.sheetWritten();
    }

    protected abstract List<COBIEROWTYPE> serializeModelObject(IFCTYPE modelObject);

    private void setCobieSection(COBIEROWCONTAINERTYPE cobieSection)
    {
        this.cobieSection = cobieSection;
    }

    protected void setLOGGER(Logger lOGGER)
    {
        LOGGER = lOGGER;
    }

    private void setLoggerHandler(LogHandler loggerHandler)
    {
        this.loggerHandler = loggerHandler;
    }

    private void setModel(IfcModelInterface model)
    {
        this.model = model;
    }

    private void setSheetName(CobieSheetName sheetName)
    {
        this.sheetName = sheetName;
    }

}
