package com.example.testtaskmornhouse.domain.usecases

import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.repository.UserRepository

class GetListHistoryUseCase(private val repository: UserRepository) {
    suspend fun execute(): List<NumberModel> {
        val resVal = repository.getListHistory()
        return resVal
    }
}