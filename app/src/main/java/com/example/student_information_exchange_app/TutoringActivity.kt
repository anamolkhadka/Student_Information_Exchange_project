package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class TutoringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutoring)

        val display=supportActionBar
        display?.title="Tutor Options"
        display?.setDisplayHomeAsUpEnabled(true)

        configureBankButton()
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
    ///Handling the Bank Activity from the Dashboard
    private fun configureBankButton() {
        val bankButton: Button = findViewById(R.id.cb_button)
        bankButton.setOnClickListener {
            val bankPage = Intent(this,BankActivity::class.java)
            startActivity(bankPage)
        }
    }
}