package com.example.buylist.view

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.buylist.R
import com.example.buylist.databinding.ActivityRegisterProductsBinding
import java.text.SimpleDateFormat
import java.util.*


class RegisterProductAtivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityRegisterProductsBinding
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterProductsBinding.inflate(layoutInflater)


        binding.buttonSave.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterPlacesActivity::class.java))
        }

        // Layout
        setContentView(binding.root)
    }

    override fun onClick(v: View) {
       if (v.id == R.id.button_save){
            handleSave()
        }
    }

    fun handleSave(){

    }
}