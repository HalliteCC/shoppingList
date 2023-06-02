package com.example.buylist.view

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
import com.example.buylist.viewmodel.PlacesViewModel

class BuyListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityShoppingListBinding
    private lateinit var viewModel: PlacesViewModel

    private var listId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingListBinding.inflate(layoutInflater)
        // Layout
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PlacesViewModel::class.java)

        binding.buttonCreateList.setOnClickListener(this)

        observer()
        loadData()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_create_list) {
            val listName = binding.editListName.text.toString()

            val model = BuyListModel().apply {
                this.id = listId
                this.listName = listName
            }
            toast(model)
        }
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            listId = bundle.getInt(BuyConstants.LIST.LIST_ID)
            viewModel.get(listId)
        }
    }

    private fun observer() {
       viewModel.place.observe(this, Observer {
            binding.editListName.setText(it.listName)
        })
    }

    private fun toast(buyList: BuyListModel) {

        val name = binding.editListName.text.toString()

        //Verificação se já existe a Lista
        if (listId == 0 && name != "") {
            viewModel.insert(buyList)
            Toast.makeText(applicationContext, "Lista Criada", Toast.LENGTH_SHORT).show()
            finish()
        } else if (listId != 0 && name != "") {
            viewModel.update(buyList)
            Toast.makeText(applicationContext, "Lista Modificada", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(applicationContext, "FALHA", Toast.LENGTH_SHORT).show()
        }
    }

}
