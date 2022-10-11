package com.ysazaka.cstv.di

import com.ysazaka.cstv.usecase.GetListOfMatchesUseCase
import com.ysazaka.cstv.usecase.GetListOfPlayersOfATeamUseCase
import com.ysazaka.cstv.viewmodel.GetListOfMatchesViewModel
import com.ysazaka.cstv.viewmodel.GetListOfPlayersOfATeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchesModule = module {
    factory { GetListOfMatchesUseCase() }
    factory { GetListOfPlayersOfATeamUseCase() }
    viewModel { GetListOfMatchesViewModel(get()) }
    viewModel { GetListOfPlayersOfATeamViewModel(get()) }
}