package org.bimserver.shared.cobie.compare;

import org.bimserver.shared.cobie.COBieUtility.CobieSheetName;

public class COBieCompareState extends java.awt.Component
{
	private static final String STATUS_MESSAGE_FETCHING_SUFFIX = " document";
	private static final String STATUS_MODE_FETCHING = "COBie Compare (Fetching)";
	private static final String STATUS_MODE_TRANSFORMING = "Transforming to Document";
	private static final String STATUS_MODE_INDEXING = "COBie Compare(Indexing)";
	private static final String STATUS_MODE_IDLE = "";
	private static final String STATUS_MODE_DONE = "COBie Compare";
	private static final String STATUS_MODE_COMPARE = "COBie Compare(Comparing Documents)";
	private static final String STATUS_MESSAGE_DONE = STATUS_MODE_IDLE;
	public static final int NULL_PROGRESS = -1;
	public static final String PROPERTY_NAME_MODE = "mode";
	public static final String PROPERTY_NAME_CURRENT_SPREADSHEET = "currentSpreadsheet";
	public static final String PROPERTY_NAME_STATUS_MESSAGE = "statusMessage";
	public static final String PROPERTY_NAME_PROGRESS = "progress";
	private static final String STATUS_MESSAGE_COMPARISON_FORMAT_STRING = "Comparing %s Sheets";
	private static final String STATUS_MESSAGE_TRANSFORM_FORMAT_STRING = "Transforming %s Comparisons to COBie Compare XML Document";
	private static final String STATUS_MESSAGE_INDEXING_BASELINE_FORMAT_STRING = "Indexing %s Sheet on baseline document";
	private static final String STATUS_MESSAGE_INDEXING_REVISION_FORMAT_STRING = "Indexing %s Sheet on revised document";
	private static final String STATUS_MESSAGE_INDEXING_FORMAT_STRING = "Indexing %s Sheet on document";
	private static final String STATUS_MESSAGE_INDEXING_GENERIC_FORMAT_STRING = "Indexing %s document";
	/**
	 * 
	 */
	private static final long serialVersionUID = -720996219318771417L;
	public enum ComparisonDocument{baseline,revision};
	public enum	CompareMode {Idle,Fetching,Indexing,Comparing,TransformingToDocument,Done}
	private CompareMode mode;
	
	private ComparisonDocument currentDocument;
	private CobieSheetName currentSpreadsheet;
	private String statusMessage;
	private int progress;
	
	public COBieCompareState()
	{
		mode = CompareMode.Idle;
		currentSpreadsheet = null;
		statusMessage = null;
		progress = NULL_PROGRESS;
	}
	
	public String getModeDisplayString()
	{
		String displayString = STATUS_MODE_IDLE;
		switch(mode)
		{
		case Comparing:
			displayString = STATUS_MODE_COMPARE;
			break;
		case Done:
			displayString = STATUS_MODE_DONE;
			break;
		case Idle:
			displayString = STATUS_MODE_IDLE;
			break;
		case Indexing:
			displayString = STATUS_MODE_INDEXING;
			break;
		case TransformingToDocument:
			displayString = STATUS_MODE_TRANSFORMING;
			break;
		case Fetching:
			displayString = STATUS_MODE_FETCHING;
			break;
		
		}
		return displayString;
	}
	
	private String getFetchingDisplayString()
	{
		String displayString  =STATUS_MODE_IDLE;
		if (currentDocument!=null)
		{
			displayString = currentDocument.name()+STATUS_MESSAGE_FETCHING_SUFFIX;
			
		}
		return displayString;
	}

	public CompareMode getMode()
	{
		return mode;
	}
	

