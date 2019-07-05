package com.boongg.store.Utilities;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

    public static String getIST(String date){
        Log.e("DATE 2 Input",date);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC+4"));
        //remove unwanted data
        date=date.replace("T"," ");
        date=date.substring(0,date.length()-6);
        //date=date.replace(".000Z","");
        try {
            //date
            Date d1 = formatter.parse(date);
            d1.toLocaleString();
            DateFormat originalFormat = new SimpleDateFormat("EEE MMM dd kk:mm:ss yyyy", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
            Date date2 = originalFormat.parse(d1.toString().replace(" GMT+05:30 ", " "));
            String formattedDate = targetFormat.format(date2);
            Log.e("DATE 2 Output",formattedDate);
            return formattedDate;
        }catch (Exception e){
                Log.e("DATE",e.toString());
        }
        return date;
    }

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
