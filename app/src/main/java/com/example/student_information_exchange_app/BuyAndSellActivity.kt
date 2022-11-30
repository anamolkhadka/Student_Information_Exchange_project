package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BuyAndSellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_and_sell)

        title="Market Place"

        configureSellItemsButton()
        configureBuyItemsButton()
        configureBackToDashboardButton()
    }

    private fun configureBackToDashboardButton() {
        val backButton: Button = findViewById(R.id.back_dashboard_link_btn)
        backButton.setOnClickListener {
            val dashboardPage = Intent(this,HomePageDashboardActivity::class.java)
            startActivity(dashboardPage)
        }
    }

    private fun configureSellItemsButton() {
        val sellButton: Button = findViewById(R.id.activity_sell_button)
        sellButton.setOnClickListener {
            val sellPage = Intent(this,SellActivity::class.java)
            startActivity(sellPage)
        }
    }

    private fun configureBuyItemsButton() {
        val buyButton: Button = findViewById(R.id.activity_buy_button)
        buyButton.setOnClickListener {
            val marketPage = Intent(this,BuyActivity::class.java)
            startActivity(marketPage)
        }
    }



}