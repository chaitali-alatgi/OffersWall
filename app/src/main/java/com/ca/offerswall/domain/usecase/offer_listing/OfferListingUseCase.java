package com.ca.offerswall.domain.usecase.offer_listing;

import com.ca.offerswall.domain.model.Offer;
import com.ca.offerswall.domain.model.Response;
import com.ca.offerswall.domain.repository.OffersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class OfferListingUseCase {

    @Inject OffersRepository repository;

    @Inject
    public OfferListingUseCase() { }

    public Observable<Response<List<Offer>>> execute(OfferListingRequest request) {
        return repository.getOffersList(request.formatRequest());
    }


}
