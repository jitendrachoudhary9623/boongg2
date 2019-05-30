package com.boongg.store.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Buttons;
import com.boongg.store.R;

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

        public ButtonViewHolder(View itemView) {
            super(itemView);
            buttonName = (TextView) itemView.findViewById(R.id.main_screen_button_name);
        }

        public void bindData(final int position) {
            Buttons i=mButtons.get(position);
            buttonName.setText(i.getButtton());
            buttonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"Button Clicked"+buttonName.getText(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}