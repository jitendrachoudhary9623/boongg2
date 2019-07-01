package com.boongg.store.Utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ProgressBar;

public class ProgressbarUtil {
    public static ProgressDialog progressDialog=null;
    public static  void showProgressbar(Context context){

        if(progressDialog==null) {
            progressDialog = new ProgressDialog(context);

            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
        }
    }
    public static  void showProgressbarWithMsg(Context context,String msg){

            progressDialog = new ProgressDialog(context);

            progressDialog.setIndeterminate(true);
            progressDialog.setMessage(msg);
            progressDialog.show();

    }

    public static  void hideProgressBar(){
        if(progressDialog!=null){
            progressDialog.hide();
        }
    }
}
