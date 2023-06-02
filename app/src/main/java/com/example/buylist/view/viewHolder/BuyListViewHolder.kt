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

class BuyListViewHolder(private val itemBinding: RowPlaceListBinding, private val listener: BuyListListener)
    : RecyclerView.ViewHolder(itemBinding.root) {

    fun bindData(list: BuyListModel) {
        itemBinding.textListName.text = list.listName


        itemBinding.imgEdit.setOnClickListener {
            listener.onListClick(list.id)
        }

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
    }


}


