package com.ca.offerswall.ui.viewmodel;

import com.ca.offerswall.data.model.Thumbnail;
import com.ca.offerswall.domain.model.Offer;
import com.ca.offerswall.domain.model.Response;
import com.ca.offerswall.domain.usecase.offer_listing.OfferListingRequest;
import com.ca.offerswall.domain.usecase.offer_listing.OfferListingUseCase;
import com.ca.offerswall.ui.viewmodel.model.OfferListState;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FormViewModelTest {

    private FormViewModel formViewModel;
    @Mock public OfferListingUseCase offerListingUseCase;
    @Mock public OfferListingRequest offerListingRequest;
    @Mock public MutableLiveData<OfferListState> offerObservableList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        formViewModel = new FormViewModel();
    }

    @Test
    public void onProceedClicked() {
        List<Offer> offerList = new ArrayList<Offer>();
        offerList.add(
                new Offer((long) 1410343, "Unique Casino ",
                        new Thumbnail(
                                "http://icons.fyber-static.com/offer_icons/53464/icon.png",
                                "http://icons.fyber-static.com/offer_icons/53464/icon.png"
                        )
                ));
        Response<List<Offer>> response = new Response.Success<>(offerList);

        when(offerListingUseCase.execute(offerListingRequest))
                .thenReturn(Observable.just(response));

        formViewModel.onProceedClicked();

        List<Offer> result = formViewModel.offerObservableList.getValue().getResponse();

        assertEquals(result.get(0), offerList.get(0));
    }
}