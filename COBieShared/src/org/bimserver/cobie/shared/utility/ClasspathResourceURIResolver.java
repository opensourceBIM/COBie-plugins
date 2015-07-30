package org.bimserver.cobie.shared.utility;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import org.bimserver.cobie.shared.Common;

public class ClasspathResourceURIResolver implements URIResolver
{
	@Override
	public Source resolve(String href, String base) throws TransformerException
	{
		StreamSource streamSource;
		
		try
		{
			URI hrefURI = new URI(href.replace(Common.BACKSLASH.toString(), Common.PATH_SEPARATOR.toString()));
			streamSource = new StreamSource(new File(hrefURI.getPath()));
		}
		
		catch (URISyntaxException e)
		{
			streamSource = new StreamSource(new File(href));
		}
		
		return streamSource;
	}
}
