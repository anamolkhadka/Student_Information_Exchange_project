package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BuyAndSellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_and_sell)

        title="MarketPlace"

        configureSellItemsButton()
        configureBuyItemsButton()
    }

    private fun configureSellItemsButton() {
        val sellButton: Button = findViewById(R.id.activity_sell_button)
        sellButton.setOnClickListener {
            val sellPage = Intent(this,SellActivity::class.java)
            startActivity(sellPage)
        }
    }

    private fun configureBuyItemsButton() {

    }



}