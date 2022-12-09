package com.example.testtaskmornhouse

import android.app.Application
import com.example.testtaskmornhouse.di.appModule
import com.example.testtaskmornhouse.di.dataModule
import com.example.testtaskmornhouse.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val modules = listOf(appModule, dataModule, domainModule)
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(androidContext = this@MyApplication)
            modules(modules)
        }
    }
}