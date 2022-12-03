package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InformationExchangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_exchange)
        configurehomeScreenInfoEx();
        configureNews();
    }

    private fun configurehomeScreenInfoEx() {
        val BackHomeInfoex: Button = findViewById(R.id.home_screen_infoExchange_button_btn)
        BackHomeInfoex.setOnClickListener {
            val backpage = Intent(this, HomePageActivity::class.java)
            startActivity(backpage)
        }
    }

    private fun configureNews() {
        val News_Bttn: Button = findViewById(R.id.news_button)
        News_Bttn.setOnClickListener {
            val newsPage = Intent(this, NewsActivity::class.java)
            startActivity(newsPage)
        }
    }
}

