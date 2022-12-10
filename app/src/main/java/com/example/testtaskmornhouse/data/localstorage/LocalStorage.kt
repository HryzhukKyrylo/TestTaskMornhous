package com.example.testtaskmornhouse.data.localstorage

import com.example.testtaskmornhouse.data.model.Number

interface LocalStorage {
    fun saveNumber(data: Number)
    fun getListHistory(): List<Number>
}