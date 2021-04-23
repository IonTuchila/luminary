package com.example.luminary.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.luminary.net.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Query("SELECT * from users")
    fun getAll(): Flow<List<User>>

    @Query("DELETE from users")
    fun clear()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>?)

}