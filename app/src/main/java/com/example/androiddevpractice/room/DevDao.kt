package com.example.androiddevpractice.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DevDao {

    // Return a list of dev topics.
    @Query("SELECT * from dev_table ORDER BY topic ASC")
    fun getAllDevTopics(): LiveData<List<Dev>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  insert(topic: Dev)

    @Query("DELETE FROM dev_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(topic: Dev)
}