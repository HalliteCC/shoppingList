package com.example.buylist.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buylist.constants.BuyConstants
import com.example.buylist.databinding.FragmentProductsBinding
import com.example.buylist.listener.ProductListener
import com.example.buylist.view.RegisterProductAtivity
import com.example.buylist.view.adapter.BuyListAdapter
import com.example.buylist.view.adapter.ProductAdapter
import com.example.buylist.viewmodel.AllProductsViewModel
import com.example.buylist.viewmodel.ProductsViewModel


class ProductsFragment : Fragment() {

    private lateinit var viewModel: AllProductsViewModel
    private var _binding: FragmentProductsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = ProductAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        viewModel = ViewModelProvider(this).get(AllProductsViewModel::class.java)

        _binding = FragmentProductsBinding.inflate(inflater, container, false)

        binding.recyclerAllTasks.layoutManager = LinearLayoutManager(context)
        binding.recyclerAllTasks.adapter = adapter

        val listener = object : ProductListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, RegisterProductAtivity::class.java)
                val bundle = Bundle()
                bundle.putInt(BuyConstants.LIST.LIST_ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAll()
                Toast.makeText(context, "Produto removido", Toast.LENGTH_SHORT).show()
            }

            override fun onCompleteClick(id: Int) {
                viewModel.status(id, true)
            }

            override fun onUndoClick(id: Int) {
                viewModel.status(id, false)
            }
        }
        adapter.attachListener(listener)

        observe()

        return binding.root
    }
    override fun onResume() {
        super.onResume()
        viewModel.getAll()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun observe() {
        viewModel.product.observe(viewLifecycleOwner) {
            adapter.updateProduct(it)
        }
    }
}