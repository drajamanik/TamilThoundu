/**
 * @author Rajamani David
 * @since	Mar 20, 2016
 *
 */
package org.wotsoc.tamilthoundu.domain;

/**
 * @author rdavid
 *
 */
public class Support 
{
	public enum SupportConstants
	{
		NEW("NEW"),CLOSED("CLOSED"),PENDING("PENDING"),UNKNOWN("");
		
		String constant;
		private SupportConstants(String constant)
		{
			this.constant= constant;
		}
		
		public String getConstant()
		{
			return constant;
		}
	}
	
	private int supportId;
	private String userName;
	private String emailId;
	private String message;
	private String phoneNo;
	private SupportConstants status;
	private String solution;
	private String givenBy;
	
	public Support() 
	{
	 
	}

	public int getSupportId() {
		return supportId;
	}

	public void setSupportId(int supportId) {
		this.supportId = supportId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public SupportConstants getStatus() 
	{
		return status;
	}

	public void setStatus(SupportConstants status) {
		this.status = status;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

}
