package org.wotsoc.tamilthoundu.config;

/**
 * <p>Title: Inspire Logger</p>
 * <p>Description: Class <b><code>InspireLogger</code></b> provides a generic
 * interface to access multiple logging implementations.
 * <p>Various logging implementations can be <b>Log4j</b>, <b>JDK logging</b>,
 * <b>Apache LogKit</b> etc
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
public interface TamilThounduLogger {

  /** This constant indicates logging at DEBUG level */
  public final static int DEBUG = 10000;

  /** This constant indicates to logging at INFO level */
  public final static int INFO = 20000;

  /** This constant indicates to logging at WARNING level */
  public final static int WARN = 30000;

  /** This constant indicates to logging at ERROR level */
  public final static int ERROR = 40000;

  /** This constant indicates to logging at FATAL level */
  public final static int FATAL = 50000;

  /**
   * This method is used to log message with a given log level.
   *
   * @param message Object representing the message object
   * @param level Log level - DEBUG, INFO, WARNING, ERROR OR FATAL
   */
  public void log(Object message, int level);

  /**
   * This method is used to log message with a given log level.
   *
   * @param message Object representing the message object
   * @param level Log level - DEBUG, INFO, WARNING, ERROR OR FATAL
   * @param thowable Object of type Throwable
   */
  public void log(Object message, int level, Throwable thowable);

  /**
   * This method returns boolean flag which indicates whether Debug level is
   * Enabled for the Logger instance
   *
   * @return boolean flag which indicates whether Debug level is Enabled
   */
  public boolean isDebugEnabled();

  /**
   * This method returns boolean flag which indicates whether Info level is
   * Enabled for the Logger instance
   *
   * @return boolean flag which indicates whether Info level is Enabled
   */
  public boolean isInfoEnabled();


  // Fiendly logging methods 
  public void debug(Object o);
  public void debug(Object o, Throwable throwable);
  public void info(Object o);
  public void info(Object o, Throwable throwable);
  public void warn(Object o);
  public void warn(Object o, Throwable throwable);
  public void error(Object o);
  public void error(Object o, Throwable throwable);
  public void fatal(Object o);
  public void fatal(Object o, Throwable throwable);
}
