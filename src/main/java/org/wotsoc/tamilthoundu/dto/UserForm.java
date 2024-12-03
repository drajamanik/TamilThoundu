package org.wotsoc.tamilthoundu.dto;

import java.io.Serializable;

public class UserForm implements Serializable
{
	private static final long serialVersionUID = 8469805156767445387L;
	private String userName;
	private String firstName;
	private String lastName;
	
	private String password;
	private String oldPassword;
	private String profileName;
	private String placeName;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String zipCode;
	private String emailId;
	private String message;
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getProfileName()
	{
		return profileName;
	}
	public void setProfileName(String profileName)
	{
		this.profileName = profileName;
	}
	public String getPlaceName()
	{
		return placeName;
	}
	public void setPlaceName(String placeName)
	{
		this.placeName = placeName;
	}
	public String getAddress1()
	{
		return address1;
	}
	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}
	public String getAddress2()
	{
		return address2;
	}
	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public String getEmailId()
	{
		return emailId;
	}
	
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
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
