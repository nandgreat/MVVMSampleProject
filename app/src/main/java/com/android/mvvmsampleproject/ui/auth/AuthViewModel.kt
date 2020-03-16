package com.android.mvvmsampleproject.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.android.mvvmsampleproject.data.repositories.UserRepository
import com.android.mvvmsampleproject.util.Coroutines

class AuthViewModel : ViewModel(){

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClicked(view: View){
        authListener?.onStarted()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or Password")
            return
        }

        Coroutines.main {
            val response = UserRepository().userLogin(email!!, password!!)
            if(response.isSuccessful){
                authListener?.onSuccess(response.body()?.user!!)
            }else{
                authListener?.onFailure("Error Code: ${response.code()}")
            }
        }
    }
}