package com.example.buylist.view.viewHolder

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.R
import com.example.buylist.databinding.RowPlaceListBinding
import com.example.buylist.listener.BuyListListener
import com.example.buylist.model.BuyListModel
import com.example.buylist.ui.home.ProductsFragment

class BuyListViewHolder(private val itemBinding: RowPlaceListBinding,  private val listener: BuyListListener)
    : RecyclerView.ViewHolder(itemBinding.root) {

    fun bindData(list: BuyListModel) {
        itemBinding.textListName.text = list.listName


        itemBinding.textListName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção da Lista")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("sim") { dialog, which -> listener.onDeleteClick(list.id) }
                .setNegativeButton("não", null)
                .create()
                .show()
            true
        }

        itemBinding.textListName.setOnClickListener{
            val fragment = ProductsFragment()
            val args = Bundle()
            args.putInt("listId", list.id)
            fragment.arguments = args
            val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(com.google.android.material.R.id.container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}


