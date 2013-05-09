package org.erdc.cobie.plugins.utils;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.google.common.base.Charsets;

public class CP1252Printwriter extends PrintWriter
{
	public CP1252Printwriter(OutputStream out) throws UnsupportedEncodingException
	{
		super(new PrintWriter(new OutputStreamWriter(out,"Cp1252")), false);

	}
}
