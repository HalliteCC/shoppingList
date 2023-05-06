package com.example.buylist.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.devmasterteam.tasks.service.helper.BiometricHelper
import com.example.buylist.R
import com.example.buylist.databinding.ActivityLoginBinding
import com.example.buylist.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //variaveis da classe
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        //layout
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(this)
        binding.textRegister.setOnClickListener(this)


        observe()
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_login) {
            handleLogin()
        } else if (v.id == R.id.text_register) {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun observe() {
        viewModel.verifyAuthentication()
        viewModel.login.observe(this) {
            if (it.status()) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(applicationContext, it.message(), Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun handleLogin() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()

        viewModel.doLogin(email, password)

    }
}

/*private fun biometricAuthentication (){
        if (BiometricHelper.isBiometricAvailable(this)) {

            val executor = ContextCompat.getMainExecutor(this)
            val bio =
                BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    }
                })

            val info = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Titulo")
                .setSubtitle("Sub titulo")
                .setDescription("Descrição")
                .setNegativeButtonText("Cancelar")
                .build()

            bio.authenticate(info)
        }
    }*/