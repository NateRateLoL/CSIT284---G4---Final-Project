package com.terrance.screens.register


class RegisterContract {
    interface View {
        fun showMessage(message: String)
        fun closeScreen()
    }

    interface Model {
        fun registerUser(username: String, password: String)
    }

    interface Presenter {
        fun register(username: String, password: String)
    }
}
