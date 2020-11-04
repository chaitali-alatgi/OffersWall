package com.ca.offerswall.domain.model;

import com.ca.offerswall.data.model.Thumbnail;

import java.io.Serializable;

public class Offer implements Serializable {
    private Long mOfferId;
    private Thumbnail mThumbnail;
    private String mTitle;

    public Offer(Long offerId, String title, Thumbnail thumbnail) {
        this.mOfferId = offerId;
        this.mTitle = title;
        this.mThumbnail = thumbnail;
    }

    public Long getmOfferId() {
        return mOfferId;
    }

    public void setmOfferId(Long mOfferId) {
        this.mOfferId = mOfferId;
    }

    public Thumbnail getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(Thumbnail mThumbnail) {
        this.mThumbnail = mThumbnail;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
