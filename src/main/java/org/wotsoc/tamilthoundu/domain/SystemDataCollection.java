/**
 * @author Rajamani David
 * @since	Mar 21, 2018
 *
 */
package org.wotsoc.tamilthoundu.domain;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rdavid
 *
 */
public class SystemDataCollection 
{
	  private Integer 		sdcId;
	  private Integer   	projectId;	
	  private Integer   	pageId;
	  private Double 		positionId;
	  private Integer   	controlId;
	  private Integer  		valueId;
	  private InputStream  	imageValue;
	  private String		imageName;
	  private Long			imageLength;
	  private String  		textValue;
	  private BigDecimal  	numberValue;
	  private Date	    	dateValue;
	  private Boolean   	booleanValue;
	  private String    	addUser; 
	  private Date   		addTime;
	  private String    	updateUser; 
	  private Date   		updateTime;
	  private String  		verifyUser;  
	  private Date  		verifyTime;
	  private Boolean 		active;

	  
	  public SystemDataCollection()
	  {
		  
	  }
	  
	  public SystemDataCollection(Integer sdcId,Integer projectId,Integer pageId,Double positionId,Integer controlId,
			   Integer valueId,InputStream imageValue,String imageName,Long imageLength,String textValue,BigDecimal numberValue,Date dateValue,Boolean booleanValue,
			   String addUser,Date addTime,String updateUser,Date updateTime,String verifyUser,Date verifyTime,Boolean active)
	  {
		   this.sdcId = sdcId;
		   this.projectId = projectId;	
		   this.pageId = pageId;
		   this.positionId= positionId;
		   this.controlId = controlId;
		   this.valueId = valueId;
		   this.imageValue = imageValue;
		   this.textValue = textValue;
		   this.numberValue = numberValue;
		   this.dateValue = dateValue;
		   this.booleanValue = booleanValue;
		   this.addUser = addUser; 
		   this.addTime = addTime;
		   this.updateUser = updateUser; 
		   this.updateTime = updateTime;
		   this.verifyUser = verifyUser;  
		   this.verifyTime = verifyTime;
		   this.active = active ;
		   this.imageName = imageName;
		   this.imageLength = imageLength;
	  }

	  
	public Integer getSdcId() {
		return sdcId;
	}
	public void setSdcId(Integer sdcId) {
		this.sdcId = sdcId;
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
	public Double getPositionId() {
		return positionId;
	}
	public void setPositionId(Double positionId) {
		this.positionId = positionId;
	}
	public Integer getControlId() {
		return controlId;
	}
	public void setControlId(Integer controlId) {
		this.controlId = controlId;
	}
	public Integer getValueId() {
		return valueId;
	}
	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}
	
	public InputStream getImageValue() {
		return imageValue;
	}

	public void setImageValue(InputStream imageValue) {
		this.imageValue = imageValue;
	}
	public String getTextValue() {
		return textValue;
	}
	
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	public BigDecimal getNumberValue() {
		return numberValue;
	}
	public void setNumberValue(BigDecimal numberValue) {
		this.numberValue = numberValue;
	}
	public Date getDateValue() {
		return dateValue;
	}
	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}
	public Boolean isBooleanValue() {
		return booleanValue;
	}
	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
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
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SystemDataCollection [sdcId=" + sdcId + ", projectId=" + projectId + ", pageId=" + pageId
				+ ", positionId=" + positionId + ", controlId=" + controlId + ", valueId=" + valueId + ", imageValue="
				+ getImageValue() + ", textValue=" + textValue + ", numberValue=" + numberValue + ", dateValue=" + dateValue
				+ ", booleanValue=" + booleanValue + ", addUser=" + addUser + ", addTime=" + addTime + ", updateUser="
				+ updateUser + ", updateTime=" + updateTime + ", verifyUser=" + verifyUser + ", verifyTime="
				+ verifyTime + ", active=" + active   
				+ ", imageName="+imageName + ", imageLength=" + imageLength +"]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((addTime == null) ? 0 : addTime.hashCode());
		result = prime * result + ((addUser == null) ? 0 : addUser.hashCode());
		result = prime * result + ((booleanValue == null) ? 0 : booleanValue.hashCode());
		result = prime * result + ((controlId == null) ? 0 : controlId.hashCode());
		result = prime * result + ((dateValue == null) ? 0 : dateValue.hashCode());
		result = prime * result + ((imageValue == null) ? 0 : imageValue.hashCode());
		result = prime * result + ((numberValue == null) ? 0 : numberValue.hashCode());
		result = prime * result + ((pageId == null) ? 0 : pageId.hashCode());
		result = prime * result + ((positionId == null) ? 0 : positionId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + ((sdcId == null) ? 0 : sdcId.hashCode());
		result = prime * result + ((textValue == null) ? 0 : textValue.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		result = prime * result + ((valueId == null) ? 0 : valueId.hashCode());
		result = prime * result + ((verifyTime == null) ? 0 : verifyTime.hashCode());
		result = prime * result + ((verifyUser == null) ? 0 : verifyUser.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imageLength == null) ? 0 : imageLength.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemDataCollection other = (SystemDataCollection) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (addTime == null) {
			if (other.addTime != null)
				return false;
		} else if (!addTime.equals(other.addTime))
			return false;
		if (addUser == null) {
			if (other.addUser != null)
				return false;
		} else if (!addUser.equals(other.addUser))
			return false;
		if (booleanValue == null) {
			if (other.booleanValue != null)
				return false;
		} else if (!booleanValue.equals(other.booleanValue))
			return false;
		if (controlId == null) {
			if (other.controlId != null)
				return false;
		} else if (!controlId.equals(other.controlId))
			return false;
		if (dateValue == null) {
			if (other.dateValue != null)
				return false;
		} else if (!dateValue.equals(other.dateValue))
			return false;
		if (numberValue == null) {
			if (other.numberValue != null)
				return false;
		} else if (!numberValue.equals(other.numberValue))
			return false;
		if (pageId == null) {
			if (other.pageId != null)
				return false;
		} else if (!pageId.equals(other.pageId))
			return false;
		if (positionId == null) {
			if (other.positionId != null)
				return false;
		} else if (!positionId.equals(other.positionId))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (sdcId == null) {
			if (other.sdcId != null)
				return false;
		} else if (!sdcId.equals(other.sdcId))
			return false;
		if (textValue == null) {
			if (other.textValue != null)
				return false;
		} else if (!textValue.equals(other.textValue))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		if (valueId == null) {
			if (other.valueId != null)
				return false;
		} else if (!valueId.equals(other.valueId))
			return false;
		if (verifyTime == null) {
			if (other.verifyTime != null)
				return false;
		} else if (!verifyTime.equals(other.verifyTime))
			return false;
		if (verifyUser == null) {
			if (other.verifyUser != null)
				return false;
		} else if (!verifyUser.equals(other.verifyUser))
			return false;
		return true;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Long getImageLength() {
		return imageLength;
	}

	public void setImageLength(Long imageLength) {
		this.imageLength = imageLength;
	}
}
