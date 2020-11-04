
package com.ca.offerswall.data.model;

import com.google.gson.annotations.SerializedName;

public class OfferType {

    @SerializedName("offer_type_id")
    private Long mOfferTypeId;
    @SerializedName("readable")
    private String mReadable;

    public Long getOfferTypeId() {
        return mOfferTypeId;
    }

    public void setOfferTypeId(Long offerTypeId) {
        mOfferTypeId = offerTypeId;
    }

    public String getReadable() {
        return mReadable;
    }

    public void setReadable(String readable) {
        mReadable = readable;
    }

}
