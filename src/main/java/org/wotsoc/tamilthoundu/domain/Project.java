/**
 * @author Rajamani David
 * @since	Apr 25, 2018
 *
 */
package org.wotsoc.tamilthoundu.domain;

/**
 * @author rdavid
 *
 */
public class Project 
{
	Integer projectId;
	String 	projectName;
	String 	projectType;
	String 	projectDescription;
	boolean active;
	
	public Integer getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectType() {
		return projectType;
	}
	
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	public String getProjectDescription() {
		return projectDescription;
	}
	
	public void setProjectDescription(String projectDescription) 
	{
		this.projectDescription = projectDescription;
	}
	
	public boolean isActive() 
	{
		return active;
	}
	
	public void setActive(boolean active) 
	{
		this.active = active;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectType=" + projectType
				+ ", projectDescription=" + projectDescription + ", active=" + active + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((projectDescription == null) ? 0 : projectDescription.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((projectType == null) ? 0 : projectType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (active != other.active)
			return false;
		if (projectDescription == null) {
			if (other.projectDescription != null)
				return false;
		} else if (!projectDescription.equals(other.projectDescription))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (projectType == null) {
			if (other.projectType != null)
				return false;
		} else if (!projectType.equals(other.projectType))
			return false;
		return true;
	}
	
	
}
