package com.terrance.screens.login

import com.terrance.app.CustomApp

class LoginModel(private val app: CustomApp) {
    fun isValidCredential(username: String, password: String): Boolean {
        val user = app.getUser()
        return user.username.equals(username, false) && user.password.equals(password, false)
    }
}