package com.snehpandya.sharedelementtransitiondemo;

import android.widget.ImageView;

/**
 * Created by sneh.pandya on 19/12/17.
 */

public interface AnimalItemClickListener {
    void onAnimalItemClick(AnimalItem animalItem, ImageView imageView, String transitionName);
}
