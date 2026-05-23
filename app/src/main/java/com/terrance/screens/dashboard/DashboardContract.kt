package com.terrance.screens.dashboard

class DashboardContract {
    interface View {
        fun showLogoutMessage()
        fun showProfileScreen()
    }

    interface Model {
        fun logout()
        fun profile()
    }

    interface Presenter {
        fun onLogoutClicked()
        fun onProfileClicked()
    }
}
