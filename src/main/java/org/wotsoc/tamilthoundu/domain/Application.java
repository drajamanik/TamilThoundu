/**
 * @author Rajamani David
 * @since	Feb 13, 2016
 *
 */
package org.wotsoc.tamilthoundu.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rdavid
 *
 */
@XmlRootElement
public class Application 
{
	private String appUrl;
	private String appVersion;
	private String appMode;//DEV/TEST/PROD
	
	public Application() 
	{
	 
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppMode() {
		return appMode;
	}

	public void setAppMode(String appMode) {
		this.appMode = appMode;
	}

}
