package com.example.androiddevpractice

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDatabase
import com.example.androiddevpractice.room.DevRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = "PracticeMainActivityViewModel"

    // Reference Repository
    private var repository: DevRepository

    var listDevTopics: LiveData<List<Dev>>
    var listTopic = mutableListOf<String>()

    val devDao = DevDatabase.getDatabase(application, viewModelScope).devDao()


    init {
        repository = DevRepository(devDao, "%")
        listDevTopics = repository.listDevTopics


    }

    fun searchTopic(search: String) {
        Log.i(TAG, "Search: $search")
        repository = DevRepository(devDao, search)
        listDevTopics = repository.listDevTopics
    }

    fun selectTopic(topic: String) = viewModelScope.launch(Dispatchers.IO){
        Log.i(TAG, "SelectedTopic = $topic")
        listTopic = repository.selectTopic(topic).toMutableList()
        Log.i(TAG, "selectTopic, ${listTopic}")


    }

    fun insertTopic(topic: Dev) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(topic)
    }

    fun deleteTopic(topic: Dev) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTopic(topic)
    }

}