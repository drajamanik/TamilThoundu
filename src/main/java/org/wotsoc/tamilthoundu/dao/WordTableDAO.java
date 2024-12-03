package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.UserProfileMap;
import org.wotsoc.tamilthoundu.domain.WordTable;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

public class WordTableDAO {
	
	public List<WordTable> getWords(Integer begin, Integer end) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();   
		sb.append("select * from public.\"Word_Table\" where \"Word_No\" between (").append(begin).append(" and ").append(end);
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return null;//getResultSet(ps.executeQuery());
	}
	
	public List<UserProfileMap> getResultSet(ResultSet rs) throws SQLException
	{
		List<UserProfileMap> upmList = new ArrayList<UserProfileMap>();
		UserProfileMap  upm=null;
		while(rs.next())
		{
			upm = new UserProfileMap();
			upm.setUpmId(rs.getInt("Word"));
			upm.setProfileId(rs.getInt("profile_id"));
			upm.setUserId(rs.getInt("user_id"));
			upm.setActive(rs.getString("active"));
			upmList.add(upm);
		}
		return upmList;
	}
}
