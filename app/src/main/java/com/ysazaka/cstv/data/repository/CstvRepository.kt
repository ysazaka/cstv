package com.ysazaka.cstv.data.repository

import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.data.model.match.PlayerDto
import com.ysazaka.cstv.data.model.response.ResponseRequired

interface CstvRepository {

    suspend fun getListOfMatchesOfTheDay(dayFilter: String): ResponseRequired<List<MatchDto>>
    suspend fun getListOfPlayersOfATeam(teamId: Long): ResponseRequired<List<PlayerDto>>

}