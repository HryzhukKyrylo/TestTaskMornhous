package com.example.testtaskmornhouse.data.repository

import com.example.testtaskmornhouse.data.remoterepository.RemoteRepository
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteRepository: RemoteRepository,
) : UserRepository {
    override suspend fun getNumberInfo(data: String): NumberModel? {
        val resVal = remoteRepository.getNumberInfo(data)
        return resVal
    }
}