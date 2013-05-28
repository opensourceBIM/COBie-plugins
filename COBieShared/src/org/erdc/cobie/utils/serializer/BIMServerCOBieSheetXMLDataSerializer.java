package org.erdc.cobie.utils.serializer;

import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.erdc.cobie.shared.cobiesheetxmldata.COBieFactory;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.slf4j.Logger;

public abstract class BIMServerCOBieSheetXMLDataSerializer extends EmfSerializer implements COBieSheetXMLDataSerializable
{
    private COBIEDocument cobieDocument;

    private COBieFactory cobieFactory;
    
    protected static Logger logger;

    protected BIMServerCOBieSheetXMLDataSerializer()
    {
        this(COBIEDocument.Factory.newInstance());
    }

    protected BIMServerCOBieSheetXMLDataSerializer(COBIEDocument cobie)
    {
        super();
        cobieFactory = new COBieFactory();
        setCOBie(cobie);
    }

    @Override
    public final COBIEDocument getCOBieDocument()
    {
        return cobieDocument;
    }

    @Override
    public final Logger getLogger()
    {
        return logger;
    }

    @Override
    public void init(COBIEDocument cobie) throws SerializerException
    {
        super.init(null, null, null, null, true);
        setCOBie(cobie);
        finalize();
    }

    @Override
    public final void init(
            IfcModelInterface model,
            ProjectInfo projectInfo,
            PluginManager pluginManager,
            RenderEnginePlugin renderEnginePlugin,
            boolean normalizeOids) throws SerializerException
    {
        super.init(model, projectInfo, pluginManager, renderEnginePlugin, normalizeOids);
        setCOBie(COBIEDocument.Factory.newInstance());
        initializeModelInverseSlots();
        finalize();
    }

    protected void finalize()
    {
        
    }
    
    private void initializeModelInverseSlots()
    {
        for (IfcRelAssociates assoc : model.getAllWithSubTypes(IfcRelAssociates.class))
        {
            for (IfcRoot relObj : assoc.getRelatedObjects())
            {
                if (relObj instanceof IfcObjectDefinition)
                {
                    IfcObjectDefinition objDef = (IfcObjectDefinition)relObj;
                    if (objDef.getHasAssociations().size() == 0)
                    {
                        objDef.getHasAssociations().add(assoc);
                    }
                }
            }
        }
    }

    protected final boolean isCOBieSheetXMLDataLoaded()
    {
        return (getCOBieDocument().getCOBIE() != null);
    }

    /**
     * Parses the IFC model and populates a corresponding COBieSheet XML
     * Document
     */
    
    private void modelToCOBie()
    {
        if (!isCOBieSheetXMLDataLoaded())
        {
            setCOBie(cobieFactory.parse(getModel()));
        }

    }

    @Override
    public void reset()
    {
        setMode(Mode.BODY);
    }

    public final void setCOBie(COBIEDocument cobie)
    {
        cobieDocument = cobie;
    }

    @Override
    public final boolean write(OutputStream outputStream) throws SerializerException
    {
        boolean succeeded = false;
        if (getMode() != Mode.FINISHED)
        {
            try
            {
                modelToCOBie();
                writeCOBIE(outputStream);
                setMode(Mode.FINISHED);
                succeeded = true;
            } catch (Exception e)
            {
                throw new SerializerException(e);
            }

        }
        return succeeded;

    }

    protected abstract void writeCOBIE(OutputStream outputStream) throws SerializerException;

}
