package com.ysazaka.cstv.data.repository

import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.data.model.response.ResponseRemote
import com.ysazaka.cstv.data.model.response.ResponseRequired
import com.ysazaka.cstv.data.remote.service.CstvService
import com.ysazaka.cstv.data.repository.mapper.MatchesMapper

class CstvRepositoryImpl(
    private val cstvService: CstvService
) : CstvRepository {

    override suspend fun getListOfMatchesOfTheDay(): ResponseRequired<List<MatchDto>> {
        return when (val responseRemote = cstvService.getListOfMatchesOfTheDay()) {
            is ResponseRemote.Success -> {
                val mappedResult = MatchesMapper.map(responseRemote.response)
                ResponseRequired.Success(result = mappedResult)
            }
            is ResponseRemote.Error -> ResponseRequired.Error(Exception(responseRemote.throwable))
        }
    }

}