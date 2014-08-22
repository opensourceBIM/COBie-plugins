package org.erdc.cobie.shared.reporting;


public class COBieSchematronCheckerSettings
{
    private String schematronRulePath;
    private String preProcessorPath;
    private String svrlHTMLPath;
    private COBieQCValidationPhase phase;
    
    public COBieSchematronCheckerSettings(String schematronRulePath, String preProcessorPath, String svrlHTMLPath, COBieQCValidationPhase phase)
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
    public COBieQCValidationPhase getPhase()
    {
        return phase;
    }
    public void setPhase(COBieQCValidationPhase phase)
    {
        this.phase = phase;
    }
    
}
