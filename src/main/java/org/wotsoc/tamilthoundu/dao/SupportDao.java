/**
 * @author Rajamani David
 * @since	Mar 20, 2016
 *
 */
package org.wotsoc.tamilthoundu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.Support;
import org.wotsoc.tamilthoundu.jdbc.JDBCConnection;
import org.wotsoc.tamilthoundu.jdbc.PreparedStatementParameter;

/**
 * @author rdavid
 *
 */
public class SupportDao 
{
	public SupportDao() 
	{
		// TODO Auto-generated constructor stub
	}

	public Support insertMessage(Support support) throws Exception
	{
		StringBuffer buff=new StringBuffer();
		buff.append("INSERT INTO movvies.support (user_name,email_id,message,status,open_time)");
		buff.append(" VALUES (?,?,?,'NEW',sysdate()); ");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		list.add(new PreparedStatementParameter(support.getUserName(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(support.getEmailId(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(support.getMessage(),Types.VARCHAR));
		//list.add(new PreparedStatementParameter(new java.util.Date(),Types.DATE));
		  
		int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		if(count>0)
		{
			return support;
		}
		return null;	
	}
	
	public Support updateMessage(Support support) throws Exception
	{
		StringBuffer buff=new StringBuffer();
		buff.append("update movvies.support set update_time=sysdate() ");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		if(support.getMessage()!=null)
		{
			buff.append(", message = ? ");
			list.add(new PreparedStatementParameter(support.getMessage(),Types.VARCHAR));
		}
		if(support.getStatus()!=null)
		{
			buff.append(", status = ? ");
			list.add(new PreparedStatementParameter(support.getStatus().getConstant(),Types.VARCHAR));
		}	
		if(support.getSolution()!=null)
		{
			buff.append(", solution = ? ");
			list.add(new PreparedStatementParameter(support.getSolution(),Types.VARCHAR));
		}
		if(support.getGivenBy()!=null)
		{
			buff.append(", given_by = ? ");
			list.add(new PreparedStatementParameter(support.getGivenBy(),Types.VARCHAR));
		}
		
		if(support.getEmailId()!=null)
		{
			buff.append(" where email_id =? ");
			list.add(new PreparedStatementParameter(support.getEmailId(),Types.VARCHAR));
		}
		else if(support.getUserName()!=null)
		{
			buff.append(" where user_name =? ");
			list.add(new PreparedStatementParameter(support.getEmailId(),Types.VARCHAR));
		}

		int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		if(count>0)
		{
			return support;
		}
		return null;	
	}
	
	public List<Support> getMessages(Support support)  throws Exception
	{
		StringBuffer buff=new StringBuffer();
		buff.append("select * from movvies.support ");
		if(support!=null)
			buff.append(" where 1=1 ");
		
		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		if(support.getMessage()!=null)
		{
			buff.append(" and message like ? ");
			list.add(new PreparedStatementParameter(support.getMessage(),Types.OTHER));
		}
		if(support.getStatus()!=null)
		{
			buff.append(" and status like ? ");
			list.add(new PreparedStatementParameter(support.getStatus(),Types.OTHER));
		}	
		if(support.getEmailId()!=null)
		{
			buff.append(" and email_id like ? ");
			list.add(new PreparedStatementParameter(support.getEmailId(),Types.OTHER));
		}
		if(support.getUserName()!=null)
		{
			buff.append(" and user_name like ? ");
			list.add(new PreparedStatementParameter(support.getEmailId(),Types.OTHER));
		}
		List<Support> supportList =new ArrayList<Support>();
		ResultSet  rs= JDBCConnection .getInstance().executeSQL(buff.toString(),list);
		while(rs.next())
			supportList .add(getSupportFromResultSet(rs));
		
		return supportList;
	}
	
	public Support getSupportFromResultSet(ResultSet rs) throws SQLException
	{
		Support support = new Support();
		support.setSupportId((Integer)rs.getObject("support_id"));
		String status=(String)rs.getObject("status");
		support.setStatus(Support.SupportConstants.valueOf(status));
		support.setEmailId((String)rs.getObject("email_id"));
		support.setMessage((String)rs.getObject("message"));
		return support;
	}
	
	public static void main(String args[]) throws Exception
	{
		SupportDao sDao =new SupportDao();
		Support support =new Support();
		support.setEmailId("drajamanik@gmail.com");
		support.setMessage("Trouble Login to website");
		support.setUserName("Rajamani David");
		sDao.insertMessage(support);
		
		support =new Support();
		support.setEmailId("drajamanik@gmail.com");
		
		List<Support> supportList=sDao. getMessages(support);
		support=supportList.get(0);
		support.setStatus(Support.SupportConstants.CLOSED);
		support.setSolution("No issue");
		support.setGivenBy("Basker");

		sDao.updateMessage(support);
	}
}
