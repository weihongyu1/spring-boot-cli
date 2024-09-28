package com.why.springbootcli.common;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间日期工具类
 *
 * @DATE 2024/9/28
 * @Author why
 */
public class DateTimeUtils {

    public static final String DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 格式化时间
     * @param dateTime 时间
     * @return 格式化后的时间
     */
    public static String formatDate(LocalDateTime dateTime) {
        return formatDateTime(dateTime, null);
    }

    /**
     * 格式化时间
     * @param dateTime 时间
     * @param format 格式
     * @return 格式化后的时间
     */
    public static String formatDateTime(LocalDateTime dateTime, String format) {
        if (StringUtils.isBlank(format)) {
            format = DATE_TIME_FORMAT_STR;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
}
