package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FormclubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formclub)
        configureCreateNewClub();
        configureJoinClub()
        title= "Form Club"

    }
    private fun configureCreateNewClub() {
        val createClub_Bttn: Button = findViewById(R.id.Create_button)
        createClub_Bttn.setOnClickListener {
            val nextCreate = Intent(this, CreateClubActivity::class.java)
            startActivity(nextCreate)
        }
    }
    private fun configureJoinClub() {
        val Join_Bttn: Button = findViewById(R.id.Join_button)
        Join_Bttn.setOnClickListener {
            val nextJoin = Intent(this, JoinClubActivity::class.java)
            startActivity(nextJoin)
        }
    }
}

