package com.blessing.aisaka.utils;

/**
 * 时间工具类
 *
 * @author zhou.peng
 * @date 2019/05/08
 */
public class TimeUtil {

    public static Integer milesecondToMintue(long milesecond) {
        return (int) milesecond / (1000 * 60);
    }
}
