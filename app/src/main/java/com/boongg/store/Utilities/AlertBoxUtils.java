package com.boongg.store.Utilities;

import android.content.Context;
import android.graphics.Color;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AlertBoxUtils {

    static SweetAlertDialog pDialog=null;
    public static void showAlert(Context context, String type,String title, String message){

        int id=0;
        switch (type){
            case "success":
                id=SweetAlertDialog.SUCCESS_TYPE;
                break;
            case "error":
                id=SweetAlertDialog.ERROR_TYPE;
                break;
            case "warning":
                id=SweetAlertDialog.WARNING_TYPE;
                break;
        }

        new SweetAlertDialog(context, id)
                .setTitleText(title)
                .setContentText(message)
                .show();
    }

    public static  void showLoadingAlert(Context context){
        if(pDialog!=null) {
            pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Loading");
            pDialog.setCancelable(false);
            pDialog.show();
        }
    }
    public  static void hideLoadingAlert(){
        if(pDialog!=null){
            pDialog.hide();
            pDialog=null;
        }
    }

}
