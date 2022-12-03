package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        configureViewDetailsNews();
    }

    private fun configureViewDetailsNews() {
        val viewDetailsbttn: Button = findViewById(R.id.ViewDetails_bttn1)
        viewDetailsbttn.setOnClickListener {
            val viewDetail1 = Intent(this, ViewDetailNewsActivity::class.java)
            startActivity(viewDetail1)
        }
    }
}