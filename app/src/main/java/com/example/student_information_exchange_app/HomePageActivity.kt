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
        configureMessageButton()
        configureBuyAndSellButton()
        configureInfoex()
        configureFormClubButton()
        configureTutoringButton()
        configureAdvertisementButton()
        configurePaymentsButton()

    }

    ///Navigating to the login page
    private fun configureLoginButton() {
        val loginButton: Button = findViewById(R.id.home_screen_login_button)
        loginButton.setOnClickListener {
            val nextPage = Intent(this, MainActivity::class.java)
            startActivity(nextPage)
        }
    }

    ////Handling register button from Homepage
    private fun configureRegisterButton() {
        val registerButton: Button = findViewById(R.id.home_screen_register_button)
        registerButton.setOnClickListener {
            val registrationPage = Intent(this, RegistrationActivity::class.java)
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
    ///Handling MessageButton from the HomeScreen page.
    private fun configureMessageButton() {
        val messageButton: Button = findViewById(R.id.home_screen_chat_button)
        messageButton.setOnClickListener {
            val loginPage = Intent(this, MainActivity::class.java)
            startActivity(loginPage)
        }
    }

    ///handling form club feature from the HomeScreen page.
    private fun configureFormClubButton() {
        val formClubButton: Button = findViewById(R.id.home_screen_formClub_button)
        formClubButton.setOnClickListener {
            val loginPage = Intent(this, MainActivity::class.java)
            startActivity(loginPage)
        }
    }

    ///Handling tutoring feature from the HomeScreen page.
    private fun configureTutoringButton() {
        val tutoringButton: Button = findViewById(R.id.home_screen_tutoring_button)
        tutoringButton.setOnClickListener {
            val loginPage = Intent(this, MainActivity::class.java)
            startActivity(loginPage)
        }
            
    }
    ////Handling the Advertisement request from the HomeScreen where the user is not logged in.
    private fun configureAdvertisementButton(){
        val advertisementButton: Button = findViewById(R.id.home_screen_advertisement_button)
        advertisementButton.setOnClickListener{
            val loginPage = Intent(this, MainActivity::class.java)
            startActivity(loginPage)
        }

    }
    ////Handling the payments module from the HomeScreen where the user is not logged in.
    private fun configurePaymentsButton() {
        val paymentsButton: Button = findViewById(R.id.home_screen_payments_button)
        paymentsButton.setOnClickListener {
            val loginPage = Intent(this, MainActivity::class.java)
            startActivity(loginPage)
        }

    }

}
