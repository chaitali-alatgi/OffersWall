package com.ca.offerswall.app.di.screen;

import android.app.Activity;
import com.ca.offerswall.ui.base.BaseActivity;
import java.lang.ref.WeakReference;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ScreenModule {
    BaseActivity baseActivity;

    public ScreenModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    @Singleton
    BaseActivity providesActivity() {
        return baseActivity;
    }

    @Provides
    @Singleton
    WeakReference<Activity> providesActivityRef() {
        return new WeakReference<Activity>(baseActivity);
    }
}
