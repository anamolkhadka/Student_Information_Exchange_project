package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class PaymentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        title="Manage Account"
        configureCardButton()
        configureBankButton()
        configureRefundButton()

    }
    ///Handling the Card Activity from the Dashboard
    private fun configureCardButton() {
        val cardButton: Button = findViewById(R.id.cm_button)
        cardButton.setOnClickListener {
            val cardPage = Intent(this,CardActivity::class.java)
            startActivity(cardPage)
        }
    }
    ///Handling the Bank Activity from the Dashboard
    private fun configureBankButton() {
        val bankButton: Button = findViewById(R.id.bm_button)
        bankButton.setOnClickListener {
            val bankPage = Intent(this,BankActivity::class.java)
            startActivity(bankPage)
        }
    }
    ///Handling the Refund Activity from the Dashboard
    private fun configureRefundButton() {
        val refundButton: Button = findViewById(R.id.rm_button)
        refundButton.setOnClickListener {
            val refundPage = Intent(this,RefundActivity::class.java)
            startActivity(refundPage)
        }
    }
}