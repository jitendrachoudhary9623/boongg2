package com.boongg.store;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.StoreInfo.StoreDetail;
import com.boongg.store.Models.Token;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.LoginRequest;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.RecyclerViews.DropAdapter;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;
import com.boongg.store.Utilities.SharedPrefUtils;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

   EditText _emailText;
    EditText _passwordText;
    Button _loginButton;
    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _emailText=(EditText)findViewById(R.id.input_email);
        _passwordText=(EditText)findViewById(R.id.input_password);
        _loginButton=(Button)findViewById(R.id.btn_login);
        _signupLink=(TextView)findViewById(R.id.link_signup);
        SharedPreferences sp = getSharedPreferences(LoginToken.PREFS ,Context.MODE_PRIVATE);
        String sc  = sp.getString(LoginToken.TOKEN,"");
        if (!sc.equals("")){
            LoginToken.tokenId=sc;
            try {
                LoginToken.id=JWTUtils.decoded(sc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            onLoginSuccess();
        }
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                /*
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                */
            }
        });
    }
CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }


        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        LoginRequest loginRequest= APIClient.getClient().create(LoginRequest.class);
        Call<Token> call1 = loginRequest.userLogin(email,password);
        call1.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.isSuccessful()) {
                    Token token = response.body();
                    if(token!=null) {
                        progressDialog.dismiss();
                        String id = "";
                        try {
                            id = JWTUtils.decoded(token.getToken());
                            Log.e("JWT ID", id);
                            //Toast.makeText(getApplicationContext(), "This is id " + id, Toast.LENGTH_LONG).show();
                            LoginToken.id = id;
                            LoginToken.tokenId = token.getToken();
                            SharedPreferences sp = getSharedPreferences(LoginToken.PREFS, Context.MODE_PRIVATE);
                            sp.edit().putString(LoginToken.TOKEN, token.getToken()).commit();
                            sp.edit().putString(LoginToken.TOKEN_ID, id).commit();
                            getOwnerData();
                            onLoginSuccess();
                        } catch (Exception e) {
                            //Toast.makeText(getApplicationContext(), "Error"+e.toString(), Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    }else{
                        //AlertBoxUtils.showAlert(getApplicationContext(),"error","Login Failed","You have entered wrong password or email");
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Wrong password or email",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Wrong password or email",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();

            }
        });
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                       // onLoginSuccess();
                        // onLoginFailed();
                    }
                }, 3000);
    }

    private void getOwnerData() {
        ProgressbarUtil.showProgressbarWithMsg(LoginActivity.this,"Authentication Successfull!!.. Please wait we are setting up application for you!!");

        OwnerInventory owner=APIClient.getClient().create(OwnerInventory.class);

        compositeDisposable.add(owner.getROwnerInfo(LoginToken.id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                new Consumer<StoreDetail>() {
                    @Override
                    public void accept(StoreDetail storeDetail) throws Exception {
                        try {
                            SharedPrefUtils.saveObjectToSharedPred(getApplicationContext(), storeDetail, LoginToken.OWNER_INFO);
                            ProgressbarUtil.hideProgressBar();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                }
        ));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
      //  _loginButton.setEnabled(true);
       // finish();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }
        if (password.isEmpty() || password.length() < 1) {
            _passwordText.setError("Enter Valid password");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;
    }
}