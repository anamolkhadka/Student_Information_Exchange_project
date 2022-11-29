package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


///This is login page activity
class MainActivity : AppCompatActivity() {

    ///Initialize Firebase Auth
    private var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureSignupButton()
        configureHomeScreenButton()
        configureLoginButton()
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
    ///Signing in the Registered User
    private fun configureLoginButton() {
        val loginButton:Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            val emailID       = findViewById<TextView>(R.id.Sign_in_text_edit_text).text.toString()
            val passwordField = findViewById<TextView>(R.id.input_password_edit_text).text.toString()

            ///Authenticating the user.
            ///Checking is user credential is null.
            if(emailID.isBlank() || passwordField.isBlank()) {

                if(emailID.isEmpty()){
                    val text = "Email is required !"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(applicationContext,text,duration)
                    toast.show()
                }
                else if (passwordField.isEmpty()) {
                    val text = "Password is required !"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                }
            }
            else
            {
                ///Trying to authenticate the user.
                auth.signInWithEmailAndPassword(emailID,passwordField)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            ///Sign in success. update the Homepage for the user.
                            Log.d("User sign in", ":Success")
                            startActivity(Intent(this, HomePageDashboardActivity::class.java))
                        }
                        ///If the sign in fails, display the error message to the user.
                        else if(!Patterns.EMAIL_ADDRESS.matcher(emailID).matches()){
                            Toast.makeText(applicationContext,"Please enter valid EmailAddress !",Toast.LENGTH_LONG).show()
                        }
                        else {
                            Toast.makeText(applicationContext,"Invalid Email or Password !",Toast.LENGTH_LONG).show()

                        }

                    }
            }


        }
    }
    ///Checking if a user is currently signed in.
    public override fun onStart() {
        super.onStart()
        ///Check if the user is signed in (non-null) and update the UI accordingly.
        val currentUser= auth.currentUser
        if(currentUser != null){
            ////reload to the signed in user homepage
            startActivity(Intent(this,HomePageDashboardActivity::class.java))
        }

    }


}