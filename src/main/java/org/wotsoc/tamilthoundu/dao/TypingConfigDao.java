package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.TypingConfig;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

public class TypingConfigDao
{
	public List<TypingConfig> getConfig(int levelId,String letterType,String timeUnit) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.Typing_Config where level_id =? and letter_type=? and time_unit=? ");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setInt(1, levelId);
		ps.setString(2, letterType);
		ps.setString(3, timeUnit);
		return getResultSet(ps.executeQuery());
	}
	
	public List<TypingConfig> getResultSet(ResultSet rs) throws SQLException
	{
		List<TypingConfig> pList = new ArrayList<>();
		TypingConfig  p=null;
		while(rs.next())
		{
			p = new TypingConfig();
			p.setTcId(rs.getInt("tc_Id"));
			p.setLevelId(rs.getInt("level_id"));
			p.setBeginRange(rs.getInt("begin_range"));
			p.setEndRange(rs.getInt("end_range"));
			p.setTime(rs.getLong("time"));
			p.setTimeUnit(rs.getString("time_unit"));
			p.setLetterType(rs.getString("letter_type"));
			pList.add(p);
		}
		return pList;
	}
	
	public static void main(String args[]) throws SQLException {
		TypingConfigDao tgDao = new TypingConfigDao();
		List<TypingConfig> tcList = tgDao.getConfig(1,"char", "minute");
		for(TypingConfig tc: tcList) {
			System.out.println(tc);
		}
	}
}
