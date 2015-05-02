package org.bimserver.cobie.shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.cxf.helpers.IOUtils;
import org.bimserver.cobie.shared.Common;
import org.bimserver.cobie.shared.utility.URIUtils;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.VirtualFile;
import org.bimserver.plugins.classloaders.EclipsePluginClassloader;
import org.bimserver.plugins.classloaders.JarClassLoader;

public class ResourceManager
{
    private Map<String, File> resourceMap = new HashMap<String, File>();
    private final List<URI> resources;
    private final URI rootDestination;
    private final PluginContext context;

    public ResourceManager(List<URI> resources, URI destination, PluginContext context)
    {
        this.resources = resources;
        this.rootDestination = destination;
        this.context = context;
    }

    public static URI getAbsolutePathFromFileSystem(URI relativePath, PluginContext context) throws URISyntaxException
    {
        Collection<VirtualFile> resources = context.listResources(URIUtils.makeDOSPath(relativePath));
        Object[] virtualFiles = resources.toArray();
        VirtualFile virtualFile = (VirtualFile)virtualFiles[0];

        return new URI(virtualFile.getName());
    }

    public static URI getAbsolutePathFromJar(URI relativePath, PluginContext context) throws URISyntaxException
    {
        return context.getResourceAsUrl(relativePath.getPath()).toURI();
    }

    private File copyDirectory(URI resource, URI destination) throws IOException, URISyntaxException
    {
        File parentDirectory = new File(destination);
        File subDirectory = new File(parentDirectory, URIUtils.getFileName(resource));
        parseResources(getResources(resource), subDirectory.toURI());

        return subDirectory;
    }

    private File copyFile(URI resource, URI destination) throws IOException
    {
        File destinationDirectory = new File(destination);
        File destinationFile = new File(destinationDirectory, URIUtils.getFileName(resource));

        try
        {
            IOUtils.copy(getPluginContext().getResourceAsInputStream(resource.getPath()), new FileOutputStream(destinationFile));
        }

        catch (Exception e)
        {
            IOUtils.copy(new FileInputStream(resource.getPath()), new FileOutputStream(destinationFile));
        }

        return destinationFile;
    }

    public void copyResources() throws IOException, URISyntaxException
    {
        parseResources(getResources(), getRootDestination());
    }

    private static void createDestination(URI destination) throws IOException
    {
        File destinationDirectory = new File(destination);

        if (!destinationDirectory.exists())
        {
            FileUtils.forceMkdir(destinationDirectory);
        }
    }

    private final PluginContext getPluginContext()
    {
        return context;
    }

    public final Map<String, File> getResourceMap()
    {
        return resourceMap;
    }

    public final List<URI> getResources()
    {
        return resources;
    }

    private List<URI> getResources(URI resource) throws URISyntaxException
    {
        List<URI> resources = new ArrayList<URI>();

        if (getPluginContext().getClassLoader() instanceof EclipsePluginClassloader)
        {
            resources = getResourcesFromFileSystem(resource);
        }

        else if (this.getPluginContext().getClassLoader() instanceof JarClassLoader)
        {
            resources = getResourcesFromJar(resource);
        }

        return resources;
    }
    
    private List<URI> getResourcesFromFileSystem(URI resource) throws URISyntaxException
    {
        List<URI> resources = new ArrayList<URI>();
        String fileSystemPath = resource.getPath();
        Collection<VirtualFile> virtualFiles = getResourcesFromPluginContext(fileSystemPath);
        if(virtualFiles != null)
        {
            for (VirtualFile virtualFile : virtualFiles)
            {
                String name = URIUtils.makeStandardPath(virtualFile.getName());
                name = name.substring(name.indexOf(Common.PATH_SEPARATOR.toString()) + 1, name.length());
                resources.add(new URI(name));
            }
        }


        return resources;
    }

	/**
	 * @param fileSystemPath
	 * @return
	 */
	public Collection<VirtualFile> getResourcesFromPluginContext(String fileSystemPath)
	{
		Collection<VirtualFile> targetDirectoryContents = null;
		if(fileSystemPath.contains(Common.PATH_SEPARATOR.toString()))
		{
			String[] splitPath = fileSystemPath.split(Common.PATH_SEPARATOR.toString());
			Collection<VirtualFile> directoryContents = getPluginContext().listResources(splitPath[0]);
			for(int i=1; i < splitPath.length; i++)
			{
				for(VirtualFile file : directoryContents)
				{
					if(file.getSimpleName().equals(splitPath[i]))
					{
						targetDirectoryContents = file.listFiles();
						break;
					}
				}
				directoryContents = targetDirectoryContents;
			}
			
		}
		else
		{
			targetDirectoryContents = getPluginContext().listResources(fileSystemPath);
		}
		return targetDirectoryContents;
	}

    private List<URI> getResourcesFromJar(URI resource)
    {
        List<URI> resources = new ArrayList<URI>();
        String fileSystemPath = URIUtils.makeJarPath(resource);
        Collection<VirtualFile> virtualFiles = getResourcesFromPluginContext(fileSystemPath);

        for (VirtualFile virtualFile : virtualFiles)
        {
            URI virtualFileURI = virtualFile.toUri();
            resources.add(virtualFileURI);
        }

        return resources;
    }

    public final URI getRootDestination()
    {
        return rootDestination;
    }

    private void parseResources(List<URI> resources, URI destination) throws IOException, URISyntaxException
    {
        createDestination(destination);

        for (URI resource : resources)
        {
            File destinationFile;

            if (URIUtils.isDirectory(resource))
            {
                destinationFile = copyDirectory(resource, destination);
            }

            else
            {
                destinationFile = copyFile(resource, destination);
                getResourceMap().put(resource.getPath(), destinationFile);
            }
        }
    }
}
