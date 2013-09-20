package org.erdc.cobie.utils.serializer;

import org.erdc.cobie.shared.enums.SchematronValidationPhase;

public class COBieSchematronCheckerSettings
{
    private String schematronRulePath;
    private String preProcessorPath;
    private String svrlHTMLPath;
    private SchematronValidationPhase phase;
    
    public COBieSchematronCheckerSettings(String schematronRulePath, String preProcessorPath, String svrlHTMLPath, SchematronValidationPhase phase)
    {
        setSchematronRulePath(schematronRulePath);
        setPreProcessorPath(preProcessorPath);
        setSvrlHTMLPath(svrlHTMLPath);
        setPhase(phase);
    }
    
    public String getSchematronRulePath()
    {
        return schematronRulePath;
    }
    public void setSchematronRulePath(String schematronRulePath)
    {
        this.schematronRulePath = schematronRulePath;
    }
    public String getPreProcessorPath()
    {
        return preProcessorPath;
    }
    public void setPreProcessorPath(String preProcessorPath)
    {
        this.preProcessorPath = preProcessorPath;
    }
    public String getSvrlHTMLPath()
    {
        return svrlHTMLPath;
    }
    public void setSvrlHTMLPath(String svrlHTMLPath)
    {
        this.svrlHTMLPath = svrlHTMLPath;
    }
    public SchematronValidationPhase getPhase()
    {
        return phase;
    }
    public void setPhase(SchematronValidationPhase phase)
    {
        this.phase = phase;
    }
    
}
