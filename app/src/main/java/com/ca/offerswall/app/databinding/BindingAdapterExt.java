package com.ca.offerswall.app.databinding;

import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;

public class BindingAdapterExt {

    @BindingConversion
    public static int setVisibility(Boolean state) {
        if(state) return View.VISIBLE;
        else return View.GONE;
    }
}
