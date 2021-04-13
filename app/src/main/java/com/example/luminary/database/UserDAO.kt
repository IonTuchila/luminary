package com.example.luminary.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.luminary.net.models.User
import com.example.luminary.net.response.UserResponse


@Dao
interface UserDAO {

    @Query("SELECT * FROM UserResponse")
    fun getAll(): UserResponse


    @Query("DELETE FROM UserResponse")
    fun clear()

    @Insert
    fun insertAll(vararg  userResponse: UserResponse)

}