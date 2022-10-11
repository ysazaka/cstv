package com.ysazaka.cstv.data.repository

import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.data.model.match.PlayerDto
import com.ysazaka.cstv.data.model.response.ResponseRemote
import com.ysazaka.cstv.data.model.response.ResponseRequired
import com.ysazaka.cstv.data.remote.service.CstvService
import com.ysazaka.cstv.data.repository.mapper.MatchesMapper
import com.ysazaka.cstv.data.repository.mapper.PlayersMapper

class CstvRepositoryImpl(
    private val cstvService: CstvService
) : CstvRepository {

    override suspend fun getListOfMatchesOfTheDay(dayFilter: String): ResponseRequired<List<MatchDto>> {
        return when (val responseRemote = cstvService.getListOfMatchesOfTheDay(dayFilter)) {
            is ResponseRemote.Success -> {
                val mappedResult = MatchesMapper.map(responseRemote.response)
                ResponseRequired.Success(result = mappedResult)
            }
            is ResponseRemote.Error -> ResponseRequired.Error(Exception(responseRemote.throwable))
        }
    }

    override suspend fun getListOfPlayersOfATeam(teamId: Long): ResponseRequired<List<PlayerDto>> {
        return when (val responseRemote = cstvService.getListOfPlayersOfATeam(teamId)) {
            is ResponseRemote.Success -> {
                val mappedResult = PlayersMapper.map(responseRemote.response)
                ResponseRequired.Success(result = mappedResult)
            }
            is ResponseRemote.Error -> ResponseRequired.Error(Exception(responseRemote.throwable))
        }
    }

}