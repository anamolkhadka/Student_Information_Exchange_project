package com.example.student_information_exchange_app

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import kotlin.math.cosh

class PurchaseDetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")

    private lateinit var Cost: String


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

        if (productPrice != null) {
            Cost= productPrice
        }

        priceRef.text       = price
        descriptionRef.text = description

        configureBackButton()
        configureBuyItemButton()

    }
    private fun configureBackButton(){
        val backButton:Button = findViewById(R.id.back_to_other_item)
        backButton.setOnClickListener{
            val previousPage= Intent(this,BuyActivity::class.java)
            startActivity(previousPage)
        }
    }
    ///Handling the buy Action
    private fun configureBuyItemButton(){
        val buyItem: Button = findViewById(R.id.buy_the_item)
        buyItem.setOnClickListener{
            calculateTotalPrice()
        }

    }

    @SuppressLint("StringFormatInvalid")
    private fun calculateTotalPrice() {
        val price = Cost.toDouble()
        ///Sales tax 8%
        val tax = price * 0.08
        val total = price+tax

        val formattedPrice = NumberFormat.getCurrencyInstance().format(price)
        val formattedTax   = NumberFormat.getCurrencyInstance().format(tax)
        val totalPrice     = NumberFormat.getCurrencyInstance().format(total)

        Log.d("Price",formattedPrice)
        Log.d("Tax",formattedTax)
        Log.d("Total",totalPrice)

        ///Getting reference from the Activity_purchase_xml
        val priceBreakdownId = findViewById<TextView>(R.id.price_breakdown)
        val priceId = findViewById<TextView>(R.id.cost_of_product_text)
        val taxId   = findViewById<TextView>(R.id.sales_tax_id)
        val totalId = findViewById<TextView>(R.id.total_amount)

        ////Attaching values to the text fields
        val priceBreakdown = getString(R.string.price_breakdown_text)
        priceBreakdownId.text = priceBreakdown
        priceId.text = getString(R.string.product_price_text).plus(formattedPrice)
        taxId.text   = getString(R.string.sales_tax_text).plus(formattedTax)
        totalId.text = getString(R.string.total_amount_due_text).plus(totalPrice)

        ///Setting the Pickup and delivery button visible.
        val pickupButton: Button = findViewById(R.id.choose_pickup_delivery_button)
        pickupButton.visibility = View.VISIBLE

        //Adding intent to the choose pickup delivery button
        pickupButton.setOnClickListener{
            val pickupDeliveryPage = Intent(this,DeliveryActivity::class.java)
            startActivity(pickupDeliveryPage)
        }

    }

}