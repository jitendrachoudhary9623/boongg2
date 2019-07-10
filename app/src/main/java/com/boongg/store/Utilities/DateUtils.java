package com.boongg.store.Utilities;

import android.util.Log;

import java.sql.Timestamp;
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
    public static String getUTC(String date){

        String temp=date;
        date=date.replace("T"," ");
        date=date.substring(0,19);
        Log.e("DATE1",date);
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try{
            Date d=mSimpleDateFormat.parse(date);
            Timestamp timestamp = new Timestamp(d.getTime());
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(timestamp.getTime());
            cal.setTimeInMillis(timestamp.getTime());
            cal.add(Calendar.SECOND, -19080);
            timestamp = new Timestamp(cal.getTime().getTime());
            Log.e("DATE1 parsed",timestamp.toString());
            return d.toString();
        }catch (Exception e){
            Log.e("DATE1",e.toString());
        }
        return temp;
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
