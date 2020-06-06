package com.example.firstkotlinapp

import android.util.Log

data class Furniture(var itemNo: Int = 0 ,var itemCategory:String ="",var itemName: String= "") : Item{

    override fun createItem() {
        Log.i("**createFurniture**",this.itemNo.toString()+" "+this.itemName+" "+this.itemCategory)
    }

    override fun displayItem() {
        Log.i("items","$itemNo  $itemCategory  $itemName")
    }
}