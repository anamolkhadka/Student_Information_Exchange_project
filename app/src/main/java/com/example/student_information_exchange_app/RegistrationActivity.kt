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

class RegistrationActivity : AppCompatActivity() {

    ///Initialize Firebase Auth
    private var auth:FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        configureLoginButton()
        configureHomeScreenButton()
        configureRegisterButton()

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
    ///Creating a new user when user request for register.
    private fun configureRegisterButton() {
        val registerButton: Button = findViewById(R.id.register_button)
        registerButton.setOnClickListener {

            ///Collecting user info
            val firstnameTextField  = findViewById<TextView>(R.id.first_name_signup_text).text.toString()
            val lastnameTextField   = findViewById<TextView>(R.id.last_name_signup_text).text.toString()
            val emailID             = findViewById<TextView>(R.id.email_sign_up_text).text.toString()
            val passwordField       = findViewById<TextView>(R.id.input_password_signup_text).text.toString()
            val repeatPasswordField = findViewById<TextView>(R.id.input_repeat_password_signup_text).text.toString()

            ///Registering the user.
            ///Checking is user credentials is null.
            if(emailID.isBlank() || passwordField.isBlank() || repeatPasswordField.isBlank() || firstnameTextField.isBlank()) {

                if(emailID.isEmpty()){
                    val text = "Email is required !"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(applicationContext,text,duration)
                    toast.show()

                }else if (passwordField.isEmpty()) {
                    Toast.makeText(applicationContext,"Password is required !",Toast.LENGTH_LONG).show()

                }else if (repeatPasswordField.isEmpty()) {
                    Toast.makeText(applicationContext,"Repeat Password is required !",Toast.LENGTH_LONG).show()

                }else if (firstnameTextField.isEmpty()) {
                    Toast.makeText(applicationContext,"Please enter your first name !",Toast.LENGTH_LONG).show()

                }

            }
            else if(passwordField != repeatPasswordField){
                Toast.makeText(applicationContext,"Your second password does not match with the first one !",Toast.LENGTH_LONG).show()

            }
            else {
                ////Try to create a new user.
                auth.createUserWithEmailAndPassword(emailID,passwordField)
                    .addOnCompleteListener(this) {task ->
                        if (task.isSuccessful) {
                            ///Sign in success, update the UI for the user with the signed in user's information
                            Log.d("New user creation",":Success")
                            startActivity(Intent(this,HomePageDashboardActivity::class.java))

                        }else if (!Patterns.EMAIL_ADDRESS.matcher(emailID).matches()){
                            ///If the sign in fails, display the error message to the user.
                            Log.d("User creation",":failed")
                            Toast.makeText(applicationContext,"Please enter valid EmailAddress !",Toast.LENGTH_LONG).show()

                        }else if(passwordField.length < 6) {
                            Toast.makeText(applicationContext,"Weak Password. Minimum 6 characters required!",Toast.LENGTH_LONG).show()

                        }else {
                            Toast.makeText(applicationContext,"Registration Unsuccessful.Try different email !",Toast.LENGTH_LONG).show()
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