package com.terrance.screens.register

import com.terrance.app.CustomApp
import com.terrance.data.User

class RegisterModel(private val app: CustomApp) : RegisterContract.Model {
    override fun registerUser(username: String, password: String) {
        app.setUser(User(username, password))
    }
}
