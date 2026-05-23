package com.terrance.screens.profile

class ProfileContract {
    interface View {
        fun showProfile(
            username: String,
            firstName: String,
            middleName: String,
            lastName: String,
            email: String
        )
        fun showMessage(message: String)
        fun navigateToDashboard()
    }

    interface Presenter {
        fun loadProfile()
        fun saveProfile(
            username: String,
            firstName: String,
            middleName: String,
            lastName: String,
            email: String
        )
        fun onReturnClicked()
    }

    interface Model {
        fun getProfile(): ProfileModel.UserProfile
        fun saveProfile(profile: ProfileModel.UserProfile)
    }
}