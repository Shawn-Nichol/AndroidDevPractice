package com.example.androiddevpractice.room

import androidx.lifecycle.LiveData

class DevRepository(private val devDao: DevDao, search: String) {

    val TAG = "PracticeDevRepository"

    val listDevTopics: LiveData<List<Dev>> = devDao.getAllDevTopics(search)



    suspend fun selectTopic(topic: String, category: String): List<String> {
       return devDao.getTopics(topic, category)
    }


    suspend fun insert(topic: Dev) {
        devDao.insert(topic)
    }

    suspend fun deleteTopic(topic: Dev) {
        devDao.delete(topic)
    }
}