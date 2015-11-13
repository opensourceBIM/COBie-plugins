package org.bimserver.cobie.shared.reporting;

import java.nio.file.Path;

public class COBieSchematronCheckerSettings
{
    private Path schematronRulePath;
    private Path preProcessorPath;
    private Path svrlHTMLPath;
    private COBieQCValidationPhase phase;
    
    public COBieSchematronCheckerSettings(Path schematronRulePath, Path preProcessorPath, Path svrlHTMLPath, COBieQCValidationPhase phase)
    {
        setSchematronRulePath(schematronRulePath);
        setPreProcessorPath(preProcessorPath);
        setSvrlHTMLPath(svrlHTMLPath);
        setPhase(phase);
    }
    
    public Path getSchematronRulePath()
    {
        return schematronRulePath;
    }
    public void setSchematronRulePath(Path schematronRulePath)
    {
        this.schematronRulePath = schematronRulePath;
    }
    public Path getPreProcessorPath()
    {
        return preProcessorPath;
    }
    public void setPreProcessorPath(Path preProcessorPath)
    {
        this.preProcessorPath = preProcessorPath;
    }
    public Path getSvrlHTMLPath()
    {
        return svrlHTMLPath;
    }
    public void setSvrlHTMLPath(Path svrlHTMLPath)
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
