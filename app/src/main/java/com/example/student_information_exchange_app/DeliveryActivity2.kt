package com.example.student_information_exchange_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class DeliveryActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery2)

        title="Delivery"

        confirmAddressButton()
        paymentButton()
    }

    @SuppressLint("SetTextI18n")
    private fun confirmAddressButton(){
        val button: Button = findViewById(R.id.confirm_address_button)
        button.setOnClickListener{

            ///Getting the value from the user inputs.
            val address1= findViewById<TextView>(R.id.Address_1_text).text.toString()
            val address2= findViewById<TextView>(R.id.Address_2_text).text.toString()
            val zipcode = findViewById<TextView>(R.id.zip_code_text).text.toString()

            ///Getting references for the output fields.
            val output1   = findViewById<TextView>(R.id.street_address_text)
            val output2   = findViewById<TextView>(R.id.city_state_text)
            val outputZip = findViewById<TextView>(R.id.zipcode_output_text)
            val paymentButton = findViewById<Button>(R.id.proceed_to_payment_button)

            ////Assigning values to the output fields.
            val deliveryRef  = findViewById<TextView>(R.id.delivery_address_text)
            deliveryRef.text = "Entered Address :"
            output1.text     = address1
            output2.text     = address2
            outputZip.text   = zipcode

            paymentButton.visibility = View.VISIBLE


        }
    }

    private fun paymentButton(){
        val paymentButton = findViewById<Button>(R.id.proceed_to_payment_button)
        paymentButton.setOnClickListener{
            val cardPage = Intent(this,CardActivity::class.java)
            startActivity(cardPage)
        }

    }
}