package com.snehpandya.sharedelementtransitiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by sneh.pandya on 18/12/17.
 */

public class PicassoActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        mImageView = (ImageView) findViewById(R.id.imageViewPicasso);
        mButton = (Button) findViewById(R.id.buttonPicasso);
        Picasso.with(this)
            .load(R.drawable.lion)
            .into(mImageView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PicassoActivity.this, PicassoResultActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(PicassoActivity.this,
                                                                                            mImageView, ViewCompat.getTransitionName(mImageView));
                startActivity(intent, optionsCompat.toBundle());
            }
        });
    }
}
