
package com.ca.offerswall.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OffersResponse {

    @SerializedName("code")
    private String mCode;
    @SerializedName("count")
    private Long mCount;
    @SerializedName("information")
    private Information mInformation;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("offers")
    private List<Offer> mOffers;
    @SerializedName("pages")
    private Long mPages;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Information getInformation() {
        return mInformation;
    }

    public void setInformation(Information information) {
        mInformation = information;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<Offer> getOffers() {
        return mOffers;
    }

    public void setOffers(List<Offer> offers) {
        mOffers = offers;
    }

    public Long getPages() {
        return mPages;
    }

    public void setPages(Long pages) {
        mPages = pages;
    }

    @Override
    public String toString() {
        return "OffersResponse{" +
                "mCode='" + mCode + '\'' +
                ", mCount=" + mCount +
                ", mInformation=" + mInformation +
                ", mMessage='" + mMessage + '\'' +
                ", mOffers=" + mOffers +
                ", mPages=" + mPages +
                '}';
    }
}
