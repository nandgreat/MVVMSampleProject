package com.android.mvvmsampleproject.data.network.responses


import com.android.mvvmsampleproject.data.db.entities.User
import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("isSuccessful")
    val isSuccessful: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("user")
    val user: User
)