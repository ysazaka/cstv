package com.ysazaka.cstv.data.remote.model

import com.squareup.moshi.Json
import org.jetbrains.annotations.Nullable

data class OpponentObjectVo (
    @Nullable
    @field:Json(name = "opponent")
    val opponent: OpponentVo
)
