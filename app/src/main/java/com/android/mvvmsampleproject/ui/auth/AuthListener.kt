package com.android.mvvmsampleproject.ui.auth

import androidx.lifecycle.LiveData
import com.android.mvvmsampleproject.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)

}