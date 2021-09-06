package com.abo.utils;

import com.abo.utils.impl.DateTimeUtilImpl;
import com.abo.utils.impl.InstantTimeUtilImpl;
import com.abo.utils.impl.LocalDateTimeTimeUtilImpl;
import com.abo.utils.impl.LongTimeUtilImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
    /**
     * LocalDateTime工具
     */
    public static final LocalDateTimeTimeUtilImpl LOCAL_DATE_TIME = new LocalDateTimeTimeUtilImpl();

    /**
     * Instant工具
     */
    public static final InstantTimeUtilImpl INSTANT = new InstantTimeUtilImpl();

    /**
     * Date工具
     */
    public static final DateTimeUtilImpl DATE = new DateTimeUtilImpl();

    /**
     * 毫秒时间戳工具
     */
    public static final LongTimeUtilImpl LONG_MILLI = new LongTimeUtilImpl();


    public static LocalDateTime fromInstant2LDT(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static Date fromInstant2Date(Instant instant) {
        return Date.from(instant);
    }

    public static Instant fromDate2Instant(Date date) {
        return date.toInstant();
    }

    public static LocalDateTime fromDate2LDT(Date date) {
        return fromInstant2LDT(fromDate2Instant(date));
    }

    public static Instant fromLDT2Instant(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    public static Date fromLDT2Date(LocalDateTime time) {
        return fromInstant2Date(fromLDT2Instant(time));
    }
}
