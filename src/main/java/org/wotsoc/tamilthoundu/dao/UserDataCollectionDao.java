/**
 * @author Rajamani David
 * @since	Mar 21, 2018
 *
 */
package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.wotsoc.tamilthoundu.domain.UserDataCollection;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

/**
 * @author rdavid
 *
 */
public class UserDataCollectionDao 
{
	public void addUserDataCollection(List<UserDataCollection> udcList) throws SQLException
	{
		for(UserDataCollection udc:udcList)
		{
			insertSQL(udc);
		}
	}

	public List<UserDataCollection> getUserControlsByUser(String userName) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		
		StringBuilder sb =new StringBuilder();
		
		sb.append("select udc.* from public.user_data_collection udc, public.project_profile_map ppm, public.user u");
		sb.append(" where ppm.project_id = udc.project_id and u.user_name=? order by udc.project_id,udc.page_id, udc.position_id");
		
 		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setString(1, userName);
 		return getUserDataCollection(ps.executeQuery());
	}
	
	private List<UserDataCollection> getUserDataCollection(ResultSet rs) throws SQLException
	{
		Set<UserDataCollection> udcList = new HashSet<UserDataCollection>();
		UserDataCollection udc = null;
		while(rs.next())
		{
			//project_Id,Page_id,position_id,control_id,value_id,image_value,text_value,number_value,date_value,boolean_value
			//add_user,add_time,update_user,update_time,verify_user,verify_time,active
			udc = new UserDataCollection();
			udc.setUdcId(rs.getInt("Udc_Id"));
			udc.setProjectId(rs.getInt("project_id"));
			udc.setPageId(rs.getInt("Page_id"));
			udc.setPositionId(rs.getDouble("position_id"));
			udc.setControlId(rs.getInt("control_id"));
			udc.setValueId(rs.getInt("value_id"));
			udc.setImageValue(udc.getImageValue());
			udc.setTextValue(rs.getString("text_value"));
			udc.setNumberValue(rs.getBigDecimal("number_value"));
			udc.setDateValue(rs.getDate("date_value"));
			udc.setBooleanValue(rs.getBoolean("boolean_value")); 
			udc.setAddUser(rs.getString("add_user"));
			udc.setAddTime(rs.getTimestamp("add_time"));
			udc.setUpdateUser(rs.getString("update_user"));
			udc.setUpdateTime(rs.getDate("update_time"));
			udc.setVerifyUser(rs.getString("verify_user"));
			udc.setVerifyTime(rs.getDate("verify_time"));
			udc.setActive(rs.getBoolean("active"));
			udcList.add(udc);
		}
		return new ArrayList<UserDataCollection>(udcList);
	}

	public void insertSQL(UserDataCollection udc) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		
		StringBuilder sb =new StringBuilder();
		sb.append("INSERT INTO public.user_data_collection(");
		sb.append("project_Id,Page_id,position_id,control_id,value_id,image_value,text_value,number_value,date_value,boolean_value,");
		sb.append("add_user,add_time,update_user,update_time,verify_user,verify_time,active");
		sb.append(" )");
		sb.append("VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?);");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setInt(1, udc.getProjectId());
		ps.setInt(2, udc.getPageId());
		ps.setDouble(3, udc.getPositionId());
		ps.setInt(4, udc.getControlId());
		ps.setInt(5, udc.getValueId());
		
		if(udc.getImageValue()==null)
			ps.setNull(6, Types.BINARY);
		else
			ps.setBinaryStream(6, udc.getImageValue());
		
		ps.setString(7, udc.getTextValue());
		ps.setBigDecimal(8, udc.getNumberValue());
		ps.setDate(9, udc.getDateValue()==null?null:new java.sql.Date(udc.getDateValue().getTime()));
		ps.setBoolean(10, udc.isBooleanValue()==null?Boolean.FALSE:udc.isBooleanValue()); 
		ps.setString(11, udc.getAddUser());
		ps.setTimestamp(12, udc.getAddTime()==null?null:new Timestamp(udc.getAddTime().getTime()));
		ps.setString(13, udc.getUpdateUser());
		ps.setTimestamp(14, udc.getUpdateTime()==null?null:new Timestamp(udc.getUpdateTime().getTime()));
		ps.setString(15, udc.getVerifyUser());
		ps.setTimestamp(16, udc.getVerifyTime()==null?null:new Timestamp(udc.getVerifyTime().getTime()));
		ps.setBoolean(17, Boolean.TRUE);
		ps.execute();
	}
	
	public static void mainOld(String args[]) throws SQLException
	{
		UserDataCollectionDao udcD = new UserDataCollectionDao();
		List<UserDataCollection> udcList =new ArrayList<UserDataCollection>(); 

		UserDataCollection udc = new UserDataCollection(		
				1,1,2,1.0,1,1,null,"Verb",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,2.1,2,1,null,"Tamil",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,2.2,2,1,null,"Y",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,3.0,3,1,null,"Y",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,3.1,3,2,null,"Noun",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,1.0,1,2,null,"Tamil",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,2.0,1,2,null,"Y",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,2.1,1,2,null,"Y",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,3.0,1,3,null,"Noun",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,1.0,4,3,null,"Tamil",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,4.1,4,3,null,"English",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udc = new UserDataCollection(		
				1,1,2,4.2,1,3,null,"Y",null,null,null,"raj",new Date(),null,null,null,null,true);
		udcList .add(udc);
		udcD.addUserDataCollection(udcList);
	}

	public static void main(String args[]) throws SQLException
	{
		UserDataCollectionDao udcDao = new UserDataCollectionDao();
		System.out.println(udcDao.getUserControlsByUser("raj"));
	}
}
