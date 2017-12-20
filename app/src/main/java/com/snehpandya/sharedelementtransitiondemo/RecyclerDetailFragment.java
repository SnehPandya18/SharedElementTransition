package com.snehpandya.sharedelementtransitiondemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by sneh.pandya on 20/12/17.
 */

public class RecyclerDetailFragment extends Fragment {

    public static final String EXTRA_ANIMAL_ITEM = "animal_item";
    public static final String EXTRA_TRANSITION_NAME = "transition_name";

    private AnimalItem mAnimalItem;
    private String transitionName;
    private ImageView mImageView;

    public RecyclerDetailFragment() {
    }

    public static RecyclerDetailFragment newInstance(AnimalItem animalItem, String transitionName) {
        RecyclerDetailFragment recyclerDetailFragment = new RecyclerDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_ANIMAL_ITEM, animalItem);
        bundle.putString(EXTRA_TRANSITION_NAME, transitionName);
        recyclerDetailFragment.setArguments(bundle);
        return recyclerDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAnimalItem = getArguments().getParcelable(EXTRA_ANIMAL_ITEM);
        transitionName = getArguments().getString(EXTRA_TRANSITION_NAME);

        mImageView = (ImageView) view.findViewById(R.id.imageViewRecycler);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mImageView.setTransitionName(transitionName);
        }
        Picasso.with(getContext())
            .load(mAnimalItem.getImageUrl())
            .noFade()
            .into(mImageView, new Callback() {
                @Override
                public void onSuccess() {
                    startPostponedEnterTransition();
                }

                @Override
                public void onError() {
                    startPostponedEnterTransition();
                }
            });
    }
}
