package com.example.e4.networking

import com.example.e4.model.Task
import com.example.e4.model.TasksResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface GetTaskApi {

    @GET("task")
    fun getTasks(): Call<TasksResponseModel>
}