/**
 * @author Rajamani David
 * @since	Nov 17, 2015
 *
 */
package org.wotsoc.tamilthoundu.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rdavid
 *
 */
@XmlRootElement
public class UserSession 
{
	private String 	userName;
	private String 	message;
	private String 	country;
	private String 	ip;
	private String 	zipCode;
	private String 	isPaid;
	private Long 	sessionId;
	private Long   	movieId;
	private String 	deviceId;
	private Date 	lastAccessTime;
	private Date	lastPointer;
	private Date	sessionTimeOut;
	private String	active;
	
	public UserSession() 
	{
		 
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public Date getLastPointer() {
		return lastPointer;
	}

	public void setLastPointer(Date lastPointer) {
		this.lastPointer = lastPointer;
	}

	public Date getSessionTimeOut() {
		return sessionTimeOut;
	}

	public void setSessionTimeOut(Date sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserSession [userName=" + userName + ", message=" + message
				+ ", country=" + country + ", ip=" + ip + ", zipCode="
				+ zipCode + ", isPaid=" + isPaid + ", sessionId=" + sessionId
				+ ", movieId=" + movieId + ", deviceId=" + deviceId
				+ ", lastAccessTime=" + lastAccessTime + ", lastPointer="
				+ lastPointer + ", sessionTimeOut=" + sessionTimeOut
				+ ", active=" + active + "]";
	}
}
