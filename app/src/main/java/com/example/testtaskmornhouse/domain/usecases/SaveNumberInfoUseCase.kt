package com.example.testtaskmornhouse.domain.usecases

import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.repository.UserRepository

class SaveNumberInfoUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(data:NumberModel){
        repository.saveNumber(data)
    }
}