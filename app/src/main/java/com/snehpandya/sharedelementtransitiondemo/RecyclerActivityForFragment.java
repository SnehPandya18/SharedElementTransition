package com.snehpandya.sharedelementtransitiondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sneh.pandya on 19/12/17.
 */

public class RecyclerActivityForFragment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_fragment);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameRecycler, new RecyclerFragment());
        ft.commit();
    }
}
