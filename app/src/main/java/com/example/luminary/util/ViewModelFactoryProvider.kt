package com.example.luminary.util

import android.content.Context
import com.example.luminary.database.ProjectRoomDatabase
import com.example.luminary.net.NetworkService
import com.example.luminary.repository.HomeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


interface ViewModelFactoryProvider {
    fun providePlantListViewModelFactory(context: Context): HomeListViewModelFactory
}

val Injector: ViewModelFactoryProvider
    get() = currentInjector

private object DefaultViewModelProvider : ViewModelFactoryProvider {
    @FlowPreview
    @ExperimentalCoroutinesApi
    private fun getHomeRepository(context: Context): HomeRepository {
        return HomeRepository.getInstance(
            plantDao(context),
            plantService(),
            context
        )
    }

    private fun plantService() = NetworkService()


    private fun plantDao(context: Context) =
        ProjectRoomDatabase.getDatabase(context.applicationContext).userAccountDao()

    override fun providePlantListViewModelFactory(context: Context): HomeListViewModelFactory {
        val repository = getHomeRepository(context)
        return HomeListViewModelFactory(repository)
    }
}

@Volatile
private var currentInjector: ViewModelFactoryProvider =
    DefaultViewModelProvider

