package com.boongg.store.PageAdapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boongg.store.Models.MainPageSlider;
import com.boongg.store.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private Context context;

    private List<MainPageSlider> sliderList;
    public SliderAdapter(Context context,List<MainPageSlider> sliderList) {
        this.context = context;
        this.sliderList = sliderList;
    }

    @Override
    public int getCount() {
        return sliderList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {


        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        if(sliderList.get(position).getLevel()==3) {
             view = inflater.inflate(R.layout.main_page_item_slider_2, null);
            TextView t1 = (TextView) view.findViewById(R.id.slider_title_1);
            TextView t2 = (TextView) view.findViewById(R.id.slider_title_2);
            TextView v1 = (TextView) view.findViewById(R.id.slider_value_1);
            TextView v2 = (TextView) view.findViewById(R.id.slider_value_2);
            TextView t3 = (TextView) view.findViewById(R.id.slider_title_3);
            TextView v3 = (TextView) view.findViewById(R.id.slider_value_3);
            TextView heading = (TextView) view.findViewById(R.id.slider_heading);

            //  LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
            t1.setText(sliderList.get(position).getItem1());
            t2.setText(sliderList.get(position).getItem2());
            v1.setText(sliderList.get(position).getValue1());
            v2.setText(sliderList.get(position).getValue2());
            t3.setText(sliderList.get(position).getItem3());
            v3.setText(sliderList.get(position).getValue3());
            heading.setText(sliderList.get(position).getTitle());
        }
        else {

             view = inflater.inflate(R.layout.main_page_item_slider, null);

            TextView t1 = (TextView) view.findViewById(R.id.slider_title_1);
            TextView t2 = (TextView) view.findViewById(R.id.slider_title_2);
            TextView v1 = (TextView) view.findViewById(R.id.slider_value_1);
            TextView v2 = (TextView) view.findViewById(R.id.slider_value_2);
            TextView heading = (TextView) view.findViewById(R.id.slider_heading);

            //  LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
            t1.setText(sliderList.get(position).getItem1());
            t2.setText(sliderList.get(position).getItem2());
            v1.setText(sliderList.get(position).getValue1());
            v2.setText(sliderList.get(position).getValue2());
            heading.setText(sliderList.get(position).getTitle());
            //textView.setText(colorName.get(position));
            //linearLayout.setBackgroundColor(color.get(position));
        }
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}