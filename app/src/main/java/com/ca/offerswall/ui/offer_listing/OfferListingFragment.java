package com.ca.offerswall.ui.offer_listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ca.offerswall.R;
import com.ca.offerswall.databinding.FragmentOfferListingBinding;
import com.ca.offerswall.domain.model.Offer;
import com.ca.offerswall.ui.adapter.OfferAdapter;
import com.ca.offerswall.ui.base.BaseFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OfferListingFragment extends BaseFragment {
    public static String INTENT_OFFERS_LIST = "INTENT_OFFERS_LIST";

    FragmentOfferListingBinding fragmentOfferListingBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentOfferListingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_offer_listing, container, false);
        return fragmentOfferListingBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        subScreenComponent.inject(this);
        Bundle arguments = getArguments();
        ObservableList<Offer> offerList = new ObservableArrayList<>();
        if(arguments != null) {
            offerList.addAll((List<Offer>)arguments.getSerializable(INTENT_OFFERS_LIST));
        }
        bindList(fragmentOfferListingBinding.rvOffers, offerList);
    }

    void bindList(RecyclerView recyclerView, ObservableList<Offer> offerList) {
        OfferAdapter adapter = new OfferAdapter(offerList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
