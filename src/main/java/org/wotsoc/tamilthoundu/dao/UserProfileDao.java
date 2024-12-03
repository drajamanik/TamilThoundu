/**
 * @author Rajamani David
 * @since	Apr 26, 2018
 *
 */
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
import org.wotsoc.tamilthoundu.domain.UserProfile;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

/**
 * @author rdavid
 *
 */
public class UserProfileDao 
{
	public List<UserProfile> getProfiles() throws SQLException{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.user_profile where active=true");
		try(PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString())){
			return getResultSet(ps.executeQuery());
		}
	}
	
	public UserProfile getProfileByName(String profileName) throws SQLException{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.user_profile where active='Y' and profile_name=?");
		try(PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString())){
			ps.setString(1,profileName);
			List<UserProfile> upList= getResultSet(ps.executeQuery());
			return upList.isEmpty()?null:upList.get(0);
		}
	}

	public List<UserProfile> getProfiles(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.user_profile where profile_Id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		try(PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString())){
			return getResultSet(ps.executeQuery());
		}
	}
	
	public List<UserProfile> getResultSet(ResultSet rs) throws SQLException
	{
		List<UserProfile> pList = new ArrayList<>();
		UserProfile  p=null;
		while(rs.next())
		{
			p = new UserProfile();
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
	
 	
	public static void main(String[] args) throws SQLException
	{
		UserProfileDao pcd = new UserProfileDao();
		System.out.println(pcd.getProfiles(Arrays.asList(1,2,3,4,5)));
	}
}
