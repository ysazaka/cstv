package com.ysazaka.cstv.di

import com.ysazaka.cstv.data.remote.di.remoteModule
import com.ysazaka.cstv.data.repository.di.repositoryModule

val appModule = listOf(
    repositoryModule,
    remoteModule,
    matchesModule
)