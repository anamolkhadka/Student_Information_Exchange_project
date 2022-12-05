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
        configureResearch();
        configureCampusLife()
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
    private fun configureResearch() {
        val Research_Bttn: Button = findViewById(R.id.research_button)
        Research_Bttn.setOnClickListener {
            val researchPage = Intent(this, ResearchActivity::class.java)
            startActivity(researchPage)
        }
    }
    private fun configureCampusLife() {
        val campuslife_Bttn: Button = findViewById(R.id.Campus_life_button)
        campuslife_Bttn.setOnClickListener {
            val CLPage = Intent(this, CampusLifeActivity::class.java)
            startActivity(CLPage)
        }
    }

}

