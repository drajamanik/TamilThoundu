/**
 * @author Rajamani David
 * @since	Feb 13, 2016
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
public class Constants 
{
	Integer constantsId;
	String	key1;
	String	key2;
	String	key3;
	String	value1;
	String	value2;
	String	value3;
	String	active;
	String	addby;
	Date	addon;
	String	modifedby;
	Date	modifiedon;
	 
	public Constants() 
	{
 
	}

	public Integer getConstantsId() {
		return constantsId;
	}

	public void setConstantsId(Integer constantsId) {
		this.constantsId = constantsId;
	}

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getKey3() {
		return key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getAddby() {
		return addby;
	}

	public void setAddby(String addby) {
		this.addby = addby;
	}

	public Date getAddon() {
		return addon;
	}

	public void setAddon(Date addon) {
		this.addon = addon;
	}

	public String getModifedby() {
		return modifedby;
	}

	public void setModifedby(String modifedby) {
		this.modifedby = modifedby;
	}

	public Date getModifiedon() {
		return modifiedon;
	}

	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	@Override
	public String toString() {
		return "Constants [constantsId=" + constantsId + ", key1=" + key1
				+ ", key2=" + key2 + ", key3=" + key3 + ", value1=" + value1
				+ ", value2=" + value2 + ", value3=" + value3 + ", active="
				+ active + ", addby=" + addby + ", addon=" + addon
				+ ", modifedby=" + modifedby + ", modifiedon=" + modifiedon
				+ "]";
	}

}
