package com.example.luminary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.luminary.net.models.User
import com.example.luminary.util.ROOM_DB_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [User::class], version = 3, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class ProjectRoomDatabase : RoomDatabase() {

    abstract fun userAccountDao(): UserDAO

    fun clearTables() {
        GlobalScope.launch(Dispatchers.IO) {
            this@ProjectRoomDatabase.clearAllTables()
        }
    }

    companion object {
        @Volatile
        private var instance: ProjectRoomDatabase? = null

        fun getDatabase(context: Context): ProjectRoomDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(
                        context
                    ).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ProjectRoomDatabase {
            return Room.databaseBuilder(context, ProjectRoomDatabase::class.java, ROOM_DB_NAME)
                .fallbackToDestructiveMigration().build()
        }
    }
}