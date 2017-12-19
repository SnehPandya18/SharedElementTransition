package com.snehpandya.sharedelementtransitiondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by sneh.pandya on 18/12/17.
 */

public class PicassoResultActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_result);

        mImageView = (ImageView) findViewById(R.id.imageView2Picasso);
        supportPostponeEnterTransition();

        Picasso.with(this)
            .load(R.drawable.lion)
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
