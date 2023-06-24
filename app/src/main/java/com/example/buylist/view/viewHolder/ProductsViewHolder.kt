package com.example.buylist.view.viewHolder

import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.R
import com.example.buylist.databinding.RowProductListBinding
import com.example.buylist.listener.ProductListener
import com.example.buylist.model.ProductsModel

class ProductsViewHolder (private val productBinding : RowProductListBinding, private val listener: ProductListener)
    : RecyclerView.ViewHolder(productBinding.root) {

        fun bind(list: ProductsModel){
            productBinding.textProduct.text = list.products
            productBinding.TotalPrice.text = list.totalPrice.toString()
            productBinding.textPrice.text = list.price.toString()
            productBinding.textQuantity.text = list.quantity.toString()


            if (list.complete){
                productBinding.imageTask.setImageResource(R.drawable.ic_done)
            }else {
                productBinding.imageTask.setImageResource(R.drawable.ic_todo)
            }

            productBinding.imageTask.setOnClickListener(View.OnClickListener {
                val productId = list.id
                val isComplete = list.complete

                if (isComplete) {
                    listener.onUndoClick(productId)
                } else {
                    listener.onCompleteClick(productId)
                }
            })



            productBinding.textProduct.setOnClickListener { listener.onClick(list.id) }

            productBinding.textProduct.setOnLongClickListener {
                AlertDialog.Builder(itemView.context)
                    .setTitle("Remoção da Produto")
                    .setMessage("Tem certeza que deseja remover?")
                    .setPositiveButton("sim") { dialog, which -> listener.onDelete(list.id) }
                    .setNegativeButton("não", null)
                    .create()
                    .show()
                true
            }
        }
}