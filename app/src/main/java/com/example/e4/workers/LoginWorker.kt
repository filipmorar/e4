package com.example.e4.workers

import com.example.e4.model.Callback
import com.example.e4.model.LoginRequestModel
import com.example.e4.model.LoginResponseModel
import com.example.e4.networking.ApiProvider
import com.example.e4.networking.LoginApi

interface LoginWorkerInterface {
    fun login(table: Int, callback: Callback<LoginResponseModel>)
}

class LoginWorker(private val api: LoginApi) : ApiWorker(), LoginWorkerInterface {

    override fun login(table: Int, callback: Callback<LoginResponseModel>) {
        ApiProvider.clearAPI()
        doRequest(
            api.login(LoginRequestModel(table))) {
            if (it.token != null) {
                ApiProvider.token = "Bearer $it"
            }
            callback(it)
        }
    }
}