package com.example.student_information_exchange_app

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TutoringAnnouncementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutoring_announcement)

        title="Make an Announcement"
        configureSubmitButton()
    }
    private fun configureSubmitButton(){
        val submit: Button =findViewById(R.id.at_submit)
        submit.setOnClickListener{
            val announcement:String=findViewById<EditText>(R.id.at_text).text.toString()
            if(announcement.isBlank())
                Toast.makeText(applicationContext,"Please provide content to announce!", Toast.LENGTH_LONG).show()
            else{
                Toast.makeText(applicationContext,"Announced to active personal sessions", Toast.LENGTH_LONG).show()
                findViewById<EditText>(R.id.at_text).setText("")
                finish()
            }
        }
    }
}
