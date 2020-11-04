package com.ca.offerswall.app.di.application;

import com.ca.offerswall.data.mapper.OffersMapper;
import com.ca.offerswall.data.repository.OfferListingRepositoryImpl;
import com.ca.offerswall.data.source.network.NetworkSourceData;
import com.ca.offerswall.domain.repository.OffersRepository;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public OffersMapper providesOffersMapper() {
        return new OffersMapper();
    }

    @Provides
    @Singleton
    public OffersRepository providesOfferRepository(NetworkSourceData networkSourceData, OffersMapper mapper) {
        return new OfferListingRepositoryImpl(networkSourceData, mapper);
    }
}
