package com.example.testtaskmornhouse.data.localstorage

import com.example.testtaskmornhouse.data.model.Number

class LocalStorageImpl(
    private val database: NumberDatabase,
) : LocalStorage {
    override fun saveNumber(data: Number) {
        database.numberDao().saveNumber(data)
    }
}