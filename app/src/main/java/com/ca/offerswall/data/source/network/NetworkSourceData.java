package com.ca.offerswall.data.source.network;

import com.ca.offerswall.data.model.OffersResponse;
import com.ca.offerswall.domain.usecase.offer_listing.OfferListingRequest;

import javax.inject.Inject;
import retrofit2.Call;

public class NetworkSourceData {

    @Inject INetworkEndpoint iNetworkEndpoint;

    @Inject
    public NetworkSourceData() { }

    public Call<OffersResponse> getOffersList(OfferListingRequest request) {
        return iNetworkEndpoint.getOffersList(request.getApplicationID(),
                request.getFormat(),
                request.getIp(),
                request.getLocale(),
                request.getOfferType(),
                String.valueOf(request.getTimeStamp()),
                request.getUserID(),
                request.getToken());
    }
}
