package com.example.e4.networking

import com.example.e4.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates

object ApiProvider {

    var token: String? by Delegates.observable<String?>(null) { _, _, _ ->
        token?.let {
            headersInterceptor.setToken(it)
        }
    }

    private val headersInterceptor: HeadersInterceptor by lazy { HeadersInterceptor() }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(headersInterceptor)
            .build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideLoginApi(): LoginApi{
        return retrofit.create(LoginApi::class.java)
    }

    fun clearAPI() {
        headersInterceptor.setToken("")
    }
}