package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureSignupButton()
        configureHomeScreenButton()
    }
    ///Navigating to the sign up page
    private fun configureSignupButton(){
        val signupButton: Button = findViewById(R.id.sign_up_link_btn)
        signupButton.setOnClickListener {
            val nextPage = Intent(this, RegistrationActivity::class.java)
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