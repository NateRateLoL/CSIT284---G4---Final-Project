package com.terrance.screens.register

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.terrance.app.CustomApp
import com.terrance.randmzer.R
import com.terrance.util.getEditTextValue
import com.terrance.util.toast

class RegisterActivity : Activity(), RegisterContract.View {
    private lateinit var presenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val app = application as CustomApp
        val model = RegisterModel(app)
        presenter = RegisterPresenter(this, model)

        findViewById<Button>(R.id.button_confirm).setOnClickListener {
            val email = getEditTextValue(R.id.register_input_email)
            val password = getEditTextValue(R.id.register_input_password)
            val confirmPassword = getEditTextValue(R.id.register_input_confirm_password)
            if (password != confirmPassword) {
                showMessage("Passwords do not match!")
            }
            presenter.register(email, password)
        }
    }
    override fun showMessage(message: String) {
        toast(message)
    }

    override fun closeScreen() {
        finish()
    }
}