package org.wotsoc.tamilthoundu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TypingGameForm	implements Serializable
{
	private static final long serialVersionUID = 3427841651728963941L;
	private String 	userName;
	private Integer userId;
	private Integer	levelId;
	private Long	timer;
	private Date	startTime;
	private Date	endTime;
	private String	timerUnit;
	private	Integer	wordCount;
	private	Integer	letterCount;
	private	Integer	totalCount;
	private	Integer	errorCount;
	private String	ip;
	private String	deviceDetail;
	private	List<String>	dataList;
	private Map<String,List<Object>>	incorrectWordsList;
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public Integer getLevelId()
	{
		return levelId;
	}
	public void setLevelId(Integer levelId)
	{
		this.levelId = levelId;
	}
	public Long getTimer()
	{
		return timer;
	}
	public void setTimer(Long timer)
	{
		this.timer = timer;
	}
	public Integer getWordCount()
	{
		return wordCount;
	}
	public void setWordCount(Integer wordCount)
	{
		this.wordCount = wordCount;
	}
	public Integer getLetterCount()
	{
		return letterCount;
	}
	public void setLetterCount(Integer letterCount)
	{
		this.letterCount = letterCount;
	}
	public Integer getErrorCount()
	{
		return errorCount;
	}
	public void setErrorCount(Integer errorCount)
	{
		this.errorCount = errorCount;
	}
	public List<String> getDataList()
	{
		return dataList;
	}
	public void setDataList(List<String> dataList)
	{
		this.dataList = dataList;
	}
	public String getTimerUnit()
	{
		return timerUnit;
	}
	public void setTimerUnit(String timerUnit)
	{
		this.timerUnit = timerUnit;
	}
	public Map<String,List<Object>> getIncorrectWordsList()
	{
		return incorrectWordsList;
	}
	public void setIncorrectWordsList(Map<String,List<Object>> incorrectWordsList)
	{
		this.incorrectWordsList = incorrectWordsList;
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
	public Integer getTotalCount()
	{
		return totalCount;
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
	public void setTotalCount(Integer totalCount)
	{
		this.totalCount = totalCount;
	}
	@Override
	public String toString()
	{
		return "TypingGameForm [userName=" + userName + ", userId=" + userId + ", levelId=" + levelId + ", timer="
				+ timer + ", wordCount=" + wordCount + ", letterCount=" + letterCount + ", errorCount=" + errorCount
				+ ", dataList=" + dataList + "]";
	}
}
