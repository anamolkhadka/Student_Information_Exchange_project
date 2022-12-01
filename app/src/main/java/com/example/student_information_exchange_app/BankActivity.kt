package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class BankActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        //title=" Link or Unlink Banks "
        val display=supportActionBar
        display?.title="Link or Unlink Banks"
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