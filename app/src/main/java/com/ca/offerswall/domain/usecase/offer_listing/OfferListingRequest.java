package com.ca.offerswall.domain.usecase.offer_listing;

import com.ca.offerswall.utils.Constants;

import java.math.BigInteger;
import java.security.MessageDigest;

import static com.ca.offerswall.utils.Constants.REQUEST_FORMAT;

public class OfferListingRequest {

    private String applicationID;
    private String format = REQUEST_FORMAT;
    private String ip = Constants.IP_ADDRESS;
    private String locale = "DE";
    private String offerType = Constants.OFFER_TYPE;
    private String userID;
    private String token;
    private long timeStamp;

    public OfferListingRequest(String applicationID, String userID, String token) {
        this.applicationID = applicationID;
        this.userID = userID;
        this.token = token;
    }

    public OfferListingRequest formatRequest() {
        this.timeStamp = System.currentTimeMillis() / 1000L;
        String queryParams = "appid="+applicationID+"&format="+format+"&ip="+ip+"&locale="+locale+"&offer_types="+offerType+"&timestamp="+timeStamp+"&uid="+userID+"&"+token;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(queryParams.getBytes("utf8"));
            this.token = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public Boolean validate() {
        return applicationID != null && userID != null && token != null;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
