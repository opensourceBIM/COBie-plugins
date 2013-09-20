package org.erdc.cobie.report;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
public class ErrorListenerLogger implements ErrorListener
{
    private Logger logger;
    public ErrorListenerLogger(Logger logger)
    {
        this.logger = logger;
    }

    @Override
    public void warning(TransformerException exception) throws TransformerException
    {
        warn(exception);
        
    }
    
    @Override
    public void error(TransformerException exception) throws TransformerException
    {
        fail(exception);
        throw exception;
    }
    
    @Override
    public void fatalError(TransformerException exception) throws TransformerException
    {
        fail(exception);
        throw exception;
    }

    private void fail(TransformerException exception)
    {
        logger.error(exception.getMessage());
    }
    
    private void warn(TransformerException exception)
    {
        logger.warn(exception.getMessageAndLocation());
    }
    

}