package com.android.mvvmsampleproject.data.repositories

import com.android.mvvmsampleproject.data.network.MyApi
import com.android.mvvmsampleproject.data.network.SafeApiRequest
import com.android.mvvmsampleproject.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { MyApi().userLogin(email, password)}
    }
}