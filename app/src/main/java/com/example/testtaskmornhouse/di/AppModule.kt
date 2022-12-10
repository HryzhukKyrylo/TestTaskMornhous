package com.example.testtaskmornhouse.di

import com.example.testtaskmornhouse.ui.mainscreen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel {
        MainViewModel(
            getNumberInfoUseCase = get(),
            saveNumberInfoUseCase = get()
        )
    }
}