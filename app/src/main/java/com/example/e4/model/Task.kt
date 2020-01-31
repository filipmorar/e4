package com.example.e4.model

import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("id") val id: Int,
    @SerializedName("tag") val tag: String,
    @SerializedName("text") val text: String,
    @SerializedName("version") val version: Int
)