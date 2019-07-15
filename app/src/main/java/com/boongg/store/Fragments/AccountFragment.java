package com.boongg.store.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boongg.store.Models.Requests.StoreInfo.StoreDetail;
import com.boongg.store.R;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.SharedPrefUtils;

import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

public class AccountFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        JSONObject object= null;

        TextView name=(TextView)rootView.findViewById(R.id.name);
        TextView franchiseType=(TextView)rootView.findViewById(R.id.franchise_type);
        TextView storeType=(TextView)rootView.findViewById(R.id.storeType);
        TextView email=(TextView)rootView.findViewById(R.id.email);
        TextView mobile=(TextView)rootView.findViewById(R.id.mobile);
        TextView created_at=(TextView)rootView.findViewById(R.id.created_at);
        try {
            String iat=JWTUtils.getCreatedTime(LoginToken.tokenId);
            Timestamp stamp = new Timestamp(Long.parseLong(iat));
            Date date = new Date(stamp.getTime());
            object = JWTUtils.getUserLoginDetailsFromJWT(LoginToken.tokenId);
            name.setText(""+object.getString("username"));
            franchiseType.setText(""+object.getString("franchiseType"));
            storeType.setText("Role : "+object.getString("role"));
            mobile.setText("Mobile : "+object.getString("mobileNumber"));
            email.setText("Email Id : "+object.getString("email"));

            StoreDetail sd=new StoreDetail();
            sd=SharedPrefUtils.returnObject(LoginToken.OWNER_INFO,sd,getContext());
            created_at.setText("Created On : "+date.toString()+"\nGST NUMBER"+sd.getGstNumber());

        } catch (Exception e) {

            e.printStackTrace();
        }
        return  rootView;
    }
    }
