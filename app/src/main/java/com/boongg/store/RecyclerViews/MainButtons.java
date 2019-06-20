package com.boongg.store.RecyclerViews;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Fragments.CancelledBookingFragment;
import com.boongg.store.Fragments.CreateBookingFragment;
import com.boongg.store.Fragments.CurrentBooking;
import com.boongg.store.Fragments.RentFragment;
import com.boongg.store.Fragments.VehicleInventoryFragment;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Buttons;
import com.boongg.store.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainButtons extends RecyclerView.Adapter<MainButtons.ButtonViewHolder> {

    List<Buttons> mButtons;
    Context mContext;

    public MainButtons() {

    }

    public MainButtons(List<Buttons> buttons, Context context) {
        mButtons = buttons;
        mContext = context;
    }


    @Override
    public ButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.main_screen_button, parent, false);
        ButtonViewHolder mv = new ButtonViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(ButtonViewHolder holder, int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return mButtons.size();
    }

    public class ButtonViewHolder extends RecyclerView.ViewHolder {

        TextView buttonName;
       ImageView buttonImage;
CardView button;
        public ButtonViewHolder(View itemView) {
            super(itemView);
            buttonName = (TextView) itemView.findViewById(R.id.main_screen_button_name);
            button=(CardView) itemView.findViewById(R.id.main_screen_card_view);
            buttonImage=(ImageView) itemView.findViewById(R.id.main_screen_button_icon);
        }

        public void switchFragment(Fragment myFragment,View v){

            MainActivity activity = (MainActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();

        }
        public void bindData(final int position) {
            final Buttons i=mButtons.get(position);
            Picasso.with(mContext).load(i.getImageId()).into(buttonImage);

            buttonName.setText(i.getButtton());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment myFragment=null;
                    switch(i.getButtton()){
                       // Toast.makeText(mContext,"Button Clicked"+buttonName.getText(),Toast.LENGTH_LONG).show();
                        case "Current Booking":
                             myFragment = new CurrentBooking();
                            break;
                        case "Cancelled Booking":
                            myFragment = new CancelledBookingFragment();
                            break;
                        case "Create Booking":
                            myFragment=new CreateBookingFragment();
                            break;
                        case "Rent Calculator":
                            myFragment=new RentFragment();
                            break;
                        case "Vehicle Inventory":
                            myFragment=new VehicleInventoryFragment();
                            break;
                    }
                    switchFragment(myFragment,v);

                }
            });

        }
    }
}