package com.terrance.screens.login

class LoginPresenter(private val view: LoginContract.View, private val model: LoginModel): LoginContract.Presenter {

    override fun validateCredential(username: String, password: String) {
        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            view.showEmptyMessage()
        } else {
            if (model.isValidCredential(username, password)) {
                view.showSuccessMessage()
                view.showDashboardScreen()
            } else {
                view.showInvalidCredential()
            }
        }
    }
}