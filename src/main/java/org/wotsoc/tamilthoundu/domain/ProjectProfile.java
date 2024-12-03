package org.wotsoc.tamilthoundu.domain;

import java.util.Date;

public class ProjectProfile {
	Integer profileId;
	String 	profileName;
	String 	profileType;
	String 	profileDescription;
	Date 	created;
	boolean active;
	
	public Integer getProfileId() 
	{
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getProfileType() {
		return profileType;
	}
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}
	public String getProfileDescription() {
		return profileDescription;
	}
	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Project Profile [profileId=" + profileId + ", profileName=" + profileName + ", profileType=" + profileType
				+ ", profileDescription=" + profileDescription + ", created=" + created + ", active=" + active + "]\n";
	}

}
