package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        configureLoginButton()
        configureRegisterButton()
        configureBuyAndSellButton()
        configureInfoex()

    }
    ///Navigating to the login page
    private fun configureLoginButton(){
        val loginButton: Button = findViewById(R.id.home_screen_login_button)
        loginButton.setOnClickListener {
            val nextPage = Intent(this, MainActivity::class.java)
            startActivity(nextPage)
        }
    }
    ////Handling register button from Homepage
    private fun configureRegisterButton(){
        val registerButton: Button = findViewById(R.id.home_screen_register_button)
        registerButton.setOnClickListener {
            val registrationPage = Intent(this,RegistrationActivity::class.java)
            startActivity(registrationPage)
        }
    }
    ///handling buy and sell from the HomeScreen page where the user is not logged in.
    private fun configureBuyAndSellButton() {
        val buyAndSellButton: Button = findViewById(R.id.home_screen_trade_button)
        buyAndSellButton.setOnClickListener {
            val loginPage = Intent(this, MainActivity::class.java)
            startActivity(loginPage)
        }
    }
    private fun configureInfoex() {
        val Infoex_bttn: Button = findViewById(R.id.home_screen_infoExchange_button)
        Infoex_bttn.setOnClickListener {
            val InfoexPage = Intent(this, InformationExchangeActivity::class.java)
            startActivity(InfoexPage)
        }
    }

}