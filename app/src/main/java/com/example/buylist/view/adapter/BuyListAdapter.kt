package com.example.buylist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.databinding.RowPlaceListBinding
import com.example.buylist.listener.BuyListListener
import com.example.buylist.model.BuyListModel
import com.example.buylist.view.viewHolder.BuyListViewHolder

class BuyListAdapter : RecyclerView.Adapter<BuyListViewHolder>() {

    private var buyList: List<BuyListModel> = listOf()
    private lateinit var listener: BuyListListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = RowPlaceListBinding.inflate(inflater, parent, false)

        return BuyListViewHolder(item, listener)
    }

    override fun getItemCount(): Int {
        return buyList.count()
    }

    override fun onBindViewHolder(holder: BuyListViewHolder, position: Int) {
        holder.bindData(buyList[position])
    }

    fun attachListener(buyListener: BuyListListener) {
        listener = buyListener
    }

    fun updateTasks(list: List<BuyListModel>){
        buyList = list
        notifyDataSetChanged()
    }
}