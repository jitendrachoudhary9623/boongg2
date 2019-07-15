package com.boongg.store;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.BrodcastReciever.ConnectivityReceiver;
import com.boongg.store.Fragments.MainFragment;
import com.boongg.store.Models.Requests.StoreInfo.StoreDetail;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.SharedPrefUtils;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,ConnectivityReceiver.ConnectivityReceiverListener {


    private DrawerLayout drawer;
    private static MainActivity mInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header, navigationView, false);
        navigationView.addHeaderView(headerView);

        TextView nav_home=(TextView)navigationView.findViewById(R.id.nav_home);
        TextView logout_nav=(TextView)navigationView.findViewById(R.id.logout_nav);
        logout_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);

                SharedPreferences preferences = getSharedPreferences(LoginToken.PREFS, 0);
                preferences.edit().remove(LoginToken.TOKEN_ID).commit();
                preferences.edit().remove(LoginToken.TOKEN).commit();
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });
        TextView contact_us_nav=(TextView)navigationView.findViewById(R.id.contact_us_nav);
        contact_us_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7776011333"));
                startActivity(callIntent);
            }
        });
        nav_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MainFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        TextView title=(TextView)headerView.findViewById(R.id.title_nav);
        TextView username=(TextView)headerView.findViewById(R.id.username_nav);
        TextView location=(TextView)headerView.findViewById(R.id.location_nav);
        TextView franchise=(TextView)headerView.findViewById(R.id.franchise_nav);
        TextView mobile_nav=(TextView)headerView.findViewById(R.id.mobile_nav);
        TextView email_nav=(TextView)headerView.findViewById(R.id.email_nav);
        TextView gst=(TextView)headerView.findViewById(R.id.gst_nav);
        gst.setVisibility(View.GONE);
        try {
           JSONObject object = JWTUtils.getUserLoginDetailsFromJWT(LoginToken.tokenId);
            title.setText(""+object.getString("username").charAt(0));
            username.setText(""+object.getString("username"));
            String franchisev=object.getString("franchiseType").replace("_"," ");
            franchise.setText(""+franchisev);
            mobile_nav.setText(""+object.getString("mobileNumber"));
            email_nav.setText(""+object.getString("email"));
            StoreDetail sd=new StoreDetail();
            sd= SharedPrefUtils.returnObject(LoginToken.OWNER_INFO,sd,getApplicationContext());
            location.setText(sd.getLocality().get(0));

            if(sd.getGstNumber()!=null&&!sd.getGstNumber().equals("")){
                gst.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){
Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
      //  toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimary));
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MainFragment()).commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MainFragment()).commit();
                break;
            case R.id.nav_logout:
                SharedPreferences preferences = getSharedPreferences(LoginToken.PREFS, 0);
                preferences.edit().remove(LoginToken.TOKEN_ID).commit();
                preferences.edit().remove(LoginToken.TOKEN).commit();
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static final int TIME_DELAY = 2500;
    private static long back_pressed=System.currentTimeMillis();;

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            int fragments = getSupportFragmentManager().getBackStackEntryCount();
            if (fragments > 0) {
                super.onBackPressed();
            }else if(fragments==0){
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("EXIT")
                        .setMessage("You want to exit the app")
                        .setPositiveButton("Exit APP", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //Stop the activity
                                finish();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }


        }
    }
/*

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK && isTaskRoot()) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("EXIT")
                    .setMessage("You want to exit the app")
                    .setPositiveButton("Exit APP", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Stop the activity
                            finish();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();

            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }
    }
*/

    public static synchronized MainActivity getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }


    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        MainActivity.getInstance().setConnectivityListener(this);
    }

    /**
     * Callback will be triggered when there is change in
     * network connection
     */
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }
    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message;
        int color;
        int background;
        if (isConnected) {
            message = "You are connected to internet";
            color = Color.WHITE;
            background=Color.GREEN;
        } else {
            message = "Internet Connection lost, the app requires internet connection";
            color = Color.WHITE;
            background=Color.RED;
        }

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.co_ordinator), message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        //textView.setBackgroundColor(background);
        snackbar.show();
    }
}

