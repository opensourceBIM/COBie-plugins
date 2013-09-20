package org.erdc.cobie.utils.serializer;


public interface COBieSchematronCheckable
{ 
    public COBieSchematronChecker createChecker(String schematronRulePath, String preProcessorPath,String svrlXSDPath,String svrlHTMLPath,String cssPath);
}
