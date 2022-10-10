package com.ysazaka.cstv.data.repository.mapper

import com.ysazaka.cstv.data.model.match.MatchDto
import com.ysazaka.cstv.data.remote.model.MatchVo

object MatchesMapper {

    fun map(payload: List<MatchVo>) = payload.map { map(it) }

    fun map(matchVO: MatchVo) = MatchDto(
        draw = matchVO.draw,
        forfeit = matchVO.forfeit
    )

}