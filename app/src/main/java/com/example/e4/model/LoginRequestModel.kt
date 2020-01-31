package com.example.e4.model

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @SerializedName("table") val table: Int
)