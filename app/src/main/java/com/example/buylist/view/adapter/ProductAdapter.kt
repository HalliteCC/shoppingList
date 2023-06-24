package com.example.buylist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.databinding.RowProductListBinding
import com.example.buylist.listener.BuyListListener
import com.example.buylist.listener.ProductListener
import com.example.buylist.model.BuyListModel
import com.example.buylist.model.ProductsModel
import com.example.buylist.view.viewHolder.ProductsViewHolder
class ProductAdapter : RecyclerView.Adapter<ProductsViewHolder>() {

    private var productList: List<ProductsModel> = listOf()
    private lateinit var listener: ProductListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RowProductListBinding.inflate(inflater, parent, false)
        return ProductsViewHolder(itemBinding, listener)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun attachListener(productListener: ProductListener) {
        listener = productListener
    }

    fun updateProduct(products: List<ProductsModel>) {
        productList = products
        notifyDataSetChanged()
    }
}
