package com.example.rohit.onboardingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    RelativeLayout relativeLayout;
    Button getStarted;
    Intent intent;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int SlideImages[] = {R.drawable.abhijeet, R.drawable.rohit, R.drawable.sleep};
    public String Headings[] = {"ABHIJEET GUPTA", "ROHIT GIRDHAR", "MILIND MAHESHWARI"};
    public String Description[] = {"I'am Passionate about Android Development and have been doing it since last 2 years. My contributions in the project were making the Camera Activity and working on the Text Recognition API", "I'am passionate about Design and have been doing UI since last couple of years. My job was to Integrate the Firebase API into the app and make a web version where we can retrieve the data.", "My role was nothing. I'm a big fat Buddha old retarted drunk guy who drinks beyond my capacity and make videos zoomed up at my face."};
    public String Colors[] = {"#FFFFFF", "#FFFFFF","#FFFFFF"};
    @Override
    public int getCount() {
        return SlideImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView sliderImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView heading = (TextView) view.findViewById(R.id.heading);
        TextView text = (TextView) view.findViewById(R.id.text);

        getStarted = (Button) view.findViewById(R.id.getStarted);


        relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
        getStarted.setVisibility(view.GONE);

        sliderImageView.setImageResource(SlideImages[position]);
        relativeLayout.setBackgroundColor(Color.parseColor(Colors[position]));
        heading.setText(Headings[position]);
        text.setText(Description[position]);


        if(position==2) {
            getStarted.setVisibility(view.VISIBLE);
        }



        container.addView(view);


        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    public void cameraActivity(View v) {
        //Just add the new activity here.

//        intent = new Intent(SliderAdapter.this, SliderAdapter.class);
//        startActivity(intent);

    }
}
