package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.wotsoc.tamilthoundu.common.CommonUtil;
import org.wotsoc.tamilthoundu.domain.ProjectProfile;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

public class ProjectProfileDao {
	public List<ProjectProfile> getProfiles(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.project_profile where profile_Id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery());
	}
	
	public List<ProjectProfile> getResultSet(ResultSet rs) throws SQLException
	{
		List<ProjectProfile> pList = new ArrayList<ProjectProfile>();
		ProjectProfile  p=null;
		while(rs.next())
		{
			p = new ProjectProfile();
			p.setProfileId(rs.getInt("profile_Id"));
			p.setProfileName(rs.getString("profile_name"));
			p.setProfileType(rs.getString("profile_type"));
			p.setProfileDescription(rs.getString("profile_description"));
			p.setActive(rs.getBoolean("active"));
			Timestamp  ts =rs.getTimestamp("created");
			p.setCreated(ts ==null?null:new Date(ts.getTime()));
			pList.add(p);
		}
		return pList;
	}
	
	public static void main(String args[]) throws SQLException
	{
		ProjectProfileDao pcd = new ProjectProfileDao();
		System.out.println(pcd.getProfiles(Arrays.asList(1,2,3,4,5)));
	}
}
