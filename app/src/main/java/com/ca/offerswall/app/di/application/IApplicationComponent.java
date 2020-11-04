package com.ca.offerswall.app.di.application;

import com.ca.offerswall.app.di.screen.IScreenComponent;
import com.ca.offerswall.app.di.screen.ScreenModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, RepositoryModule.class})
public interface IApplicationComponent {
    IScreenComponent plus(ScreenModule screenModule);
}
