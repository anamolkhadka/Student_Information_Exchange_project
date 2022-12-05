package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        configureViewDetailsNews();
        configureViewDetailsNews2();
        configureTopBarNews();
    }
    private fun configureTopBarNews(){
        val display=supportActionBar
        display?.title="News"
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

    private fun configureViewDetailsNews() {
        val viewDetailsbttn: Button = findViewById(R.id.ViewDetails_bttn1)
        viewDetailsbttn.setOnClickListener {
            val viewDetail1 = Intent(this, ViewDetailNewsActivity::class.java)
            startActivity(viewDetail1)
        }
    }
    private fun configureViewDetailsNews2() {
        val viewDetailsbttn2: Button = findViewById(R.id.ViewDetails_bttn2)
        viewDetailsbttn2.setOnClickListener {
            val viewDetail2 = Intent(this, ViewDetailsNews2Activity::class.java)
            startActivity(viewDetail2)
        }
    }
}