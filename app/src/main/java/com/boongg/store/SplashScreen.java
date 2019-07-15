package com.boongg.store;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {

    TextView text;
    String appPermissions[] = {Manifest.permission.INTERNET,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.CAMERA};
    private static final int PERMISSION_REQUEST_CODE = 1102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        text=(TextView)findViewById(R.id.splash_status);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                text.setText("Checking Permissions");
                if(checkAndRequestPermissions()) {
                    text.setText("Starting Application...");

                    initApp();
                }
                else{
                    text.setText("Please provide all the permissions");

                    //checkAndRequestPermissions();
                }
            }
        }, 3* 1000);
    }

    public boolean checkAndRequestPermissions() {
        List<String> listPermissionNedded = new ArrayList<>();
        for (String perm : appPermissions) {
            if (ContextCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED) {
                    listPermissionNedded.add(perm);
            }
        }

        if(!listPermissionNedded.isEmpty()){
            ActivityCompat.requestPermissions(this,
                    listPermissionNedded.toArray(new String[listPermissionNedded.size()]),
                    PERMISSION_REQUEST_CODE);
            return false;
        }
        return true;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    if(requestCode==PERMISSION_REQUEST_CODE){
        HashMap<String,Integer> permissionResults=new HashMap<>();
        int deniedCount = 0;

        for(int i=0;i<grantResults.length;i++){
            if(grantResults[i]==PackageManager.PERMISSION_DENIED){
                permissionResults.put(permissions[i],grantResults[i]);
                deniedCount++;
            }
        }

        if(deniedCount==0){
            initApp();
        }else{
            for(Map.Entry<String,Integer> entry:permissionResults.entrySet()){
                String permName=entry.getKey();
                int permResult=entry.getValue();

                if(ActivityCompat.shouldShowRequestPermissionRationale(this,permName)){
                    showDialog("","Boongg App requires permissions to work without any problems.","Yes, Grant Permissions",
                            new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    checkAndRequestPermissions();
                                }
                            },
                            "No , Exit app",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    finish();
                                }
                            },false);
                }
                else{
                    showDialog("",
                            "You denied few permissions. Allow them","Go to settings",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
        Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("packaged",getPackageName(),null));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                                }
                            },
                            "No Exitt app",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
dialog.dismiss();
finish();
                                }
                            },
                            false);
                    break;

                }
            }
        }
    }
    }

    private void initApp() {
        SharedPreferences sp = getSharedPreferences(LoginToken.PREFS, Context.MODE_PRIVATE);
        String sc = sp.getString(LoginToken.TOKEN, "");
        if (!sc.equals("")) {
            LoginToken.tokenId = sc;
            try {
                LoginToken.id = JWTUtils.decoded(sc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
        } else {
            Intent i = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(i);
        }
        finish();

    }
    public AlertDialog showDialog(String title, String msg, String positiveLabel, DialogInterface.OnClickListener positiveClick, String negativeLabel, DialogInterface.OnClickListener negativeOnClick, boolean isCancelAble){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(isCancelAble);
        builder.setMessage(msg);
        builder.setPositiveButton(positiveLabel,positiveClick);
        builder.setNegativeButton(negativeLabel,negativeOnClick);

        AlertDialog alert=builder.create();
        return alert;
    }
}

