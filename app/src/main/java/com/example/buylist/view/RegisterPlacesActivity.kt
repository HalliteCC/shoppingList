package com.example.buylist.view

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.buylist.databinding.ActivityShoppingListBinding
import java.util.*

class RegisterPlacesActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityShoppingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingListBinding.inflate(layoutInflater)

        binding.buttonCreateList.setOnClickListener {
            TODO()
        }


        // Layout
        setContentView(binding.root)
    }




}