package com.ysazaka.cstv.data.remote.api

import com.ysazaka.cstv.data.remote.model.MatchVo
import retrofit2.http.GET

interface CstvAPI {

    @GET("matches")
    suspend fun getListOfMatchesOfTheDay(): List<MatchVo>

}