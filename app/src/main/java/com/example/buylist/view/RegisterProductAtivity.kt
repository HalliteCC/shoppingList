package com.example.buylist.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.buylist.R
import com.example.buylist.constants.BuyConstants
import com.example.buylist.databinding.ActivityRegisterProductsBinding
import com.example.buylist.model.BuyListModel
import com.example.buylist.model.ProductsModel
import com.example.buylist.viewmodel.AllPlacesViewModel
import com.example.buylist.viewmodel.PlacesViewModel
import com.example.buylist.viewmodel.ProductsViewModel
import com.example.buylist.viewmodel.RegisterViewModel
import java.text.SimpleDateFormat


class RegisterProductAtivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterProductsBinding
    private lateinit var viewModel: ProductsViewModel
    private lateinit var shoppingListViewModel: AllPlacesViewModel

    private var productId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterProductsBinding.inflate(layoutInflater)
        // Layout
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)


        binding.buttonSave.setOnClickListener(this)

        observe()
        loadData()
        loadSpinner()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            val product = binding.editDescription.text.toString()
            var strQ = binding.editQuantity.text.toString()
            val str = binding.editPrice.text.toString()
            if(product != "" || str != "" || strQ !=""){
                var quantity = strQ.toInt()
                var price = str.toDouble()
                val model = ProductsModel().apply {
                    this.id = productId
                    this.products = product
                    this.price = price
                    this.quantity = quantity
                    this.totalPrice = price * quantity
                }
                toast(model)
            }else {
                Toast.makeText(applicationContext, "FALHA", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            productId = bundle.getInt(BuyConstants.LIST.LIST_ID)
            viewModel.get(productId)
        }
    }

    private fun loadSpinner(){

        shoppingListViewModel = ViewModelProvider(this).get(AllPlacesViewModel::class.java)
        val list = shoppingListViewModel.spinner()
        val nameList = mutableListOf("Selecione uma opção") // Adiciona a mensagem no início da lista
        nameList.addAll(list.map { it.listName })

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nameList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerShopping.adapter = adapter
    }

    fun observe() {
        viewModel.productSave.observe(this, Observer {
            binding.editDescription.setText(it.products)
        })
    }


     fun toast(productList: ProductsModel) {

        val name = binding.editDescription.text.toString()
        val strQ = binding.editQuantity.text.toString()
        val str = binding.editPrice.text.toString()

        //Verificação se já existe a Lista
        if (productId == 0 && name != "" && strQ != "" && str != "") {
            viewModel.insetProduct(productList)
            Toast.makeText(applicationContext, "Produto Criado", Toast.LENGTH_SHORT).show()
            finish()
        } else if (productId != 0 && name != "" && strQ != "" && str != "") {
            viewModel.updateProduct(productList)
            Toast.makeText(applicationContext, "Produto Modificado", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(applicationContext, "FALHA", Toast.LENGTH_SHORT).show()
        }
    }

    fun arrowBack(view: View){
        onBackPressed()
    }
}