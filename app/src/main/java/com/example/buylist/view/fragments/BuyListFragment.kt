package com.example.buylist.view.fragments

import androidx.fragment.app.Fragment
import com.example.buylist.databinding.FragmentBuyListsBinding
import com.example.buylist.view.adapter.Adapter
import com.example.buylist.viewmodel.BuyListViewModel

class BuyListFragment : Fragment() {

    private var _binding: FragmentBuyListsBinding? = null

    private val binding get() = _binding
    private lateinit var viewModel: BuyListViewModel
    private val adapter = Adapter()
}