package org.bimserver.cobie.satellite.tasks;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.bimserver.cobie.cobielite.COBIEDocument;
import org.bimserver.shared.cobie.compare.COBieCompareState;
import org.bimserver.shared.cobie.merge.COBieIDMMerger;
import org.bimserver.shared.cobie.merge.COBieMergeIDMItem;
import org.bimserver.shared.cobie.merge.COBieMergeState;

public class COBieMergeIDMTask extends ApplicationTask<COBIEDocument> implements PropertyChangeListener
{

	private static final String STATUS_MESSAGE_EXCEPTION = "Operation canceled";
	private static final String STATUS_MESSAGE_DONE = "Merge Done";
	private COBieIDMMerger cobieMerger;
	
	public COBieMergeIDMTask(COBieMergeIDMItem baseItem, COBieMergeIDMItem revisionItem,Informable informable,boolean requiresRunningBiMServer)
	{
		super(informable,requiresRunningBiMServer);
		cobieMerger = 
				new COBieIDMMerger(baseItem, revisionItem);
	}
	
	public COBieMergeIDMTask(Informable informable,boolean requiresRunningBiMServer)
	{
		super(informable,requiresRunningBiMServer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if(evt.getSource()==cobieMerger.getMergeState())
		{
			COBieMergeState mergeState = cobieMerger.getMergeState();
			String propertyName = evt.getPropertyName();
			if(propertyName.equals(COBieMergeState.PROPERTY_NAME_PROGRESS))
			{
				int compareProgress = mergeState.getProgress();
				if (compareProgress!=COBieMergeState.NULL_PROGRESS)
					setProgress(mergeState.getProgress());
			}
			else if (propertyName.equals(COBieMergeState.PROPERTY_NAME_STATUS_MESSAGE))
			{
				publish(new COBieTaskProgress(mergeState.getStatusMessage()));
			}
		}
		
	}

	@Override
	protected COBIEDocument doInBackground() throws Exception
	{
		// TODO Auto-generated method stub
		return cobieMerger.merge();
	}
	
	@Override
    public void done() 
    {
		
    	
    	if(isCancelled())
    	{
    		setProgress(0);
    		publish(new COBieTaskProgress(STATUS_MESSAGE_EXCEPTION));
    	}
    	else
    	{
    		setProgress(100);
    		publish(new COBieTaskProgress(STATUS_MESSAGE_DONE));
    	}
    	super.done();
    }

}
