package com.example.donutroomassignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Donut::class], version = 1, exportSchema = false)
abstract class DonutDatabase: RoomDatabase() {

    abstract val donutDao: DonutDao

    companion object {

        @Volatile
        private var INSTANCE : DonutDatabase? = null

        fun getInstance(context: Context): DonutDatabase {

            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DonutDatabase::class.java,
                        "donut_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}