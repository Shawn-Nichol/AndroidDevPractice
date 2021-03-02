package com.example.androiddevpractice.ui.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.room.DevDatabase
import com.example.androiddevpractice.room.DevRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(context: Context) : ViewModel() {

    private val TAG = "PracticeMainActivityViewModel"

    // Reference Repository
    var repository: DevRepository


    var listOfDevTopics: LiveData<List<Dev>>
    // LiveData so when there is an change the list will update.
    var selectedListTopic: LiveData<List<String>>

    val devDao = DevDatabase.getDatabase(context, viewModelScope).devDao()


    init {
        repository = DevRepository(devDao, "%")
        listOfDevTopics = repository.listDevTopics
        selectedListTopic = repository.selectTopic("Activity", "Activity")
    }

    fun searchTopic(search: String) = viewModelScope.launch(Dispatchers.IO){

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