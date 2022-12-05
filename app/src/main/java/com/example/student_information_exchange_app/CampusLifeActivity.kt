package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CampusLifeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campus_life)
        configureViewDetailsCampusLife1()
        configureViewDetailsCampusLife2()
    }
    private fun configureViewDetailsCampusLife1() {
        val viewDetails_cl_bttn1: Button = findViewById(R.id.ViewDetails_bttnCl1)
        viewDetails_cl_bttn1.setOnClickListener {
            val viewDetailcl1 = Intent(this, ViewDetailsCL1Activity::class.java)
            startActivity(viewDetailcl1)
        }
    }

    private fun configureViewDetailsCampusLife2() {
        val viewDetailsCL_bttn2: Button = findViewById(R.id.ViewDetails_bttnCL2)
        viewDetailsCL_bttn2.setOnClickListener {
            val viewDetailresearch2 = Intent(this,ViewDetailsCL2Acitvity::class.java)
            startActivity(viewDetailresearch2)
        }
    }
}