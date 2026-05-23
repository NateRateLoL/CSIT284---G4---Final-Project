package com.terrance.screens.register

class RegisterPresenter(private val view: RegisterActivity, private val model: RegisterModel) : RegisterContract.Presenter {
    override fun register(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            view.showMessage("Fields cannot be empty!")
        } else {
            model.registerUser(username, password)
            view.showMessage("Registration Successful!")
            view.closeScreen()
        }
    }
}