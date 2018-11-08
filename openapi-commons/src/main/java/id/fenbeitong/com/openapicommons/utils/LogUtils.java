package id.fenbeitong.com.openapicommons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * LogUtils
 * <p>Log Utils
 *
 * @author Created by ivan on 上午11:48 18-11-8.
 * @version 1.0
 **/
public class LogUtils {

    /**
     * @param clazz :
     * @return org.slf4j.Logger
     * @author Created by ivan on 上午11:49 18-11-8.
     * <p>get log for class
     **/
    public static Logger get(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * @param logger :
     * @return org.slf4j.Logger
     * @author Created by ivan on 上午11:49 18-11-8.
     * <p>Get logger for defined logger.
     **/
    public static Logger get(String logger) {
        return LoggerFactory.getLogger(logger);
    }

    /**
     * @return org.slf4j.Logger
     * @author Created by ivan on 上午11:50 18-11-8.
     * <p>Get logger for current class in thread.
     **/
    public static Logger get() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 第二层 Thread,target
        return LoggerFactory.getLogger(stackTrace[2].getClassName());
    }

    // ------------------------ Trace

    /**
     * Trace等级日志，小于debug<br>
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void trace(String format, Object... arguments) {
        trace(innerGet(), format, arguments);
    }

    /**
     * Trace等级日志，小于Debug
     *
     * @param log       日志对象
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void trace(Logger log, String format, Object... arguments) {
        log.trace(format, arguments);
    }

    // ------------------------ debug

    /**
     * Debug等级日志，小于Info<br>
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void debug(String format, Object... arguments) {
        debug(innerGet(), format, arguments);
    }

    /**
     * Debug等级日志，小于Info
     *
     * @param log       日志对象
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void debug(Logger log, String format, Object... arguments) {
        log.debug(format, arguments);
    }

    // ------------------------ info

    /**
     * Info等级日志，小于Warn<br>
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void info(String format, Object... arguments) {
        info(innerGet(), format, arguments);
    }

    /**
     * Info等级日志，小于Warn
     *
     * @param log       日志对象
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void info(Logger log, String format, Object... arguments) {
        log.info(format, arguments);
    }

    // ------------------------ warn

    /**
     * Warn等级日志，小于Error<br>
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void warn(String format, Object... arguments) {
        warn(innerGet(), format, arguments);
    }

    /**
     * Warn等级日志，小于Error
     *
     * @param log       日志对象
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void warn(Logger log, String format, Object... arguments) {
        log.warn(format, arguments);
    }

    /**
     * Warn等级日志，小于Error<br>
     *
     * @param e         需在日志中堆栈打印的异常
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void warn(Throwable e, String format, Object... arguments) {
        warn(innerGet(), e, format(format, arguments));
    }

    /**
     * Warn等级日志，小于Error
     *
     * @param log       日志对象
     * @param e         需在日志中堆栈打印的异常
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void warn(Logger log, Throwable e, String format, Object... arguments) {
        log.warn(format(format, arguments), e);
    }

    /**
     * Error等级日志<br>
     *
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void error(String format, Object... arguments) {
        error(innerGet(), format, arguments);
    }

    /**
     * Error等级日志<br>
     *
     * @param log       日志对象
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void error(Logger log, String format, Object... arguments) {
        log.error(format, arguments);
    }

    /**
     * Error等级日志<br>
     *
     * @param e         需在日志中堆栈打印的异常
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void error(Throwable e, String format, Object... arguments) {
        error(innerGet(), e, format(format, arguments));
    }

    /**
     * Error等级日志<br>
     *
     * @param log       日志对象
     * @param e         需在日志中堆栈打印的异常
     * @param format    格式文本，{} 代表变量
     * @param arguments 变量对应的参数
     */
    public static void error(Logger log, Throwable e, String format, Object... arguments) {
        log.error(format(format, arguments), e);
    }

    /**
     * @return 动态获得日志，效率低.
     */
    private static Logger innerGet() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 第三层Thread, innerGet, target
        return LoggerFactory.getLogger(stackTrace[3].getClassName());
    }

    /**
     * 参数处理.
     *
     * @param template 模板
     * @param values   值
     */
    private static String format(String template, Object... values) {
        return String.format(template.replace("{}", "%s"), values);
    }

}
