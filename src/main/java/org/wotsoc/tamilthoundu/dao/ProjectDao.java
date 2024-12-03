/**
 * @author Rajamani David
 * @since	Apr 25, 2018
 *
 */
package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.wotsoc.tamilthoundu.common.CommonUtil;
import org.wotsoc.tamilthoundu.domain.Project;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

/**
 * @author rdavid
 *
 */
public class ProjectDao 
{
	public List<Project> getProjects(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.project where project_Id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery());
	}
	
	public List<Project> getProjectsByUserName(String userName, String projectId) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		
		sb.append(" select * from public.user u , public.User_Profile_Map upm, public.Project_Profile_Map ppm,Project pr ");
		sb.append(" where u.user_id=upm.user_id and upm.profile_id=ppm.profile_id and ppm.project_id=pr.project_id and ");
		sb.append(" u.user_name='").append(userName).append("'").append(" and pr.active='true' ");
		if(projectId!=null)
			sb.append(" and pr.project_id=").append(projectId);	
		sb.append(";");
		System.out.println(sb);
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery());
	}
	
	public List<Project> getResultSet(ResultSet rs) throws SQLException
	{
		Set<Project> pList = new HashSet<Project>();
		Project  p=null;
		while(rs.next())
		{
			p = new Project();
			p.setProjectId(rs.getInt("project_Id"));
			p.setProjectName(rs.getString("project_name"));
			p.setProjectType(rs.getString("project_type"));
			p.setProjectDescription(rs.getString("project_description"));
			p.setActive(rs.getBoolean("active"));
			pList.add(p);
		}
		return new ArrayList<Project>(pList);
	}
	
 	
	public static void main(String args[]) throws SQLException
	{
		ProjectDao pcd = new ProjectDao();
		//System.out.println(pcd.getProjects(Arrays.asList(1,2,3,4,5)));
		System.out.println(pcd.getProjectsByUserName("raj",null));
	}
}
