/**
 * @author Rajamani David
 * @since	Nov 20, 2015
 *
 */
package org.wotsoc.tamilthoundu.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public enum ConfigReader 
{
	instance;
	
	InputStream inputStream;
	Properties jdbcProp = null;
	
	private ConfigReader() 
	{
	
	}
	
	public Properties getJDBCPropValues()  
	{
		if(jdbcProp==null)
		{
			try
			{
				jdbcProp = getJDBCConfig();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return jdbcProp;
	}
		
		public Properties getJDBCConfig() throws IOException 
		{
			Properties prop = new Properties();
			try 
			{
				String propFileName = "postgres.properties";
	 
				inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
	 
				if (inputStream != null) 
				{
					prop.load(inputStream);
				} 
				else 
				{
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
	 
			} 
			catch (Exception e) 
			{
				System.out.println("Exception: " + e);
			} finally 
			{
				inputStream.close();
			}
			return prop;
		}
		
		public static Object getValue(String key)
		{
			return ConfigReader.instance.getJDBCPropValues().get(key);
		}

		public static void main(String args[])
		{
			System.out.println(ConfigReader.getValue("mysql.jdbc.url"));
		}
 
}
