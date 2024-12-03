package org.wotsoc.tamilthoundu.config;

/* Core java imports */
/**
 * <p>Title: Inspire LoggerFactory</p>
 * <p>Description: Class <b><code>LoggerFactory</code></b> is a factory for
 * logger component and returns an instance of logger implementation.
 * Method getCurrentInstance returns an instance of type InspireLogger.
 *
 * <p><b>The class would be used as follows:</b>
 * <p><p>Use log method for logging with DEBUG, INFO, WARNING, ERROR and FATAL
 * severity levels.
 * <p><code>logger.log(yourMessageObject, logLevel);</code>
 *
 * @author Johnson Tuscano
 * @version 1.0 03 Nov 2005
 *
 * Modification History:
 * Date         Programmer             Description
 * 03 Nov 2005  Johnson Tuscano        Created
 */
public class LoggerFactory 
{
  /** Constructor defined private so as to restrict instance creation */
  private LoggerFactory(){
  }

  /**
   * This method returns an instance of InspireLogger.
   * Parameter passed is the name of class which requires logging. This method
   * creates an instance of InspireLogger and returns it to the caller.
   *
   * <p><b>The class would be used as follows:</b>
   * <p>Get instance of Logger object:
   * <p><code>private static InspireLogger logger = LoggerFactory
   * .getCurrentInstance(YourClassName.class);<code>
 * @param <T>
   *
   * @param className class which requires logging.
   * @return Instance of InspireLogger.
   */
  public static TamilThounduLogger getCurrentInstance(Class<?> className)
  {
    return new LoggerImpl(className);
  }
}
