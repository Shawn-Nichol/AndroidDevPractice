package com.example.androiddevpractice.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dev_table")
data class Dev(
    @ColumnInfo(name = "Topic") val topic: String,
    @ColumnInfo(name = "Category") val category: String,
    @ColumnInfo(name = "Details") val Details: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowId") var id: Long = 0
)