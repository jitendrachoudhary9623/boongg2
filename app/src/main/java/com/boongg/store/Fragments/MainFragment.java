package com.boongg.store.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boongg.store.Models.Buttons;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.MainButtons;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                View rootView= inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_main_buttons);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        MainButtons buttons;
        List<Buttons> btn=new ArrayList<>();
        btn.add(new Buttons("Current Booking"));
        btn.add(new Buttons("Cancelled Booking"));
        btn.add(new Buttons("Create Booking"));
        btn.add(new Buttons("Logout"));


        buttons = new MainButtons(btn, getContext());
        recyclerView.setAdapter(buttons);

        return rootView;
    }
}
