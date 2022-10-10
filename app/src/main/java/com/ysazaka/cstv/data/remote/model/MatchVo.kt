package com.ysazaka.cstv.data.remote.model

import com.squareup.moshi.Json

data class MatchVo(
    @field:Json(name = "draw")
    val draw: Boolean,

    @field:Json(name = "forfeit")
    val forfeit: Boolean
)
