package com.ca.offerswall.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ca.offerswall.databinding.ItemOfferBinding;
import com.ca.offerswall.domain.model.Offer;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    ObservableList<Offer> offersList;

    public OfferAdapter( ObservableList<Offer> offersList) {
        this.offersList = offersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ViewHolder(ItemOfferBinding.inflate(
               LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.bind(offersList.get(position));
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemOfferBinding binding;
        public ViewHolder(ItemOfferBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Offer offer) {
            Picasso.get().load(offer.getmThumbnail().getLowres()).into(binding.ivPoster);
            binding.tvTitle.setText(offer.getmTitle());
        }
    }
}
