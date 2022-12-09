package com.example.testtaskmornhouse.di

import com.example.testtaskmornhouse.BuildConfig
import com.example.testtaskmornhouse.data.apirepository.ApiService
import com.example.testtaskmornhouse.data.remoterepository.RemoteRepository
import com.example.testtaskmornhouse.data.remoterepository.RemoteRepositoryImpl
import com.example.testtaskmornhouse.data.repository.UserRepositoryImpl
import com.example.testtaskmornhouse.domain.repository.UserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    factory<OkHttpClient> {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> {
        val retrofit = get<Retrofit>()
        retrofit.create(ApiService::class.java)
    }

    single<RemoteRepository> {
        RemoteRepositoryImpl(
            apiService = get()
        )
    }

    single<UserRepository> {
        UserRepositoryImpl(
            remoteRepository = get()
        )
    }
}