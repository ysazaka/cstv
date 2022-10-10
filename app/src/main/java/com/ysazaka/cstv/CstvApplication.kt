package com.ysazaka.cstv

import android.app.Application
import com.ysazaka.cstv.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class CstvApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        loadDependencies()
    }


    private fun loadDependencies() {
        startKoin {
            androidContext(this@CstvApplication)
            modules(appModule)
        }
    }

}