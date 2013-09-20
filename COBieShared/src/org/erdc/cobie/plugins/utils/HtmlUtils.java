package org.erdc.cobie.plugins.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.swing.text.BadLocationException;
import org.apache.commons.io.IOUtils;


public class HtmlUtils
{
	public static String injectCSS(File cssFile,String html) throws IOException, BadLocationException
	{
		InputStream inStream = new FileInputStream(cssFile);
		StringWriter wrt = new StringWriter();
		IOUtils.copy(inStream, wrt);
		String cssInject = wrt.toString();
		cssInject = "<head><style>" + cssInject +"</style>";
		html = html.replace("<head>",cssInject);
		return html;
	}
}
