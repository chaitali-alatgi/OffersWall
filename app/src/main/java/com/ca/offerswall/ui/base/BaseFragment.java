package com.ca.offerswall.ui.base;

import android.os.Bundle;
import com.ca.offerswall.app.di.subscreen.ISubScreenComponent;
import com.ca.offerswall.app.di.subscreen.SubScreenModule;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public volatile ISubScreenComponent subScreenComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subScreenComponent = initializeDagger();
    }

    private ISubScreenComponent initializeDagger() {
        ISubScreenComponent iSubScreenComponent = subScreenComponent;
        if(iSubScreenComponent == null) {
            synchronized (this) {
                iSubScreenComponent = BaseActivity.getScreenComponent().plus(new SubScreenModule(this));
            }
        }
        return iSubScreenComponent;
    }

}
