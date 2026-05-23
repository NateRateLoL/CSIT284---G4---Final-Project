package com.terrance.screens.login

class LoginContract() {
    interface View {
        fun showEmptyMessage()
        fun showSuccessMessage()
        fun showDashboardScreen()
        fun showRegisterScreen()
        fun showInvalidCredential()
    }

    interface Presenter {
        fun validateCredential(username: String, password: String) {

        }
    }
}