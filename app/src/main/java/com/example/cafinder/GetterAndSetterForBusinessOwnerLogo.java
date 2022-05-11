package com.example.cafinder;

import android.graphics.Bitmap;

public class GetterAndSetterForBusinessOwnerLogo {

    private Bitmap image;


    public GetterAndSetterForBusinessOwnerLogo(Bitmap image){
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
