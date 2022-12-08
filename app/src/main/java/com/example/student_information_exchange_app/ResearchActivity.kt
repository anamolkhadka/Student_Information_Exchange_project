package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class ResearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_research)
        configureViewDetailsResearch1()
        configureViewDetailsResearch2()
        configureTopBarResearch()

    }

    private fun configureViewDetailsResearch1() {
        val viewDetails_research_bttn1: Button = findViewById(R.id.ViewDetailsResearch1)
        viewDetails_research_bttn1.setOnClickListener {
            val viewDetailresearch1 = Intent(this, ViewDetailsResearch1Activity::class.java)
            startActivity(viewDetailresearch1)
        }
    }

    private fun configureViewDetailsResearch2() {
        val viewDetailsresearch_bttn2: Button = findViewById(R.id.ViewDetailsResearch2)
        viewDetailsresearch_bttn2.setOnClickListener {
            val viewDetailresearch2 = Intent(this, ViewDetailsResearch2Activity::class.java)
            startActivity(viewDetailresearch2)
        }
    }
    private fun configureTopBarResearch(){
        val display=supportActionBar
        display?.title="Research"
        display?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
