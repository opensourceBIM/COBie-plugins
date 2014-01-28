package org.erdc.cobie.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.erdc.cobie.shared.enums.string.Common;
import org.erdc.cobie.sqlite.string.Error;

public class Connector
{
	private static final int TIME_OUT = 30;
	
	private Connection connection;
	private final String databasePath;
	private final String databaseServerPath;
	private String userName;
	private String password;
	
	public Connector(String databasePath, String databaseServerPath)
	{
		this(databasePath, databaseServerPath, Common.EMPTY_STRING.toString(), Common.EMPTY_STRING.toString());
	}
	
	public Connector(String databasePath, String databaseServerPath, String userName, String password)
	{
		this.databasePath = databasePath;
		this.databaseServerPath = databaseServerPath;
		this.userName = userName;
		this.password = password;
	}
	
	public void connect() throws CobieSQLiteException
	{
		try
		{
			Class.forName(getDatabaseServerPath());
			connection = DriverManager.getConnection(getDatabasePath(), getUserName(), getPassword());	
		}

		catch (ClassNotFoundException e)
		{
			throw new CobieSQLiteException(this.getClass(), Error.DATABASE_SERVER_INIT_FAILED.format(getDatabaseServerPath()), e);
		}
		
		catch (SQLException e)
		{
			throw new CobieSQLiteException(this.getClass(), Error.DATABASE_CONNECTION_FAILED.format(getDatabasePath()), e);
		}
	}
	
	public final Connection getConnection() throws CobieSQLiteException
	{		
		return connection;
	}
	
	public final String getDatabasePath()
	{
		return databasePath;
	}
	
	public final String getDatabaseServerPath()
	{
		return databaseServerPath;
	}
	
	protected final String getPassword()
	{
		return password;
	}
	
	protected final String getUserName()
	{
		return userName;
	}
	
	public final boolean isConnected()
	{
		boolean isConnected = false;
		
		try 
		{
			isConnected = connection.isValid(TIME_OUT);
		} 
		
		catch (SQLException e) 
		{
			// No code needed.
		}
		
		return isConnected;
	}
	
	public final void setCredentials(String userName, String password)
	{
		setUserName(userName);
		setPassword(password);
	}
	
	private void setPassword(String password)
	{
		this.password = password;
	}
	
	private void setUserName(String userName)
	{
		this.userName = userName;
	}
}
