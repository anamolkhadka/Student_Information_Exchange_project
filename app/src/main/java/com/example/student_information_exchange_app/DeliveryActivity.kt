package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)

        title="Choose one "
        configurePickupButton()
        configureDeliveryButton()

    }
    ///Handling delivery
    private fun configureDeliveryButton (){
        val button: Button = findViewById(R.id.activity_deliver_button)
        button.setOnClickListener{
            val deliveryPage= Intent(this,DeliveryActivity2::class.java)
            startActivity(deliveryPage)
        }
    }
    ///Handling Pickup
    private fun configurePickupButton(){
        val button2: Button = findViewById(R.id.activity_pickup_button)
        button2.setOnClickListener{
            val pickupPage= Intent(this,PickupActivity::class.java)
            startActivity(pickupPage)
        }

    }
}