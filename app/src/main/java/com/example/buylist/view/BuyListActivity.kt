package com.example.buylist.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buylist.databinding.ActivityShoppingListBinding

class BuyListActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityShoppingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingListBinding.inflate(layoutInflater)

        binding.buttonCreateList.setOnClickListener {
            startActivity(Intent(this, RegisterProductAtivity::class.java ))
        }


        // Layout
        setContentView(binding.root)
    }




}