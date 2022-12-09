package com.example.testtaskmornhouse.domain.usecases

import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.repository.UserRepository


class GetNumberInfoUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(data: String): NumberModel? {
        val resVal = repository.getNumberInfo(data)
        return resVal
    }
}