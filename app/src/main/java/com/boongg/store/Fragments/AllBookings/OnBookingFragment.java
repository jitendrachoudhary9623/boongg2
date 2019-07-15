package com.boongg.store.Fragments.AllBookings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.app.AlertDialog;

import com.boongg.store.Fragments.VehicleInventoryFragments.AllBikesFragment;
import com.boongg.store.Models.Requests.AvailableBikes.AvailableBike;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.VehicleInventoryAdapter;
import com.boongg.store.Utilities.LoginToken;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class OnBookingFragment extends Fragment {
    RecyclerView recyclerView=null;
    TextView msg;
    INotifier notifier;

    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_on_booking, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_inventory_on_booking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        OwnerInventory inventory= APIClient.getClient().create(OwnerInventory.class);
        msg=(TextView)rootView.findViewById(R.id.on_booking_inventory_no_msg);
        getOnBooking();
        return rootView;
    }

    BookingRequest request;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    VehicleInventoryAdapter adapter;
    public void setupRecycleView(List<AvailableBike> bookings){
        if (bookings.size() > 0) {
            notifier.notify(1, bookings.size());
            msg.setText("Wait data is loading ..");
            adapter = new VehicleInventoryAdapter(bookings, getContext(),true);
            recyclerView.setAdapter(adapter);
            msg.setVisibility(View.GONE);
        } else {
            notifier.notify(1, 0);

            msg.setVisibility(View.VISIBLE);
        }
    }
    public interface INotifier {
        public void notify(int position,int data);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.inventory_menu,menu);
        final MenuItem searchItem = menu.findItem(R.id.i_search);
        MenuItem refresh=menu.findItem(R.id.i_refresh);
        refresh.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getOnBooking();
                return false;
            }
        });

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        EditText searchEditText = (EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchEditText.setTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setHintTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setBackgroundColor(getResources().getColor(R.color.white));
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                getOnBooking();
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                updateSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                updateSearch(query);

                return false;
            }
        });    }

    private void updateSearch(String query) {
        try {
            List<AvailableBike> search = new ArrayList<>();
            for (AvailableBike b : availableBikes) {
                if (b.getVehicleModel().toUpperCase().contains(query.toUpperCase())||b.getBrand().toUpperCase().contains(query.toUpperCase())||b.getRegistrationNumber().contains(query.toUpperCase())) {
                    search.add(b);
                }
            }
            if(search.isEmpty()){
                msg.setText("No Search Results found");
                msg.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }else {
                recyclerView.setVisibility(View.VISIBLE);

                msg.setVisibility(View.GONE);
                setupRecycleView(search);
            }


        }catch (Exception e){}
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment p=null;
        for(Fragment a:getActivity().getSupportFragmentManager().getFragments()){
            if(a instanceof AllBikesFragment){
                p=a;
            }
        }
        try
        {
            notifier = (INotifier) p;
        }
        catch (Exception e)
        {
           // Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
        }    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Fragment p=null;
        for(Fragment a:getActivity().getSupportFragmentManager().getFragments()){
            if(a instanceof  AllBikesFragment){
                p=a;
            }
        }
        try
        {
            notifier = (INotifier) p;

        }
        catch (Exception e)
        {
           // Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
        }    }

    List<AvailableBike> availableBikes=new ArrayList<>();

    private void getOnBooking() {

        try {
            BookingRequest request = APIClient.getClient().create(BookingRequest.class);

            compositeDisposable.add(request.getSAvailableBikes(LoginToken.id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<AvailableBike>>() {
                @Override
                public void accept(List<AvailableBike> dropBookings) throws Exception {
                    availableBikes.clear();
                    for (AvailableBike bikes : dropBookings) {
                        if (bikes.getStatusType().getType().equals("BOOKED")) {
                            availableBikes.add(bikes);
                        }
                    }
                    setupRecycleView(availableBikes);
                }
            }));

        }catch (Exception e){}
    }



}
