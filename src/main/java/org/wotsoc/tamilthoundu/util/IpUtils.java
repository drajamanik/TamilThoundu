/**
 * @author Rajamani David
 * @since	Feb 29, 2016
 *
 */
package org.wotsoc.tamilthoundu.util;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rdavid
 *
 */
public class IpUtils {

	  public static final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

	  public static final Pattern pattern = Pattern.compile("^(?:" + _255 + "\\.){3}" + _255 + "$");

	  public static String longToIpV4(long longIp) {

	    int octet3 = (int) ((longIp >> 24) % 256);

	    int octet2 = (int) ((longIp >> 16) % 256);

	    int octet1 = (int) ((longIp >> 8) % 256);

	    int octet0 = (int) ((longIp) % 256);

	    return octet3 + "." + octet2 + "." + octet1 + "." + octet0;

	  }

	  public static long ipV4ToLong(String ip) {

	    String[] octets = ip.split("\\.");

	    return (Long.parseLong(octets[0]) << 24) + (Integer.parseInt(octets[1]) << 16) +

	        (Integer.parseInt(octets[2]) << 8) + Integer.parseInt(octets[3]);

	  }

	  public static boolean isIPv4Private(String ip) {

	    long longIp = ipV4ToLong(ip);

	    return (longIp >= ipV4ToLong("10.0.0.0") && longIp <= ipV4ToLong("10.255.255.255")) ||

	        (longIp >= ipV4ToLong("172.16.0.0") && longIp <= ipV4ToLong("172.31.255.255")) ||

	        longIp >= ipV4ToLong("192.168.0.0") && longIp <= ipV4ToLong("192.168.255.255");

	  }

	  public static boolean isIPv4Valid(String ip) {

	    return pattern.matcher(ip).matches();

	  }

	  public static String getIpFromRequest(HttpServletRequest request) 
	  {

	    String ip;

	    boolean found = false;

	    if ((ip = request.getHeader("x-forwarded-for")) != null) 
	    {
	      StringTokenizer tokenizer = new StringTokenizer(ip, ",");

	      while (tokenizer.hasMoreTokens()) 
	      {
	        ip = tokenizer.nextToken().trim();

	        if (isIPv4Valid(ip) && !isIPv4Private(ip)) {

	          found = true;

	          break;
	        }
	      }
	    }
	    
		ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  

	    if (!found) 
	    {

	      ip = request.getRemoteAddr();

	    }

	    return ip;

	  }
}