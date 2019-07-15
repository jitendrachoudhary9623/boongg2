package com.boongg.store.Utilities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class FragmentUtils {
    public static  void backToPrevzFragment(AppCompatActivity activity){
       activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
