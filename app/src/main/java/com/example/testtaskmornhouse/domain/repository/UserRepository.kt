package com.example.testtaskmornhouse.domain.repository

import com.example.testtaskmornhouse.domain.model.NumberModel

interface UserRepository {
    suspend fun getNumberInfo(data: String): NumberModel?
    suspend fun saveNumber(data: NumberModel)
    suspend fun getListHistory(): List<NumberModel>
    suspend fun getRandomNumberInfo(): NumberModel?
}