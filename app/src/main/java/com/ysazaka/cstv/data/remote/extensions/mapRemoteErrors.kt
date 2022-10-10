package com.ysazaka.cstv.data.remote.extensions

import com.ysazaka.cstv.data.model.response.ResponseRemote
import retrofit2.HttpException

fun Throwable.mapRemoteErrors(): ResponseRemote.Error {
    return when (this) {
        is HttpException -> {
            when (code()) {
                401, 403 -> ResponseRemote.Error.TokenExpired(this)
                else -> ResponseRemote.Error.Unknown(this)
            }
        }
        else -> ResponseRemote.Error.Unknown(this)
    }
}