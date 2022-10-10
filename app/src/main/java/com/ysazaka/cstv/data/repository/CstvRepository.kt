package com.ysazaka.cstv.data.repository

import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.data.model.response.ResponseRequired

interface CstvRepository {

    suspend fun getListOfMatchesOfTheDay(dayFilter: String): ResponseRequired<List<MatchDto>>

}