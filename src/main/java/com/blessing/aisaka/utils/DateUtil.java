package com.blessing.aisaka.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhou.peng
 * @date 2019/03/15
 */
public class DateUtil {
    private static DateFormat dateFormatDay = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat dateFormatSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date stringToDay(String str) {
        Date date = null;
        try {
            date = dateFormatDay.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
