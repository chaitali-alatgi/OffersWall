package com.ca.offerswall.app.di.subscreen;

import com.ca.offerswall.ui.home.FormFragment;
import com.ca.offerswall.ui.offer_listing.OfferListingFragment;
import dagger.Subcomponent;

@Subcomponent(modules = {SubScreenModule.class})
public interface ISubScreenComponent {
    void inject(FormFragment formFragment);
    void inject(OfferListingFragment offerListingFragment);
}
