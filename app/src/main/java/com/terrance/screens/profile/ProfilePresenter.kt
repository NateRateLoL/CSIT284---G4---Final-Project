package com.terrance.screens.profile

class ProfilePresenter(private val view: ProfileContract.View, private val model: ProfileContract.Model) : ProfileContract.Presenter {
    override fun loadProfile() {
        val profile = model.getProfile()
        view.showProfile(
            profile.username,
            profile.firstName,
            profile.middleName,
            profile.lastName,
            profile.email
        )
    }

    override fun saveProfile(
        username: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String
    ) {
        val updatedProfile = ProfileModel.UserProfile(
            username,
            firstName,
            middleName,
            lastName,
            email
        )
        model.saveProfile(updatedProfile)
        view.showMessage("Profile updated successfully!")
    }

    override fun onReturnClicked() {
        view.navigateToDashboard()
    }
}
