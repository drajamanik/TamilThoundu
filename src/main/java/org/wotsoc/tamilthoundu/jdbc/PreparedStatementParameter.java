package org.wotsoc.tamilthoundu.jdbc;


public class PreparedStatementParameter 
{
	public PreparedStatementParameter() 
	{
	
	}

	public PreparedStatementParameter(Object object, int type) 
	{
		this.object = object;
		this.SQLType = type;
	}

	private Object object;
	private int SQLType;

	public Object getObject() 
	{
		return object;
	}

	public void setObject(Object object) 
	{
		this.object = object;
	}

	public int getSQLType() 
	{
		return SQLType;
	}

	public void setSQLType(int type) 
	{
		SQLType = type;
	}

	public String toString() 
	{
		return object != null ? object.toString() : null;
	}
}
