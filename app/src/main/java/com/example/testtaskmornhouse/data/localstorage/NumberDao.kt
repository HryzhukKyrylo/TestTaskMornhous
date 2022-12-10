package com.example.testtaskmornhouse.data.localstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testtaskmornhouse.data.model.Number

@Dao
interface NumberDao {
    @Insert
    fun saveNumber(number: Number)

    @Query("SELECT * FROM my_number_table")
    fun getAll(): List<Number>

    @Query("DELETE FROM my_number_table")
    fun deleteAll()
}