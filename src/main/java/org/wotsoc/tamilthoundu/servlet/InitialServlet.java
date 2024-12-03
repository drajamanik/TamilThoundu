/**
 * @author Rajamani David
 * @since	Mar 25, 2016
 *
 */
package org.wotsoc.tamilthoundu.servlet;

import java.time.Duration;
import java.time.Instant;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.wotsoc.tamilthoundu.config.LoggerFactory;
import org.wotsoc.tamilthoundu.config.TamilThounduLogger;

/**
 * @author rdavid
 *
 */
public class InitialServlet extends HttpServlet  
{
	private static final long serialVersionUID = -7127262805015380147L;
	private static final TamilThounduLogger logger = LoggerFactory.getCurrentInstance(InitialServlet.class);
	
	public InitialServlet() 
	{
		 
	}
	
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		logger.log("Entered init()", TamilThounduLogger.INFO);
		intialize();
	}
	
	public void intialize()
	{
		Instant start, end;
		start = Instant.now();
 		end = Instant.now();
		long ns = Duration.between(start, end).toNanos()/1000000000;
		logger.log("All Init Load Completed in "+ns, TamilThounduLogger.INFO);
	}
}
