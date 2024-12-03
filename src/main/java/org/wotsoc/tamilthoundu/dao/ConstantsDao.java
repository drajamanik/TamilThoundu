/**
 * @author Rajamani David
 * @since	Feb 13, 2016
 *
 */
package org.wotsoc.tamilthoundu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.Constants;
import org.wotsoc.tamilthoundu.jdbc.JDBCConnection;
import org.wotsoc.tamilthoundu.jdbc.PreparedStatementParameter;

/**
 * @author rdavid
 *
 */
public enum ConstantsDao 
{
	instance;
	static List<Constants> listConstants = new ArrayList<Constants>();

 	public List<Constants> getAllConstants(String key1,String key2, String key3) throws Exception
	{
		List<Constants> foundList =new ArrayList<Constants>();
		if(listConstants.size()==0)
		{
			listConstants.addAll(getAllConstants());
		}
		for(Constants cons:listConstants)
		{
			if(key1!=null && key1.equals(cons.getKey1()) )
			{
				if(key2==null || key2.equals(cons.getKey2()))
				{
					if (key3==null || key3.equals(cons.getKey3()))
					{
					foundList.add(cons);
					}
				}
			}
		}

		return foundList;
	}
	
	public List<Constants> getAllConstants() throws Exception
	{
		List<Constants> listConstants =new ArrayList<Constants>();
		StringBuffer buff=new StringBuffer();
		buff.append("select * from constants where active='Y' ");
		
		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		ResultSet rs  = JDBCConnection .getInstance().executeSQL(buff.toString(),list);
		Constants constant=null;
		while(rs.next())
		{
			constant=getConstantsFromResultSet(rs);
			if(constant!=null)
				listConstants.add(constant);
		}
		return listConstants;
	}
	
	public Constants getConstantsFromResultSet(ResultSet rs) throws SQLException
	{
		Constants constant = new Constants();
		constant.setConstantsId((Integer)rs.getObject("constants_Id"));
		constant.setKey1((String)rs.getObject("key1"));
		constant.setKey2((String)rs.getObject("key2")); 
		constant.setKey3((String)rs.getObject("key3")); 
		constant.setValue1((String)rs.getObject("value1"));
		constant.setValue2((String)rs.getObject("value2"));
		constant.setValue3((String)rs.getObject("value3"));
		constant.setActive((String)rs.getObject("active"));
		constant.setAddby((String)rs.getObject("addby"));
		
		Timestamp ts = null; 
		if(rs.getObject("addon")!=null)
		{
			ts=(Timestamp) rs.getObject("addon");
			constant.setAddon(new Date(ts.getTime())) ;
		}
		constant.setModifedby((String)rs.getObject("modifiedby"));
		if(rs.getObject("modifiedon")!=null)
			constant.setModifiedon(new Date( ((Timestamp) rs.getObject("modifiedon")).getTime())) ;
		return constant;
 	}
}
