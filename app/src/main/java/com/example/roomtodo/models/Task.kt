package com.example.roomtodo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Task(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "taskId")
    val id : String,
    @ColumnInfo(name = "taskTitle")
    val title : String,
    val description : String,
    val date : Date,

    )