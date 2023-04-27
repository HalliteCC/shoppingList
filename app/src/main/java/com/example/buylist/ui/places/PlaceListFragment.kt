package com.example.buylist.ui.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buylist.databinding.FragmentBuyListsBinding
import com.example.buylist.view.adapter.BuyListAdapter
import com.example.buylist.viewmodel.BuyListViewModel


class PlaceListFragment : Fragment() {

    private lateinit var viewModel: BuyListViewModel
    private var _binding: FragmentBuyListsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val filter = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {

        viewModel = ViewModelProvider(this).get(BuyListViewModel::class.java)
        _binding = FragmentBuyListsBinding.inflate(inflater, container, false)

        binding.recyclerAllPlaces.layoutManager = LinearLayoutManager(context)
        binding.recyclerAllPlaces.adapter = BuyListAdapter()


        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}