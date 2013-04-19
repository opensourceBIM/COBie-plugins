package org.erdc.cobie.plugins.idm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.erdc.cobie.plugins.idm.ignoreschema.ClassDefinition;
import org.erdc.cobie.plugins.idm.ignoreschema.PackageDefinition;
import org.erdc.cobie.shared.COBieUtility;
import org.erdc.cobie.shared.idm.COBieFilterable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieIDM implements ObjectIDM, COBieFilterable
{
	private static final String LOGGER_MESSAGE_MIDDLE_WILL_IGNORE = " will ignore the following entities:  ";
	private static final String LOGGER_MESSAGE_START_IGNORE_READ_PREFIX = "Reading ignore file ";
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieIDM.class);
	private JAXBContext jaxbContext;
	private File cobieIgnoreFile;
	private ObjectIDMPlugin defaultIDM;
	private ArrayList<String> ignoreClassNames;
	private String pluginName;
	public COBieIDM()
	{
		ignoreClassNames = new ArrayList<String>();
	}
	
	@Override
	public List<String> getIgnoreClassNames()
	{
		return ignoreClassNames;
	}
	
	public COBieIDM(File ignoreFile,Set<Ifc2x3tc1Package> set, PluginContext pluginContext,ObjectIDMPlugin fileBasedIDM)
	{
		this();
		initializePluginName(pluginContext);
		this.cobieIgnoreFile = ignoreFile;
		try {
			
			this.defaultIDM = fileBasedIDM;
			LOGGER.info(LOGGER_MESSAGE_START_IGNORE_READ_PREFIX+ignoreFile.getName());
			jaxbContext = JAXBContext.newInstance(PackageDefinition.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			PackageDefinition packageDefinition = (PackageDefinition) unmarshaller.unmarshal(cobieIgnoreFile);
			for (ClassDefinition classDefinition : packageDefinition.getClassDefinitions()) 
			{
				ignoreClassNames.add(classDefinition.getName());
			}
			logCOBieIgnoreList();
			
		} catch (JAXBException e) {
			LOGGER.error("", e);
		}
	}
	
	private void initializePluginName(PluginContext pluginContext)
	{
		Plugin plugin = pluginContext.getPlugin();
		if(plugin instanceof ObjectIDMPlugin)
		{
			ObjectIDMPlugin idmPlugin = (ObjectIDMPlugin) plugin;
			this.pluginName = idmPlugin.getDefaultName();
		}
	}

	private void logCOBieIgnoreList()
	{
		
		if (ignoreClassNames.size()>0)
		LOGGER.info(pluginName+LOGGER_MESSAGE_MIDDLE_WILL_IGNORE+
					COBieUtility.delimittedStringFromArrayList(ignoreClassNames));
		else
			LOGGER.info("Ignore file "+cobieIgnoreFile.getName()+" is empty");
	}
	




	public boolean shouldIgnoreClass(EClass eClass)
	{
		// TODO Auto-generated method stub
		return (ignoreClassNames.contains(eClass.getName()));
	}

	@Override
	public boolean shouldFollowReference(EClass originalClass, EClass eClass,
			EStructuralFeature eStructuralFeature)
	{
		// TODO Auto-generated method stub
		if (ignoreClassNames.contains(eClass.getName()))
			return false;
		else if (defaultIDM!=null)
			return defaultIDM.getObjectIDM().shouldFollowReference(originalClass, eClass, eStructuralFeature);
		else
			return true;

	}

	@Override
	public boolean shouldIncludeClass(EClass originalClass, EClass eClass)
	{
		// TODO Auto-generated method stub
		return !(shouldIgnoreClass(eClass));
	}



}
