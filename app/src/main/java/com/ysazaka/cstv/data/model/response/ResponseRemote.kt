package com.ysazaka.cstv.data.model.response

sealed class ResponseRemote<out T> {
    data class Success<out T>(val response: T): ResponseRemote<T>()

    sealed class Error(open val throwable: Throwable) : ResponseRemote<Nothing>(){
        data class Unknown(override val throwable: Throwable): Error(throwable)
        data class TokenExpired(override val throwable: Throwable): Error(throwable)
    }
}
