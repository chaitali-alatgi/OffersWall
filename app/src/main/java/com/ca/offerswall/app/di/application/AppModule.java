package com.ca.offerswall.app.di.application;

import android.content.Context;
import com.ca.offerswall.ui.BaseApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    BaseApplication baseApplication;

    public AppModule(BaseApplication application) {
        baseApplication = application;
    }

    @Provides
    BaseApplication provideApplication() {
        return baseApplication;
    }

    @Provides
    Context providesContext() {
        return baseApplication.getApplicationContext();
    }
}
