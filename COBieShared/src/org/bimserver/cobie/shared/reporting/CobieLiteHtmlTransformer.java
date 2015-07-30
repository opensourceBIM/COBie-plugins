package org.bimserver.cobie.shared.reporting;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.TransformerException;

import org.bimserver.cobie.shared.Common;
import org.buildingsmartalliance.docs.nbims03.cobie.cobielite.FacilityDocument;

public class CobieLiteHtmlTransformer
{
	private final String reportXSLPath;
	private final FacilityDocument facilityDocument;
	
	public CobieLiteHtmlTransformer(String reportXSLPath, FacilityDocument facilityDocument)
	{
		this.reportXSLPath = reportXSLPath;
		this.facilityDocument = facilityDocument;
	}
	
	 public void executeTransform(OutputStream outputStream) throws UnsupportedEncodingException, IOException, TransformerException
	 {
	        	SaxonTransformer.executeSaxonXSLT(outputStream, facilityDocument
	                    .toString().getBytes(Common.ENCODING_UTF8.toString()), getReportXSLPath());
	    }

	public String getReportXSLPath()
	{
		return reportXSLPath;
	}
}
