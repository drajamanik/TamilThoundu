/**
 * @author Rajamani David
 * @since	Apr 26, 2018
 *
 */
package org.wotsoc.tamilthoundu.domain;

import java.util.Date;

/**
 * @author rdavid
 *
 */
public class ProjectDataSetup 
{
	Integer pdsId;
	Integer projectId;
	Integer valueIdFrom;
	Integer valueIdTo;
	boolean sent;   
	boolean received;
	Date sentDate;   
	Date receivedDate;
	
	public Integer getPdsId() 
	{
		return pdsId;
	}
	
	public void setPdsId(Integer pdsId) 
	{
		this.pdsId = pdsId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getValueIdFrom() {
		return valueIdFrom;
	}
	public void setValueIdFrom(Integer valueIdFrom) {
		this.valueIdFrom = valueIdFrom;
	}
	public Integer getValueIdTo() {
		return valueIdTo;
	}
	public void setValueIdTo(Integer valueIdTo) {
		this.valueIdTo = valueIdTo;
	}
	public boolean isSent() {
		return sent;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	public boolean isReceived() {
		return received;
	}
	public void setReceived(boolean received) {
		this.received = received;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	
	@Override
	public String toString() {
		return "ProjectDataSetup [pdsId=" + pdsId + ", projectId=" + projectId + ", valueIdFrom=" + valueIdFrom
				+ ", valueIdTo=" + valueIdTo + ", sent=" + sent + ", received=" + received + ", sentDate=" + sentDate
				+ ", receivedDate=" + receivedDate + "]\n";
	}
	
 }
