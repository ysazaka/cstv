package com.ysazaka.cstv.data.model.match

data class PlayerDto(
    val id: Long,
    val firstName: String?,
    val lastName: String?,
    val nickname: String?,
    val imageUrl: String?
)