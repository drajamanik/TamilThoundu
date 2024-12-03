package org.wotsoc.tamilthoundu.domain;

import java.util.Date;

public class UserHistory
{
	private long userHistoryId;
	private int userId;
	private int projectId;
	private int levelId;
	private Date startTime;
	private Date endTime;
	private int totalCount;
	private int errorCount;
	private String ip;
	private String deviceDetail;
	private int profileId;
	private int seqId;
	private long timer;
	private String errorData;
	
	public long getUserHistoryId()
	{
		return userHistoryId;
	}
	public void setUserHistoryId(long userHistoryId)
	{
		this.userHistoryId = userHistoryId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getSeqId()
	{
		return seqId;
	}
	public void setSeqId(int seqId)
	{
		this.seqId = seqId;
	}

	public int getProjectId()
	{
		return projectId;
	}
	public void setProjectId(int projectId)
	{
		this.projectId = projectId;
	}
	
	public int getProfileId()
	{
		return profileId;
	}
	public void setProfileId(int profileId)
	{
		this.profileId = profileId;
	}
	public int getLevelId()
	{
		return levelId;
	}
	public void setLevelId(int levelId)
	{
		this.levelId = levelId;
	}
	public Date getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}
	public Date getEndTime()
	{
		return endTime;
	}
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}
	public int getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	public int getErrorCount()
	{
		return errorCount;
	}
	public void setErrorCount(int errorCount)
	{
		this.errorCount = errorCount;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	
	public String getDeviceDetail()
	{
		return deviceDetail;
	}
	public void setDeviceDetail(String deviceDetail)
	{
		this.deviceDetail = deviceDetail;
	}
	public long getTimer()
	{
		return timer;
	}
	public void setTimer(long timer)
	{
		this.timer = timer;
	}
	public String getErrorData()
	{
		return errorData;
	}
	public void setErrorData(String errorData)
	{
		this.errorData = errorData;
	}
	@Override
	public String toString()
	{
		return "UserHistory [userHistoryId=" + userHistoryId + ", userId=" + userId + ", seqId=" + seqId + ", projectId=" + projectId + ", profileId=" + profileId
				+ ", levelId=" + levelId + ", startTime=" + startTime + ", endTime=" + endTime + ", totalCount="
				+ totalCount + ", errorCount=" + errorCount + ", ip=" + ip + ", deviceDetail=" + deviceDetail + ", seqId=" + seqId + ", timer=" + timer + ", errorData=" + errorData + "]";
	}
	
}
