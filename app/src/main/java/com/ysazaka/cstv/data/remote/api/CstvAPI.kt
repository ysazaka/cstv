package com.ysazaka.cstv.data.remote.api

import com.ysazaka.cstv.data.remote.model.MatchVo
import com.ysazaka.cstv.data.remote.model.PlayerVo
import retrofit2.http.GET
import retrofit2.http.Query

interface CstvAPI {

    @GET("matches")
    suspend fun getListOfMatchesOfTheDay(
        @Query("filter[begin_at]") beginAt: String,
        @Query("filter[end_at]") endAt: String
    ): List<MatchVo>

    @GET("players")
    suspend fun getListOfPlayersOfATeam(
        @Query("filter[team_id]") teamId: Long
    ): List<PlayerVo>

}