	protected void setMode(CompareMode mode)
	{
		CompareMode oldMode = getMode();
		this.mode = mode;
		firePropertyChange(PROPERTY_NAME_MODE,oldMode,mode);
		if (mode==COBieCompareState.CompareMode.Done)
			setProgress(NULL_PROGRESS);
		setStatusMessage();
	}
	public CobieSheetName getCurrentSpreadsheet()
	{
		return currentSpreadsheet;
	}
	protected void setCurrentSpreadsheet(CobieSheetName currentSpreadsheet)
	{
		CobieSheetName oldSheet = this.getCurrentSpreadsheet();
		this.currentSpreadsheet = currentSpreadsheet;
		firePropertyChange(PROPERTY_NAME_CURRENT_SPREADSHEET,oldSheet,currentSpreadsheet);
		setStatusMessage();
	}
	public String getStatusMessage()
	{
		return statusMessage;
	}
	

	private void setStatusMessage()
	{
		String oldStatusMessage = getStatusMessage();
		String newStatusMessage = STATUS_MODE_IDLE;
		switch(mode)
		{
			case Comparing:
				newStatusMessage = getComparingStatusMessage();
				break;
			case Done:
				newStatusMessage = STATUS_MESSAGE_DONE;
				break;
			case Idle:
				newStatusMessage = null;
				break;
			case TransformingToDocument:
				newStatusMessage = getTransformingStatusMessage();
				break;
		case Indexing:
				newStatusMessage = getIndexingStatusMessage();
			break;
		case Fetching:
				newStatusMessage = getFetchingDisplayString();
			break;
		}
		this.statusMessage = newStatusMessage;
		firePropertyChange(PROPERTY_NAME_STATUS_MESSAGE,oldStatusMessage,newStatusMessage);
	}
	
	@SuppressWarnings("unused")
	private String getIndexingStatusMessageDetailed()
	{
		String indexingMessage = STATUS_MODE_IDLE;
		if(getCurrentSpreadsheet()!=null)
		{
			String currentSpreadsheetName =
					getCurrentSpreadsheet().name();
			if (currentDocument!=null)
			{
				switch(currentDocument)
				{
				case baseline:
					indexingMessage = String.format(STATUS_MESSAGE_INDEXING_BASELINE_FORMAT_STRING, currentSpreadsheetName);
					break;
				case revision:
					indexingMessage = String.format(STATUS_MESSAGE_INDEXING_REVISION_FORMAT_STRING, currentSpreadsheetName);
					break;
				}
			}
			else
				indexingMessage = String.format(STATUS_MESSAGE_INDEXING_FORMAT_STRING, currentSpreadsheetName);
		}
		return indexingMessage;
	}
	
	private String getIndexingStatusMessage()
	{
		String indexingMessage = STATUS_MODE_IDLE;
		if (currentDocument!=null)
			indexingMessage = String.format(STATUS_MESSAGE_INDEXING_GENERIC_FORMAT_STRING, currentDocument.name());
		return indexingMessage;
	}

	private String getComparingStatusMessage()
	{
		String comparisonMessage = STATUS_MODE_IDLE;
		if(getCurrentSpreadsheet()!=null)
		{
			String currentSpreadsheetName =
					getCurrentSpreadsheet().name();
			comparisonMessage = String.format(STATUS_MESSAGE_COMPARISON_FORMAT_STRING, currentSpreadsheetName);
		}
		return comparisonMessage;
	}
	
	private String getTransformingStatusMessage()
	{
		String transformingStatusMessage = STATUS_MODE_IDLE;
		if(getCurrentSpreadsheet()!=null)
		{
			String currentSpreadsheetName =
					getCurrentSpreadsheet().name();
			transformingStatusMessage = String.format(STATUS_MESSAGE_TRANSFORM_FORMAT_STRING, currentSpreadsheetName);
		}
		return transformingStatusMessage;
	}
	
	public int getProgress()
	{
		return progress;
	}
	
	protected void setProgress(int progress)
	{
		int oldProgress = this.getProgress();
		this.progress = progress;
		firePropertyChange(PROPERTY_NAME_PROGRESS, oldProgress, progress);
		setStatusMessage();
	}

	public ComparisonDocument getCurrentDocument()
	{
		return currentDocument;
	}

	protected void setCurrentDocument(ComparisonDocument currentDocument)
	{
		this.currentDocument = currentDocument;
		setStatusMessage();
	}
		
}
