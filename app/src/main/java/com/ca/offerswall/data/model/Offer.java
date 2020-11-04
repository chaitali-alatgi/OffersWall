
package com.ca.offerswall.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("link")
    private String mLink;
    @SerializedName("offer_id")
    private Long mOfferId;
    @SerializedName("offer_types")
    private List<OfferType> mOfferTypes;
    @SerializedName("payout")
    private Long mPayout;
    @SerializedName("required_actions")
    private String mRequiredActions;
    @SerializedName("teaser")
    private String mTeaser;
    @SerializedName("thumbnail")
    private Thumbnail mThumbnail;
    @SerializedName("time_to_payout")
    private TimeToPayout mTimeToPayout;
    @SerializedName("title")
    private String mTitle;

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public Long getOfferId() {
        return mOfferId;
    }

    public void setOfferId(Long offerId) {
        mOfferId = offerId;
    }

    public List<OfferType> getOfferTypes() {
        return mOfferTypes;
    }

    public void setOfferTypes(List<OfferType> offerTypes) {
        mOfferTypes = offerTypes;
    }

    public Long getPayout() {
        return mPayout;
    }

    public void setPayout(Long payout) {
        mPayout = payout;
    }

    public String getRequiredActions() {
        return mRequiredActions;
    }

    public void setRequiredActions(String requiredActions) {
        mRequiredActions = requiredActions;
    }

    public String getTeaser() {
        return mTeaser;
    }

    public void setTeaser(String teaser) {
        mTeaser = teaser;
    }

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        mThumbnail = thumbnail;
    }

    public TimeToPayout getTimeToPayout() {
        return mTimeToPayout;
    }

    public void setTimeToPayout(TimeToPayout timeToPayout) {
        mTimeToPayout = timeToPayout;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
