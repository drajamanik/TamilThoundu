/**
 * @author Rajamani David
 * @since	Apr 25, 2018
 *
 */
package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.wotsoc.tamilthoundu.common.CommonUtil;
import org.wotsoc.tamilthoundu.domain.UserProfileMap;
import org.wotsoc.tamilthoundu.jdbc.JDBCConnection;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;
import org.wotsoc.tamilthoundu.jdbc.PreparedStatementParameter;

/**
 * @author rdavid
 *
 */
public class UserProfileMapDao 
{
	public List<UserProfileMap> getUserProfileMaps(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.user_profile_map where profile_Id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery());
	}

	public List<UserProfileMap> getUserProfileMaps(Integer userId) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.user_profile_map where user_Id =").append(userId);
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery());
	}
	
	public UserProfileMap createUserProfileMap(UserProfileMap upm) throws Exception
	{
		StringBuffer buff=new StringBuffer();
		buff.append("INSERT INTO public.user_profile_map (user_id,profile_id,active)");
		buff.append(" VALUES (?,?,?); ");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		list.add(new PreparedStatementParameter(upm.getUserId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(upm.getProfileId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(upm.isActive(),Types.VARCHAR));
		int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		if(count>0)
		{
			return upm;
		}
		return null;	
	}

	public List<UserProfileMap> getResultSet(ResultSet rs) throws SQLException
	{
		List<UserProfileMap> upmList = new ArrayList<UserProfileMap>();
		UserProfileMap  upm=null;
		while(rs.next())
		{
			upm = new UserProfileMap();
			upm.setUpmId(rs.getInt("upm_Id"));
			upm.setProfileId(rs.getInt("profile_id"));
			upm.setUserId(rs.getInt("user_id"));
			upm.setActive(rs.getString("active"));
			upmList.add(upm);
		}
		return upmList;
	}
	
 	
	public static void main(String args[]) throws SQLException
	{
		UserProfileMapDao pcd = new UserProfileMapDao();
		System.out.println(pcd.getUserProfileMaps(Arrays.asList(1,2,3,4,5)));
	}

}
