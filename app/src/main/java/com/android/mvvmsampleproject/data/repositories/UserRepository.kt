package com.android.mvvmsampleproject.data.repositories

import com.android.mvvmsampleproject.data.network.MyApi
import com.android.mvvmsampleproject.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return MyApi().userLogin(email, password)
    }
}