package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PickupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup)

        title="Pickup"
        paymentButton()

    }

    private fun paymentButton(){
        val paymentButton = findViewById<Button>(R.id.proceed_to_payment_button_2)
        paymentButton.setOnClickListener{
            val cardPage = Intent(this,CardActivity::class.java)
            startActivity(cardPage)
        }

    }
}