package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AdvertisementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement)
        title="Request for placing your Ads"
        configureSubmitButton()
    }

    private fun configureSubmitButton(){

        val button: Button = findViewById(R.id.submit_advertising_form)
        button.setOnClickListener{

            ////Getting reference from the input fields.
            ///Collecting user info
            val firstname = findViewById<TextView>(R.id.advertisement_first_name_text).text.toString()
            val lastname = findViewById<TextView>(R.id.advertisement_last_name_text).text.toString()
            val emailiD = findViewById<TextView>(R.id.advertisement_email_text).text.toString()
            val businessName = findViewById<TextView>(R.id.advertisement_business_name_text).text.toString()
            val contact = findViewById<TextView>(R.id.contact_number_text).text.toString()
            if (emailiD.isBlank() || businessName.isBlank() || firstname.isBlank() || lastname.isBlank() || contact.isBlank()) {
                Toast.makeText(
                    applicationContext,
                    "Please Fill up all the above fields !",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                Toast.makeText(applicationContext,"Your request has been submitted. We will be reaching out !", Toast.LENGTH_LONG).show()
                val nextPage = Intent(this,HomePageDashboardActivity::class.java)
                startActivity(nextPage)

            }

        }

    }
}