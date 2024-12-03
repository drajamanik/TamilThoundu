/**
 * @author Rajamani David
 * @since	Mar 23, 2018
 *
 */
package org.wotsoc.tamilthoundu.dto;

import java.util.Date;

/**
 * @author rdavid
 *
 */
public class PageControlDto 
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
	  
	  public PageControlDto(Integer 	pcId,Integer   projectId,Integer   pageId,
		  Integer 	positionId,Integer   controlId,String   	nameId,String  	defaultValue,
		  String  	dataType,String    fieldHelp,String    addUser,Date    	addTime, 
		  String    updateUser,Date   	updateTime,String  	verifyUser,Date  	verifyTime,
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

	public Integer getProjectId() {
		return projectId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public Integer getControlId() {
		return controlId;
	}

	public String getNameId() {
		return nameId;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public String getDataType() {
		return dataType;
	}

	public String getFieldHelp() {
		return fieldHelp;
	}

	public String getAddUser() {
		return addUser;
	}

	public Date getAddTime() {
		return addTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public boolean isActive() {
		return active;
	}

}
