package com.example.firstkotlinapp;

import android.util.Log;

public class Clothes implements Item{

    private String clothingType;
    private String productName;
    private String size;

    public Clothes(String clothingType,String productName,String size) {
        this.clothingType = clothingType;
        this.productName = productName;
        this.size = size;
    }

    @Override
    public void createItem() {
        Log.i("**createClothes**",this.clothingType+" "+this.productName+" "+this.size);
    }

    @Override
    public void displayItem() {
        Log.i("Clothes",this.clothingType+"  "+this.productName+"  "+this.size);
    }
}
