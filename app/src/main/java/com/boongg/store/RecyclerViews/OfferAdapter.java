package com.boongg.store.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.ViewOffer;
import com.boongg.store.Models.Responses.CancelledData.Cancel;
import com.boongg.store.R;
import com.boongg.store.Utilities.DateSorter;

import java.util.List;


public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    List<ViewOffer> offer;
    Context mContext;

    public OfferAdapter() {
    }

    public OfferAdapter(List<ViewOffer> offer, Context context) {
        this.offer = offer;
        mContext = context;
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_offer, parent, false);
        OfferViewHolder mv = new OfferViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        holder.bindData(position);

    }



    @Override
    public int getItemCount() {
        return offer.size();
    }
    public class OfferViewHolder extends RecyclerView.ViewHolder {

      TextView coupoun_code,discount_percent,min,max,used_by;
        public OfferViewHolder(View itemView) {
            super(itemView);
          coupoun_code=(TextView)itemView.findViewById(R.id.offer_coupon_code);
          discount_percent=(TextView)itemView.findViewById(R.id.offer_discount_percent);
          min=(TextView)itemView.findViewById(R.id.offer_min_discount);
          max=(TextView)itemView.findViewById(R.id.offer_max_discount);
          used_by=(TextView)itemView.findViewById(R.id.offer_used_by);
        }


        public void bindData(final int position) {
          ViewOffer o=offer.get(position);
          try {
              coupoun_code.setText(o.getCoupenCode());
              if(o.getDiscountType().equals("Percent")) {
                  discount_percent.setText("" + o.getDiscountInPrecentOrFlat()+" %");
              }else{
                  discount_percent.setText("" + o.getDiscountInPrecentOrFlat()+" FLAT");

              }
              min.setText("Min Discount : " + o.getMinTransaction());
              max.setText("Max Discount : " + o.getMaxDiscount());
              used_by.setText("Used By : " + o.getUsedByUser().size());
          }catch (Exception e){

          }
        }
    }

}

