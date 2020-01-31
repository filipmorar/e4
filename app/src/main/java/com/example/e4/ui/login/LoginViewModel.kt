package com.example.e4.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e4.utils.SingleLiveEvent
import com.example.e4.workers.LoginWorkerInterface

class LoginViewModel(private val loginWorker: LoginWorkerInterface) : ViewModel() {
    val table = MutableLiveData<String>()

    val loginMessage = SingleLiveEvent<String>()

    val navigationCommand: SingleLiveEvent<LoginNavigationCommand> = SingleLiveEvent()

    sealed class LoginNavigationCommand {
        object NavigateToMainScreen : LoginNavigationCommand()
    }

    fun onLogin() {
        loginWorker.login(table.value.orEmpty().toInt()) {
            if(it == null){
                loginMessage.value = "Table already booked"
            }
            else {
                navigationCommand.value = LoginNavigationCommand.NavigateToMainScreen
            }
        }
    }

}
