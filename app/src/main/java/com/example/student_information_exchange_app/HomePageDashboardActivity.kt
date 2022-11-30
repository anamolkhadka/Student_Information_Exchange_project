package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        title= "SIE DASHBOARD"

        configureLogoutButton()
        displayUserEmail()
        configureRegisterButton()
        configureBuyAndSellButton()

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
            ////Change this from sell to market page later on
            val buyAndSellPage = Intent(this,SellActivity::class.java)
            startActivity(buyAndSellPage)
        }

    }


}