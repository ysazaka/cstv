package com.ysazaka.cstv.di

import com.ysazaka.cstv.usecase.GetListOfMatchesUseCase
import com.ysazaka.cstv.viewmodel.GetListOfMatchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchesModule = module {
    factory { GetListOfMatchesUseCase() }
    viewModel { GetListOfMatchesViewModel(get()) }
}