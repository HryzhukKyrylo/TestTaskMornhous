package com.example.testtaskmornhouse.di

import com.example.testtaskmornhouse.domain.usecases.GetNumberInfoUseCase
import com.example.testtaskmornhouse.domain.usecases.SaveNumberInfoUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetNumberInfoUseCase(
            repository = get()
        )
    }

    factory {
        SaveNumberInfoUseCase(
            repository = get()
        )
    }
}