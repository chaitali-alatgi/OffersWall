package com.ca.offerswall.ui.home;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ca.offerswall.R;
import com.ca.offerswall.databinding.FragmentFormBinding;
import com.ca.offerswall.domain.model.Offer;
import com.ca.offerswall.ui.base.BaseFragment;
import com.ca.offerswall.ui.base.Navigator;
import com.ca.offerswall.ui.offer_listing.OfferListingFragment;
import com.ca.offerswall.ui.viewmodel.FormViewModel;
import com.ca.offerswall.ui.viewmodel.model.OfferListState;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

public class FormFragment extends BaseFragment {
    FragmentFormBinding fragmentFormBinding;
    @Inject
    FormViewModel formViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFormBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_form, container, false);
        return fragmentFormBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        subScreenComponent.inject(this);
        fragmentFormBinding.setFormViewModel(formViewModel);
        formViewModel.bound();
        observeOfferListLiveData();
    }

    private void observeOfferListLiveData() {
        formViewModel.offerObservableList.observe(getViewLifecycleOwner(), offerListStateObserver);
    }

    private Observer<OfferListState> offerListStateObserver = new Observer<OfferListState> () {
        @Override
        public void onChanged(OfferListState offerListState) {
            if( offerListState instanceof OfferListState.SuccessOfferListState) {
                formViewModel.progressVisibility.set(false);
                List<Offer> offerList = (List<Offer>) offerListState.getResponse();
                redirectToNextScreen(offerList);
            } else if(offerListState instanceof OfferListState.LoadingOfferListState) {
                formViewModel.progressVisibility.set(true);
            } else if(offerListState instanceof OfferListState.ErrorOfferListState) {
                formViewModel.progressVisibility.set(false);
                if(offerListState.getException() instanceof IOException){
                    showErrorMessage(getString(R.string.network_connection));
                } else {
                    showErrorMessage(offerListState.getException().getMessage());
                }
            }
        }
    };

    private void redirectToNextScreen(List<Offer> offerList) {
        Fragment nextFragment = new OfferListingFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(OfferListingFragment.INTENT_OFFERS_LIST, (Serializable) offerList);
        nextFragment.setArguments(bundle);
        Navigator.toNextFragment(getActivity(), nextFragment);
    }

    private void showErrorMessage(String message) {
        Snackbar snack = Snackbar.make(getActivity().findViewById(android.R.id.content),
                Html.fromHtml(message), Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snack.getView();
        layout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.black));
        TextView textView = layout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        snack.show();
    }
}
