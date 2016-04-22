package org.bimserver.cobie.shared.reporting;

import java.io.File;




public class COBieSchematronCheckerSettings
{
    private File schematronRuleFile;
    private File preProcessorFile;
    private File svrlHTMLFile;
    private COBieQCValidationPhase phase;
    
    public COBieSchematronCheckerSettings(File schematronRuleFile, File preProcessorFile, File svrlHTMLFile, COBieQCValidationPhase phase)
    {
        setSchematronRuleFile(schematronRuleFile);
        setPreProcessorFile(preProcessorFile);
        setSvrlHTMLFile(svrlHTMLFile);
        setPhase(phase);
    }
    
    public File getSchematronRuleFile()
    {
        return schematronRuleFile;
    }
    public void setSchematronRuleFile(File schematronRuleFile)
    {
        this.schematronRuleFile = schematronRuleFile;
    }
    public File getPreProcessorFile()
    {
        return preProcessorFile;
    }
    public void setPreProcessorFile(File preProcessorFile)
    {
        this.preProcessorFile = preProcessorFile;
    }
    public File getSvrlHTMLFile()
    {
        return svrlHTMLFile;
    }
    public void setSvrlHTMLFile(File svrlHTMLFile)
    {
        this.svrlHTMLFile = svrlHTMLFile;
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
