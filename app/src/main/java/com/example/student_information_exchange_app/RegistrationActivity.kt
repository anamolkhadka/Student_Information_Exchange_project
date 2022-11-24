package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        configureLoginButton()
        configureHomeScreenButton()

        ////title= "Registration" , for setting up title for the activity page
    }
    ///Navigating to the login page
    private fun configureLoginButton(){
        val loginButton: Button = findViewById(R.id.login_link_btn)
        loginButton.setOnClickListener {
            val nextPage = Intent(this, MainActivity::class.java)
            startActivity(nextPage)
        }
    }
    ///Navigating to the Home screen page
    private fun configureHomeScreenButton(){
        val homepageButton: Button = findViewById(R.id.home_screen_link_btn)
        homepageButton.setOnClickListener {
            val homepage = Intent(this,HomePageActivity::class.java)
            startActivity(homepage)
        }
    }
}