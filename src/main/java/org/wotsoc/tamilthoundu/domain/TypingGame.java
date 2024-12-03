package org.wotsoc.tamilthoundu.domain;

public class TypingGame
{
	Integer	tgId; 
	Integer	levelId; 
	Integer	seqId;
	Integer	wordCount;
	Integer	letterCount;
	String	typeText;
	
	public Integer getTgId()
	{
		return tgId;
	}
	public void setTgId(Integer tgId)
	{
		this.tgId = tgId;
	}
	public Integer getLevelId()
	{
		return levelId;
	}
	public void setLevelId(Integer levelId)
	{
		this.levelId = levelId;
	}
	public Integer getSeqId()
	{
		return seqId;
	}
	public void setSeqId(Integer seqId)
	{
		this.seqId = seqId;
	}
	public String getTypeText()
	{
		return typeText;
	}
	public void setTypeText(String typeText)
	{
		this.typeText = typeText;
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
	@Override
	public String toString()
	{
		return "TypingGame [tgId=" + tgId + ", levelId=" + levelId + ", seqId=" + seqId + ", CharLen=" + letterCount + ",WordLen=" + wordCount +
				", typeText=" + typeText +  "]";
	}
}
