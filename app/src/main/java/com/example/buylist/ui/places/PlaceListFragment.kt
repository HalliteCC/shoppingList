package com.example.buylist.ui.places

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
import com.example.buylist.databinding.FragmentBuyListsBinding
import com.example.buylist.listener.BuyListListener
import com.example.buylist.view.BuyListActivity
import com.example.buylist.view.adapter.BuyListAdapter
import com.example.buylist.viewmodel.AllPlacesViewModel


class PlaceListFragment : Fragment() {

    private lateinit var viewModel: AllPlacesViewModel
    private var _binding: FragmentBuyListsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private val adapter = BuyListAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        viewModel = ViewModelProvider(this).get(AllPlacesViewModel::class.java)

        _binding = FragmentBuyListsBinding.inflate(inflater, container, false)

        //layout
        binding.recyclerAllPlaces.layoutManager = LinearLayoutManager(context)

        //adapter
        binding.recyclerAllPlaces.adapter = adapter


        //Click Event
        val listener = object : BuyListListener {
            override fun onListClick(id: Int) {
                val intent = Intent(context, BuyListActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(BuyConstants.LOGIN.ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDeleteClick(id: Int) {
                viewModel.delete(id)
                viewModel.getAll()
                Toast.makeText(context, "Convidado removido", Toast.LENGTH_SHORT).show()
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
        viewModel.buy.observe(viewLifecycleOwner) {
            adapter.updateTasks(it)
        }
    }


}