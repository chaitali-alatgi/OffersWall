package com.ca.offerswall.ui.viewmodel.model;

import com.ca.offerswall.domain.model.Offer;
import java.util.List;

public abstract class OfferListState {
    List<Offer> response = null;
    Throwable exception = null;
    public static class SuccessOfferListState extends OfferListState {
        public SuccessOfferListState(List<Offer> offerList) {
            this.response = offerList;
        }
    }

    public static class LoadingOfferListState extends OfferListState {
        public LoadingOfferListState(boolean isLoading, List<Offer> offerList) {
            this.response = offerList;
        }
    }

    public static class ErrorOfferListState extends OfferListState {
        public ErrorOfferListState(Throwable error, List<Offer> offerList) {
            this.exception = error;
        }
    }

    public List<Offer> getResponse() {
        return response;
    }

    public Throwable getException() {
        return exception;
    }
}
