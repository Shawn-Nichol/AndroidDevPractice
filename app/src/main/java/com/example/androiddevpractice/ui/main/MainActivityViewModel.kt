package com.example.androiddevpractice.ui.main

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

    var listOfDevTopics: LiveData<List<Dev>>
    // LiveData so when there is an change the list will update.
    var selectedListTopic: LiveData<List<String>>

    val devDao = DevDatabase.getDatabase(application, viewModelScope).devDao()


    init {
        repository = DevRepository(devDao, "%")
        listOfDevTopics = repository.listDevTopics
        selectedListTopic = repository.selectTopic("Activity", "Activity")
    }

    fun searchTopic(search: String) = viewModelScope.launch(Dispatchers.IO){
        Log.i(TAG, "Search: $search")
        repository = DevRepository(devDao, search)
        listOfDevTopics = repository.listDevTopics
    }


    fun selectTopic(topic: String, category: String) = viewModelScope.launch(Dispatchers.IO){
        Log.i(TAG, "SelectedTopic = $topic, Category = $category")
        selectedListTopic = repository.selectTopic(topic, category)
        Log.i(TAG, "selectTopic, ${selectedListTopic}")
    }

    fun insertTopic(topic: Dev) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(topic)
    }

    fun deleteTopic(topic: Dev) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTopic(topic)
    }



}