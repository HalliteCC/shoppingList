package com.example.buylist.view.viewHolder

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
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