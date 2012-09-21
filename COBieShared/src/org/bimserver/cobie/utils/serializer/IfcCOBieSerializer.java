package org.bimserver.cobie.utils.serializer;

import java.util.List;

import org.apache.xmlbeans.XmlObject;
import org.bimserver.cobie.utils.serializer.sheetserializers.IfcToJob;
import org.bimserver.cobie.utils.serializer.sheetserializers.LogHandler;
import org.bimserver.emf.IdEObject;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.cobie.COBieUtility;
import org.bimserver.shared.cobie.COBieUtility.CobieSheetName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcCOBieSerializer.
 *@param <S> the singular cobie type serialized (e.g. FacilityType)
 * @param <T> the containing type of the singular COBie elements (e.g. COBIEType.Facilities)
 * @param <K> the entry level ifc type type 
 */
public abstract class IfcCOBieSerializer<S extends XmlObject,T extends XmlObject,K extends IdEObject>
{
	
	private static final String INTERFACE_IMPL_SUFFIX = "Impl";
	protected T cobieSection;
	private Logger LOGGER;

	protected LogHandler loggerHandler;

	protected IfcModelInterface model;

	protected CobieSheetName sheetName;

	/**
	 * Instantiates a new ifccobie serializer.
	 *
	 * @param cobieSection the cobie section
	 * @param model the model
	 */
	public IfcCOBieSerializer(T cobieSection,IfcModelInterface model)
	{
		setCobieSection(cobieSection);
		setModel(model);
		init();
	}

	protected T getCobieSection()
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
	
	protected abstract List<K> getTopLevelModelObjects();

	protected void init()
	{
		initializeSheetName();
		setLOGGER(LoggerFactory.getLogger(this.getClass()));
		setLoggerHandler(new LogHandler(sheetName,LOGGER));
	}

	private void initializeSheetName()
	{
		String sheetNamePlural = cobieSection.getClass().getSimpleName();
		if(sheetNamePlural.endsWith(INTERFACE_IMPL_SUFFIX))
			sheetNamePlural = sheetNamePlural.substring(0,sheetNamePlural.length()-4);
		setSheetName(COBieUtility.CobiePluralNameToCobieSheetName.get(sheetNamePlural));
	}

	public final void serializeIfc()
	{
		loggerHandler.sheetWriteBegin();
		for(K modelObject:getTopLevelModelObjects())
		{
			try
			{
				List<S> newRows = serializeModelObject(modelObject);
				for(S newRow:newRows)
					loggerHandler.rowWritten();
			}
			catch(Exception ex)
			{
				loggerHandler.error(ex);
			}
		}
		loggerHandler.sheetWritten();
	}

	protected abstract List<S> serializeModelObject(K modelObject);

	private void setCobieSection(T cobieSection)
	{
		this.cobieSection = cobieSection;
	}
	
	private void setLOGGER(Logger lOGGER)
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
