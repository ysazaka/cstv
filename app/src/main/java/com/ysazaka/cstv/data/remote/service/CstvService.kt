package com.ysazaka.cstv.data.remote.service

import com.ysazaka.cstv.data.model.response.ResponseRemote
import com.ysazaka.cstv.data.remote.model.MatchVo
import com.ysazaka.cstv.data.remote.model.PlayerVo

interface CstvService {

    suspend fun getListOfMatchesOfTheDay(dayFilter: String): ResponseRemote<List<MatchVo>>
    suspend fun getListOfPlayersOfATeam(teamId: Long): ResponseRemote<List<PlayerVo>>

}