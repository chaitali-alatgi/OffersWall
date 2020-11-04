package com.ca.offerswall.app.di.subscreen;

import com.ca.offerswall.ui.base.BaseFragment;
import java.lang.ref.WeakReference;
import javax.inject.Singleton;
import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.Provides;

@Module
public class SubScreenModule {

    BaseFragment baseFragment;

    public SubScreenModule(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    @Provides
    @Singleton
    BaseFragment providesFragment() {
        return baseFragment;
    }

    @Provides
    @Singleton
    WeakReference<Fragment> providesFragmentRef() {
        return new WeakReference<Fragment>(baseFragment);
    }

}
