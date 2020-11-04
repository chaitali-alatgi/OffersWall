
package com.ca.offerswall.data.model;

import com.google.gson.annotations.SerializedName;

public class TimeToPayout {

    @SerializedName("amount")
    private Long mAmount;
    @SerializedName("readable")
    private String mReadable;

    public Long getAmount() {
        return mAmount;
    }

    public void setAmount(Long amount) {
        mAmount = amount;
    }

    public String getReadable() {
        return mReadable;
    }

    public void setReadable(String readable) {
        mReadable = readable;
    }

}
