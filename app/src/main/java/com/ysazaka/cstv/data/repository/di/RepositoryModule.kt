package com.ysazaka.cstv.data.repository.di

import com.ysazaka.cstv.data.repository.CstvRepository
import com.ysazaka.cstv.data.repository.CstvRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<CstvRepository> {
        CstvRepositoryImpl(
            get()
        )
    }
}