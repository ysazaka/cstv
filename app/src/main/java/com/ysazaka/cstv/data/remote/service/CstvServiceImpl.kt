package com.ysazaka.cstv.data.remote.service

import com.ysazaka.cstv.data.model.response.ResponseRemote
import com.ysazaka.cstv.data.remote.api.CstvAPI
import com.ysazaka.cstv.data.remote.extensions.mapRemoteErrors
import com.ysazaka.cstv.data.remote.model.MatchVo

class CstvServiceImpl(
    private val cstvApi: CstvAPI
) : CstvService {

    override suspend fun getListOfMatchesOfTheDay(dayFilter: String): ResponseRemote<List<MatchVo>> {
        return try {
            val payload = cstvApi.getListOfMatchesOfTheDay(dayFilter, dayFilter)
            ResponseRemote.Success(response = payload)
        } catch (throwable: Throwable) {
            throwable.mapRemoteErrors()
        }
    }

}