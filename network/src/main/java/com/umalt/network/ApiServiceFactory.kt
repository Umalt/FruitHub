package com.umalt.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Umalt on 2/22/21
 */
object ApiServiceFactory {

    fun makeApiService(
        baseUrl: String,
        okHttpClient: OkHttpClient
    ): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    fun makeOkHttpClient(
        apiInterceptor: Interceptor,
        stethoInterceptor: Interceptor,
        httpLoggingInterceptor: Interceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(apiInterceptor)
            .addInterceptor(httpLoggingInterceptor)

        if (BuildConfig.DEBUG) client.addNetworkInterceptor(stethoInterceptor)

        return client.build()
    }
}