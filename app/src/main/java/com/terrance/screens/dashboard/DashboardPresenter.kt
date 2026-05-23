package com.terrance.screens.dashboard

class DashboardPresenter(private val view: DashboardContract.View, private val model: DashboardContract.Model) : DashboardContract.Presenter {
    override fun onLogoutClicked() {
        model.logout()
        view.showLogoutMessage()
    }
    override fun onProfileClicked() {
        model.profile()
        view.showProfileScreen()
    }

}