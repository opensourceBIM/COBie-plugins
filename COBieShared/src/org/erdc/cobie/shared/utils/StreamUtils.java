package org.erdc.cobie.shared.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.erdc.cobie.shared.exceptions.CobieException;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class StreamUtils 
{	
	public static ByteArrayInputStream getInputStream(ByteArrayOutputStream output) throws CobieException
	{
		return new ByteArrayInputStream(output.toByteArray());
	}
	
	public static ByteInputStream getInputStream(ByteOutputStream output) throws CobieException
	{
		return new ByteInputStream(output.getBytes(), output.size());
	}
}
