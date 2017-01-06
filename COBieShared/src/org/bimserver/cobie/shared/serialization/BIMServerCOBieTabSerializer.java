package org.bimserver.cobie.shared.serialization;

import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.nibs.cobie.tab.COBIEDocument;
import org.slf4j.Logger;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

public abstract class BIMServerCOBieTabSerializer extends EmfSerializer implements COBieSheetXMLDataSerializable
{
    private COBIEDocument cobieDocument;

    private COBieTabSerializer cobieFactory;
    
    protected static Logger logger;

    protected BIMServerCOBieTabSerializer(SettingsType settings)
    {
        this(COBIEDocument.Factory.newInstance(), settings);
    }

    protected BIMServerCOBieTabSerializer(COBIEDocument cobie, SettingsType settings)
    {
        super();
        cobieFactory = new COBieTabSerializer(settings);
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
 
        super.init(null, null, null, null, null, true);
        setCOBie(cobie);
    }

    public void init(IfcModelInterface model, ProjectInfo projectInfo,
			PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin,
			PackageMetaData packageMetaData, boolean normalizeOids)
			throws SerializerException 
    
    {

    	super.init(model, projectInfo, pluginManager, renderEnginePlugin,
				packageMetaData, normalizeOids);
        setCOBie(COBIEDocument.Factory.newInstance());
        initializeModelInverseSlots();
	}

	@Override
	protected boolean write(OutputStream outputStream, ProgressReporter reporter) throws SerializerException 
	{
		boolean succeeded = false;
        if (getMode() != Mode.FINISHED)
        {
            try
            {
                modelToCOBie();
                writeCOBIE(outputStream);

                succeeded = true;
            } catch (Exception e)
            {
                throw new SerializerException(e);
            }
            finally
            {
                setMode(Mode.FINISHED);
            }

        }
        return succeeded;
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

    protected abstract void writeCOBIE(OutputStream outputStream) throws SerializerException;

}
