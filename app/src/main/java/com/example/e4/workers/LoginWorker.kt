package com.example.e4.workers

import com.example.e4.model.Callback
import com.example.e4.model.LoginRequestModel
import com.example.e4.networking.ApiProvider
import com.example.e4.networking.LoginApi

interface LoginWorkerInterface {
    fun login(table: Int, callback: Callback<String?>)
}

class LoginWorker(private val api: LoginApi) : ApiWorker(), LoginWorkerInterface {

    override fun login(table: Int, callback: Callback<String?>) {
        ApiProvider.clearAPI()
        doRequest(
            api.login(LoginRequestModel(table))) {
            if (it != null) {
                ApiProvider.token = "Bearer $it"
            }
            callback(it)
        }
    }
}