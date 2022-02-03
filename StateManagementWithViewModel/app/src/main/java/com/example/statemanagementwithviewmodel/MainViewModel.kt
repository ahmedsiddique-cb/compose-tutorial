package com.example.statemanagementwithviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var username by mutableStateOf("")
    var password by mutableStateOf("")

    fun onUsernameChanged(newString: String) {
        username = newString
    }

    fun onPasswordChanged(newString: String) {
        password = newString
    }
}