package org.wotsoc.tamilthoundu.domain;

public class TypingConfig
{
	int tcId;
	int levelId; 
	long time; 
	String timeUnit;
	int beginRange;
	int endRange;
	String letterType;

	public int getTcId()
	{
		return tcId;
	}
	public void setTcId(int tcId)
	{
		this.tcId = tcId;
	}
	public int getLevelId()
	{
		return levelId;
	}
	public void setLevelId(int levelId)
	{
		this.levelId = levelId;
	}
	public long getTime()
	{
		return time;
	}
	public void setTime(long time)
	{
		this.time = time;
	}
	public String getTimeUnit()
	{
		return timeUnit;
	}
	public void setTimeUnit(String timeUnit)
	{
		this.timeUnit = timeUnit;
	}
	public int getBeginRange()
	{
		return beginRange;
	}
	public void setBeginRange(int beginRange)
	{
		this.beginRange = beginRange;
	}
	public int getEndRange()
	{
		return endRange;
	}
	public void setEndRange(int endRange)
	{
		this.endRange = endRange;
	}
	public String getLetterType()
	{
		return letterType;
	}
	public void setLetterType(String letterType)
	{
		this.letterType = letterType;
	}
	@Override
	public String toString()
	{
		return "TypingConfig [tcId=" + tcId + ", levelId=" + levelId + ", time=" + time + ", timeUnit=" + timeUnit
				+ ", beginRange=" + beginRange + ", endRange=" + endRange + ", letterType=" + letterType + "]";
	}
}
