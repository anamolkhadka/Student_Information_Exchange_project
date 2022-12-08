package com.example.student_information_exchange_app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        title="Rate Prior Tutors"
        configureRateButton()
    }
    private fun configureRateButton(){
        var button:Button=findViewById(R.id.rate_button)
        button.isEnabled=false
    }
}
