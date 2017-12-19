package com.snehpandya.sharedelementtransitiondemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sneh.pandya on 19/12/17.
 */

public class AnimalItem implements Parcelable {

    private String name;
    private String imageUrl;

    AnimalItem(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    private AnimalItem(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<AnimalItem> CREATOR = new Creator<AnimalItem>() {
        @Override
        public AnimalItem createFromParcel(Parcel in) {
            return new AnimalItem(in);
        }

        @Override
        public AnimalItem[] newArray(int size) {
            return new AnimalItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(imageUrl);
    }
}
