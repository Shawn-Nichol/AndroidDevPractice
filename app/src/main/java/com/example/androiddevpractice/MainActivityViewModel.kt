package com.example.androiddevpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDatabase
import com.example.androiddevpractice.room.DevRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application){

    // Reference Repository
    private val repository: DevRepository

    val devTopics: LiveData<List<Dev>>

    init {
        val devDao = DevDatabase.getDatabase(application, viewModelScope).devDao()
        repository = DevRepository(devDao)
        devTopics = repository.devTopics
    }

    fun insertTopic(topic: Dev) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(topic)
    }

    fun deleteTopic(topic: Dev)  = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTopic(topic)
    }

}