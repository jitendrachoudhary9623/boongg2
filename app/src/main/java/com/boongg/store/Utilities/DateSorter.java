package com.boongg.store.Utilities;


import android.util.Log;

import com.boongg.store.Models.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateSorter {
    public static String getFormattedDate(String d) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy h:mm a");
        Date date = inputFormat.parse(d);
        String formattedDate = outputFormat.format(date);
        String formattedDate1 = formattedDate;
        return formattedDate1;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
       return calendar1.equals(calendar2);
    }
    public static boolean isFuture(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.before(calendar2);

    }
    public static boolean isPast(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
       return calendar1.after(calendar2);
    }
    public static List<Booking> getBookings(String category,List<Booking> response){
        List<Booking> cBookings=new ArrayList<>();
        Log.e("JWT",category);
        for(Booking b:response){
        new Date();
            try {
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                String date = simpleDateFormat.format(new Date());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse(date);
                Date date2 = sdf.parse(b.getEndDate());


                Log.e("JWT","Date 1 "+ date1);
                Log.e("JWT","Date 2 "+date2);
                Log.e("JWT",""+isSameDay(date1,date2)+" "+isFuture(date1,date2));

                switch(category){
                    case "Today":
                        if(isSameDay(date1,date2)){
                            cBookings.add(b);
                        }
                        break;
                    case "Future":
                        if(isFuture(date1,date2)){
                            cBookings.add(b);
                        }
                        break;
                    case "Overdue":
                        Log.e("JWT","Overdue 2");

                        if(isPast(date1,date2)){
                            cBookings.add(b);
                            Log.e("JWT","Overdue 3");

                        }
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.e("JWT",e.toString());
            }
        }
        return cBookings;
    }
}
