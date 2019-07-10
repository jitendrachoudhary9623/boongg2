package com.boongg.store.Fragments.AllBookings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Fragments.VehicleInventoryFragments.AllBikesFragment;
import com.boongg.store.Interfaces.INotifier;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.AvailableBikes.AvailableBike;
import com.boongg.store.Models.Requests.MaintainanceBikes.MaintenanceBike;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.DataFetchers.GetAvailableBikes;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.BookingAdapter;
import com.boongg.store.RecyclerViews.VehicleInventoryAdapter;
import com.boongg.store.Utilities.LoginToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableFragment extends Fragment {
    RecyclerView recyclerView=null;
     TextView msg;
    INotifier notifier;
    List<AvailableBike> b = new ArrayList<>();

    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_available, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_inventory_all_bikes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        setHasOptionsMenu(true);

        OwnerInventory inventory= APIClient.getClient().create(OwnerInventory.class);
        Call<List<VehicleInventoryResponse>> call1 = inventory.getAvailableVehicles(LoginToken.id);
        msg=(TextView)rootView.findViewById(R.id.all_bikes_inventory_no_msg);
        getAvailableBikes();
       // onAttachToParentFragment(getParentFragment());


        return rootView;
    }
    BookingRequest request;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    public void setupRecycleView(List<AvailableBike> bookings){

          //  Toast.makeText(getContext(),"Ok",Toast.LENGTH_LONG).show();
            if (recyclerView == null) {
                recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_inventory_all_bikes);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
            if (bookings.size() > 0) {
                VehicleInventoryAdapter adapter = new VehicleInventoryAdapter(bookings, getContext());
                recyclerView.setAdapter(adapter);
                msg.setVisibility(View.GONE);
                notifier.notify(0, bookings.size());
            } else {
                notifier.notify(0, 0);

                msg.setVisibility(View.VISIBLE);
            }

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
                getAvailableBikes();
                return false;
            }
        });

        final SearchView searchView = (SearchView) searchItem.getActionView();
        EditText searchEditText = (EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchEditText.setTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setHintTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setBackgroundColor(getResources().getColor(R.color.white));
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
              getAvailableBikes();
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
                for (AvailableBike b : b) {
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
            Log.e("AVAILABLE FRAGMENT",e.toString());
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
            notifier = (INotifier) this;

        }
        catch (Exception e)
        {
            Log.e("AVAILABLE FRAGMENT",e.toString());

            //  Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
        }    }

    List<AvailableBike> avaialble,maintainance,ongoining;
    private void getAvailableBikes() {
        try {
            BookingRequest request = APIClient.getClient().create(BookingRequest.class);
            compositeDisposable.add(request.getSAvailableBikes(LoginToken.id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<AvailableBike>>() {
                @Override
                public void accept(final List<AvailableBike> dropBookings) throws Exception {
                    final List<AvailableBike> availableBikes = new ArrayList<>();
                    BookingRequest request2 = OAPIClient.getClient().create(BookingRequest.class);
                    Toast.makeText(getContext(),""+dropBookings.size(),Toast.LENGTH_LONG).show();
                    Call<List<MaintenanceBike>> call = request2.getCMaintainanceBikes();
                    call.enqueue(new Callback<List<MaintenanceBike>>() {
                        @Override
                        public void onResponse(Call<List<MaintenanceBike>> call, Response<List<MaintenanceBike>> response) {
                            try {
                                b.clear();
                                for (AvailableBike bikes : dropBookings) {
                                    boolean flag = true;
                                    for (MaintenanceBike mb : response.body()) {
                                        if (bikes.get_id().equals(mb.get_rentPoolKey().get_id())) {
                                            flag = false;
                                        }
                                        if (flag == false) {
                                            break;
                                        }
                                    }
                                    if (flag) {
                                        availableBikes.add(bikes);
                                    }

                                }
                                b.clear();
                                for (AvailableBike a : availableBikes) {
                                    if (a.getStatusType().getType().equals("AVAILABLE")) {
                                        b.add(a);
                                    }
                                }
                                setupRecycleView(b);
                            } catch (Exception e) {
                            }
                        }

                        @Override
                        public void onFailure(Call<List<MaintenanceBike>> call, Throwable t) {

                        }
                    });

                }
            }));
        }catch (Exception e){}
    }

    public interface INotifier {
        public void notify(int position,int data);
    }

}
