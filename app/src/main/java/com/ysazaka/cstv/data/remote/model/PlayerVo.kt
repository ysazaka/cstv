package com.ysazaka.cstv.data.remote.model

import com.squareup.moshi.Json
import org.jetbrains.annotations.Nullable

data class PlayerVo (
    @field:Json(name = "id")
    val id: Long,

    @Nullable
    @field:Json(name = "first_name")
    val firstName: String,

    @Nullable
    @field:Json(name = "last_name")
    val lastName: String,

    @Nullable
    @field:Json(name = "name")
    val nickname: String,

    @Nullable
    @field:Json(name = "image_url")
    val imageUrl: String
)