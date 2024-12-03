/**
 * @author Rajamani David
 * @since	Jun 13, 2018
 *
 */
package org.wotsoc.tamilthoundu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author rdavid
 *
 */
public class SQLLiteConnection 
{
	private  Connection conn =null; 
	private static SQLLiteConnection ps =null;
	
	private SQLLiteConnection()
	{
		
	}
	
	public Connection getConnetion()
	{
		return conn;
	}
	
	public static SQLLiteConnection getInstance()
	{
		if(ps==null)
		{
			ps = new SQLLiteConnection();
			try {
				ps.connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ps =null;
			}
		}
		return ps;
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
			try 
			{
				conn=localConnect();
			} catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return conn;
	}
	
	public Connection connect() throws SQLException
	{
		conn = getConnectionByContext();
		return conn;
	}
	
	public Connection localConnect() throws SQLException
	{
		String url = "jdbc:sqlite:C:/sqlite/db/tamilthoundu.db";
		conn = DriverManager.getConnection(url);
		return conn ;
	}
	
	public ResultSet querySQL(String stringSQL) throws SQLException
	{
		PreparedStatement ps =conn.prepareStatement(stringSQL);
		return ps.executeQuery();
	}
	
	public static void main(String args[]) throws SQLException
	{
		SQLLiteConnection pd = new SQLLiteConnection();
		pd.connect();
	}

}
