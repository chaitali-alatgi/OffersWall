package com.ca.offerswall.app.di.screen;

import com.ca.offerswall.app.di.subscreen.ISubScreenComponent;
import com.ca.offerswall.app.di.subscreen.SubScreenModule;
import dagger.Subcomponent;

@Subcomponent(modules = {ScreenModule.class})
public interface IScreenComponent {
    ISubScreenComponent plus(SubScreenModule subScreenModule);
}
