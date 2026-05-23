package com.terrance.screens.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.terrance.app.CustomApp
import com.terrance.randmzer.R
import com.terrance.screens.dashboard.DashboardActivity
import com.terrance.util.toast

class ProfileActivity : Activity(), ProfileContract.View {
    private lateinit var presenter: ProfileContract.Presenter
    private lateinit var editUsername: EditText
    private lateinit var editFirstName: EditText
    private lateinit var editMiddleName: EditText
    private lateinit var editLastName: EditText
    private lateinit var editEmail: EditText
    private lateinit var btnSave: TextView
    private lateinit var btnBack: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        editUsername = findViewById(R.id.edit_username)
        editFirstName = findViewById(R.id.edit_first_name)
        editMiddleName = findViewById(R.id.edit_middle_name)
        editLastName = findViewById(R.id.edit_last_name)
        editEmail = findViewById(R.id.edit_email)
        btnSave = findViewById(R.id.text_save)
        btnBack = findViewById(R.id.text_go_back)

        val app = application as CustomApp
        val model = ProfileModel(app)
        presenter = ProfilePresenter(this, model)

        presenter.loadProfile()

        btnBack.setOnClickListener {
            presenter.onReturnClicked()
        }

        btnSave.setOnClickListener {
            presenter.saveProfile(
                editUsername.text.toString(),
                editFirstName.text.toString(),
                editMiddleName.text.toString(),
                editLastName.text.toString(),
                editEmail.text.toString()
            )
        }
    }

    override fun showProfile(
        username: String,
        firstName: String,
        middleName: String,
        lastName: String,
        email: String
    ) {
        editUsername.setText(username)
        editFirstName.setText(firstName)
        editMiddleName.setText(middleName)
        editLastName.setText(lastName)
        editEmail.setText(email)
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun navigateToDashboard() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }
}
