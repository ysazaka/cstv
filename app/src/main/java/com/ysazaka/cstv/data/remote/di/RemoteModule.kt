package com.ysazaka.cstv.data.remote.di

import com.squareup.moshi.Moshi
import com.ysazaka.cstv.data.remote.api.CstvAPI
import com.ysazaka.cstv.data.remote.service.CstvService
import com.ysazaka.cstv.data.remote.service.CstvServiceImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val remoteModule = module {
    factory { providesOkHttpClient(get()) }
    single { provideMoshi() }
    single {
        createService<CstvAPI>(
            okHttpClient = get(),
            url = "https://api.pandascore.co/csgo/"
        )
    }

    single { provideInterceptor() }
    factory<CstvService> { CstvServiceImpl(get()) }
}

fun provideInterceptor(): Interceptor {
    return Interceptor { chain: Interceptor.Chain ->
        val original: Request = chain.request()
        val requestBuilder: Request.Builder = original.newBuilder()
            .addHeader(
                "Authorization",
                "Bearer JQ8-E94RdN3YCDgovEeWTh_n5IDZxWIQZeEHWvYeWu0twvF19ig"
            )
        val request: Request = requestBuilder.build()
        chain.proceed(request)
    }
}

fun providesOkHttpClient(interceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

internal fun provideMoshi(): Moshi {
    return Moshi.Builder().build()
}

inline fun <reified T> createService(okHttpClient: OkHttpClient, url: String): T {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(T::class.java)
}