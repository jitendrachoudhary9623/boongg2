package com.boongg.store.Fragments.VehicleInventoryFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.app.AlertDialog;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boongg.store.Fragments.AllBookings.AvailableFragment;
import com.boongg.store.Fragments.AllBookings.Maintainance;
import com.boongg.store.Fragments.AllBookings.OnBookingFragment;
import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class AllBikesFragment extends Fragment implements AvailableFragment.INotifier,Maintainance.INotifier,OnBookingFragment.INotifier {

    BottomNavigationView bottomNav;
    BookingRequest request;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    List<PreDropBooking> avaialble,maintainance,ongoining;
    BottomNavigationMenuView bottomNavigationMenuView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_all_bikes, container, false);
        bottomNav = rootView.findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        request=OAPIClient.getClient().create(BookingRequest.class);

        if (savedInstanceState == null) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_2,
                    new AvailableFragment()).commit();
        }

        return rootView;

    }


    private void setupBadgeAt(int i) {

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_available:

                            selectedFragment = new AvailableFragment();
                            break;
                        case R.id.nav_maintainance:
                            selectedFragment = new Maintainance();
                            break;
                        case R.id.nav_onbooking:
                            selectedFragment = new OnBookingFragment();
                            break;
                    }

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_2,
                            selectedFragment).commit();

                    return true;
                }
            };


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void notify(int position, int data) {

        bottomNavigationMenuView =
                (BottomNavigationMenuView) bottomNav.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(position);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;
        View badge = LayoutInflater.from(getContext()).inflate(R.layout.bottom_nav_badge, itemView, true);
        TextView text = badge.findViewById(R.id.notifications_badge);
        text.clearComposingText();

        text.setText(""+data);
    }
}
