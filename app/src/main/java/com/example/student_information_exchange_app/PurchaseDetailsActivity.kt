package com.example.student_information_exchange_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class PurchaseDetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_details)

        title="Product Details"

        ///Getting value from the BuyItemAdapter
        val intent:Intent = intent
        val productName  = intent.getStringExtra("Name")
        val productPrice = intent.getStringExtra("Price")
        val description  = intent.getStringExtra("Description")
        val image  = intent.getStringExtra("ImageUri")

        ///Getting reference to the XML fields
        val productNameRef  = findViewById<TextView>(R.id.product_name_output)
        val imageRef = findViewById<ImageView>(R.id.item_image_output)
        val priceRef = findViewById<TextView>(R.id.product_price_output)
        val descriptionRef = findViewById<TextView>(R.id.product_description_output)

        ///Assigning Image
        Picasso.get().load(image).into(imageRef)
        ////Assigning values
        productNameRef.text = productName
        val price = "$ $productPrice"
        priceRef.text       = price
        descriptionRef.text = description



    }


}