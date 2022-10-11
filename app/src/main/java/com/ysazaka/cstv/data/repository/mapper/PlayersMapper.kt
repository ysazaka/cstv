package com.ysazaka.cstv.data.repository.mapper

import com.ysazaka.cstv.data.model.match.PlayerDto
import com.ysazaka.cstv.data.remote.model.PlayerVo

object PlayersMapper {

    fun map(payload: List<PlayerVo>) = payload.map { map(it) }

    fun map(playerVo: PlayerVo) = PlayerDto(
        id = playerVo.id,
        firstName = playerVo.firstName,
        lastName = playerVo.lastName,
        nickname = playerVo.nickname,
        imageUrl = playerVo.imageUrl
    )

}