package com.example.testtaskmornhouse.data.repository

import com.example.testtaskmornhouse.data.localstorage.LocalStorage
import com.example.testtaskmornhouse.data.model.toEntity
import com.example.testtaskmornhouse.data.remoterepository.RemoteRepository
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteRepository: RemoteRepository,
    private val localStorage: LocalStorage,
) : UserRepository {
    override suspend fun getNumberInfo(data: String): NumberModel? {
        val resVal = remoteRepository.getNumberInfo(data)
        return resVal
    }

    override suspend fun saveNumber(data: NumberModel) {
        localStorage.saveNumber(data.toEntity())
    }
}