package com._520it.crm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/16.
 */
public class ParseDate {
    public static Date parseDate(String date){
        Date time = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        try {
            time=sd.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
