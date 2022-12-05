package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ViewDetailsCL2Acitvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details_cl2_acitvity)
        configureSummaryCL2()
        configureBackHomeCL2()
        configureSelectAnotherCL2()
        configureTopBarCL2()
    }

    private fun configureSummaryCL2() {
        val text: TextView = findViewById(R.id.summary_cl2)
        text.text =
            "This University offers many extracurricular activities and programs for you to explore.Our campus is full of active, self-motivated individuals and we have all the connections in place to give everyone a chance to get involved and take charge.\n\n" +
                    "STUDENT ORGANIZATIONS\n\n" +
                    "We have groups centered on academics, religion, service, professional passions, and other fun stuff that really defies categorization. With hundreds of options to choose from, there is something to capture your interest and get you connected to a community at UTA.\n\n" +
                    "CULTURAL ENGAGEMENT AND SOCIAL CHANGE\n\n" +
                    "We can say there’s just about everything for everyone on our campus. And a lot of that diversity can be found through our Cultural Engagement and Social Change department, which showcases cultural events and promotes leadership workshops for a more inclusive experience.\n\n" +
                    "CENTER FOR SERVICE LEARNING\n\n" +
                    "We can give the most civic-minded students a chance to take their determination to improve communities and apply it to any discipline. We work closely with students and faculty to create meaningful connections with unique learning experiences. See how your education can have an immediate impact.\n\n" +
                    "STUDENT GOVERNANCE\n\n" +
                    "Lend your voice to speak the will of the students. Improve the quality of the student experience for everyone through resolutions, meetings, and strong, thoughtful leadership. Visit our page and see some of the most recent changes we’ve championed.\n" +
                    "Source: UTA Student Life"

    }

    private fun configureBackHomeCL2() {
        val BackhomebttnCL2: Button = findViewById(R.id.Back_home_bttn_cl2)
        BackhomebttnCL2.setOnClickListener {
            val backhomeCl2 = Intent(this, HomePageActivity::class.java)
            startActivity(backhomeCl2)
        }
    }

    private fun configureSelectAnotherCL2() {
        val Select_another_bttnCL2: Button = findViewById(R.id.select_another_cl2)
        Select_another_bttnCL2.setOnClickListener {
            val Prev_info_CL2 = Intent(this, InformationExchangeActivity::class.java)
            startActivity(Prev_info_CL2)
        }
    }

    private fun configureTopBarCL2() {
        val display = supportActionBar
        display?.title = "Details"
        display?.setDisplayHomeAsUpEnabled(true)
    }

    //Goes back to previous page when back arrow is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}