package com.example.buylist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buylist.databinding.ActivityRegisterProductsBinding


class RegisterProductAtivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterProductsBinding.inflate(layoutInflater)


        binding.buttonSave.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterPlacesActivity::class.java))
        }

        // Layout
        setContentView(binding.root)
    }
}