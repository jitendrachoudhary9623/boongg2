package com.boongg.store.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boongg.store.Fragments.DropFragments.ExtendedDrop;
import com.boongg.store.Fragments.DropFragments.FutureDrop;
import com.boongg.store.Fragments.DropFragments.TodayDrop;
import com.boongg.store.Fragments.VehicleInventoryFragments.AddBike;
import com.boongg.store.Fragments.VehicleInventoryFragments.AllBikesFragment;
import com.boongg.store.Fragments.VehicleInventoryFragments.RentCollectionFragment;
import com.boongg.store.R;

public class VehicleInventoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_vehicle_inventory, container, false);
        TabLayout tabLayout = (TabLayout)rootView.findViewById(R.id.tablayout_inventory);
        tabLayout.addTab(tabLayout.newTab().setText("All Bikes List"));
        tabLayout.addTab(tabLayout.newTab().setText("Rent Collection"));
        tabLayout.addTab(tabLayout.newTab().setText("Add Bikes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)rootView.findViewById(R.id.pager_inventory);
        final PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        int mNoOfTabs;

        public PagerAdapter(FragmentManager fm, int NumberOfTabs)
        {
            super(fm);
            this.mNoOfTabs = NumberOfTabs;
        }


        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            fragment = null;
            switch(position)
            {
                case 0:
                    fragment = new AllBikesFragment();
                    break;
                case 1:
                    fragment = new RentCollectionFragment();
                    break;
                case 2:
                    fragment = new AddBike();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return mNoOfTabs;
        }
    }

}
