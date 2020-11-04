package com.ca.offerswall.ui;

import android.app.Application;

import com.ca.offerswall.app.di.application.AppModule;
import com.ca.offerswall.app.di.application.DaggerIApplicationComponent;
import com.ca.offerswall.app.di.application.IApplicationComponent;
import com.ca.offerswall.app.di.application.NetworkModule;
import com.ca.offerswall.app.di.application.RepositoryModule;
import com.ca.offerswall.utils.InternetUtils;

public class BaseApplication extends Application {
    private static IApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependencyInjection();
        new InternetUtils(this);
    }

    private void initializeDependencyInjection() {
        applicationComponent = DaggerIApplicationComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(this))
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public static IApplicationComponent getAppComponent() {
        return applicationComponent;
    }

}
