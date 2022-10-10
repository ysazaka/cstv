package com.ysazaka.cstv.data.remote.model

import com.squareup.moshi.Json
import org.jetbrains.annotations.Nullable

data class MatchVo(
    @Nullable
    @field:Json(name = "id")
    val id: Long,

    @Nullable
    @field:Json(name = "name")
    val name: String,

    @Nullable
    @field:Json(name = "begin_at")
    val beginAt: String,

    @Nullable
    @field:Json(name = "end_at")
    val endAt: String,

    @Nullable
    @field:Json(name = "status")
    val status: String,

    @Nullable
    @field:Json(name = "league")
    val league: LeagueVo,

    @Nullable
    @field:Json(name = "serie")
    val serie: SerieVo,

    @Nullable
    @field:Json(name = "opponents")
    val opponentList: List<OpponentObjectVo>
)
