package com.example.buylist.view.fragments

import androidx.fragment.app.Fragment
import com.example.buylist.databinding.FragmentProductsBinding
import com.example.buylist.view.adapter.BuyListAdapter
import com.example.buylist.viewmodel.BuyListViewModel

class ProductsFragment : Fragment() {
    private var _binding: FragmentProductsBinding? = null

    private val binding get() = _binding
    private lateinit var viewModel: BuyListViewModel
    private val buyListAdapter = BuyListAdapter()
}