package com.example.testtaskmornhouse.data.remoterepository

import com.example.testtaskmornhouse.data.apirepository.ApiService
import com.example.testtaskmornhouse.data.model.toModel
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.google.gson.stream.MalformedJsonException


interface RemoteRepository {
    suspend fun getNumberInfo(data: String): NumberModel?
    suspend fun getRandomNumberInfo(): NumberModel?
}

class RemoteRepositoryImpl(
    private val apiService: ApiService
) : RemoteRepository {
    override suspend fun getNumberInfo(data: String): NumberModel? {
        val response = try {
            apiService.getNumberInfo(data)
        } catch (ex: MalformedJsonException) {
            ex.printStackTrace()
            null
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
        return response?.toModel()
    }

    override suspend fun getRandomNumberInfo(): NumberModel? {
        val response = try {
            apiService.getRandomNumberInfo()
        } catch (ex: MalformedJsonException) {
            ex.printStackTrace()
            null
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
        return response?.toModel()
    }
}