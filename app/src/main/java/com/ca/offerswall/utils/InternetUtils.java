package com.ca.offerswall.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.ca.offerswall.ui.BaseApplication;

import androidx.lifecycle.LiveData;

public class InternetUtils extends LiveData<Boolean> {
    private BroadcastReceiver broadcastReceiver = null;
    private static BaseApplication application;

    public InternetUtils(BaseApplication application) {
        this.application = application;
    }

    public static Boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    @Override
    protected void onActive() {
        super.onActive();
        registerBroadCastReceiver();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        unRegisterBroadCastReceiver();
    }

    private void registerBroadCastReceiver() {
        if (broadcastReceiver == null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

            broadcastReceiver = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        NetworkInfo info = (NetworkInfo) extras.getParcelable("networkInfo");
                        if (info != null) {
                            Boolean value = info.getState() == NetworkInfo.State.CONNECTED;
                        }
                    }
                }
            };

            application.registerReceiver(broadcastReceiver, filter);
        }
    }

    private void unRegisterBroadCastReceiver() {
        if (broadcastReceiver != null) {
            application.unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
        }
    }
}
