package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CreateClubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_club)
        configurebackHomecc()
        configureRequestButton()
        title="Create New Club"
    }

    private fun configurebackHomecc() {
        val backcc_Bttn: Button = findViewById(R.id.home_cc_btn)
        backcc_Bttn.setOnClickListener {
            val back_Page = Intent(this, HomePageDashboardActivity::class.java)
            startActivity(back_Page)
        }
    }
    private fun configureRequestButton() {
        val registerButton: Button = findViewById(R.id.request_button)
        registerButton.setOnClickListener {

            ///Collecting user info
            val firstname = findViewById<TextView>(R.id.first_name_cc_text).text.toString()
            val lastname = findViewById<TextView>(R.id.last_name_cc_text).text.toString()
            val emailiD = findViewById<TextView>(R.id.email_cc_text).text.toString()
            val StudentID = findViewById<TextView>(R.id.studentID_cc_text).text.toString()
            val ClubName = findViewById<TextView>(R.id.Clubname_cc_text).text.toString()
            val ClubDes = findViewById<TextView>(R.id.Clubdescription_cc_text).text.toString()
            if (emailiD.isBlank() || StudentID.isBlank() || ClubName.isBlank() || firstname.isBlank() || lastname.isBlank() || ClubDes.isBlank()) {
                Toast.makeText(
                    applicationContext,
                    "Please Fill up all the above field !",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Your Form has been submitted to review, Please let us 2-3 businees days to review your application.",
                    Toast.LENGTH_LONG
                ).show()
                val nextPage = Intent(this,HomePageDashboardActivity::class.java)
                startActivity(nextPage)
            }

        }
    }
}