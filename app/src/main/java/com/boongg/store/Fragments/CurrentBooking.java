package com.boongg.store.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.boongg.store.R;

public class CurrentBooking extends Fragment {
    BottomNavigationView bottomNav;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_current_booking, container, false);
        bottomNav = rootView.findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_2,
                    new PickUpFragment()).commit();
        }
        return rootView;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_pickup:
                            selectedFragment = new PickUpFragment();
                            break;
                        case R.id.nav_drop:
                            selectedFragment = new DropFragment();
                            break;
                        case R.id.nav_history:
                            selectedFragment = new HistoryFragment();
                            break;
                    }

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_2,
                            selectedFragment).commit();

                    return true;
                }
            };
}
