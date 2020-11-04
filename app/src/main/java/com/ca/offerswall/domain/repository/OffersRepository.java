package com.ca.offerswall.domain.repository;

import com.ca.offerswall.domain.model.Offer;
import com.ca.offerswall.domain.model.Response;
import com.ca.offerswall.domain.usecase.offer_listing.OfferListingRequest;
import java.util.List;

import io.reactivex.Observable;

public interface OffersRepository {

    Observable<Response<List<Offer>>> getOffersList(OfferListingRequest request);
}
