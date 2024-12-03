/**
 * @author Rajamani David
 * @since	Apr 26, 2018
 *
 */
package org.wotsoc.tamilthoundu.domain;

/**
 * @author rdavid
 *
 */
public class UserProfileMap 
{
	Integer upmId;
	Integer userId;
	Integer profileId;
	String  active;
	
	public Integer getUpmId() {
		return upmId;
	}
	public void setUpmId(Integer upmId) {
		this.upmId = upmId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public String isActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "UserProfileMap [upmId=" + upmId + ", userId=" + userId + ", profileId=" + profileId + ", active="
				+ active + "]\n";
	}
}
