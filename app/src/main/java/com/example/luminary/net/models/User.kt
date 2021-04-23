package com.example.luminary.net.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User(
    @PrimaryKey @ColumnInfo(name = "email") val email: String,
    var name: Name?,
    var picture: Picture?
)