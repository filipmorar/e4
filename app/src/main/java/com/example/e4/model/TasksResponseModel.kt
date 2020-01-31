package com.example.e4.model

import com.google.gson.annotations.SerializedName

data class TasksResponseModel(
    @SerializedName("tasks") val tasks: List<Task>
)