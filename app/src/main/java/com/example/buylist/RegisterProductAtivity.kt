package com.example.buylist

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.buylist.databinding.ActivityRegisterProductsBinding
import java.text.SimpleDateFormat
import java.util.*


class RegisterProductAtivity : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityRegisterProductsBinding
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterProductsBinding.inflate(layoutInflater)

        binding.buttonDate.setOnClickListener(this)
        binding.buttonSave.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterPlacesActivity::class.java))
        }

        // Layout
        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_date) {
            handleDate()
        }else if (v.id == R.id.button_save){

        }

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val dueDate = dateFormat.format(calendar.time)
        binding.buttonDate.text = dueDate
    }

    fun handleDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, this, year, month, day).show()

    }
}