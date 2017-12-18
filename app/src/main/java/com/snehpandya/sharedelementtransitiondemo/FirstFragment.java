package com.snehpandya.sharedelementtransitiondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by sneh.pandya on 18/12/17.
 */

public class FirstFragment extends Fragment {

    private ImageView mImageView;
    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImageView = (ImageView) view.findViewById(R.id.imageViewFragment);
        mButton = (Button) view.findViewById(R.id.buttonFragment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                getFragmentManager()
                    .beginTransaction()
                    .addSharedElement(mImageView, ViewCompat.getTransitionName(mImageView))
                    .addToBackStack(mImageView.toString())
                    .replace(R.id.frame, secondFragment)
                    .commit();
            }
        });
    }
}
