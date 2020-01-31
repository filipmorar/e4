package com.example.e4.model

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("token") val token: String?
)