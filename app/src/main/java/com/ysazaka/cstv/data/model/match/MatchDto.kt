package com.ysazaka.cstv.data.model.match

import java.io.Serializable

data class MatchDto (
    val id: Long,
    val name: String?,
    val beginAt: String?,
    val endAt: String?,
    val status: String?,
    val league: LeagueDto?,
    val serie: SerieDto?,
    val opponentList: List<OpponentObjectDto>?
) : Serializable