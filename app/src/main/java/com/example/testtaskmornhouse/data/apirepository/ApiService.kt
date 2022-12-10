package com.example.testtaskmornhouse.data.apirepository

import com.example.testtaskmornhouse.data.model.ApiNumberDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{number}?json")
    suspend fun getNumberInfo(@Path(value = "number") data: String): ApiNumberDTO

    @GET("random/math?json")
    suspend fun getRandomNumberInfo(): ApiNumberDTO
}