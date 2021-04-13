package com.example.luminary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.luminary.net.response.UserResponse
import com.example.luminary.util.ROOM_DB_NAME

@Database(entities = [UserResponse::class], version = 2, exportSchema = false)
@TypeConverters(DataConverter :: class)
abstract class ProjectRoomDatabase : RoomDatabase() {

    abstract fun userAccountDao(): UserDAO

    companion object {
        private var INSTANCE: ProjectRoomDatabase? = null

        fun getDatabase(context: Context) = INSTANCE ?: kotlin.run {
            Room.databaseBuilder(
                context.applicationContext,
                ProjectRoomDatabase::class.java,
                ROOM_DB_NAME
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}