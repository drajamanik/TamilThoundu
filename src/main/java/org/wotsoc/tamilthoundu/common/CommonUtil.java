/**
 * @author Rajamani David
 * @since	Nov 24, 2015
 *
 */
package org.wotsoc.tamilthoundu.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil 
{
	public CommonUtil() 
	{
	 
	}

	public static Map<String,Object> getParams(String value[])
	{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Constants.USER_NAME ,value[0]);
    	map.put(Constants.PASSWORD ,value[1]);
    	map.put(Constants.IP_LOCATION ,value[2]);
		return map;
	}
	public static Map<String,Object> getParams(String name[],String value[])
	{
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0;i<name.length;i++)
		{
			map.put(name[i], value[i]);
		}
		return map;
	}
	
	public static String commaSeparatedString(List<Integer> intIds)
	{
		StringBuilder sb = new StringBuilder();
		for (Integer id : intIds)
		{
			sb.append(id).append(",");
		}
		String str = sb.toString();
		if (str.endsWith(","))
		{
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}


}
