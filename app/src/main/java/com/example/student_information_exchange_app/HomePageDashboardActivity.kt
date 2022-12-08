package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomePageDashboardActivity : AppCompatActivity() {

    ////This is a dashboard for the signed in user.
    ///Initialize Firebase Auth
    var auth: FirebaseAuth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_dashboard)

        //title= "SIE DASHBOARD"

        configureTopBar()
        configureLogoutButton()
        displayUserEmail()
        configureRegisterButton()
        configureBuyAndSellButton()
        configureTutoringButton()
        configurePaymentsButton()
        configureInfoex()
        configureFormclub()
        configureMessage()
        configureAdvertisement()

    }
    //Sets up top bar with a name (enables back bars)
    private fun configureTopBar(){
        val display=supportActionBar
        display?.title="SIE DASHBOARD"
    }
    ///Logging out the user and sending to the login page
    private fun configureLogoutButton(){
        val logoutButton:Button = findViewById(R.id.home_screen_logout_button)
        logoutButton.setOnClickListener {
            val nextPage = Intent(this, MainActivity::class.java)
            startActivity(nextPage)
            Firebase.auth.signOut()
        }
    }
    private fun displayUserEmail(){
        val user = Firebase.auth.currentUser
        user?.let {
            val email = user.email
            if (email != null) {
                Log.d("Username: ",email)

                ///Assigning the userEmail in the user's dashboard.
                val userEmail = findViewById<TextView>(R.id.userEmail_text)
                userEmail.text= email

            }

        }
    }
    ///Handling the register button from the user's dashboard
    private fun configureRegisterButton(){
        val registerButton: Button = findViewById(R.id.dashboard_register_button)
        registerButton.setOnClickListener {
            Toast.makeText(applicationContext,"Please logout for signing up a new account.",
                Toast.LENGTH_LONG).show()
        }
    }
    ///Handling the Buy and sell Activity from the Dashboard
    private fun configureBuyAndSellButton() {
        val buyAndSellButton: Button = findViewById(R.id.dashboard_trade_button)
        buyAndSellButton.setOnClickListener {
            val buyAndSellPage = Intent(this,BuyAndSellActivity::class.java)
            startActivity(buyAndSellPage)
        }
    }
    ///Handling tutoring feature from the HomeScreen page.
    private fun configureTutoringButton() {
        val tutoringButton: Button = findViewById(R.id.dashboard_tutoring_button)
        tutoringButton.setOnClickListener {
            val tutoringPage = Intent(this,TutoringActivity::class.java)
            startActivity(tutoringPage)
        }
    }
    ////Handling the payments module from the HomeScreen where the user is not logged in.
    private fun configurePaymentsButton() {
        val paymentsButton: Button = findViewById(R.id.dashboard_payments_button)
        paymentsButton.setOnClickListener {
            val paymentsPage = Intent(this,PaymentActivity::class.java)
            startActivity(paymentsPage)
        }
    }

    private fun configureInfoex() {
        val InfoExButton: Button = findViewById(R.id.dashboard_infoExchange_button)
        InfoExButton.setOnClickListener {
            val InfoExPage = Intent(this,InformationExchangeActivity::class.java)
            startActivity(InfoExPage)
        }
    }
    private fun configureFormclub() {
        val FormClubBttn: Button = findViewById(R.id.dashboard_formClub_button)
        FormClubBttn.setOnClickListener {
            val FormclubPage = Intent(this,FormclubActivity::class.java)
            startActivity(FormclubPage)
        }
    }

    private fun configureMessage(){
        val button:Button = findViewById(R.id.dashboard_chat_button)
        button.setOnClickListener{
            val messagePage = Intent(this,EmailActivity::class.java)
            startActivity(messagePage)
        }
    }

    private fun configureAdvertisement(){
        val button:Button = findViewById(R.id.dashboard_advertisement_button)
        button.setOnClickListener{
            val adPage = Intent(this,AdvertisementActivity::class.java)
            startActivity(adPage)
        }
    }
}