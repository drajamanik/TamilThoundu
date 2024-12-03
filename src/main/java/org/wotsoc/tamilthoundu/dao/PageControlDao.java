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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.wotsoc.tamilthoundu.common.CommonUtil;
import org.wotsoc.tamilthoundu.domain.PageControl;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

/**
 * @author rdavid
 *
 */
public class PageControlDao 
{
	
	public void addPageControl(List<PageControl> pcList) throws SQLException
	{
		for(PageControl pc:pcList)
		{
			insertSQL(pc);
		}
	}
	
	public List<PageControl> getPageControls(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.page_control where active=true and project_Id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery());
	}
	
	public List<PageControl> getPageControls(Integer projectId) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.page_control where project_Id=?");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setInt(1, projectId);
		return getResultSet(ps.executeQuery());
	}
	
	public List<PageControl> getResultSet(ResultSet rs) throws SQLException
	{
		List<PageControl> pcList = new ArrayList<PageControl>();
		PageControl  pc=null;
		while(rs.next())
		{
			pc = new PageControl();
			pc.setPcId(rs.getInt("pc_id"));
			pc.setProjectId(rs.getInt("project_id"));
			pc.setPageId(rs.getInt("page_id"));
			pc.setPositionId(rs.getInt("position_id"));
			pc.setControlId(rs.getInt("control_id"));
			pc.setNameId(rs.getString("name_id"));
			pc.setDefaultValue(rs.getString("default_value"));
			pc.setDataType(rs.getString("data_type"));
			pc.setFieldHelp(rs.getString("field_help"));
			pc.setAddUser(rs.getString("add_user"));
			pc.setAddTime(rs.getTimestamp("add_time"));
			pc.setUpdateUser(rs.getString("update_user"));
			pc.setUpdateTime(rs.getTimestamp("update_time"));
			pc.setVerifyUser(rs.getString("verify_user"));
			pc.setVerifyTime(rs.getTimestamp("verify_time"));
			pc.setActive(rs.getBoolean("active"));
			pcList.add(pc);
		}
		return pcList;
	}
	
	public void insertSQL(PageControl pc) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		
		StringBuilder sb =new StringBuilder();
		sb.append("INSERT INTO public.page_control(");
		sb.append("project_id,page_id,position_id,control_id,name_id,default_value,");
		sb.append("data_type,field_help,add_user,add_time,update_user,update_time,verify_user,verify_time,active");
		sb.append(" )");
		sb.append("VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?);");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setInt(1, pc.getProjectId());
		ps.setInt(2, pc.getPageId());
		ps.setInt(3, pc.getPositionId());
		ps.setInt(4, pc.getControlId());
		ps.setString(5, pc.getNameId());
		ps.setString(6, pc.getDefaultValue());
		ps.setString(7, pc.getDataType());
		ps.setString(8, pc.getFieldHelp());
		ps.setString(9, pc.getAddUser());
		
		ps.setTimestamp(10, pc.getAddTime()==null?null:new Timestamp(pc.getAddTime().getTime()));
		ps.setString(11, pc.getUpdateUser());
		ps.setTimestamp(12, pc.getUpdateTime()==null?null:new Timestamp(pc.getUpdateTime().getTime()));
		ps.setString(13, pc.getVerifyUser());
		ps.setTimestamp(14, pc.getVerifyTime()==null?null:new Timestamp(pc.getVerifyTime().getTime()));
		ps.setBoolean(15, Boolean.TRUE);
		ps.execute();
	}
	
	public static void main(String args[]) throws SQLException
	{
		PageControlDao pcd = new PageControlDao();
		System.out.println(pcd.getPageControls(Arrays.asList(1,2)));
	}

}
