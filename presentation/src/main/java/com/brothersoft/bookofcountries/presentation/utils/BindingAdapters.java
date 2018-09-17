package com.brothersoft.bookofcountries.presentation.utils;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.brothersoft.bookofcountries.R;
import com.squareup.picasso.Picasso;


public class BindingAdapters {
    @BindingAdapter("imageUrl")
    public static void setFlagsImage(ImageView view, String url) {
        SvgLoader.pluck()
                .with((Activity) view.getContext())
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(url, view);
    }

    @BindingAdapter({"imageWeather"})
    public static void setWeatherImage1(ImageView view, String url) {
        Picasso.get()
                .load(url)
                .resize(150,150)
                .into(view);
    }
}
