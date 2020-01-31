package com.example.e4.networking

import com.example.e4.model.LoginRequestModel
import com.example.e4.model.LoginResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("auth")
    fun login(@Body table: LoginRequestModel): Call<LoginResponseModel>

}