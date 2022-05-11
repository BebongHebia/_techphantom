package com.example.cafinder;

import android.graphics.Bitmap;

public class GetterAndSetterProfileImage {

    Bitmap image;
    public GetterAndSetterProfileImage(Bitmap image){
        this.image = image;

    }
    public Bitmap getImage(){
        return image;
    }

    public void setImage(Bitmap image){
        this.image = image;
    }
}
