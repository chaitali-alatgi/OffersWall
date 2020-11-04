package com.ca.offerswall.ui.base;

import android.os.Bundle;
import com.ca.offerswall.app.di.screen.IScreenComponent;
import com.ca.offerswall.app.di.screen.ScreenModule;
import com.ca.offerswall.ui.BaseApplication;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public static volatile IScreenComponent screenComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenComponent = initializeDagger();
    }

    private IScreenComponent initializeDagger() {
        IScreenComponent iScreenComponent = screenComponent;
        if(iScreenComponent == null) {
            synchronized (this) {
                iScreenComponent = BaseApplication.getAppComponent().plus(new ScreenModule(this));
            }
        }
        return iScreenComponent;
    }

    public static IScreenComponent getScreenComponent() {
        return screenComponent;
    }
}
