package com.example.e4.networking

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {

    private var token: String? = null

    fun setToken(value: String) {
        this.token = value
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        token?.let {
            requestBuilder.addHeader("Authorization", it)
        }
        return chain.proceed(requestBuilder.build())
    }

}