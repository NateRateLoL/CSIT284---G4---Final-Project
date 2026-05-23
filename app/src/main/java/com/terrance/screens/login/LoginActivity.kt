package com.terrance.screens.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.terrance.app.CustomApp
import com.terrance.randmzer.R
import com.terrance.screens.dashboard.DashboardActivity
import com.terrance.screens.register.RegisterActivity
import com.terrance.util.getEditTextValue
import com.terrance.util.toast

class LoginActivity : Activity(), LoginContract.View {
    lateinit var presenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val app = (application as CustomApp)
        val model = LoginModel(app)
        presenter = LoginPresenter(this, model)

        (findViewById<Button>(R.id.button_login)).setOnClickListener {
            val username = getEditTextValue(R.id.login_input_email)
            val password = getEditTextValue(R.id.login_input_password)

            presenter.validateCredential(username, password)
        }

        (findViewById<TextView>(R.id.text_register)).setOnClickListener {
            showRegisterScreen()
        }
    }

    override fun showEmptyMessage() {
        toast("Invalid Credential")
    }

    override fun showSuccessMessage() {
        toast("Login Successful")
    }

    override fun showDashboardScreen() {
        startActivity(Intent(this, DashboardActivity::class.java))
    }

    override fun showRegisterScreen() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun showInvalidCredential() {
        toast("Invalid Credential")
    }
}

