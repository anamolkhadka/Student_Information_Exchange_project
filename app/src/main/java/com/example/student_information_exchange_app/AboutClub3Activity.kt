package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AboutClub3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_club3)
        configureSummaryclub3()
        configureJoinButton3()
        title="Club Information"
    }
    private fun configureSummaryclub3(){
        val text: TextView = findViewById(R.id.summary_club3)
        text.text = "The purpose of the organization is to bring together students who are interested in pursuing a career in Actuarial Science. This includes starting study groups for the Actuarial Exams, generating information about Actuarial careers, interacting with employers in the area, and helping students prepare to find employment in the Actuarial Science field.\n" +
                "\n" +
                "Contact Information\n" +
                "E: vaj5908@mavs.uta.edu\n"
    }
    private fun configureJoinButton3(){
        val joinButton2: Button = findViewById(R.id.Join_club3_button)
        joinButton2.setOnClickListener {
            Toast.makeText(applicationContext,"Your request has been sent to admin.The response will be emailed.",
                Toast.LENGTH_LONG).show()
        }
    }
}