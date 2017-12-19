package com.snehpandya.sharedelementtransitiondemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by sneh.pandya on 19/12/17.
 */

public class RecyclerDetailActivity extends AppCompatActivity {

    private ImageView mImageView;
    private String imageUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_detail);
        supportPostponeEnterTransition();

        mImageView = (ImageView) findViewById(R.id.imageViewRecycler);

        Bundle bundle = getIntent().getExtras();
        AnimalItem animalItem = bundle.getParcelable(RecyclerActivity.EXTRA_ANIMAL_ITEM);
        imageUrl = animalItem.getImageUrl();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = bundle.getString(RecyclerActivity.EXTRA_ANIMAL_TRANSITION_NAME);
            mImageView.setTransitionName(imageTransitionName);
        }

        Picasso.with(this)
            .load(imageUrl)
            .noFade()
            .into(mImageView, new Callback() {
                @Override
                public void onSuccess() {
                    supportStartPostponedEnterTransition();
                }

                @Override
                public void onError() {
                    supportStartPostponedEnterTransition();
                }
            });
    }
}
