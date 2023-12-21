package com.example.roomtodo.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.roomtodo.dao.TaskDao
import com.example.roomtodo.database.TaskDatabase
import com.example.roomtodo.models.Task
import com.example.roomtodo.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import java.lang.Exception

class TaskRepository(application: Application) {

    private val taskDao:TaskDao = TaskDatabase.getInstance(application).taskDao

    fun insertTask(task: Task) = MutableLiveData<Resource<Long>>().apply {
        postValue(Resource.Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.insertTask(task)
                postValue(Resource.Success(result))
            }
        }catch (e: Exception){
            postValue(Resource.Error(e.message.toString()))

        }
    }

}