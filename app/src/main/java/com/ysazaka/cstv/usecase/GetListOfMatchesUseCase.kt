package com.ysazaka.cstv.usecase

import com.ysazaka.cstv.data.repository.CstvRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetListOfMatchesUseCase : KoinComponent {
    private val cstvRepository: CstvRepository by inject()
    suspend operator fun invoke() = cstvRepository.getListOfMatchesOfTheDay()
}