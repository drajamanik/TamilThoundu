/**
 * @author Rajamani David
 * @since	Mar 21, 2018
 *
 */
package org.wotsoc.tamilthoundu.dao;

import java.io.IOException;
import java.io.InputStream;
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

import org.wotsoc.tamilthoundu.common.ImageConverter;
import org.wotsoc.tamilthoundu.domain.SystemDataCollection;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

/**
 * @author rdavid
 *
 */
public class SystemDataCollectionDao 
{
	public void addSystemDataCollection(List<SystemDataCollection> sdcList) throws SQLException
	{
		for(SystemDataCollection sdc:sdcList)
		{
			insertSQL(sdc);
			try {
				if(sdc.getImageValue()!=null)
					sdc.getImageValue().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<SystemDataCollection> getSystemControlsByUser(String userName) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		
		StringBuilder sb =new StringBuilder();
		
		sb.append("select * from public.system_data_collection udc, public.project_profile_map ppm, public.user u,public.project_data_setup pds ");
		sb.append(" where ppm.project_id = udc.project_id and u.user_name=? and pds.sent=false and pds.received=false ");
		sb.append(" order by udc.project_id,udc.page_id, udc.position_id");
		System.out.println(sb);
 		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setString(1, userName);
 		return getSystemDataCollection(ps.executeQuery());
	}
	
	private List<SystemDataCollection> getSystemDataCollection(ResultSet rs) throws SQLException
	{
		Set<SystemDataCollection> udcList = new HashSet<SystemDataCollection>();
		SystemDataCollection udc = null;
		while(rs.next())
		{
			//project_Id,Page_id,position_id,control_id,value_id,image_value,text_value,number_value,date_value,boolean_value
			//add_user,add_time,update_user,update_time,verify_user,verify_time,active
			udc = new SystemDataCollection();
			udc.setSdcId(rs.getInt("Sdc_Id"));
			udc.setProjectId(rs.getInt("project_id"));
			udc.setPageId(rs.getInt("Page_id"));
			udc.setPositionId(rs.getDouble("position_id"));
			udc.setControlId(rs.getInt("control_id"));
			udc.setValueId(rs.getInt("value_id"));
			udc.setImageValue(rs.getBinaryStream("image_value"));
			udc.setImageName(rs.getString("image_name"));
			udc.setImageLength(rs.getLong("image_length"));
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
		return new ArrayList<SystemDataCollection>(udcList);
	}
	
	public void insertSQL(SystemDataCollection sdc) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		
		StringBuilder sb =new StringBuilder();
		sb.append("INSERT INTO public.system_data_collection(");
		sb.append("project_Id,Page_id,position_id,control_id,value_id,image_value,text_value,number_value,date_value,boolean_value,");
		sb.append("add_user,add_time,update_user,update_time,verify_user,verify_time,active,image_name,image_length");
		sb.append(" )");
		sb.append("VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?);");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setInt(1, sdc.getProjectId());
		ps.setInt(2, sdc.getPageId());
		ps.setDouble(3, sdc.getPositionId());
		ps.setInt(4, sdc.getControlId());
		ps.setInt(5, sdc.getValueId());
		
		if(sdc.getImageValue()==null)
			ps.setNull(6, Types.BINARY);
		else
			ps.setBinaryStream(6, sdc.getImageValue());
		
		ps.setString(7, sdc.getTextValue());
		ps.setBigDecimal(8, sdc.getNumberValue());
		ps.setDate(9, sdc.getDateValue()==null?null:new java.sql.Date(sdc.getDateValue().getTime()));
		ps.setBoolean(10, sdc.isBooleanValue()==null?Boolean.FALSE:sdc.isBooleanValue()); 
		ps.setString(11, sdc.getAddUser());
		ps.setTimestamp(12, sdc.getAddTime()==null?null:new Timestamp(sdc.getAddTime().getTime()));
		ps.setString(13, sdc.getUpdateUser());
		ps.setTimestamp(14, sdc.getUpdateTime()==null?null:new Timestamp(sdc.getUpdateTime().getTime()));
		ps.setString(15, sdc.getVerifyUser());
		ps.setTimestamp(16, sdc.getVerifyTime()==null?null:new Timestamp(sdc.getVerifyTime().getTime()));
		ps.setBoolean(17, Boolean.TRUE);
		ps.setString(18, sdc.getImageName());
		ps.setLong(19, sdc.getImageLength());
		ps.execute();
	}
	
	public static void mainOld(String args[]) throws SQLException
	{
		SystemDataCollectionDao sdcD = new SystemDataCollectionDao();
		List<SystemDataCollection> sdcList =new ArrayList<SystemDataCollection>(); 

		for(int i=1;i<=50;i++)
		{
			String fileName = "C:\\tamil\\Sandilyan\\Kadal Vendhan\\page"+i+".jpg";
			ImageConverter ic =new ImageConverter();
			//String fileContent=ic.convertToString(fileName);
			Object[] fileContent=ic.convertToStream(fileName);
			SystemDataCollection sdc = new SystemDataCollection(		
					2,2,1,1.0,1, i,(InputStream)fileContent[0],(String)fileContent[1],(Long)fileContent[2],null,null,null,null,"raj",new Date(),null,null,null,null,true);
			sdcList .add(sdc);
		}
 		sdcD.addSystemDataCollection(sdcList);
	}

	public static void main(String args[]) throws SQLException
	{
		SystemDataCollectionDao udcDao = new SystemDataCollectionDao();
		System.out.println(udcDao.getSystemControlsByUser("raj"));
	}
}
