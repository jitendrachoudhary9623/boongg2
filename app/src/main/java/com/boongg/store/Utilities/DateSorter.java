package com.boongg.store.Utilities;


import android.util.Log;

import com.boongg.store.Models.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public static List<Booking> getBookings(String category,List<Booking> response){
        List<Booking> cBookings=new ArrayList<>();
        Log.e("JWT",category);
        for(Booking b:response){
        new Date();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date date1 = new Date();
                Date date2 = sdf.parse(b.getStartDate());
                Log.e("JWT","Date 1 "+new Date());
                Log.e("JWT","Date 2 "+date2);

                switch(category){
                    case "Today":
                        if(date1.compareTo(date2)==0){
                            cBookings.add(b);
                        }
                        break;
                    case "Future":
                        if(date1.before(date2)){
                            cBookings.add(b);
                        }
                        break;
                    case "Overdue":
                        Log.e("JWT","Overdue 2");

                        if(date1.after(date2)){
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
