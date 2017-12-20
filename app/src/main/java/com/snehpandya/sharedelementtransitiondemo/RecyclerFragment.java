package com.snehpandya.sharedelementtransitiondemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by sneh.pandya on 19/12/17.
 */

public class RecyclerFragment extends Fragment implements AnimalItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerviewAdapter mRecyclerviewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerviewAdapter = new RecyclerviewAdapter(this, generateDummyItems());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewFragment);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mRecyclerviewAdapter);
    }

    @Override
    public void onAnimalItemClick(AnimalItem animalItem, ImageView imageView, String transitionName) {
        Fragment fragment = RecyclerDetailFragment.newInstance(animalItem, transitionName);
        getFragmentManager().beginTransaction()
            .addSharedElement(imageView, transitionName)
            .addToBackStack("TAG")
            .replace(R.id.frameRecycler, fragment)
            .commit();
    }

    private ArrayList<AnimalItem> generateDummyItems() {
        ArrayList<AnimalItem> animalItems = new ArrayList<>();
        animalItems.add(new AnimalItem("Dog", "https://c1.staticflickr.com/1/188/417924629_6832e79c98_z.jpg?zz=1"));
        animalItems.add(new AnimalItem("Penguin", "https://c1.staticflickr.com/9/8616/16237154608_c5489cae31_z.jpg"));
        animalItems.add(new AnimalItem("Eagle", "https://c1.staticflickr.com/5/4010/4210875342_7cb06a9b62_z.jpg?zz=1"));
        animalItems.add(new AnimalItem("Rabbit", "https://c2.staticflickr.com/4/3285/2819978026_175072995a_z.jpg?zz=1"));
        animalItems.add(new AnimalItem("Dolphin", "https://c1.staticflickr.com/8/7619/16124006043_60bc4d8ca5_z.jpg"));
        animalItems.add(new AnimalItem("Snake", "https://c1.staticflickr.com/9/8796/17158681740_a6caa5099f_z.jpg"));
        animalItems.add(new AnimalItem("Seal", "https://c1.staticflickr.com/4/3852/14729534910_62b338dd72_z.jpg"));
        animalItems.add(new AnimalItem("Rhino", "https://c1.staticflickr.com/1/335/18040640224_f56f05f8dc_z.jpg"));
        animalItems.add(new AnimalItem("Leopard", "https://c1.staticflickr.com/9/8678/16645189230_b0e96e7af9_z.jpg"));
        animalItems.add(new AnimalItem("Hippo", "https://c2.staticflickr.com/4/3774/9377370000_6a57d1cfec_z.jpg"));
        return animalItems;

    }
}
