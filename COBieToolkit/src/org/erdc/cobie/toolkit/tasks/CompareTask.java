package org.erdc.cobie.toolkit.tasks;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.TransformerException;

import org.apache.xmlbeans.XmlException;
import org.erdc.cobie.report.ReportSerializer;
import org.erdc.cobie.shared.COBieTaskProgress;
import org.erdc.cobie.shared.Informable;
import org.erdc.cobie.shared.compare.COBieCompareResult;
import org.erdc.cobie.shared.compare.COBieCompareState;
import org.erdc.cobie.sheetxmldata.COBIEDocument;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.cobie.compare.COBieCompareDocument;

public class CompareTask extends ApplicationTask<Void> implements PropertyChangeListener
{

	private static final String OPERATION_CANCELED_MESSAGE = "Operation canceled";

	private static final String COMPARISON_REPORT_SAVED_MESSAGE = "Comparison report saved";

	private static final String TEST_COMPARE_FILENAME = "testCompare.xml";

	private static final String COMPARE_HTML_XSLT_PATH =
			"lib/CompareReport.xslt";

	private static final String DEFAULT_ENCODING = "UTF-8";

	private static final String PROGRESS_MESSAGE_COMPARE_DONE = "Comparison Done";
	
	private static final String PROGRESS_MESSAGE_COMPARING_DOCUMENTS = "Comparing documents - progress bar will not refresh until finished";
	private static final String PROGRESS_MESSAGE_LOADING_XML = "Loading Comparisons into XML Document";
	private static final String PROGRESS_MESSAGE_PREFIX_ERROR = "An error occured while performing comparison:  ";
	private static final String PROGRESS_MESSAGE_SAVING_COMPARE = "Transforming Comparison to HTML";
	private COBIEDocument baselineDocument,revisionDocument;
	private COBieCompareDocument compareDocument;
	private COBieCompareResult compareResult;
	private String reportFilePath;
	private boolean writesReportFile;
	
	public CompareTask(COBIEDocument baselineDocument,COBIEDocument revisionDocument,
			String reportFilePath,
			Informable informable,boolean requiresRunningBiMServer)
	{
		
		super(informable,requiresRunningBiMServer);
		setBaselineDocument(baselineDocument);
		setRevisionDocument(revisionDocument);
		setReportFilePath(reportFilePath);
		setWritesReportFile(true);
		compareResult = new COBieCompareResult(baselineDocument,revisionDocument);
		compareResult.getState().addPropertyChangeListener(CompareTask.this);
	}
	public CompareTask(Informable informable,boolean requiresRunningBiMServer)
	{
		super(informable,requiresRunningBiMServer);
		compareResult = new COBieCompareResult();
		compareResult.getState().addPropertyChangeListener(CompareTask.this);
	}
	@Override
	protected Void doInBackground() throws Exception
	{	
		try
		{

			this.setProgress(1);
			publish(new COBieTaskProgress(PROGRESS_MESSAGE_COMPARING_DOCUMENTS));
			performComparison();
			
			if(isWritesReportFile())
			{
				setProgress(50);
				publish(new COBieTaskProgress(PROGRESS_MESSAGE_LOADING_XML));
				//publish(new COBieTaskProgress("Initializing document..."));
				//COBieCompareDocument compareDocument = COBieCompareDocument..Factory.newInstance();
				//publish(new COBieTaskProgress("Initialed blank compare..."));
				setCompareDocument(compareResult.asCOBieCompareDocument());
				setProgress(70);
				publish(new COBieTaskProgress(PROGRESS_MESSAGE_SAVING_COMPARE));
				saveComparison();
				
			}
			setProgress(100);
			publish(new COBieTaskProgress(PROGRESS_MESSAGE_COMPARE_DONE));
			super.sleep();
		}
		catch(Exception e)
		{
			handleExecutionException(new COBieTaskProgress(PROGRESS_MESSAGE_PREFIX_ERROR));
		}
		
		return null;

	}


	@Override
    public void done() 
    { 	
    	if(isCancelled())
    	{
    		setProgress(0);
    		publish(new COBieTaskProgress(OPERATION_CANCELED_MESSAGE));
    	}
    	else
    	{
    		setProgress(100);
    		publish(new COBieTaskProgress(COMPARISON_REPORT_SAVED_MESSAGE));
    	}
    	super.done();
    }
	

	private void executeXslTransform(File saveFile) throws UnsupportedEncodingException, IOException, TransformerException
	{
		FileOutputStream fOut = new FileOutputStream(saveFile);
		ReportSerializer.executeSaxonXSLT(fOut, compareDocument.toString().getBytes(DEFAULT_ENCODING),COMPARE_HTML_XSLT_PATH);
	}

	public COBIEDocument getBaselineDocument()
	{
		return baselineDocument;
	}
	public COBieCompareDocument getCompareDocument()
	{
		return compareDocument;
	}
	
	
	public COBieCompareResult getCompareResult()
	{
		return compareResult;
	}
	
	public String getReportFilePath()
	{
		return reportFilePath;
	}
	
	public COBIEDocument getRevisionDocument()
	{
		return revisionDocument;
	}

	public boolean isWritesReportFile()
	{
		return writesReportFile;
	}
	protected void performComparison() throws ServerException, UserException, XmlException, IOException,Exception
	{
		compareResult.indexDocumentsAndPerformCompare();
		setCompareResult(compareResult);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		try
		{
			if (evt.getSource()==compareResult.getState())
			{
				COBieCompareState compareState =
						 compareResult.getState();
				String propertyName = evt.getPropertyName();
				if(propertyName.equals(COBieCompareState.PROPERTY_NAME_PROGRESS))
				{
					int compareProgress = compareState.getProgress();
					if (compareProgress!=COBieCompareState.NULL_PROGRESS)
						setProgress(compareState.getProgress());
				}
				else if (propertyName.equals(COBieCompareState.PROPERTY_NAME_STATUS_MESSAGE))
				{

					publish(new COBieTaskProgress(compareState.getStatusMessage(),compareState.getModeDisplayString()));
				}
			}

		}
		catch(Exception ex)
		{
			
		}
		
	}
	private void saveComparison() throws ServerException, UserException, XmlException, IOException, TransformerException
	{

		File reportFile = new File(reportFilePath);
		executeXslTransform(reportFile);
	}
	public void setBaselineDocument(COBIEDocument baselineDocument)
	{
		this.baselineDocument = baselineDocument;
	}
	
	public void setCompareDocument(COBieCompareDocument compareDocument) throws IOException
	{
		this.compareDocument = compareDocument;
		compareDocument.save(new File(TEST_COMPARE_FILENAME));

	}

	protected void setCompareResult(COBieCompareResult compareResult)
	{
		this.compareResult = compareResult;
	}

	public void setReportFilePath(String reportFilePath)
	{
		this.reportFilePath = reportFilePath;
	}


	public void setRevisionDocument(COBIEDocument revisionDocument)
	{
		this.revisionDocument = revisionDocument;
	}


	protected void setWritesReportFile(boolean writesReportFile)
	{
		this.writesReportFile = writesReportFile;
	}

}
