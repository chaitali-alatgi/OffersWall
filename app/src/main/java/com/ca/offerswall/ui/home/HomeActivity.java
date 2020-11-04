package com.ca.offerswall.ui.home;

import android.os.Bundle;

import com.ca.offerswall.R;
import com.ca.offerswall.databinding.ActivityHomeBinding;
import com.ca.offerswall.ui.base.BaseActivity;
import com.ca.offerswall.ui.base.Navigator;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        Navigator.toNextFragment(this, new FormFragment());
    }
}
