package com.example.firstkotlinapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et_user_name = findViewById(R.id.et_user_name) as EditText
        var et_password = findViewById(R.id.et_password) as EditText
        var btn_reset = findViewById(R.id.btn_reset) as Button
        var btn_submit = findViewById(R.id.btn_submit) as Button
        val items = mutableListOf(
            Furniture(1,"Furniture","Study table"),
            Furniture(2,"Furniture","Wardrobe"),
            Furniture(3,"Furniture","Chair"),
            Furniture(4,"Furniture","Door"),
            Furniture(5,"Furniture","Dining table")
        )

        var furniture = Furniture(6,"Furniture","Couch")
        furniture.createItem()
        items+=furniture

        var clothes = Clothes("Casual","Jeans","L")
        clothes.createItem()
        clothes.displayItem()

        btn_reset.setOnClickListener {
            et_user_name.setText("")
            et_password.setText("")
        }

        btn_submit.setOnClickListener {
            val user_name = et_user_name.text;
            val password = et_password.text;
            if (!validatePassword(user_name.toString(), password.toString()))
              Toast.makeText(this@MainActivity, "Incorrect password", Toast.LENGTH_LONG).show()
            else
            {
                 setVisibilty()
                var itemlist = arrayListOf<String>()
                var adapter = ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_multiple_choice
                    , itemlist)
                listView.adapter =  adapter

                items.forEach{ e ->
                    itemlist.add(e.itemName)
                    adapter.notifyDataSetChanged()
                }
            }

        }
    }

    private fun setVisibilty() {
        et_password.visibility = View.INVISIBLE
        et_user_name.visibility = View.INVISIBLE
        btn_reset.visibility = View.INVISIBLE
        btn_submit.visibility = View.INVISIBLE
        textView1.visibility= View.INVISIBLE
    }
}

    fun validatePassword(username :String, password: String): Boolean{
        if(username.length!=0 && password.length>=6)
          return true

        return false
    }

