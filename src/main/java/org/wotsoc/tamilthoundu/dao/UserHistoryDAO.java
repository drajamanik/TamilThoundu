package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.UserHistory;
import org.wotsoc.tamilthoundu.jdbc.JDBCConnection;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;
import org.wotsoc.tamilthoundu.jdbc.PreparedStatementParameter;

public class UserHistoryDAO
{
	public List<UserHistory> getUserHistory(Integer userId, int levelId) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.user_history where user_Id=? and level_id =?");
		try (PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString())){
			ps.setInt(1, userId); 
			ps.setInt(2, levelId); 
			return getResultSet(ps.executeQuery());
		}
	}
	
	public List<UserHistory> getMaxUserHistory(String userId, int levelId) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select user_id, level_id, max(seq_id) as seq_id FROM public.user_history where userId=? and level_id =? group by user_id,level_id");
		try (PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString())){
			ps.setString(1, userId); 
			ps.setInt(2, levelId); 
			return getResultSet(ps.executeQuery());
		}
	}
	
	public static boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int columns = rsmd.getColumnCount();
	    for (int x = 1; x <= columns; x++) {
	        if (columnName.equals(rsmd.getColumnName(x))) {
	            return true;
	        }
	    }
	    return false;
	}
	
	private List<UserHistory> getResultSet(ResultSet rs) throws SQLException
	{
		List<UserHistory> pList = new ArrayList<>();
		UserHistory  p=null;
		while(rs.next())
		{
			p = new UserHistory();
			if(hasColumn(rs,"user_hist_id"))
				p.setUserHistoryId(rs.getInt("user_hist_id"));
			if(hasColumn(rs,"user_Id"))
				p.setUserId(rs.getInt("user_Id"));
			if(hasColumn(rs,"project_Id"))
				p.setProjectId(rs.getInt("project_Id"));
			if(hasColumn(rs,"level_Id"))
				p.setLevelId(rs.getInt("level_Id"));
			if(hasColumn(rs,"start_Time"))
				p.setStartTime(rs.getDate("start_Time"));
			if(hasColumn(rs,"end_Time"))
				p.setEndTime(rs.getDate("end_Time"));
			if(hasColumn(rs,"total_count"))
				p.setTotalCount(rs.getInt("total_count"));
			if(hasColumn(rs,"error_count"))
				p.setErrorCount(rs.getInt("error_count"));
			if(hasColumn(rs,"ip"))
				p.setIp(rs.getString("ip"));
			if(hasColumn(rs,"device_detail"))
				p.setDeviceDetail(rs.getString("device_detail"));
			if(hasColumn(rs,"profile_Id"))
				p.setProfileId(rs.getInt("profile_Id"));
			if(hasColumn(rs,"seq_Id"))
				p.setSeqId(rs.getInt("seq_Id"));
			if(hasColumn(rs,"timer"))
				p.setTimer(rs.getLong("timer"));
			if(hasColumn(rs,"error_data"))
				p.setErrorData(rs.getString("error_data"));
			pList.add(p);
		}
		return pList;
	}
	
	public UserHistory createUserHistory(UserHistory userHistory) throws Exception
	{
		StringBuffer buff=new StringBuffer();
		buff.append("INSERT INTO public.user_history (user_id,project_id,level_id,start_time,end_time,error_count,total_count,ip,device_detail,profile_id,seq_id,timer,error_data)");
		buff.append(" VALUES (?,?, ?,?,?, ?,?,?, ?,? ,?,?,?); ");

		List<PreparedStatementParameter> list =new ArrayList<PreparedStatementParameter>();
		//list.add(new PreparedStatementParameter(userHistory.getUserHistoryId(),Types.BIGINT));
		list.add(new PreparedStatementParameter(userHistory.getUserId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(userHistory.getProjectId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(userHistory.getLevelId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(userHistory.getStartTime(),Types.TIME_WITH_TIMEZONE));
		list.add(new PreparedStatementParameter(userHistory.getEndTime(),Types.TIME_WITH_TIMEZONE));
		list.add(new PreparedStatementParameter(userHistory.getErrorCount(),Types.INTEGER));
		list.add(new PreparedStatementParameter(userHistory.getTotalCount(),Types.INTEGER));
		list.add(new PreparedStatementParameter(userHistory.getIp(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(userHistory.getDeviceDetail(),Types.VARCHAR));
		list.add(new PreparedStatementParameter(userHistory.getProfileId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(userHistory.getSeqId(),Types.INTEGER));
		list.add(new PreparedStatementParameter(userHistory.getTimer(),Types.BIGINT));
		list.add(new PreparedStatementParameter(userHistory.getErrorData(),Types.VARCHAR));
		int count  = JDBCConnection .getInstance().updateSQL(buff.toString(),list);		
		if(count>0)
		{
			return userHistory;
		}
		return null;	
	}
}
