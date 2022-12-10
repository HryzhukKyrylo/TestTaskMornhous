package com.example.testtaskmornhouse.domain.usecases

import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.repository.UserRepository

class GetRandomNumberInfoUseCase(private val repository: UserRepository) {
    suspend fun execute(): NumberModel? {
        val resVal = repository.getRandomNumberInfo()
        return resVal
    }
}