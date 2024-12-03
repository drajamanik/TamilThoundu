/**
 * @author Rajamani David
 * @since	Mar 31, 2017
 *
 */
package org.wotsoc.tamilthoundu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

/**
 * @author rdavid
 *
 */
public class PostgresSQLDatabase 
{
	private  Connection conn =null; 
	private static PostgresSQLDatabase ps =null;
	
	private PostgresSQLDatabase()
	{
		
	}
	
	public Connection getConnetion()
	{
		return conn;
	}
	
	public static PostgresSQLDatabase getInstance()
	{
		if(ps==null)
		{
			ps = new PostgresSQLDatabase();
			try {
				ps.connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ps =null;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ps =null;
			}
		}
		if(ps!=null && ps.conn==null)
			try{
				//ps.connect();
				ps.localConnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ps =null;
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
			PGSimpleDataSource dataSource =
				    (PGSimpleDataSource) ds;
			dataSource .setReWriteBatchedInserts(true);
			return dataSource.getConnection();
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
	
	public Connection connect() throws SQLException, ClassNotFoundException
	{
		//String url = "jdbc:postgresql://localhost/mydatabase?user=postgres&password=rajamani&ssl=false";
		//String url = "jdbc:postgresql://localhost/postgres?user=postgres&password=rajamani&ssl=false";
		String url = "jdbc:postgresql://147.135.46.77:5433/postgres?user=postgres&password=rajamani&ssl=false";
		//String url = "jdbc:postgresql://147.135.46.77:5432/DataCapture?user=postgres&password=postgres&ssl=false&reWriteBatchedInserts=true";
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(url);
		System.out.println("Connection:"+conn); 
		//conn = getConnectionByContext();
		return conn;
	}
	
	public void close() throws SQLException {
		conn.close();
	}
	
	public Connection localConnect() throws SQLException
	{
		//String url = "jdbc:postgresql://localhost/mydatabase?user=postgres&password=rajamani&ssl=false";
		String url = "jdbc:postgresql://147.135.46.77:5432/DataCapture?user=postgres&password=postgres&ssl=false&reWriteBatchedInserts=true";
		conn = DriverManager.getConnection(url);
		return conn ;
	}
	
	public ResultSet querySQL(String stringSQL) throws SQLException
	{
		PreparedStatement ps =conn.prepareStatement(stringSQL);
		return ps.executeQuery();
	}
	
	public void executeWordClassifySQL(Integer no, String type) throws SQLException
	{
		StringBuilder sb =new StringBuilder();
		sb.append("INSERT INTO public.\"Word_Classify_Type\"(");
		sb.append("\"Classify_No\",\"Classify_Type\"");
		sb.append(" )");
		sb.append("VALUES (?,?);");
		PreparedStatement ps =conn.prepareStatement(sb.toString());
		ps.setInt(1, no);
		ps.setString(2, type);
		
		ps.execute();
	}

	public PreparedStatement  executeWordTableSQL() throws SQLException
	{
		StringBuilder sb =new StringBuilder();
		sb.append("INSERT INTO public.\"Word_Table\"(");
		sb.append("\"Word\"");
		sb.append(",\"frequency\"");
		sb.append(",\"Source\"");
		sb.append(" )");
		sb.append("VALUES (?,?,?);");
		return conn.prepareStatement(sb.toString());
	}
	
	public void executeWordTableSQL(String word, Integer frequency,String source,boolean executeBatch,PreparedStatement ps) throws SQLException
	{
//		StringBuilder sb =new StringBuilder();
//		sb.append("INSERT INTO public.\"Word_Table\"(");
//		sb.append("\"Word\"");
//		sb.append(",\"frequency\"");
//		sb.append(",\"Source\"");
//		sb.append(" )");
//		sb.append("VALUES (?,?,?);");
//		PreparedStatement ps =conn.prepareStatement(sb.toString());
		ps.setString(1, word);
		ps.setInt(2, frequency);
		ps.setString(3, source);
		ps.addBatch();
		if(executeBatch)
			ps.executeBatch();
	}
	
	public void executePageControlSQL(String sql) throws SQLException
	{
		StringBuilder sb =new StringBuilder();
		sb.append("INSERT INTO public.page_control(");
		sb.append("project_id,page_id,position_id,control_id,name_id,default_value,");
		sb.append("data_type,field_help,add_user,add_time,update_user,update_time,verify_user,verify_time,active");
		sb.append(" )");
		sb.append("VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?);");
		PreparedStatement ps =conn.prepareStatement(sb.toString());
		ps.setString(1, sql);
		ps.execute();
	}

	public static void main(String args[]) throws Exception
	{
		PostgresSQLDatabase pd = new PostgresSQLDatabase();
		Connection conn=pd.connect();
		
		ReadFromFile rff = new ReadFromFile();
		Map<String,String> strMap=rff.readFileAsMap("C:\\Workspaces\\TamilThoundu\\News.txt");
 		Set<String> setStr= strMap.keySet();
 		int index=0;
 		String temp ="";
 		boolean executeFlag = false;
 		int counter=0;
 		PreparedStatement ps = pd.executeWordTableSQL();
 		//conn.setAutoCommit(false);
		for(String set:setStr) {
			if(index>10000) {
				executeFlag =true;
				index=0;
				System.out.println(counter++);
			}else {
				executeFlag =false;
			}
			temp = set;
			set = set.replace("­", "");
			set = set.trim();
			try {
			pd.executeWordTableSQL(set, Integer.parseInt(strMap.get(temp).trim()),"News",executeFlag,ps);
			}catch(Exception exp) {
				System.out.println(set+":"+temp);
			}
			index ++;
		}
		//conn.commit();
		pd.close();
	}

}
