package com.boongg.store;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.List;


public class UploadDocuments extends AppCompatActivity {

    private static final int REQUEST_GET_SINGLE_FILE =2 ;
    private static final int REQUEST_GET_PDF_SINGLE_FILE =355 ;
    int currentSelected=0;
    TextView rcUpload, pucUpload, InsuranceUpload;
    ImageView rcImage, pucImage, InsuaranceImage;
    List<PreDropBooking> vehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upload_documents);
                String vehicle = getIntent().getExtras().getString("ID");
                String rcURL=getIntent().getExtras().getString("RC");
        String pucURL=getIntent().getExtras().getString("PUC");
        String insuranceURL=getIntent().getExtras().getString("INSURANCE");

        rcUpload = (TextView) findViewById(R.id.rc_file_chooser);
            rcImage = (ImageView) findViewById(R.id.rc_Image);
            pucUpload = (TextView) findViewById(R.id.puc_file_chooser);
            pucImage = (ImageView) findViewById(R.id.puc_Image);
            InsuranceUpload = (TextView) findViewById(R.id.insurance_file_chooser);
            InsuaranceImage = (ImageView) findViewById(R.id.insurance_Image);

            if(!rcURL.equals("")){
             loadImage(rcURL,rcImage);
            }
        if(!pucURL.equals("")){
            loadImage(pucURL,pucImage);
        }
        if(!insuranceURL.equals("")){
            loadImage(insuranceURL,InsuaranceImage);
        }
           rcUpload.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   showOptions(111);
               }
           });
           pucUpload.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   showOptions(222);
               }
           });
           InsuranceUpload.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   showOptions(333);
               }
           });


    }

    private void loadImage(String url, ImageView imageView) {
        Glide.with(getApplicationContext())
                .load(url) // or URI/path
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.IMMEDIATE)
                .error(R.drawable.motorcycle)
                .skipMemoryCache(false)
                .into(imageView);
    }

    private final int CAMERA_INTENT = 20;

    private void showOptions(int selected) {
        currentSelected=selected;
        String[] colors = {"Take Picture", "Select From Gallery", "Use File Explorer"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Your Action");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(photoCaptureIntent, CAMERA_INTENT);
                        break;
                    case 1:
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType("image/*");
                        startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_GET_SINGLE_FILE);
                        break;
                    case 2:
                        Intent i2 = new Intent(Intent.ACTION_GET_CONTENT);
                        i2.addCategory(Intent.CATEGORY_OPENABLE);
                        i2.setType("application/pdf");
                        startActivityForResult(Intent.createChooser(i2, "Select PDF"),REQUEST_GET_PDF_SINGLE_FILE);
                        break;
                    case 3:
                        break;
                }
            }
        });
        builder.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case CAMERA_INTENT:
                    if(data.getExtras().get("data")!=null) {
                        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                        Toast.makeText(getApplicationContext(),""+currentSelected,Toast.LENGTH_LONG).show();
                        switch (currentSelected){
                            case 111:
                                rcImage.setImageBitmap(bitmap);
                                break;
                            case 222:
                                pucImage.setImageBitmap(bitmap);
                                break;
                            case 333:
                                InsuaranceImage.setImageBitmap(bitmap);
                                break;
                        }                        }
                    else{
                        Toast.makeText(getApplicationContext(),"Not "+currentSelected,Toast.LENGTH_LONG).show();
                    }
                    break;
                case REQUEST_GET_SINGLE_FILE:
                    Uri selectedImageUri = data.getData();
                    // Get the path from the Uri
                    final String path = getPathFromURI(selectedImageUri);
                    if (path != null) {
                        File f = new File(path);
                        selectedImageUri = Uri.fromFile(f);
                    }
                    Toast.makeText(getApplicationContext(),""+currentSelected,Toast.LENGTH_LONG).show();

                    switch (currentSelected){
                        case 111:
                            rcImage.setImageURI(selectedImageUri);
                            break;
                        case 222:
                            pucImage.setImageURI(selectedImageUri);
                            break;
                        case 333:
                            InsuaranceImage.setImageURI(selectedImageUri);
                            break;
                    }            }
        }
    }

    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }
}

/*

    FormData d = new FormData();
        d.setDocType("rc");
                d.setExpiryDate("");
                Gson gson=new Gson();
                d.setId("5d0dac9949a0ce355823c785");
                RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), imageBytes);
                RequestBody descBody = RequestBody.create(MediaType.parse("aoolication/json"), gson.toJson(d));
*/
