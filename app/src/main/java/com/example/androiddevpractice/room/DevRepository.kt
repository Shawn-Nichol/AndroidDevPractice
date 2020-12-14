package com.example.androiddevpractice.room

import androidx.lifecycle.LiveData

class DevRepository(private val devDao: DevDao, search: String) {

    val TAG = "PracticeDevRepository"

    val listDevTopics: LiveData<List<Dev>> = devDao.getAllDevTopics(search)
    val listTopics: LiveData<List<String>> = devDao.getTopics()


    suspend fun insert(topic: Dev) {
        devDao.insert(topic)
    }

    suspend fun deleteTopic(topic: Dev) {
        devDao.delete(topic)
    }
}