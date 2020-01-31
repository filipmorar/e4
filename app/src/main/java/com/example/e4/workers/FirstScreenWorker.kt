package com.example.e4.workers

import com.example.e4.model.Callback
import com.example.e4.model.TasksResponseModel
import com.example.e4.networking.GetTaskApi

interface FirstScreenWorkerInterface{
    fun getTasks(callback: Callback<TasksResponseModel>)
}
class FirstScreenWorker(private val getTaskApi: GetTaskApi): ApiWorker(), FirstScreenWorkerInterface {
    override fun getTasks(callback: Callback<TasksResponseModel>) {
        doRequest(getTaskApi.getTasks()) {
            callback(it)
        }
    }
}