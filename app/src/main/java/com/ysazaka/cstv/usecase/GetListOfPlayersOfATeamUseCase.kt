package com.ysazaka.cstv.usecase

import com.ysazaka.cstv.data.repository.CstvRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetListOfPlayersOfATeamUseCase : KoinComponent {
    private val cstvRepository: CstvRepository by inject()
    suspend operator fun invoke(teamId: Long) = cstvRepository.getListOfPlayersOfATeam(teamId)
}