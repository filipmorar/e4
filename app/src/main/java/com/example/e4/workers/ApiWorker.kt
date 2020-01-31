package com.example.e4.workers

import com.example.e4.model.Callback
import retrofit2.Call
import retrofit2.Response

abstract class ApiWorker{

    internal fun <T> doRequest(
        call: Call<T>,
        callback: Callback<T>
    ) {
        call.enqueue(object : retrofit2.Callback<T> {
            override fun onResponse(
                call: Call<T>,
                response: Response<T>
            ) {
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<T>, error: Throwable?) {
            }
        })
    }


}