package com.boongg.store.Utilities;


import android.util.Log;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Responses.Drop.DropBooking;

import java.sql.Timestamp;
import java.text.DateFormat;
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

    public static List<DropBooking> getDropBookings(String category, List<DropBooking> response, boolean chooseStart){
        List<DropBooking> cBookings=new ArrayList<>();
        Log.e("JWT",category);
        for(DropBooking b:response){
            new Date();
            try {
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                String date = simpleDateFormat.format(new Date());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse(date);
                Date date2;
                if(chooseStart)
                    date2 = sdf.parse(b.getStartDate());
                else{
                    date2 = sdf.parse(b.getEndDate());
                }

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
                        if(isPast(date1,date2)){
                            cBookings.add(b);
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

    public static List<Booking> getBookings(String category,List<Booking> response,boolean chooseStart){
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
                Date date2;
                if(chooseStart)
                     date2 = sdf.parse(b.getStartDate());
                else{
                    date2 = sdf.parse(b.getEndDate());
                }

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
                        if(isPast(date1,date2)){
                            cBookings.add(b);
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
    public static String convertStringToTimestamp(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            // you can change format of date
            Date date = formatter.parse(str_date);
            return String.valueOf(date.getTime());
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }
}
