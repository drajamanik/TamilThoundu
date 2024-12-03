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
import org.wotsoc.tamilthoundu.domain.ProjectDataSetup;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

/**
 * @author rdavid
 *
 */
public class ProjectDataSetupDao 
{
	public List<ProjectDataSetup> getProjectDataSetups(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.project_data_setup where project_Id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery());
	}
	
	public List<ProjectDataSetup> getResultSet(ResultSet rs) throws SQLException
	{
		List<ProjectDataSetup> pdsList = new ArrayList<ProjectDataSetup>();
		ProjectDataSetup  pds=null;
		while(rs.next())
		{
			pds = new ProjectDataSetup();
			pds.setPdsId(rs.getInt("pds_id"));
			pds.setProjectId(rs.getInt("project_Id"));
			pds.setValueIdFrom(rs.getInt("value_id_from"));
			pds.setValueIdTo(rs.getInt("value_id_to"));
			pds.setReceived(rs.getBoolean("received"));
			pds.setSent(rs.getBoolean("sent"));
			Timestamp ts=rs.getTimestamp("received_time");
			pds.setReceivedDate(ts==null?null:new Date(ts.getTime()));
			ts=rs.getTimestamp("sent_time");
			pds.setSentDate(ts==null?null:new Date(ts.getTime()));
			pdsList.add(pds);
		}
		return pdsList;
	}

	public static void main(String args[]) throws SQLException
	{
		ProjectDataSetupDao pcd = new ProjectDataSetupDao();
		System.out.println(pcd.getProjectDataSetups(Arrays.asList(1,2,3,4,5)));
	}

}
