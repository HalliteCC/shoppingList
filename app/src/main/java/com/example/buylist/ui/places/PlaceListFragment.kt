package com.example.buylist.ui.places

import android.app.DirectAction
import android.content.Intent
import android.icu.text.RelativeDateTimeFormatter.Direction
import android.os.Bundle
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buylist.R
import com.example.buylist.constants.BuyConstants
import com.example.buylist.databinding.FragmentBuyListsBinding
import com.example.buylist.listener.BuyListListener
import com.example.buylist.view.BuyListActivity
import com.example.buylist.view.RegisterProductAtivity
import com.example.buylist.view.adapter.BuyListAdapter
import com.example.buylist.viewmodel.AllPlacesViewModel
import org.w3c.dom.Text


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
            override fun onOpenFragment(id: Int) {
                val navController = Navigation.findNavController(binding.root)
                navController.navigate(R.id.nav_product)
            }

            override fun onListClick(id: Int) {

                val intent = Intent(context, BuyListActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(BuyConstants.LIST.LIST_ID, id)
                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onDeleteClick(id: Int) {
                viewModel.delete(id)
                viewModel.getAll()
                Toast.makeText(context, "Lista removida", Toast.LENGTH_SHORT).show()
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
