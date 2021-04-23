package com.example.luminary.repository

import android.content.Context
import androidx.room.RoomDatabase
import com.example.luminary.database.ProjectRoomDatabase
import com.example.luminary.database.UserDAO
import com.example.luminary.net.NetworkService
import com.example.luminary.net.models.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
@FlowPreview
class HomeRepository private constructor(
    private val dao: UserDAO,
    private val api: NetworkService,
    private val context: Context
) {


    val usersFlow: Flow<List<User>>
        get() = dao.getAll()


    private suspend fun getAllUsers() {
        val users = api.getAllUsers()
        dao.insertAll(users.results)

    }

    suspend fun tryUpdateRecentUsersCache() {
        getAllUsers()
    }

     fun deleteAllUsers() {
        try {
            ProjectRoomDatabase.getDatabase(context).clearTables()
        }catch (t : Throwable){

        }
    }

    companion object {
        @Volatile
        private var instance: HomeRepository? = null

        fun getInstance(dao: UserDAO, api: NetworkService, context: Context) =
            instance ?: synchronized(this) {
                instance ?: HomeRepository(dao, api, context).also { instance = it }
            }
    }

}