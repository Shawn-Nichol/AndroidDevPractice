package com.example.androiddevpractice.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dev_table")
data class Dev(
    @ColumnInfo(name = "topic") val topic: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "sub category") val subCategory: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowId") var id: Long = 0
)