package com.android.mvvmsampleproject.data.repositories

import com.android.mvvmsampleproject.data.db.AppDatabase
import com.android.mvvmsampleproject.data.db.entities.User
import com.android.mvvmsampleproject.data.network.MyApi
import com.android.mvvmsampleproject.data.network.SafeApiRequest
import com.android.mvvmsampleproject.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()
}