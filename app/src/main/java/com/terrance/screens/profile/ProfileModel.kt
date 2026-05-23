package com.terrance.screens.profile

import com.terrance.app.CustomApp
import com.terrance.data.User

class ProfileModel(private val app: CustomApp) : ProfileContract.Model {
    data class UserProfile(
        val username: String,
        val firstName: String,
        val middleName: String,
        val lastName: String,
        val email: String
    )

    override fun getProfile(): UserProfile {
        val user = app.getUser()
        return UserProfile(
            user.username,
            user.firstName,
            user.middleName,
            user.lastName,
            user.email
        )
    }

    override fun saveProfile(profile: UserProfile) {
        val currentUser = app.getUser()

        val updatedUser = User(
            username = profile.username,
            password = currentUser.password,
            firstName = profile.firstName,
            middleName = profile.middleName,
            lastName = profile.lastName,
            email = profile.email
        )

        app.setUser(updatedUser)
    }
}
