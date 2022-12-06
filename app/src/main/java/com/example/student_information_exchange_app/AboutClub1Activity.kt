package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AboutClub1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_club1)
        configureSummaryclub1()
        configureJoinButton1()
        title="Club Information"
    }
    private fun configureSummaryclub1(){
        val text: TextView = findViewById(R.id.summary_club1)
        text.text = "The 2100 Club aims to create a stronger sense of community and collaboration among artists in the glass studio. This organization hopes to better the studio by organizing and running fundraising events to help fund visiting artists and equipment for the studio, social events to create a greater sense of community among the students, and to set an example for incoming students as active members both inside the studio and outside in the local art community. Those in the club strive to be active, dedicated members of the studio and hope to lead by example.    \n" +
                "\n" +
                "Insta:2100club\n" +
                "\n" +
                "FB:UTA2100club\n" +
                "\n" +
                "Contact Information\n" +
                "E: 2100glass@gmail.com\n"

    }
    private fun configureJoinButton1(){
        val joinButton1: Button = findViewById(R.id.Join_club1_button)
        joinButton1.setOnClickListener {
            Toast.makeText(applicationContext,"Your request has been sent to admin. The response will be emailed.",
                Toast.LENGTH_LONG).show()
        }
    }


}