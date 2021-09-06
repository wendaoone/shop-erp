package com.abo.utils;

import java.time.Duration;

public interface TimeUtil<E> {
    String format(E time);

    String format(E time, String pattern);

    /**
     * 获取时间戳-毫秒数
     */
    long getTimeMilli(E time);

    /**
     * 获取时间戳-秒数
     */
    long getTimeSeconds(E time);


    /**
     * 获取一天的开始时间(0点时间)
     */
    E getDayStartTime(E time);

    /**
     * 获取一天的开始时间(0点时间) 时间戳-毫秒
     */
    long getDayStartTimeMilli(E time);


    /**
     * 获取一天的开始时间(0点时间) 时间戳-秒
     */
    long getDayStartTimeSeconds(E time);


    /**
     * 获取一天的结束时间('23:59:59.999999999')
     */
    E getDayEndTime(E time);

    /**
     * 获取一天的结束时间('23:59:59.999999999') 的时间戳-毫秒
     */
    long getDayEndTimeMilli(E time);


    /**
     * 获取一天的结束时间('23:59:59.999999999') 的时间戳-秒
     */
    long getDayEndTimeSeconds(E time);

    /**
     * 计算两个时间差(小的时间作为第1个参数，大的时间作为第二个参数，否则会返回负数)
     *
     * @param time  时间1（小）
     * @param time2 时间2（大）
     * @return 返回时间差对象
     * @author wulm
     **/
    Duration diff(E time, E time2);

    /**
     * 计算两个毫秒时间差(小的时间作为第1个参数，大的时间作为第二个参数，否则会返回负数)
     *
     * @param time  时间1（小）
     * @param time2 时间2（大）
     * @return 毫秒时间差
     * @author wulm
     **/
    default long diffToMilli(E time, E time2) {
        return diff(time, time2).toMillis();
    }

    /**
     * 计算两个毫秒时间差,取绝对值
     *
     * @param time  时间1
     * @param time2 时间2
     * @return 毫秒时间差, 取绝对值
     * @author wulm
     **/
    default long diffToMilliAbs(E time, E time2) {
        return Math.abs(diffToMilli(time, time2));
    }

    /**
     * 计算与当前的时间差（当前时间之前结果为“正数”，当前时间之后结果为“负数”）
     *
     * @param time 要计算的时间
     * @return 时间差对象
     * @author wulm
     **/
    default Duration diffNow(E time) {
        return diff(time, now());
    }

    /**
     * 计算与当前时间的毫秒时间差
     *
     * @param time 要比较的时间
     * @return 毫秒时间差，返回正数:小于当前时间，负数:大于当前时间,0:和当前时间相同
     * @author wulm
     **/
    default long diffNowToMilli(E time) {
        return diffNow(time).toMillis();
    }

    /**
     * 计算与当前时间的毫秒时间差（返回正数）
     *
     * @author wulm
     **/
    default long diffNowToMilliAbs(E time) {
        return Math.abs(diffNowToMilli(time));
    }

    E now();
}
