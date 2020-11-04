package com.ca.offerswall.data.repository;

import com.ca.offerswall.data.mapper.OffersMapper;
import com.ca.offerswall.data.model.OffersResponse;
import com.ca.offerswall.data.source.network.NetworkSourceData;
import com.ca.offerswall.domain.model.Offer;
import com.ca.offerswall.domain.model.Response;
import com.ca.offerswall.domain.repository.OffersRepository;
import com.ca.offerswall.domain.usecase.offer_listing.OfferListingRequest;
import com.ca.offerswall.utils.InternetUtils;

import java.io.IOException;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.subjects.SingleSubject;
import retrofit2.Call;
import retrofit2.Callback;

public class OfferListingRepositoryImpl implements OffersRepository {
    NetworkSourceData networkSourceData;
    OffersMapper offersMapper;

    public OfferListingRepositoryImpl(NetworkSourceData networkSourceData, OffersMapper mapper) {
        this.networkSourceData = networkSourceData;
        this.offersMapper = mapper;
    }

    @Override
    public Observable<Response<List<Offer>>> getOffersList(OfferListingRequest request) {
        SingleSubject<Response<List<Offer>>> listOfRecipeSubject = SingleSubject.create();
        if (InternetUtils.isNetworkAvailable()) {
            networkSourceData.getOffersList(request)
                    .enqueue(new Callback<OffersResponse> (){
                        @Override
                        public void onResponse(Call<OffersResponse> call, retrofit2.Response<OffersResponse> response) {
                            listOfRecipeSubject.onSuccess(new Response.Success(offersMapper.map(response.body())));
                        }

                        @Override
                        public void onFailure(Call<OffersResponse> call, Throwable t) {
                            listOfRecipeSubject.onError(new Response.Error<List<Offer>>(t, null).getException());
                        }
            });
        } else {
            listOfRecipeSubject.onSuccess(new Response.Error<List<Offer>>(new IOException(), null));
        }
        return listOfRecipeSubject.toObservable();
    }
}
