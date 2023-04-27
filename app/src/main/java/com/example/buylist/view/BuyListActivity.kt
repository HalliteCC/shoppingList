package com.example.buylist.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.buylist.R
import com.example.buylist.constants.BuyConstants
import com.example.buylist.databinding.ActivityShoppingListBinding
import com.example.buylist.model.BuyListModel
import com.example.buylist.viewmodel.BuyListViewModel

class BuyListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityShoppingListBinding
    private lateinit var viewModel: BuyListViewModel
    private var listId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(BuyListViewModel::class.java)

        binding.buttonCreateList.setOnClickListener (this)


        loadData()
        observer()


        // Layout
        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_create_list){
            val listName = binding.editDescription.text.toString()

            val model = BuyListModel().apply {
                this.id = listId
                this.listName = listName
            }
            toast(model)
            viewModel.insert(model)
        }
    }

    fun loadData(){
        val bundle = intent.extras
        if (bundle != null){
            listId = bundle.getInt(BuyConstants.LOGIN.ID)
            viewModel.get(listId)
        }
    }

    private fun observer(){
        viewModel.buyList.observe(this, Observer{
            binding.editDescription.setText(it.listName)
        })
    }

    fun toast (buyList: BuyListModel){

        val name = binding.editDescription.text.toString()

        //Verificação se já existe a Lista
        if (listId == 0 &&  name != "") {
            viewModel.insert(buyList)
            Toast.makeText(applicationContext, "Lista Criada", Toast.LENGTH_SHORT).show()
            finish()
        }else if (listId != 0 && name != "") {
            viewModel.update(buyList)
            Toast.makeText(applicationContext, "Lista Modificada", Toast.LENGTH_SHORT).show()
            finish()
        }else {
            Toast.makeText(applicationContext, "FALHA", Toast.LENGTH_SHORT).show()
        }
    }

}