package org.wotsoc.tamilthoundu.config;

import org.apache.log4j.Level;
/* Log4J imports */
import org.apache.log4j.Logger;

/**
 * <p>Title: Inspire Logger Implementation (Log4J) </p>
 * <p>Description: Class <b><code>LoggerImpl</code></b> implements
 * InspireLogger interface to provide Log4J implementation.
 *
 * <p><b>The class would be used as follows:</b>
 * <p><p>Use log method for logging with DEBUG, INFO, WARNING, ERROR and FATAL
 * severity levels.
 * <p><code>logger.log(yourMessageObject, logLevel);</code>
 * <p><code>logger.log(yourMessageObject, logLevel, throwable);</code>
 * <p>log levels need to be specified using InspireLogger interface
 * <p>Providing throwable object as the third argument would include the error
 * stack trace in the log appender.
 *
 * <p>
 * Use isDebugEnabled and isInfoEnabled methods to check whther loging is
 * enabled for DEBUG and INFO severity levels respectively
 *
 *
 * @author Johnson Tuscano
 * @version 1.0 07 Nov 2005
 *
 * Modification History:
 * Date         Programmer             Description
 * 09 Nov 2005  Johnson Tuscano        Created
 */
public class LoggerImpl implements TamilThounduLogger {

  /**
   * Holds reference to Log4J Logger instance.
   */
  private Logger logger;

  /**
   * LoggerImpl No arg constructor
   */
  LoggerImpl(){

    logger = Logger.getRootLogger();
  }

  /**
   * LoggerImpl constructor which returns an instance of Log4J Logger for
   * the Class specified.
   */
  LoggerImpl(Class<?> className){

    logger = Logger.getLogger(className.getName());
  }

  /**
   * This method is used to log message with a given log level.
   *
   * @param message Object representing the message object
   * @param level Log level - DEBUG, INFO, WARNING, ERROR OR FATAL
   */
  public void log(Object message, int level){

    /* log message at the specified log level using log4j logger */
    logger.log(Level.toLevel(level, Level.DEBUG), message);
  }

  /**
   * This method is used to log message with a given log level.
   *
   * @param message Object representing the message object
   * @param level Log level - DEBUG, INFO, WARNING, ERROR OR FATAL
   * @param throwable Object of type Throwable
   */
  public void log(Object message, int level, Throwable throwable){

    /* log message along with the exception trace at the specified log level
     * using log4j logger */
    logger.log(Level.toLevel(level, Level.DEBUG), message, throwable);
  }

  /**
   * This method returns boolean flag which indicates whether Debug level is
   * Enabled for the Logger instance
   *
   * @return boolean flag which indicates whether Debug level is Enabled
   */
  public boolean isDebugEnabled(){
    return logger.isDebugEnabled();
  }

  /**
   * This method returns boolean flag which indicates whether Info level is
   * Enabled for the Logger instance
   *
   * @return boolean flag which indicates whether Info level is Enabled
   */
  public boolean isInfoEnabled(){
    return logger.isInfoEnabled();
  }

  

// Delegating methods to Logger ...
  public void debug(Object o) {
    logger.debug(o);
  }

  public void debug(Object o, Throwable throwable) {
    logger.debug(o, throwable);
  }

  public void error(Object o) {
    logger.error(o);
  }

  public void error(Object o, Throwable throwable) {
    logger.error(o, throwable);
  }

  public void fatal(Object o, Throwable throwable) {
    logger.fatal(o, throwable);
  }

  public void fatal(Object o) {
    logger.fatal(o);
  }

  public void warn(Object o) {
    logger.warn(o);
  }

  public void warn(Object o, Throwable throwable) {
    logger.warn(o, throwable);
  }

  public void info(Object o, Throwable throwable) {
    logger.info(o, throwable);
  }

  public void info(Object o) {
    logger.info(o);
  }
}
