package com.altova.db;

import java.sql.Connection;
import java.util.HashMap;

public class Catalog 
{
	private Connection connection = null;
	private HashMap<Integer, Statement> map = new HashMap<Integer, Statement>();
	private int visible = 1;
	private boolean isTarget = false;
	private int queryTimeout = 60;

	public Catalog(Connection conn, int timeout )
	{
		connection = conn;
		queryTimeout = timeout;
	}

	public Catalog(Connection conn, int timeout, boolean target)
	{
		connection = conn;
		queryTimeout = timeout;
		isTarget = target;
	}
	
	public void close() throws Exception
	{
		if (isTarget)
			connection.close();
			
		freeConnection();
	}
	
	public void freeConnection() throws Exception
	{
		if (isTarget)
			return;

		visible--;
		if (visible == 0)
			connection.close();
	}
	
	public void allocateConnection()
	{
		if (isTarget)
			return;
			
		visible++;
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public int getQueryTimeout()
	{
		return queryTimeout;
	}
	
	public Statement createStatement(int id, String statement_string) throws Exception
	{
		Statement statement = new Statement(this, statement_string);
		map.put(id, statement);
		return statement;
	}
	
	public Statement getStatement(int id)
	{
		return map.get(id);
	}
}
