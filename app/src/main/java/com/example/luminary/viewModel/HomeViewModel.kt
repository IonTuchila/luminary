



package com.example.luminary.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.luminary.net.models.User
import com.example.luminary.repository.HomeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@FlowPreview
class HomeViewModel internal constructor(
    private val userRepository: HomeRepository
) : ViewModel() {

    private val userFlow = MutableStateFlow(true)

    val usersUsingFlow: LiveData<List<User>> = userFlow.flatMapLatest {
        userRepository.usersFlow
    }.asLiveData()


    init {
        fetch()
    }

    fun fetch() {
        userRepository.deleteAllUsers()
        launchDataLoad { userRepository.tryUpdateRecentUsersCache() }
    }

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                block()
            } catch (err: Throwable) {

            }
        }
    }

}