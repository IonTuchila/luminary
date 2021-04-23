package com.example.luminary.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.luminary.repository.HomeRepository
import com.example.luminary.viewModel.HomeViewModel

/**
 * Factory for creating a [PlantListViewModel] with a constructor that takes a [PlantRepository].
 */
class HomeListViewModelFactory(
    private val repository: HomeRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = HomeViewModel(repository) as T
}