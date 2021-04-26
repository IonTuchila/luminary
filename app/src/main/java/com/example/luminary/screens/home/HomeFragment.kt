package com.example.luminary.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.luminary.databinding.FragmentHomeBinding
import com.example.luminary.repository.HomeRepository
import com.example.luminary.util.Injector
import com.example.luminary.viewModel.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private lateinit var adapter: HomeAdapter
    lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels {
        Injector.providePlantListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root
        setupRecycler()

        return binding.root
    }

    private fun subscribeUi(adapter: HomeAdapter) {
        viewModel.usersUsingFlow.observe(viewLifecycleOwner) { users ->
            adapter.submitList(users)
            binding.swipeToRefresh.isRefreshing = false
        }
    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    private fun setupRecycler() {
        adapter = HomeAdapter {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        }

        binding.recycler.adapter = adapter
        binding.recycler.apply {
            this.layoutManager = LinearLayoutManager(this.context)
            itemAnimator = DefaultItemAnimator()
        }

        subscribeUi(adapter)
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.fetch()
        }
    }
}

