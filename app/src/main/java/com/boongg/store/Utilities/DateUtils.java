package com.boongg.store.Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getTodaysDate(){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public  static  String getDateAfterBeforeTime(int monthsToAdd){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, monthsToAdd);

        return (c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)) +
                "-" + c.get(Calendar.DATE));

    }
}
