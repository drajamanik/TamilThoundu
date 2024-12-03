package org.wotsoc.tamilthoundu.domain;

import java.util.Date;

public class WordTable {
	private Integer wordNo;
	private String word;
	private String resultType;
	private String comments;
	private String userId;
	private Date dateTime;
	private String wordType;
	private Integer frequency;
	
	public Integer getWordNo() {
		return wordNo;
	}
	public void setWordNo(Integer wordNo) {
		this.wordNo = wordNo;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getWordType() {
		return wordType;
	}
	public void setWordType(String wordType) {
		this.wordType = wordType;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	@Override
	public String toString() {
		return "WordTable [wordNo=" + wordNo + ", word=" + word + ", resultType=" + resultType + ", comments="
				+ comments + ", userId=" + userId + ", dateTime=" + dateTime + ", wordType=" + wordType + ", frequency="
				+ frequency + "]";
	}
}
