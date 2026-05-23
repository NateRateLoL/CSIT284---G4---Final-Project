package com.terrance.app

import android.app.Application
import android.util.Log
import com.terrance.data.User

class CustomApp: Application() {

    private var user = User("NateRate", "Bring1t0n")

    override fun onCreate() {
        super.onCreate()

        Log.e("Custom App", "onCreate is called")
    }

    fun getUser(): User {
        return user
    }
    fun setUser(newUser: User) {
        user = newUser
    }
}