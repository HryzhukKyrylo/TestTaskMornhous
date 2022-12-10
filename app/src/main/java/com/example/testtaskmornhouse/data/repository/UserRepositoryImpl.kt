package com.example.testtaskmornhouse.data.repository

import com.example.testtaskmornhouse.data.localstorage.LocalStorage
import com.example.testtaskmornhouse.data.model.toEntity
import com.example.testtaskmornhouse.data.remotestorage.RemoteStorage
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteStorage: RemoteStorage,
    private val localStorage: LocalStorage,
) : UserRepository {
    override suspend fun getNumberInfo(data: String): NumberModel? {
        val resVal = remoteStorage.getNumberInfo(data)
        return resVal
    }

    override suspend fun saveNumber(data: NumberModel) {
        localStorage.saveNumber(data.toEntity())
    }

    override suspend fun getListHistory(): List<NumberModel> {
        val res = localStorage.getListHistory()
        return res.map { it.toEntity() }
    }

    override suspend fun getRandomNumberInfo(): NumberModel? {
        val resVal = remoteStorage.getRandomNumberInfo()
        return resVal
    }
}