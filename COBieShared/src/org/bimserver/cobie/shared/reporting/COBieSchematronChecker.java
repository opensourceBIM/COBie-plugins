package org.bimserver.cobie.shared.reporting;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.UUID;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.nibs.cobie.tab.COBIEDocument;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class COBieSchematronChecker
{
    private static final String RESPONSE_EXCEPTION = "An exception occured while writing COBie Compliance report to response stream:  ";
    private static final String MSG_HTML_XSLT_DONE = "Transformation 3 of 3: Done transforming SVRL report to HTML.";
    private static final String MSG_HTML_XSLT_BEGIN = "Transformation 3 of 3: Begin transforming SVRL report to HTML.";
    private static final String MSG_SVRL_XSLT_DONE = "Transformation 2 of 3: Done transforming target COBie model into SVRL report.";
    private static final String MSG_SVRL_XSLT_BEGIN = "Transformation 2 of 3:  Begin transforming target model into Schematron Validation Report Language (SVRL) report. This can take several minutes for files greater than 5 MB.";
    private static final String MSG_HTML_XSLT_ERROR = "Transformation 3 of 3:  An exception occured while transforming SVRL to HTML:  ";
    private static final String MSG_SVRL_XSLT_ERROR = "Transformation 2 of 3:  An exception occured while transforming target COBie model to SVRL XML report:  ";
    private static final String MSG_SCHEMATRON_XSLT_DONE = "Transformation 1 of 3:  Done transforming COBie Schematron rules to XSLT.";
    private static final String MSG_SCHEMATRON_XSLT_ERROR = "Transformation 1 of 3:  An Exception occured while transforming COBie Schematron rules to XSLT:  ";
    private static final String MSG_SCHEMATRON_XSLT_BEGIN = "Transformation 1 of 3:  Begin transforming COBie Schematron rules to XSLT.";
    private static final Logger LOGGER = LoggerFactory.getLogger(COBieSchematronChecker.class);
  
    private COBIEDocument COBie;
    private COBieSchematronCheckerSettings settings;
    private TransformerFactory transformerFactory = TransformerFactory
            .newInstance("net.sf.saxon.TransformerFactoryImpl", getClass().getClassLoader());
    private SAXBuilder saxBuilder = new SAXBuilder();
    private File ruleTransformResult, cobieTransformResult;
    public COBieSchematronChecker(COBieSchematronCheckerSettings settings)
    {
        this(settings, null);
    }

    public COBieSchematronChecker(COBieSchematronCheckerSettings settings,
            COBIEDocument cobie)
    {
        this.settings = settings;
        COBie = cobie;
    }

    public COBIEDocument getCOBie()
    {
        return COBie;
    }

    private void transformSchematronRules(OutputStream outputStream) throws Exception
    {
        LOGGER.info(MSG_SCHEMATRON_XSLT_BEGIN);

        File ruleFile = getschematronRulePath().toFile();
        try
        {
            saxBuilder.build(getPreProcessorPath().toFile());
        } catch (Exception e)
        {
            LOGGER.error(MSG_SCHEMATRON_XSLT_ERROR + e.getMessage());
            throw e;
        }
        File preProcessor = getPreProcessorPath().toFile();
        XSLTransform transformer =
                new XSLTransform(new StreamSource(ruleFile), new StreamSource(preProcessor),
                transformerFactory);
        transformer.getTransformer().setParameter(getSettings().getPhase().getSchematronPhaseParameterName().getLocalName(), getSettings().getPhase().getSchematronPhaseParameterValue().getStringValue());
        transformer.transform(outputStream); 
        LOGGER.info(MSG_SCHEMATRON_XSLT_DONE);
    }

    private void transformCOBietoSVRL(OutputStream outputStream) throws Exception
    {
        LOGGER.info(MSG_SVRL_XSLT_BEGIN);
        ByteArrayInputStream targetDocStream;
        try
        {
            targetDocStream = new ByteArrayInputStream(COBie.toString().getBytes("UTF-8"));
        } catch (Exception e)
        {
            LOGGER.error(MSG_SVRL_XSLT_ERROR + e.getMessage());
            throw e;
        }

        try
        {
            XSLTransform transformer =
                    new XSLTransform(new StreamSource(targetDocStream), new StreamSource(
                    this.ruleTransformResult),
                    transformerFactory);        
            transformer.transform(outputStream);
            LOGGER.info(MSG_SVRL_XSLT_DONE);
        }
        catch(Exception e)
        {
            throw e;
        }
        
    }

    
    private File getTempFile(String extension)
    {
        File ruleDirectory = getschematronRulePath().toFile().getParentFile();
        return new File(ruleDirectory, UUID.randomUUID().toString() +"."+extension);
    }

    private void transformSVRLtoHTML(OutputStream outputStream) throws Exception
    {
        LOGGER.info(MSG_HTML_XSLT_BEGIN);
        File svrlHTMLFile = getSVRLHtmlPath().toFile();

        try
        {
            saxBuilder.build(svrlHTMLFile);
        } catch (Exception e)
        {
            LOGGER.error(MSG_HTML_XSLT_ERROR + e.getMessage());
            throw e;
        }

        XSLTransform transformer =
                new XSLTransform(new StreamSource(this.cobieTransformResult),
                new StreamSource(svrlHTMLFile), transformerFactory);
        transformer.getTransformer().setParameter(getSettings().getPhase().getTitleParameterName().toString(), 
                getSettings().getPhase().getTitleParameterValue().getStringValue());
        transformer.transform(outputStream);
        LOGGER.info(MSG_HTML_XSLT_DONE);
    }

    private void schematronReportToOutputStream(OutputStream outputStream) throws Exception
    {
        try
        {
        	COBie.save(new File("incoming.xml"));
            this.ruleTransformResult = getTempFile("xsl");
            transformSchematronRules(new FileOutputStream(this.ruleTransformResult));
            this.cobieTransformResult = getTempFile("xml");
            transformCOBietoSVRL(new FileOutputStream(this.cobieTransformResult));
            transformSVRLtoHTML(outputStream);

        } 
        catch (IOException e)
        {
            LOGGER.error(RESPONSE_EXCEPTION + e.getMessage());
            throw e;
        }
        finally
        {
            this.cobieTransformResult.delete();
            this.ruleTransformResult.delete();
        }

    }

    public void setCOBie(COBIEDocument cOBie)
    {
        COBie = cOBie;
    }

    public void writeResult(OutputStream output) throws Exception
    {
        try
        {
            schematronReportToOutputStream(output);
        } catch (Exception ex)
        {
            throw ex;
        }
    }

    public COBieSchematronCheckerSettings getSettings()
    {
        return settings;
    }

    public void setSettings(COBieSchematronCheckerSettings settings)
    {
        this.settings = settings;
    }
    
    private Path getschematronRulePath()
    {
        return settings.getSchematronRulePath();
    }
    
    private Path getPreProcessorPath()
    {
        return settings.getPreProcessorPath();
    }
    
    private Path getSVRLHtmlPath()
    {
        return settings.getSvrlHTMLPath();
    }
}
