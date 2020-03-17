package com.android.mvvmsampleproject.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.android.mvvmsampleproject.data.repositories.UserRepository
import com.android.mvvmsampleproject.util.ApiException
import com.android.mvvmsampleproject.util.Coroutines

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel(){

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClicked(view: View){
        authListener?.onStarted()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or Password")
            return
        }

        Coroutines.main {

            try {
                val authResponse = repository.userLogin(email!!, password!!)

                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }

        }
    }
}