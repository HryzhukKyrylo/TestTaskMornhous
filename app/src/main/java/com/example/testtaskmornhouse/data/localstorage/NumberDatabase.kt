package com.example.testtaskmornhouse.data.localstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtaskmornhouse.data.model.Number

@Database(entities = [Number::class], version = 1, exportSchema = false)
abstract class NumberDatabase : RoomDatabase() {
    abstract fun numberDao(): NumberDao
}