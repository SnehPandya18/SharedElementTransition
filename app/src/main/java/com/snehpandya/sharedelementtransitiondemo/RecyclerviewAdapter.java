package com.snehpandya.sharedelementtransitiondemo;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sneh.pandya on 19/12/17.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ImageViewHolder> {

    private final AnimalItemClickListener mAnimalItemClickListener;
    private ArrayList<AnimalItem> mAnimalItems;

    RecyclerviewAdapter(AnimalItemClickListener animalItemClickListener, ArrayList<AnimalItem> animalItems) {
        mAnimalItemClickListener = animalItemClickListener;
        mAnimalItems = animalItems;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false));
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        final AnimalItem animalItem = mAnimalItems.get(position);

        Picasso.with(holder.itemView.getContext())
            .load(animalItem.getImageUrl())
            .into(holder.animalImageView);

        holder.animalImageView.setAdjustViewBounds(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.animalImageView.setTransitionName("animal_name_" + String.valueOf(holder.getAdapterPosition()));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnimalItemClickListener.onAnimalItemClick(animalItem, holder.animalImageView, holder.animalImageView.getTransitionName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAnimalItems.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView animalImageView;

        ImageViewHolder(View itemView) {
            super(itemView);
            animalImageView = (ImageView) itemView.findViewById(R.id.imageViewItemAnimal);
            animalImageView.setAdjustViewBounds(true);
        }
    }
}
