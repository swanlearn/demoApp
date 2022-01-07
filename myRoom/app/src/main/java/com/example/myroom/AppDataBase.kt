package com.example.myroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myroom.iteam

@Database(entities = [iteam::class], version = 1, exportSchema = true)
abstract class AppDataBase:RoomDatabase() {
    abstract fun UDao(): UDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        var tempInstance = INSTANCE
        fun getInstance(context: Context): AppDataBase {

            if (tempInstance != null) {
                return tempInstance as AppDataBase
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "user_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}