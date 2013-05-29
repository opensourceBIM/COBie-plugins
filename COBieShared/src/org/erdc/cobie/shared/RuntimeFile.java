package org.erdc.cobie.shared;

import java.net.URI;
import java.net.URISyntaxException;

public class RuntimeFile
{
    private URI relativePath;

    public RuntimeFile(String relativePath)
    {
        try
        {
            this.relativePath = new URI(relativePath);
        }

        catch (URISyntaxException e)
        {
            this.relativePath = null;
        }
    }

    public RuntimeFile(URI relativePath)
    {
        this.relativePath = relativePath;
    }

    public URI getRelativePath()
    {
        return this.relativePath;
    }

}
