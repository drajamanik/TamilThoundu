/**
 * @author Rajamani David
 * @since	Mar 23, 2016
 *
 */
package org.wotsoc.tamilthoundu.servlet;

/**
 * @author rdavid
 *
 */
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener 
{

  private static int totalActiveSessions;
	
  public static int getTotalActiveSession()
  {
	return totalActiveSessions;
  }
	
  @Override
  public void sessionCreated(HttpSessionEvent arg0) 
  {
	totalActiveSessions++;
	System.out.println("sessionCreated - add one session into counter");
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) 
  {
	totalActiveSessions--;
	System.out.println("sessionDestroyed - deduct one session from counter");
  }	
}
