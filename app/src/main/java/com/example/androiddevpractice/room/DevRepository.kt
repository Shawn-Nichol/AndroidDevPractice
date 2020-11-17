package com.example.androiddevpractice.room

import androidx.lifecycle.LiveData

class DevRepository(private val devDao: DevDao) {
    val devTopics: LiveData<List<Dev>> = devDao.getAllDevTopics()

    suspend fun insert(topic: Dev) {
        devDao.insert(topic)
    }

    suspend fun deleteTopic(topic: Dev) {
        devDao.delete(topic)
    }
}