package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AdvertisementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement)

        configureSubmitButton()
        configureBackButton()
    }

    private fun configureBackButton(){
        val button: Button = findViewById(R.id.home_screen_link_btn)
        button.setOnClickListener{
            val nextPage = Intent(this,HomePageDashboardActivity::class.java)
            startActivity(nextPage)
        }
    }
    private fun configureSubmitButton(){

        val button: Button = findViewById(R.id.submit_advertising_form)
        button.setOnClickListener{
            Toast.makeText(applicationContext,"Your request has been submitted. Please wait for 5days for hearing back from us.", Toast.LENGTH_LONG).show()
            val nextPage = Intent(this,HomePageDashboardActivity::class.java)
            startActivity(nextPage)
        }

    }
}