package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class CardActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        configureTopBar()
    }
    //Sets up top bar with a name and back arrow
    private fun configureTopBar(){
        val display=supportActionBar
        display?.title="Add or Remove Cards"
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