package com.terrance.screens.dashboard
import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import com.terrance.app.CustomApp
import com.terrance.randmzer.R
import com.terrance.util.toast

class DashboardActivity : Activity(), DashboardContract.View {
    lateinit var presenter: DashboardPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val app: CustomApp = (application as CustomApp)
        val model = DashboardModel(app)
        presenter = DashboardPresenter(this, model)

        (findViewById<ImageButton>(R.id.buttonMenu)).setOnClickListener {
            showMenuDialog()
        }
    }

    private fun showMenuDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_menu, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        dialogView.findViewById<ImageButton>(R.id.menuClose).setOnClickListener {
            dialog.dismiss()
        }

        val menuItems = ArrayList<String>()
        menuItems.add("Profile")
        menuItems.add("Logout")

        val listView = dialogView.findViewById<ListView>(R.id.listViewMenu)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    dialog.dismiss()
                    presenter.onProfileClicked()
                }
                1 -> {
                    dialog.dismiss()
                    presenter.onLogoutClicked()
                }
            }
        }

        dialog.show()
    }

    override fun showLogoutMessage() {
        toast("Logging out!")
    }

    override fun showProfileScreen() {
        toast("Going to Profile!")
    }
}