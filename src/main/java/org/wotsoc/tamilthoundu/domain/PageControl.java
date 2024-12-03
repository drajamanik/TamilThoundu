/**
 * @author Rajamani David
 * @since	Mar 21, 2018
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
public class PageControl 
{
	  private Integer 	pcId;
	  private Integer   projectId;
	  private Integer   pageId;
	  private Integer 	positionId;
	  private Integer   controlId;
	  private String   	nameId;
	  private String  	defaultValue;
	  private String  	dataType;
	  private String    fieldHelp;
	  private String    addUser;
	  private Date    	addTime; 
	  private String    updateUser; 
	  private Date   	updateTime;
	  private String  	verifyUser;  
	  private Date  	verifyTime;
	  private boolean 	active;
	  
	  public PageControl()
	  {
		  
	  }
	  
	  //PageControl(int, int, int, int, int, String, String, String, String, String, String, Date, String, Date, String, Date, boolean) 
	  public PageControl(Integer 	pcId,Integer   projectId,Integer   pageId,Integer 	positionId,Integer   controlId,
			  String   	nameId,String  	defaultValue,String  	dataType,String    fieldHelp,
			  String    addUser,Date    addTime,String    updateUser,Date updateTime,String  verifyUser,Date verifyTime,
			  boolean 	active)
	  {
			  this.pcId =pcId;
			  this.projectId =projectId;
			  this.pageId =pageId;
			  this.positionId =positionId;
			  this.controlId =controlId;
			  this.nameId =nameId;
			  this.defaultValue=defaultValue;
			  this.dataType =dataType;
			  this.fieldHelp =fieldHelp;
			  this.addUser =addUser;
			  this.addTime =addTime; 
			  this.updateUser = updateUser; 
			  this.updateTime = updateTime;
			  this.verifyUser = verifyUser ;  
			  this.verifyTime = verifyTime;
			  this.active = active;
	  }
	  
	public Integer getPcId() {
		return pcId;
	}
	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public Integer getControlId() {
		return controlId;
	}
	public void setControlId(Integer controlId) {
		this.controlId = controlId;
	}
	public String getNameId() {
		return nameId;
	}
	public void setNameId(String nameId) {
		this.nameId = nameId;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getFieldHelp() {
		return fieldHelp;
	}
	public void setFieldHelp(String fieldHelp) {
		this.fieldHelp = fieldHelp;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateYime) {
		this.updateTime = updateYime;
	}
	public String getVerifyUser() {
		return verifyUser;
	}
	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}
	public Date getVerifyTime() {
		return verifyTime;
	}
	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "PageControl [pcId=" + pcId + ", projectId=" + projectId + ", pageId=" + pageId + ", positionId="
				+ positionId + ", controlId=" + controlId + ", nameId=" + nameId + ", defaultValue=" + defaultValue
				+ ", dataType=" + dataType + ", fieldHelp=" + fieldHelp + ", addUser=" + addUser + ", addTime="
				+ addTime + ", updateUser=" + updateUser + ", updateTime=" + updateTime + ", verifyUser=" + verifyUser
				+ ", verifyTime=" + verifyTime + ", active=" + active + "]\n";
	}
}
