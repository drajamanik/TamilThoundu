/**
 * @author Rajamani David
 * @since	Nov 17, 2015
 *
 */
package org.wotsoc.tamilthoundu.domain;

import java.util.List;

public class User 
{
	private Integer userId;
	private Integer profileId;
	private String 	firstName;
	private String 	lastName;
	private String 	emailId;
	private String 	phone;
	private List<Address> addressList;
	private String 	userName;
	private String 	password;
	private String 	oldPassword;
	private String 	isPaid;
	private String 	isActive;
	
	public User() 
	{
		 
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId
				+ ", phone=" + phone + ", address=" + addressList + ", profileId=" + profileId
				+ ", userName=" + userName + "]";
 	}

	/**
	 * @return the isPaid
	 */
	public String getIsPaid() {
		return isPaid;
	}

	/**
	 * @param isPaid the isPaid to set
	 */
	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}
	
	public String isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<Address> getAddressList()
	{
		return addressList;
	}

	public void setAddressList(List<Address> addressList)
	{
		this.addressList = addressList;
	}

	public Integer getProfileId()
	{
		return profileId;
	}

	public void setProfileId(Integer profileId)
	{
		this.profileId = profileId;
	}

	public String getOldPassword()
	{
		return oldPassword;
	}

	public void setOldPassword(String oldPassword)
	{
		this.oldPassword = oldPassword;
	}

}
