package com.example.testtaskmornhouse.di

import com.example.testtaskmornhouse.domain.usecases.GetNumberInfoUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetNumberInfoUseCase(
            repository = get()
        )
    }
}