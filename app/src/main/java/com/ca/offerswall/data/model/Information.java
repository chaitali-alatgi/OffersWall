
package com.ca.offerswall.data.model;

import com.google.gson.annotations.SerializedName;

public class Information {

    @SerializedName("app_name")
    private String mAppName;
    @SerializedName("appid")
    private Long mAppid;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("support_url")
    private String mSupportUrl;
    @SerializedName("virtual_currency")
    private String mVirtualCurrency;

    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String appName) {
        mAppName = appName;
    }

    public Long getAppid() {
        return mAppid;
    }

    public void setAppid(Long appid) {
        mAppid = appid;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getSupportUrl() {
        return mSupportUrl;
    }

    public void setSupportUrl(String supportUrl) {
        mSupportUrl = supportUrl;
    }

    public String getVirtualCurrency() {
        return mVirtualCurrency;
    }

    public void setVirtualCurrency(String virtualCurrency) {
        mVirtualCurrency = virtualCurrency;
    }

}
