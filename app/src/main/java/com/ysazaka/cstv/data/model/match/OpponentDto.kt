package com.ysazaka.cstv.data.model.match

import java.io.Serializable

data class OpponentDto(
    val id: Long?,
    val name: String?,
    val imageUrl: String?
) : Serializable
