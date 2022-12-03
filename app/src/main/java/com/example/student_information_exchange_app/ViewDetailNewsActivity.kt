package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ViewDetailNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_detail_news)
        configureBackHomeNews()
        configureSelectAnotherNews()
    }

    private fun configureBackHomeNews() {
        val BackhomebttnNews: Button = findViewById(R.id.Back_home_bttn_news)
        BackhomebttnNews.setOnClickListener {
            val backhomeNews = Intent(this, HomePageActivity::class.java)
            startActivity(backhomeNews)
        }
    }
    private fun configureSelectAnotherNews() {
        val Select_another_bttn1: Button = findViewById(R.id.select_another_info1)
       Select_another_bttn1.setOnClickListener {
            val Prev_info1 = Intent(this, InformationExchangeActivity::class.java)
            startActivity(Prev_info1)
        }
    }
}