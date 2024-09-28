package com.why.springbootcli.common.config.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.LayoutBase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.why.springbootcli.common.utils.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义日志数据Layout
 *
 * @DATE 2024/9/28
 * @Author why
 */
public class LogstashLayout extends LayoutBase<ILoggingEvent> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String doLayout(ILoggingEvent loggingEvent) {
        String separator = System.lineSeparator();
        JSONObject logstashEvent = new JSONObject(true);
        //设置系统时间
        logstashEvent.put("log_time", DateTimeUtils.formatDate(LocalDateTime.now()));
        //设置日志级别
        Level level = loggingEvent.getLevel();
        logstashEvent.put("level", level.levelStr);
        //设置类路径
        String className = loggingEvent.getLoggerName();
        StackTraceElement[] data = loggingEvent.getCallerData();
        if (data != null && data.length > 0) {
            String fileName = data[0].getFileName();
            int lineNumber = data[0].getLineNumber();
            String methodName = data[0].getMethodName();
            className = className + "." + methodName + "(" + fileName + ":" + lineNumber + ")";
        }
        logstashEvent.put("className", className);
        //设置message
        String message = loggingEvent.getFormattedMessage();
        if (StringUtils.isNotBlank(message)) {
            JSONObject msgObj = JSON.parseObject(message);
            logstashEvent.putAll(msgObj);
        }
        //设置异常信息
        if (loggingEvent.getThrowableProxy() != null) {
            setErrLogDetails(loggingEvent, logstashEvent);
        }
        return logstashEvent + separator;
    }

    /**
     * 设置异常信息
     * @param loggingEvent 日志事件
     * @param logstashEvent 日志事件
     */
    private void setErrLogDetails(ILoggingEvent loggingEvent, JSONObject logstashEvent) {
        IThrowableProxy throwableProxy = loggingEvent.getThrowableProxy();
        //设置异常的类
        String exceptionClass = throwableProxy.getClassName();
        if (StringUtils.isNotBlank(exceptionClass)) {
            exceptionClass = exceptionClass.replace(".", "_");
        }
        logstashEvent.put("exceptionClass", exceptionClass);
        //设置异常描述信息
        String errMsg = throwableProxy.getMessage();
        logstashEvent.put("errMsg", errMsg);
        //设置堆栈信息
        ExtendedThrowableProxyConverter converter = new ExtendedThrowableProxyConverter();
        String stackInfo = converter.convert(loggingEvent);
        logstashEvent.put("stackInfo", stackInfo);
        converter.stop();
    }
}
