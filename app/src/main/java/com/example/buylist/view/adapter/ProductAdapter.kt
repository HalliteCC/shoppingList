package com.example.buylist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.databinding.RowProductListBinding
import com.example.buylist.listener.BuyListListener
import com.example.buylist.listener.ProductListener
import com.example.buylist.model.ProductsModel
import com.example.buylist.view.viewHolder.ProductsViewHolder

class ProductAdapter : RecyclerView.Adapter<ProductsViewHolder>() {


    private var productList: List<ProductsModel> = listOf()
    private lateinit var listener: ProductListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val item = RowProductListBinding.inflate(inflate, parent, false)

        return ProductsViewHolder(item, listener)
    }

    override fun getItemCount(): Int {
        return productList.count()
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun attachListener(productListener: ProductListener) {
        listener = productListener
    }
}