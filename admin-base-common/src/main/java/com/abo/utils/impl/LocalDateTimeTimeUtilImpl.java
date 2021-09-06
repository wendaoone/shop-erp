package com.abo.utils.impl;

import com.abo.enums.DatePatternEnum;
import com.abo.utils.DateUtils;
import com.abo.utils.TimeUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTimeUtilImpl implements TimeUtil<LocalDateTime> {
    @Override
    public String format(LocalDateTime time) {
        return  format( time, DatePatternEnum.YYYYMMDDHHMMSS_BYSEP.getFormat());
    }

    @Override
    public String format(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public long getTimeMilli(LocalDateTime time) {
        return DateUtils.fromLDT2Instant(time).toEpochMilli();
    }

    @Override
    public long getTimeSeconds(LocalDateTime time) {
        return DateUtils.fromLDT2Instant(time).getEpochSecond();
    }


    @Override
    public LocalDateTime getDayStartTime(LocalDateTime time) {
        return LocalDateTime.of(time.toLocalDate(), LocalTime.MIN);
    }

    @Override
    public long getDayStartTimeMilli(LocalDateTime time) {
        return getTimeMilli(getDayStartTime(time));
    }

    @Override
    public long getDayStartTimeSeconds(LocalDateTime time) {
        return getTimeSeconds(getDayStartTime(time));
    }

    @Override
    public LocalDateTime getDayEndTime(LocalDateTime time) {
        return LocalDateTime.of(time.toLocalDate(), LocalTime.MAX);
    }

    @Override
    public long getDayEndTimeMilli(LocalDateTime time) {
        return getTimeMilli(getDayEndTime(time));
    }

    @Override
    public long getDayEndTimeSeconds(LocalDateTime time) {
        return getTimeSeconds(getDayEndTime(time));
    }

    @Override
    public Duration diff(LocalDateTime time, LocalDateTime time2) {
        return Duration.between(time, time2);
    }

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
