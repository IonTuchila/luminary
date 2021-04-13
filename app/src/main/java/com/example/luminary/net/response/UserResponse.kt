package com.example.luminary.net.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.luminary.database.DataConverter
import com.example.luminary.net.models.User

@Entity
class UserResponse(@PrimaryKey(autoGenerate = true) val  id : Int,
                    var results: List<User>){}