/**
 * @author Rajamani David
 * @since	Nov 24, 2015
 *
 */
package org.wotsoc.tamilthoundu.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class Login implements Serializable 
{
	private static final long serialVersionUID = -7831270123002884986L;

	@FormParam("userName")
	private String userName;
	
	@FormParam("password")
	private String password;
	
	@FormParam("ip")
	private String ip;
	
	@FormParam("oldPassword")
	private String oldPassword;
	
	public Login() 
	{
		 
	}

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

	public String getIp() 
	{
		return ip;
	}

	public void setIp(String ip) 
	{
		this.ip = ip;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
}
