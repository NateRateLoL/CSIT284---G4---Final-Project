package com.terrance.screens.dashboard

import android.content.Intent
import com.terrance.app.CustomApp
import com.terrance.screens.login.LoginActivity
import com.terrance.screens.profile.ProfileActivity

class DashboardModel(val app: CustomApp) : DashboardContract.Model {
    override fun logout() {
        val intent = Intent(app, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        app.startActivity(intent)
    }

    override fun profile() {
        val intent = Intent(app, ProfileActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        app.startActivity(intent)
    }
}