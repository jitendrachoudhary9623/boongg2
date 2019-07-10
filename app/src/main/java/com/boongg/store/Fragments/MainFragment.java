package com.boongg.store.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.boongg.store.MainActivity;
import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Buttons;
import com.boongg.store.Models.DashboardInfo;
import com.boongg.store.Models.MainPageSlider;
import com.boongg.store.Models.Responses.Drop.DropBooking;
import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.Dashboard;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.PageAdapters.SliderAdapter;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.MainButtons;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.LoginToken;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainFragment extends Fragment {
    ViewPager viewPager;
    TabLayout indicator;
    List<MainPageSlider> sliderData;
    private CompositeDisposable mCompositeDisposable;
    ProgressBar pb;
    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView= inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        RecyclerView recyclerView;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_main_buttons);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        pb=(ProgressBar)rootView.findViewById(R.id.progressbar);
        MainButtons buttons;
        List<Buttons> btn=new ArrayList<>();
        btn.add(new Buttons("Current Booking",R.drawable.reading));
        btn.add(new Buttons("Create Booking",R.drawable.notebook));
        btn.add(new Buttons("Cancelled Booking",R.drawable.cancel_b));
        btn.add(new Buttons("Rent Calculator",R.drawable.calculator));
        btn.add(new Buttons("Vehicle Inventory",R.drawable.vespa));
        btn.add(new Buttons("Offers",R.drawable.banking));
        btn.add(new Buttons("Account",R.drawable.customer_support));
        btn.add(new Buttons("SOP",R.drawable.management));
        btn.add(new Buttons("Logout",R.drawable.exit));


        buttons = new MainButtons(btn, getContext());
        recyclerView.setAdapter(buttons);

        viewPager=(ViewPager)rootView.findViewById(R.id.viewPager);
        indicator=(TabLayout)rootView.findViewById(R.id.indicator);
        sliderData = new ArrayList<>();
       // sliderData.add(new MainPageSlider("Booking","Drop","5","2","Today's Booking"));
        //sliderData.add(new MainPageSlider("Booking","Total Earnings","25","Rs . 2160","Approx. Business This Month"));
        //sliderData.add(new MainPageSlider("Bgookin","","","","Todays Drop"));
        if(sliderData.size()!=0) {
            viewPager.setAdapter(new SliderAdapter(getContext(), sliderData));
            indicator.setupWithViewPager(viewPager, true);
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new SliderTimer(), 6000, 6000);
        }
        fetchData();

        return rootView;
    }
    int pickup=0;
    int drop=0;
    private void fetchData() {
        final BookingRequest bookingRequest = OAPIClient.getClient().create(BookingRequest.class);
       /* bookingRequest.getRAllBookings().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Booking>>() {
                    @Override
                    public void onSuccess(List<Booking> bookings) {
                       pickup= DateSorter.getBookings("Today",bookings,true).size();

                        bookingRequest.getDashboardDropBookings().subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeWith(new DisposableSingleObserver<List<DropBooking>>() {
                                    @Override
                                    public void onSuccess(List<DropBooking> bookings) {
                                        drop= DateSorter.getDropBookings("Today",bookings,true).size();

                                        sliderData.add(new MainPageSlider("Pickup","Drop",""+pickup,""+drop,"Today's Booking"));
                                        pb.setVisibility(View.GONE);
                                        viewPager.setVisibility(View.VISIBLE);
                                        indicator.setVisibility(View.VISIBLE);
                                        viewPager.setAdapter(new SliderAdapter(getContext(), sliderData));
                                        indicator.setupWithViewPager(viewPager, true);
                                        Timer timer = new Timer();
                                        timer.scheduleAtFixedRate(new SliderTimer(), 6000, 6000);
                                    }
                                    @Override
                                    public void onError(Throwable e) {

                                    }
                                });
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
*/
       try {
           final Dashboard dashboard = APIClient.getClient().create(Dashboard.class);
           dashboard.getDashboardInfo(LoginToken.id)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<DashboardInfo>() {
               @Override
               public void onSuccess(DashboardInfo d) {
                   try {
                       DecimalFormat format = new DecimalFormat("0.#");

                       sliderData.add(new MainPageSlider("Pickup", "Drop", "" + format.format(d.getPickup()), "" + format.format(d.getDrop()), "Today's Booking"));
                       sliderData.add(new MainPageSlider("Today", "Monthly", getResources().getString(R.string.rs) + " " + Math.round(d.getTodayCollection()), getResources().getString(R.string.rs) + " " + Math.round(d.getMonthlyCollection()), "Collection", 2));
                       sliderData.add(new MainPageSlider("Maintainance", "Available", "" + format.format(d.getMaintainance()), "" +format.format(d.getAvailable()), "Bikes", "On-Going", "" + format.format(d.getOngoing()), 3));
                   }catch (Exception e){
                       sliderData.add(new MainPageSlider("Pickup", "Drop", "" + d.getPickup(), "" + d.getDrop(), "Today's Booking"));
                       sliderData.add(new MainPageSlider("Today", "Monthly", getResources().getString(R.string.rs) + " " + Math.round(d.getTodayCollection()), getResources().getString(R.string.rs) + " " + Math.round(d.getMonthlyCollection()), "Collection", 2));
                       sliderData.add(new MainPageSlider("Maintainance", "Available", "" + d.getMaintainance(), "" + d.getAvailable(), "Bikes", "On-Going", "" + d.getOngoing(), 3));

                   }
                   pb.setVisibility(View.GONE);
                   viewPager.setVisibility(View.VISIBLE);
                   indicator.setVisibility(View.VISIBLE);
                   viewPager.setAdapter(new SliderAdapter(getContext(), sliderData));
                   indicator.setupWithViewPager(viewPager, true);
                   Timer timer = new Timer();
                   timer.scheduleAtFixedRate(new SliderTimer(), 6000, 6000);
               }

               @Override
               public void onError(Throwable e) {
                   Log.d("DATA",e.toString());

               }
           });
       }catch (Exception e){

           Log.d("DATA",e.toString());
       }
    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            try {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem() < sliderData.size() - 1) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }catch (Exception e){

            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

    }
}
