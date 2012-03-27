package org.bimserver.cobie.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.cobie.ignoreSchema.ClassDefinition;
import org.bimserver.cobie.ignoreSchema.PackageDefinition;
import org.bimserver.cobie.utils.COBieUtility;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieIDM implements ObjectIDM
{
	private static final Logger LOGGER = LoggerFactory.getLogger(COBieIDM.class);
	private JAXBContext jaxbContext;
	private File cobieIgnoreFile;
	private ObjectIDMPlugin defaultIDM;
	private ArrayList<String> ignoreClassNames;
	public COBieIDM()
	{
		ignoreClassNames = new ArrayList<String>();
	}
	
	public COBieIDM(File ignoreFile,Set<Ifc2x3Package> set, PluginContext pluginContext,ObjectIDMPlugin fileBasedIDM)
	{
		this();
		this.cobieIgnoreFile = ignoreFile;
		try {
			this.defaultIDM = fileBasedIDM;
			LOGGER.info("Reading COBieIDM ignore file");
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
	
	private void logCOBieIgnoreList()
	{
		if (ignoreClassNames.size()>0)
		LOGGER.info("COBieIDM will ignore the following entities:  "+
					COBieUtility.delimittedStringFromArrayList(ignoreClassNames));
		else
			LOGGER.info("COBieIDM file is empty");
	}
	
	@Override
	public boolean shouldIgnoreField(EClass originalClass, EClass eClass,
			EStructuralFeature eStructuralFeature)
	{
		if (ignoreClassNames.contains(eClass.getName()))
			return true;
		else
			return defaultIDM.getObjectIDM().shouldIgnoreField(originalClass, eClass, eStructuralFeature);

	}

	@Override
	public boolean shouldIgnoreClass(EClass eClass)
	{
		// TODO Auto-generated method stub
		return (ignoreClassNames.contains(eClass.getName()));
	}



}
