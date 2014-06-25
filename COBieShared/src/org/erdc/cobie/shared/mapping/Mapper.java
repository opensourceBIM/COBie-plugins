package org.erdc.cobie.shared.mapping;

import org.erdc.cobie.shared.LoggerUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.altova.TraceTarget;

public abstract class Mapper implements LoggerUser, TraceTarget
{
	public abstract void run() throws Exception;

	public void writeTrace(String info)
	{
		getLogger().info(info);
		
	}

	@Override
	public final Logger getLogger()
	{
		return LoggerFactory.getLogger(this.getClass());
	}	

}
