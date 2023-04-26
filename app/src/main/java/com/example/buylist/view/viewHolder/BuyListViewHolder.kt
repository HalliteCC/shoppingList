package com.example.buylist.view.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.databinding.RowPlaceListBinding
import com.example.buylist.listener.BuyListListener

class BuyListViewHolder(
    private val itemBinding: RowPlaceListBinding, val listener: BuyListListener) :
    RecyclerView.ViewHolder(itemBinding.root) {


}