package org.bimserver.cobie.satellite.tasks;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.bimserver.cobie.satellite.CobieSatelliteServer;
import org.bimserver.shared.cobie.compare.COBieCompareResult;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class BiMServerCompareTask extends CompareTask implements BimServerTaskConnectable
{
	private long roid1,roid2;
	public long getRoid2()
	{
		return roid2;
	}

	public void setRoid2(long roid2)
	{
		this.roid2 = roid2;
	}

	public long getRoid1()
	{
		return roid1;
	}

	public void setRoid1(long roid1)
	{
		this.roid1 = roid1;
	}

	private CobieSatelliteServer cobieSatelliteServer;
	public BiMServerCompareTask(final CobieSatelliteServer cobieSatelliteServer,long roid1, long roid2,
			String reportFilePath,
			Informable informable,boolean requiresRunningBiMServer)
	{
		
		super(informable,requiresRunningBiMServer);
		this.cobieSatelliteServer = cobieSatelliteServer;
		this.roid1= roid1;
		this.roid2 = roid2;
		setReportFilePath(reportFilePath);
		setWritesReportFile(true);
	}
	
	public BiMServerCompareTask(Informable informable,
			final CobieSatelliteServer satelliteServer,boolean requiresRunningBiMServer)
	{
		super(informable,requiresRunningBiMServer);
		this.cobieSatelliteServer = satelliteServer;
	}

	@Override
	protected void performComparison() throws ServerException, UserException, XmlException, IOException,Exception
	{
		super.getCompareResult().initializeBiMServerCompare(roid1, roid2,cobieSatelliteServer.getBimServerWorkerClient().getServiceInterface());
		super.performComparison();
	//	setCompareResult(new 
				//COBieCompareResult(roid1,roid2,cobieSatelliteServer.getBimServerWorkerClient().getServiceInterface()));
	}

	@Override
	public CobieSatelliteServer getSatelliteServer()
	{
		// TODO Auto-generated method stub
		return cobieSatelliteServer;
	}

	@Override
	public void setSatelliteServer(final CobieSatelliteServer satelliteServer)
	{
		this.cobieSatelliteServer = satelliteServer;
		
	}
}
