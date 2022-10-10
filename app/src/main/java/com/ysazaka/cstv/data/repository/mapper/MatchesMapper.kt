package com.ysazaka.cstv.data.repository.mapper

import com.ysazaka.cstv.data.model.match.*
import com.ysazaka.cstv.data.remote.model.*

object MatchesMapper {

    fun map(payload: List<MatchVo>) = payload.map { map(it) }

    fun map(matchVO: MatchVo) = MatchDto(
        id = matchVO.id,
        name = matchVO.name,
        beginAt = matchVO.beginAt,
        endAt = matchVO.endAt,
        status = matchVO.status,
        league = map(matchVO.league),
        serie = map(matchVO.serie),
        opponentList = mapOpponentList(matchVO.opponentList)
    )

    fun map(leagueVo: LeagueVo) = LeagueDto(
        id = leagueVo.id,
        name = leagueVo.name,
        imageUrl = leagueVo.imageUrl,
    )

    fun map(serieVo: SerieVo) = SerieDto(
        id = serieVo.id,
        name = serieVo.name,
        fullName = serieVo.fullName,
    )

    fun mapOpponentList(payload: List<OpponentObjectVo>) = payload.map { map(it) }

    fun map(opponentObjectVo: OpponentObjectVo) = OpponentObjectDto(
        opponent = map(opponentObjectVo.opponent)
    )

    fun map(opponentVo: OpponentVo) = OpponentDto(
        id = opponentVo.id,
        name = opponentVo.name,
        imageUrl = opponentVo.imageUrl
    )

}