package com.example.androiddevpractice.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DevDao {

    /**
     * SELECT: Columns
     * FROM: Table
     * WHERE: is used to filter records
     * LIKE: is used in the WHERE clause to search for a specific pattern.
     * GROUP BY: groups rows that have the same values into summary rows.
     * ORDER BY ASC the by category. and then by topic in the category.
     */
    @Query("SELECT * FROM dev_table WHERE topic LIKE :search GROUP BY topic, Category ORDER BY category, topic")
    fun getAllDevTopics(search: String): LiveData<List<Dev>>

    /**
     * Returns the string details column, when the topic and category setting are true.
     */
    @Query("SELECT Details FROM dev_table WHERE (Topic = :topic and Category = :category) ")
    fun getTopics(topic: String, category: String): LiveData<List<String>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  insert(topic: Dev)

    @Query("DELETE FROM dev_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(topic: Dev)
}