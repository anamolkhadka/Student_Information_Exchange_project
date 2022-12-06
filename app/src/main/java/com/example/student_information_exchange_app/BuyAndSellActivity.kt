package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class BuyAndSellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_and_sell)

        configureTopBar()
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
        val buyButton: Button = findViewById(R.id.activity_buy_button)
        buyButton.setOnClickListener {
            val marketPage = Intent(this,BuyActivity::class.java)
            startActivity(marketPage)
        }
    }
    //Sets up top bar with a name and back arrow
    private fun configureTopBar(){
        val display=supportActionBar
        display?.title="Market Place"
        display?.setDisplayHomeAsUpEnabled(true)
    }
    //Goes back to previous page when back arrow is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}