/**
 * @author Rajamani David
 * @since	Nov 17, 2015
 *
 */
package org.wotsoc.tamilthoundu.jdbc;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.wotsoc.tamilthoundu.common.ConfigReader;


public class JDBCConnection 
{

	private static JDBCConnection onlyInstance;
	private Connection conn=null;
	
	private JDBCConnection() 
	{
		conn=getConnectionByContext();
		if(conn==null)
			conn=getLocalConnection();
	}
	
	public Connection getLocalConnection()
	{
		try 
		{
			String driverName=(String)ConfigReader.getValue("postgres.jdbc.driver");
			String url=(String)ConfigReader.getValue("postgres.jdbc.url");
			String userName=(String)ConfigReader.getValue("postgres.jdbc.username");
			String password=(String)ConfigReader.getValue("postgres.jdbc.password");
			
			Class.forName(driverName).newInstance();
		    conn = DriverManager.getConnection(url+"?user="+userName+"&password="+password);
		} catch (InstantiationException e) 
		{
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException ex) 
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
	
	public Connection getConnectionByContext() 
	{
		// Obtain our environment naming context
		Context initCtx;
		DataSource ds ;
		try 
		{
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			// Look up our data source
			//ds = (DataSource)envCtx.lookup("jdbc/DataCapture");
			ds = (DataSource)envCtx.lookup("jdbc/postgres");
		    return ds.getConnection();
		  
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static JDBCConnection getInstance()
	{
		if(onlyInstance ==null)
			onlyInstance =new JDBCConnection();
		return onlyInstance;
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	public ResultSet executeSQL(String sql) throws SQLException
	{
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			return ps.executeQuery();	
		}
	}

	public ResultSet executeSQL(String sql,List<PreparedStatementParameter> parameters) throws Exception
	{
			PreparedStatement ps = null;
			Connection conn= getConnection();
	 		conn = getConnection();
			ps = conn.prepareStatement(sql);
			setPreparedStatementParameters(ps, parameters);
			return ps.executeQuery();	
	}
	
	public int updateSQL(String sql,List<PreparedStatementParameter> parameters) throws Exception
	{
			PreparedStatement ps = null;
			Connection conn= getConnection();
	 		conn = getConnection();
			ps = conn.prepareStatement(sql);
			setPreparedStatementParameters(ps, parameters);
			return ps.executeUpdate();	
	}

	protected void setPreparedStatementParameters(PreparedStatement ps, List<PreparedStatementParameter> parameters) throws SQLException 
	{
		if (parameters != null && !parameters.isEmpty()) 
		{
			int index = 1;
			for (Iterator<PreparedStatementParameter> it = parameters.iterator(); it.hasNext(); index++) 
			{
				PreparedStatementParameter param =  it.next();
				if (param.getObject() == null) 
				{
					ps.setNull(index, param.getSQLType());
				}
				else if (param.getSQLType()==Types.VARCHAR)
				{
					ps.setString(index, (String)param.getObject());
				}
				else if (param.getSQLType()==Types.OTHER)
				{
					ps.setString(index, "%"+(String)param.getObject()+"%");
				}
				else if (param.getSQLType()==Types.DOUBLE)
				{
					ps.setDouble(index, (Double)param.getObject());
				}
				else if (param.getSQLType()==Types.TIMESTAMP)
				{
					ps.setTimestamp(index, (Timestamp)param.getObject());
				}
				else if (param.getSQLType()==Types.DATE)
				{
					ps.setDate(index, (Date)param.getObject());
				}
				else if (param.getSQLType()==Types.TIME_WITH_TIMEZONE)
				{
					try {
						long time= ((java.util.Date)param.getObject()).getTime(); 
						LocalDateTime  ldt = convertToLocalDateTimeViaSqlTimestamp(time);
						ps.setObject(index,ldt);
					}catch (Exception exp) {
						exp.printStackTrace();
					}
				}
				else if (param.getSQLType()==Types.BIGINT)
				{
					ps.setLong(index, (Long)param.getObject());
				}
				else if (param.getSQLType()==Types.INTEGER)
				{
					ps.setInt(index, (Integer)param.getObject());
				}
				else if (param.getSQLType()==Types.NCLOB)
				{
					ps.setClob(index, (Clob)param.getObject());
				}
				else 
				{
					ps.setObject(index, param.getObject(), param.getSQLType());
				}
			}
		}
	}
	
	public LocalDateTime convertToLocalDateTimeViaSqlTimestamp(long time) {
	    return new java.sql.Timestamp(time).toLocalDateTime();
	}
	
	public LocalDateTime convertToLocalDateTimeViaSqlTimestamp(java.util.Date dateToConvert) {
	    return new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime();
	}

	
	public static void main(String arags[]) throws Exception
	{
		ResultSet rs  =JDBCConnection .getInstance().executeSQL("select * from DataCapture.timestamp;");
		while(rs.next())
		{
			System.out.println( rs.getObject("No")+":"+rs.getObject("title"));
		}
	}

	
}
