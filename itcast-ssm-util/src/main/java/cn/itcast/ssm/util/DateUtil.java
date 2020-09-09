package cn.itcast.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String Date2String(String format, Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String format1 = simpleDateFormat.format(date);
        return format1;
    }

    public static Date String2Date(String format, String date) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date parse = simpleDateFormat.parse(date);
        return parse;
    }
}
