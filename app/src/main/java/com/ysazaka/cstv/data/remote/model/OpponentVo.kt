package com.ysazaka.cstv.data.remote.model

import com.squareup.moshi.Json
import org.jetbrains.annotations.Nullable

data class OpponentVo (
    @Nullable
    @field:Json(name = "id")
    val id: Long,

    @Nullable
    @field:Json(name = "name")
    val name: String,

    @Nullable
    @field:Json(name = "image_url")
    val imageUrl: String
)