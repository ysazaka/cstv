package com.ysazaka.cstv.data.remote.service

import com.ysazaka.cstv.data.model.response.ResponseRemote
import com.ysazaka.cstv.data.remote.model.MatchVo

interface CstvService {

    suspend fun getListOfMatchesOfTheDay(): ResponseRemote<List<MatchVo>>

}