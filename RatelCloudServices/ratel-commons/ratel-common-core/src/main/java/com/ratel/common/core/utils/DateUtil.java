package com.ratel.common.core.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * RatelCloud
 * @ClassName: DateUtil
 * @Package: com.ratel.common.core.utils
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 日期处理帮助类
 * @Version: 1.0
 */
public class DateUtil {
    private static ZoneId zone = ZoneId.of("GMT+10");

    /**
     * yyyyMMddHHmmss
     */
    public static final DateTimeFormatter FORMATTER_DATE_TIMESTAMP = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final String[] PARSE_PATTERNS = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM",
            "yyyyMMdd"};

    public static void setZone(String zoneId) {
        DateUtil.zone = ZoneId.of(zoneId);
    }

    /**
     * 获取当前日期
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前时间
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前日期时间
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前的微秒数
     */
    public static long getClockMillis() {
        Clock clock = Clock.systemDefaultZone();
        return clock.millis();
    }

    public static LocalDate dateLocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(zone).toLocalDate();
    }

    /**
     * 返回当前时间yyyyMMddHHmmss
     */
    public static String getDateTimestamp() {
        return getLocalDateTime().format(FORMATTER_DATE_TIMESTAMP);
    }

    /**
     * 返回当前时间yyyy-MM-dd
     */
    public static String getDate() {
        return getLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 返回当前系统时间 yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTime() {
        return getLocalDateTime().format(FORMATTER_DATE_TIME);
    }

    /**
     * 获取当月第一天 yyyy-MM-dd
     */
    public static String getFirstDayOfMonth() {
        return getLocalDate().withDayOfMonth(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取本月最后一天 yyyy-MM-dd
     */
    public static String getLastDayOfMonth() {
        LocalDate localDate = getLocalDate();
        return localDate.withDayOfMonth(localDate.lengthOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 将yyyyMMddHHmmss转为 yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTimestamp(String dateTimestamp) {
        return LocalDateTime.parse(dateTimestamp, FORMATTER_DATE_TIMESTAMP).format(FORMATTER_DATE_TIME);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转为 yyyyMMddHHmmss
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTime(String dateTime) {
        return parseLocalDateTime(dateTime).format(FORMATTER_DATE_TIMESTAMP);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转为 LocalDateTime
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, FORMATTER_DATE_TIME);
    }

    /**
     * 将yyyyMMddHHmmss转为 LocalDateTime
     *
     * @param dateTimestamp
     * @return
     */
    public static LocalDateTime parseLocalDateTimestamp(String dateTimestamp) {
        return LocalDateTime.parse(dateTimestamp, FORMATTER_DATE_TIMESTAMP);
    }

    /**
     * yyyy-MM-dd字符串转LocalDate
     *
     * @param dateString
     * @return
     */
    public static LocalDate parseLocalDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * yyyy-MM-dd 增加日期
     *
     * @param date
     * @param days
     * @return
     */
    public static String plusDays(String date, int days) {
        LocalDate localDate = parseLocalDate(date);
        return localDate.plusDays(days).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDate 较小的时间 yyyy-MM-dd
     * @param endDate 较大的时间 yyyy-MM-dd
     * @return 相差天数
     */
    public static int dateCompareTo(String startDate, String endDate) {
        LocalDate startLocalDate = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endLocalDate = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
        Period period = Period.between(startLocalDate, endLocalDate);
        return period.getDays();
    }

    /**
     * 获取时间节点所在的月份第一天
     *
     * @param localDate
     * @return
     */
    public static LocalDate firstDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取时间节点所在的月份最后一天
     *
     * @param localDate
     * @return
     */
    public static LocalDate lastDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    public static LocalDate toLocalDate(Date date) {
        return null == date ? null : date.toInstant().atZone(zone).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return null == date ? null : date.toInstant().atZone(zone).toLocalDateTime();
    }

    //--------------------------------------------------------------------------------------
    /**
     * LocalDateTimel转Date
     *
     * @param dateTime
     * @return
     */
    public static Date toDate(LocalDateTime dateTime) {
        Instant instant = dateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalDate + LocalTime 转Date
     *
     * @param date
     * @param time
     * @return
     */
    public static Date toDate(LocalDate date, LocalTime time) {
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        return toDate(dateTime);
    }

    /**
     * 日期字符串转当天 00:00:00.000 的Date
     *
     * @param dateStr 格式 yyyy-MM-dd
     * @return
     */
    public static Date parseStartOfDay(String dateStr) {
        LocalDate localDate = parseLocalDate(dateStr);
        Instant instant = LocalDateTime.of(localDate, LocalTime.MIN).atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 日期字符串转当天 23:59:59.999999999 的Date
     *
     * @param dateStr 格式 yyyy-MM-dd
     * @return
     */
    public static Date parseEndOfDay(String dateStr) {
        LocalDate localDate = parseLocalDate(dateStr);
        Instant instant = LocalDateTime.of(localDate, LocalTime.MAX).atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 转当天 00:00:00.000 的Date
     *
     * @param date
     * @return
     */
    public static Date transferStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        Instant instant = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN).atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 转当天 23:59:59.999999999 的Date
     *
     * @param date
     * @return
     */
    public static Date transferEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        Instant instant = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date parseDate(String dateStr) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, PARSE_PATTERNS);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String format(Date date, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static Date plusDays(Date date, int days) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        Instant instant = localDateTime.plusDays(days).atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 日期是否是周末
     *
     * @param date
     * @return true->周末日期；false->工作日
     */
    public static boolean isWeekend(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    // 重写并保留两个方法，根据参数作为区分，在页面可以调用 %{changeYMDtoEn(columeName)}
    public static String changeYMDtoEn(String dateYMD) {
        Date dates = parseDate(dateYMD);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy", Locale.UK);      // 月日年
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+10"));
        return sdf.format(dates);
    }

    // 因为上面方法在jsp中会有年份截取情况，因此页面实际调用是这个方法
    public static String changeYMDtoEn(Date dateYMD) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.UK);      // 月日年
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+10"));
        return sdf.format(dateYMD);
    }

     /**
      * @Author: Eric
      * @Date: 2:03 PM 18/09/20
      * @Description: 获取当前时间的时间戳
      * @Param:
      * @Return:
      */
    public static Timestamp getCurrentTimeStamp(){
        LocalDateTime now = LocalDateTime.now();
        return Timestamp.valueOf(now);
    }

     /**
      * @Author: Eric
      * @Date: 2:53 PM 18/09/20
      * @Description: 取得当前时间戳（精确到秒）
      * @Param:
      * @Return:
      */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }
}
