package com.ca.offerswall.ui.viewmodel;

import com.ca.offerswall.R;
import com.ca.offerswall.domain.model.Offer;
import com.ca.offerswall.domain.model.Response;
import com.ca.offerswall.domain.usecase.offer_listing.OfferListingRequest;
import com.ca.offerswall.domain.usecase.offer_listing.OfferListingUseCase;
import com.ca.offerswall.ui.viewmodel.model.OfferListState;

import java.util.List;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FormViewModel extends ViewModel {
    public ObservableField<String> applicationID = new ObservableField<>();
    public ObservableField<String> userID = new ObservableField<>();
    public ObservableField<String> token = new ObservableField<>();
    public MutableLiveData<OfferListState> offerObservableList = new MutableLiveData();
    public ObservableBoolean progressVisibility = new ObservableBoolean();
    @Inject
    OfferListingUseCase offerListingUseCase;

    @Inject
    public FormViewModel() {

    }

    public void bound() {
        applicationID.set("2070");
        userID.set("superman");
        token.set("1c915e3b5d42d05136185030892fbb846c278927");
    }

    public void onProceedClicked() {
        offerObservableList.postValue(
                new OfferListState.LoadingOfferListState(true, null)
        );
        OfferListingRequest request = new OfferListingRequest(applicationID.get(), userID.get(), token.get());
        if(request.validate()) {
            offerListingUseCase.execute(request)
                    .subscribe(
                            response -> {
                                handleOffersListResponseResult(response);
                            }
                    );
        } else {
            new OfferListState.ErrorOfferListState(
                    new Exception(String.valueOf(R.string.invalid_input)), null
            );
        }
    }

    private void handleOffersListResponseResult(Response<List<Offer>> response) {
        if (response instanceof Response.Success) {
            offerObservableList.postValue(
                    new OfferListState.SuccessOfferListState(response.getData())
            );
        } else if (response instanceof Response.Error) {
            offerObservableList.postValue(
                    new OfferListState.ErrorOfferListState(response.getException(), response.getData())
            );
        }
    }
}
