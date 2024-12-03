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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wotsoc.tamilthoundu.common.CommonUtil;
import org.wotsoc.tamilthoundu.domain.Project;
import org.wotsoc.tamilthoundu.domain.ProjectProfile;
import org.wotsoc.tamilthoundu.domain.ProjectProfileMap;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

/**
 * @author rdavid
 *
 */
public class ProjectProfileMapDao 
{
	public List<ProjectProfileMap> getProjectProfileMapsByProjectIds(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.project_profile_map where project_Id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery(),false,false);
	}
	

	public List<ProjectProfileMap> getProjectProfileMapsByProjectIdsWithDetail(List<Integer> projectIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		//sb.append(" select ppm.ppm_id as ppm_ppm_id, *  from project_profile pp, project p, project_profile_map ppm ");
		//sb.append(" where pp.profile_id = ppm.profile_id and p.project_id=ppm.project_id ");
		sb.append(" select "); 	
		sb.append(" ppm.ppm_id as ppm_ppm_id, ppm.profile_Id as ppm_profile_Id, ");
		sb.append(" ppm.project_id as ppm_project_id,ppm.active as ppm_active, ");
		sb.append(" p.project_Id as p_project_Id,p.project_Name as p_project_Name, ");
		sb.append(" p.project_Description as p_project_Description,p.project_Type as p_project_Type, ");
		sb.append(" p.active as p_active,pp.profile_Id as pp_profile_Id, ");
		sb.append(" pp.profile_Name as pp_profile_Name,pp.profile_Description as pp_profile_Description, ");
		sb.append(" pp.profile_Type as pp_profile_Type,pp.active as pp_active ");
		sb.append(" from project_profile pp, project p, project_profile_map ppm ");
		sb.append(" where pp.profile_id = ppm.profile_id and p.project_id=ppm.project_id ");
		
		sb.append(" and p.project_id in (").append(CommonUtil.commaSeparatedString(projectIds)).append(")");
		System.out.println(sb.toString());
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery(),true,true);
	}

	public List<ProjectProfileMap> getProjectProfileMapsByProfileIds(List<Integer> profileIds) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.project_profile_map where profile_Id in (").append(CommonUtil.commaSeparatedString(profileIds)).append(")");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		return getResultSet(ps.executeQuery(),false,false);
	}
	
	public List<ProjectProfileMap> getResultSet(ResultSet rs,boolean needProject,boolean needProjectProfile) throws SQLException
	{
		List<ProjectProfileMap> ppmList = new ArrayList<ProjectProfileMap>();
		ProjectProfileMap  ppm = null;
		Map<Long,ProjectProfileMap> ppmMap = new HashMap<Long,ProjectProfileMap>();
		Map<Long,ProjectProfile> ppMap = new HashMap<Long,ProjectProfile>();
		Map<Long,Project> pMap = new HashMap<Long,Project>();
		
		while(rs.next())
		{
			ppm = ppmMap.get(rs.getInt("ppm_ppm_id"));
			if(ppm==null)
				ppm = new ProjectProfileMap();
			
			ppm.setPpmId(rs.getInt("ppm_ppm_id"));
			ppm.setProfileId(rs.getInt("ppm_profile_Id"));
			ppm.setProjectId(rs.getInt("ppm_project_id"));
			ppm.setActive(rs.getBoolean("ppm_active"));
			if(needProject) {
				Project p = pMap.get(rs.getInt("p_project_Id"));
				if(p ==null)
					p = new Project();
				p.setProjectId(rs.getInt("p_project_Id"));
				p.setProjectName(rs.getString("p_project_Name"));
				p.setProjectDescription(rs.getString("p_project_Description"));
				p.setProjectType(rs.getString("p_project_Type"));
				p.setActive(rs.getBoolean("p_active"));
				ppm.addProject(p);
			}
			if(needProjectProfile) {
				ProjectProfile pp = ppMap.get(rs.getInt("pp_profile_Id"));
				if(pp ==null)
					pp = new ProjectProfile();
				pp.setProfileId(rs.getInt("pp_profile_Id"));
				pp.setProfileName(rs.getString("pp_profile_Name"));
				pp.setProfileDescription(rs.getString("pp_profile_Description"));
				pp.setProfileType(rs.getString("pp_profile_Type"));
				pp.setActive(rs.getBoolean("pp_active"));
				ppm.addProjectProfile(pp);
			}
			
			ppmList.add(ppm);
		}
		return ppmList;
	}

	public static void main(String args[]) throws SQLException
	{
		ProjectProfileMapDao pcd = new ProjectProfileMapDao();
		//System.out.println(pcd.getProjectProfileMapsByProfileIds((Arrays.asList(1,2,3,4,5))));
		//System.out.println(pcd.getProjectProfileMapsByProjectIds((Arrays.asList(1))));
		System.out.println(pcd.getProjectProfileMapsByProjectIdsWithDetail((Arrays.asList(1))));
	}
}
