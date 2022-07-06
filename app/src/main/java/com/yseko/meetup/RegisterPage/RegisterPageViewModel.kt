package com.yseko.meetup.RegisterPage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yseko.meetup.network.ExpressServiceApi
import com.yseko.meetup.network.RequestUser
import kotlinx.coroutines.launch

class RegisterPageViewModel: ViewModel() {
    var email by mutableStateOf("")
    var username by mutableStateOf("")
    var password by mutableStateOf("")

    var emailValid by mutableStateOf(false)
    var usernameValid by mutableStateOf(false)
    var passwordValid by mutableStateOf(false)

    var token by mutableStateOf("")



    fun registerUser(){
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailValid = true
        }
        if(username.length in 3..50){
            usernameValid = true
        }
        if(password.length >=6){
            passwordValid = true
        }
        if(emailValid && usernameValid && passwordValid) {
            viewModelScope.launch {
                try {
                    token = ExpressServiceApi.retrofitService.registerUser(
                        RequestUser(
                            email,
                            username,
                            password
                        )
                    ).token

                }catch (e: Error){
                    println(e)
                }
            }
        }
    }

}