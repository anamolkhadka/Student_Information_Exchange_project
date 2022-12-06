package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class JoinClubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_club)
        configureAboutClub1()
        configureAboutClub2()
        configureAboutClub3()
        title="Clubs"
    }
    private fun configureAboutClub1() {
        val AboutClub1bttn: Button = findViewById(R.id.ViewDetails_club1)
      AboutClub1bttn.setOnClickListener {
            val About1 = Intent(this, AboutClub1Activity::class.java)
            startActivity(About1)
        }
    }
    private fun configureAboutClub2() {
        val AboutClub2bttn: Button = findViewById(R.id.ViewDetailsclub2)
        AboutClub2bttn.setOnClickListener {
            val About2 = Intent(this, AboutClub2Activity::class.java)
            startActivity(About2)
        }
    }
    private fun configureAboutClub3() {
        val AboutClub3bttn: Button = findViewById(R.id.ViewDetailsclub3)
        AboutClub3bttn.setOnClickListener {
            val About3 = Intent(this, AboutClub3Activity::class.java)
            startActivity(About3)
        }
    }
}