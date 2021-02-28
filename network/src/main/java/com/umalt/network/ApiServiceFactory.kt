package com.umalt.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.umalt.data.BuildConfig
import com.umalt.network.interceptor.ApiInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Umalt on 2/22/21
 */
object ApiServiceFactory {

    fun makeApiService(baseUrl: String): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(makeOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    private fun makeOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(ApiInterceptor())
            .addInterceptor(makeHttpLoggingInterceptor())

        if (BuildConfig.DEBUG) client.addNetworkInterceptor(StethoInterceptor())

        return client.build()
    }

    private fun makeHttpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = when {
                BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}