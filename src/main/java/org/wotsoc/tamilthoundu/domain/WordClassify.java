package org.wotsoc.tamilthoundu.domain;

public class WordClassify {
	private Integer classifyNo;
	private String classifyType;
	
	public Integer getClassifyNo() {
		return classifyNo;
	}
	public void setClassifyNo(Integer classifyNo) {
		this.classifyNo = classifyNo;
	}
	public String getClassifyType() {
		return classifyType;
	}
	public void setClassifyType(String classifyType) {
		this.classifyType = classifyType;
	}
	@Override
	public String toString() {
		return "WordClassify [classifyNo=" + classifyNo + ", classifyType=" + classifyType + "]";
	}
}
