package com.example.cafinder;

import android.graphics.Bitmap;

public class AddCarModelClass {

    Bitmap image;
    public AddCarModelClass(Bitmap image){
        this.image = image;

    }
    public Bitmap getImage(){
        return image;
    }

    public void setImage(Bitmap image){
        this.image = image;
    }
}
