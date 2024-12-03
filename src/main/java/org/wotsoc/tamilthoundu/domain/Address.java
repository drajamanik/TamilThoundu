package org.wotsoc.tamilthoundu.domain;

public class Address
{
	private Integer userId;
	private Integer userAddressId;
	private Integer userProfileId;
	private String placeName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	public Address() {
		
	}
	
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public Integer getUserAddressId()
	{
		return userAddressId;
	}
	public void setUserAddressId(Integer userAddressId)
	{
		this.userAddressId = userAddressId;
	}
	public Integer getUserProfileId()
	{
		return userProfileId;
	}
	public void setUserProfileId(Integer userProfileId)
	{
		this.userProfileId = userProfileId;
	}
	
	public String getPlaceName() {
		return this.placeName;
	}
	
	public void setPlaceName(String placeName){
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
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
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

	@Override
	public String toString()
	{
		return "Address [userId=" + userId + ", userAddressId=" + userAddressId + ", userProfileId=" + userProfileId
				+ ", placeName= " +placeName
				+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + "]";
	}
}
