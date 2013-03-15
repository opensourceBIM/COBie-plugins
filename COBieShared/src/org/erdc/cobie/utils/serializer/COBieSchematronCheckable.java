package org.erdc.cobie.utils.serializer;

import org.erdc.cobie.sheetxmldata.COBIEDocument;

public interface COBieSchematronCheckable
{ 
    public COBieSchematronChecker createChecker(String schematronRulePath, String preProcessorPath,String svrlXSDPath,String svrlHTMLPath,String cssPath);
}
