package org.erdc.cobie.shared;

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
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.VirtualFile;
import org.bimserver.plugins.classloaders.EclipsePluginClassloader;
import org.bimserver.plugins.classloaders.JarClassLoader;
import org.erdc.cobie.shared.utils.URIUtils;

public class FileMover
{
    private Map<String, File> resourceMap = new HashMap<String, File>();
    private final List<URI> resources;
    private final URI rootDestination;
    private final PluginContext context;

    public FileMover(List<URI> resources, URI destination, PluginContext context)
    {
        this.resources = resources;
        this.rootDestination = destination;
        this.context = context;
    }

    public static URI getAbsolutePathFromFileSystem(URI relativePath, PluginContext context) throws URISyntaxException
    {
        Collection<VirtualFile> resources = context.listResources(URIUtils.makeDOSPath(relativePath));
        Object[] virtualFiles = resources.toArray();
        VirtualFile v = (VirtualFile)virtualFiles[0];

        return new URI(v.getName());
    }

    public static URI getAbsolutePathFromJar(URI relativePath, PluginContext context) throws URISyntaxException
    {
        return context.getResourceAsUrl(relativePath.getPath()).toURI();
    }

    private File copyDirectory(URI resource, URI destination) throws IOException, URISyntaxException
    {
        File parentDirectory = new File(destination);
        File subDirectory = new File(parentDirectory, URIUtils.getFileName(resource));
        this.parseResources(this.getResources(resource), subDirectory.toURI());

        return subDirectory;
    }

    private File copyFile(URI resource, URI destination) throws IOException
    {
        File destinationDirectory = new File(destination);
        File destinationFile = new File(destinationDirectory, URIUtils.getFileName(resource));

        try
        {
            IOUtils.copy(this.context.getResourceAsInputStream(resource.getPath()), new FileOutputStream(destinationFile));
        }

        catch (Exception e)
        {
            IOUtils.copy(new FileInputStream(resource.getPath()), new FileOutputStream(destinationFile));
        }

        return destinationFile;
    }

    public void copyResources() throws IOException, URISyntaxException
    {
        this.parseResources(this.getResources(), this.getRootDestination());
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
        return this.context;
    }

    public Map<String, File> getResourceMap()
    {
        return this.resourceMap;
    }

    public List<URI> getResources()
    {
        return this.resources;
    }

    private List<URI> getResources(URI resource) throws URISyntaxException
    {
        List<URI> resources = new ArrayList<URI>();

        if (this.getPluginContext().getClassLoader() instanceof EclipsePluginClassloader)
        {
            resources = this.getResourcesFromFileSystem(resource);
        }

        else if (this.getPluginContext().getClassLoader() instanceof JarClassLoader)
        {
            resources = this.getResourcesFromJar(resource);
        }

        return resources;
    }
    
    private List<URI> getResourcesFromFileSystem(URI resource) throws URISyntaxException
    {
        List<URI> resources = new ArrayList<URI>();
        String fileSystemPath = URIUtils.makeSimplePath(resource);
        Collection<VirtualFile> virtualFiles = this.getPluginContext().listResources(fileSystemPath);

        for (VirtualFile virtualFile : virtualFiles)
        {
            String name = URIUtils.makeStandardPath(virtualFile.getName());
            name = name.substring(name.indexOf('/') + 1, name.length());
            resources.add(new URI(name));
        }

        return resources;
    }

    private List<URI> getResourcesFromJar(URI resource)
    {
        List<URI> resources = new ArrayList<URI>();
        String fileSystemPath = URIUtils.makeSimplePath(resource);
        Collection<VirtualFile> virtualFiles = this.context.listResources(fileSystemPath);

        for (VirtualFile virtualFile : virtualFiles)
        {
            URI virtualFileURI = virtualFile.toUri();
            resources.add(virtualFileURI);
        }

        return resources;
    }

    public URI getRootDestination()
    {
        return this.rootDestination;
    }

    private boolean isDirectory(URI resource)
    {
        boolean isDirectory = false;

        try
        {
            this.context.listResources(resource.getPath());
            isDirectory = true;
        }

        catch (Exception ex)
        {
            // No code needed.
        }

        return isDirectory;
    }

    private void parseResources(List<URI> resources, URI destination) throws IOException, URISyntaxException
    {
        createDestination(destination);

        for (URI resource : resources)
        {
            File destinationFile;

            if (this.isDirectory(resource))
            {
                destinationFile = this.copyDirectory(resource, destination);
            }

            else
            {
                destinationFile = this.copyFile(resource, destination);
                this.resourceMap.put(resource.getPath(), destinationFile);
            }
        }
    }
}
