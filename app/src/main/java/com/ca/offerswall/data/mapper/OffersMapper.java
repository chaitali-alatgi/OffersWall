package com.ca.offerswall.data.mapper;

import com.ca.offerswall.data.model.OffersResponse;
import com.ca.offerswall.domain.model.Offer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class OffersMapper {

    @Inject
    public OffersMapper(){}

    public List<Offer> map(OffersResponse response) {
        List<Offer> offerList = new ArrayList<>();
        for(com.ca.offerswall.data.model.Offer offerItem: response.getOffers()) {
            offerList.add(new Offer(
                    offerItem.getOfferId(),
                    offerItem.getTitle(),
                    offerItem.getThumbnail()
            ));
        }
        return offerList;
    }
}
