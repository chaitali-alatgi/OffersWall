
package com.ca.offerswall.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Thumbnail implements Serializable {

    @SerializedName("hires")
    private String mHires;
    @SerializedName("lowres")
    private String mLowres;

    public Thumbnail(String mHires, String mLowres) {
        this.mHires = mHires;
        this.mLowres = mLowres;
    }

    public String getHires() {
        return mHires;
    }

    public void setHires(String hires) {
        mHires = hires;
    }

    public String getLowres() {
        return mLowres;
    }

    public void setLowres(String lowres) {
        mLowres = lowres;
    }

}
