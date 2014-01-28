package org.erdc.cobie.sqlite.string;

import org.erdc.cobie.shared.utils.StringTable;
import org.erdc.cobie.shared.utils.StringUtils;

public enum Error implements StringTable
{
	COLLECTION_TYPE_NOT_SUPPORTED("The supplied collection (%s) is not supported by CobieCollectionSerializer."),
	COLUMN_DOES_NOT_EXIST("The specified column (%s) does not exist in this collection."),
	//COLUMN_ALREADY_EXISTS("The supplied column (%s) cannot be added to this Row because it already exists."),
	//COLUMN_ARRAYS_INCONSISTENT("The supplied column arrays (columnNames & columnValues) do not match."),
	DATABASE_CONNECTION_FAILED("Database connection (%s) could not be initialized."), 
	DATABASE_INPUT_STREAM_FAILED("An InputStream could not be generated with the supplied path (%s)."),
	DATABASE_SERVER_INIT_FAILED("Database driver (%s) initialization failed."),
	ENTITY_INIT_FAILURE("Supplied entity (%s) cannot be instantiated."),
	ENTITY_KEY_NOT_SET("Entity (%s) has not been set!"),
	INVALID_COLUMN_TYPE("The supplied type (%s) is not currently supported as a Column value type."),
	INVALID_COLUMN_VALUE("The supplied parameter (%s) does not match the type (%s) stored in this column."),
	LAST_INSERT_ROWID_FAILED("Could not retrieve Last Insert ROWID."),
	QUERY_EXECUTION_FAILED("Query execution failed.\nQuery contents: %s\nQuery result: %s"),	
	RELATIONSHIP_INIT_FAILURE("Supplied relationship (%s) cannot be instantiated."),
	ROW_INSTANTIATION_FAILURE("Row instantiation failure!"),
	SELECT_UNIQUE_REQUIRED("The supplied query cannot be used to select a unique Entity instance. This method should be passed a select query that returns a single result."),
	VALUE_TYPE_NOT_SUPPORTED("The supplied value type (%s) is not currently supported.");
	
	private final String string;
	
	private Error(String string)
	{
		this.string = string;
	}

	@Override
	public String format(Object... args)
	{
		return String.format(string, args);
	}

	@Override
	public String postfix(String s)
	{
		return StringUtils.concatenate(string, s, Default.TEXT_SEPARATOR.toString());
	}

	@Override
	public String prefix(String s)
	{
		return StringUtils.concatenate(s, string, Default.TEXT_SEPARATOR.toString());
	}

	@Override
	public String toString()
	{
		return string;
	}
}
