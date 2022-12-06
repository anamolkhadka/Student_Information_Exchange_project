package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AboutClub2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_club2)
        configureSummaryclub2()
        configureJoinButton2()
        title="Club Information"
    }
    private fun configureSummaryclub2(){
        val text: TextView = findViewById(R.id.summary_club2)
        text.text = "A Collection of Brothers at the University of Texas at Arlington was established as a means of social networking amongst males on campus and as a support system for males to fellowship together regardless of classification, organization affiliation, or any other factor that could portray diversity amongst one another. We provide educational, cultural, and social programs along with community service and fellowship events that encourage us to be better leaders and role models.\n" +
                "\n" +
                "Contact Information\n" +
                "701 S. Nedderman Dr.\n" +
                "Arlington, TX 76019\n" +
                "United States\n" +
                "E: olubambo.oludimu@uta.edu\n"
    }
    private fun configureJoinButton2(){
        val joinButton2: Button = findViewById(R.id.Join_club2_button)
        joinButton2.setOnClickListener {
            Toast.makeText(applicationContext,"Your request has been sent to admin. The response will be emailed.",
                Toast.LENGTH_LONG).show()
        }
    }
}