package com.boongg.store.Utilities;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

public class FragmentUtils {
    public static  void backToPrevzFragment(Activity activity){
       activity.getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
