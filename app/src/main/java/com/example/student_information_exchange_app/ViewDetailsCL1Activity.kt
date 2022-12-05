package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ViewDetailsCL1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details_cl1)
        configureSummaryCl1()
        configureBackHomeCL1()
        configureSelectAnotherCL1()
        configureTopBarCL1()
    }
    private fun configureSummaryCl1(){
        val text: TextView = findViewById(R.id.summary_cl1)
        text.text = "From sport clubs to counseling and psychological services, we want our students to maintain a healthy lifestyle. Our health and recreational programs give students an outlet to decompress through mental and physical wellness.\n\n" +
                "INTRAMURAL SPORTS\n\n" +
                "Mavericks come in all skill levels. Intramurals are the best way to get everyone in the game. We play everything from bowling and flag football to dodgeball and video game tournaments.\n\n" +
                "MAVERICK ACTIVITIES CENTER\n\n" +
                "The MAC is the unofficial center of the UTA campus. It’s usually full of people competing, meeting, gaming, swimming, dunking basketballs, serving volleyballs, talking, listening, and eating together.\n\n" +
                "\n\n" +
                "SPORT CLUBS\n\n" +
                "If you want to take your game on the road without competing at a Division I level, we have a range of Club Sports. Everything from aikido to wrestling with some ultimate frisbee flung in the middle.\n\n" +
                "CAMPUS RECREATION\n\n" +
                "The best resource for learning how to fit in your fitness. We'll show you when to get your MAC on, how to bring it intramural-style, where to take the aquatic plunge, who can help you take training personally, and everything else fitness/wellness-related on campus.\n" +
                "Source: UTA Student Life"

    }
    private fun configureBackHomeCL1() {
        val BackhomebttnCL1: Button = findViewById(R.id.Back_home_bttn_cl1)
        BackhomebttnCL1.setOnClickListener {
            val backhomeCl1 = Intent(this, HomePageActivity::class.java)
            startActivity(backhomeCl1)
        }
    }
    private fun configureSelectAnotherCL1() {
        val Select_another_bttnCL1: Button = findViewById(R.id.select_another_cl1)
        Select_another_bttnCL1.setOnClickListener {
            val Prev_info_CL1 = Intent(this, InformationExchangeActivity::class.java)
            startActivity(Prev_info_CL1)
        }
    }
    private fun configureTopBarCL1(){
        val display=supportActionBar
        display?.title="Details"
        display?.setDisplayHomeAsUpEnabled(true)
    }
    //Goes back to previous page when back arrow is pressed
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