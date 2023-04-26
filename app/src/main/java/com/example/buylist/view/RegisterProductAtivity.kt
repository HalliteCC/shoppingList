package com.example.buylist.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.buylist.R
import com.example.buylist.databinding.ActivityRegisterProductsBinding
import java.text.SimpleDateFormat


class RegisterProductAtivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityRegisterProductsBinding
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterProductsBinding.inflate(layoutInflater)


        binding.buttonSave.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

        // Layout
        setContentView(binding.root)
    }

    override fun onClick(v: View) {
       if (v.id == R.id.button_save){
           val product = R.id.edit_description.toString()
           val quantity = R.id.edit_quantity.toString()
           val price = R.id.edit_price.toString()
           if(product == "" || quantity == "" || price == ""){
               Toast.makeText(applicationContext, R.string.fill_all_fields, Toast.LENGTH_SHORT).show()
           }else{
               handleSave()
           }

        }
    }

    fun handleSave(){

    }
}