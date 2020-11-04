package com.ca.offerswall.data.source.network;

import com.ca.offerswall.data.model.OffersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INetworkEndpoint {
    @GET("offers.json")
    Call<OffersResponse> getOffersList(@Query("appid") String appID,
                                       @Query("format") String format,
                                       @Query("ip") String ip,
                                       @Query("locale") String locale,
                                       @Query("offer_types") String offer_types,
                                       @Query("timestamp") String timestamp,
                                       @Query("uid") String uid,
                                       @Query("hashkey") String hashkey);
}
