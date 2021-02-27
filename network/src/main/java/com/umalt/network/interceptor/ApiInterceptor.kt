package com.umalt.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Umalt on 2/27/21
 */
class ApiInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val requestBuilder = originalRequest.newBuilder().apply {
            header("X-Device-Type", "ANDROID")
            header("Content-Type", "application/json")
            method(originalRequest.method(), originalRequest.body())
        }
        return try {
            chain.proceed(requestBuilder.build())
        } catch (e: Exception) {
            throw e
        }
    }
}