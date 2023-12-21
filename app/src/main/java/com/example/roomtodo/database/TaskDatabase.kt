package com.example.roomtodo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.roomtodo.models.Task

@Database(
    entities = [Task::class],
    version = 1
    )

@TypeConverters(TypeConverters::class)
abstract class TaskDatabase : RoomDatabase() {
    companion object{
        @Volatile
        private var INSTANCE : TaskDatabase? = null
        fun getInstance(context: Context) : TaskDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}