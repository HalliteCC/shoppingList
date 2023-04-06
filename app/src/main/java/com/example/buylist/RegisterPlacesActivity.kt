package com.example.buylist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.buylist.databinding.ActivityShoppingListBinding

class RegisterPlacesActivity: AppCompatActivity() {

private lateinit var binding: ActivityShoppingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingListBinding.inflate(layoutInflater)

        binding.buttonCreateList.setOnClickListener{
            startActivity(Intent(this, RegisterProductAtivity::class.java))
        }


        // Layout
        setContentView(binding.root)
    }

}