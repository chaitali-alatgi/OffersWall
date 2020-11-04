package com.ca.offerswall.ui.base;

import com.ca.offerswall.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class Navigator {
    public static void toNextFragment(FragmentActivity activity, Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_home_layout_main, fragment)
                .commit();
    }
}
