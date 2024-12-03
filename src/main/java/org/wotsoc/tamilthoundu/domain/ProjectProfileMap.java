/**
 * @author Rajamani David
 * @since	Apr 25, 2018
 *
 */
package org.wotsoc.tamilthoundu.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rdavid
 *
 */
public class ProjectProfileMap 
{
	Integer ppmId;
	Integer projectId;
	Integer profileId;
	boolean active;
	private List<ProjectProfile> prjProfileList = new ArrayList<ProjectProfile>();
	private List<Project> 		 projectList 	= new ArrayList<Project>();

	public void addProjectProfile(ProjectProfile pp) {
		prjProfileList.add(pp);
	}
	
	public List<ProjectProfile> getProjectProfileList() {
		return prjProfileList;
	}
	
	public void addProject(Project p) {
		projectList.add(p);
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}
	
	public Integer getPpmId() {
		return ppmId;
	}
	public void setPpmId(Integer ppmId) {
		this.ppmId = ppmId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "ProjectProfileMap [ppmId=" + ppmId + ", projectId=" + projectId + ", profileId=" + profileId
				+ ", active=" + active + " , ProfileProfile[ " + prjProfileList + "] , Project[" + projectList +"]"+ "]\n";
	}
}
