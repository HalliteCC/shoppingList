package com.example.buylist.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.buylist.R
import com.example.buylist.databinding.ActivityRegisterAccountBinding
import com.example.buylist.model.LoginModel
import com.example.buylist.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Variaveis da classe
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding = ActivityRegisterAccountBinding.inflate(layoutInflater)

        //Eventos
        binding.buttonSave.setOnClickListener(this)

        observe()

        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleRegister()
        }
    }

    private fun observe() {
        viewModel.register.observe(this) {
            if (it.status()) {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                Toast.makeText(
                    applicationContext,
                    "Cadastro realizado com sucesso",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else {
                Toast.makeText(applicationContext, it.message(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleRegister() {
        val name = binding.editName.text.toString()
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()

        viewModel.create(name, email, password)
    }

    fun arrowBack(view: View){
        onBackPressed()
    }
}