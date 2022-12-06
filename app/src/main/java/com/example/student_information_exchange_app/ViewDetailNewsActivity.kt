package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ViewDetailNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_detail_news)
        configureSummaryNews()
        configureBackHomeNews()
        configureSelectAnotherNews()
        configureTopBarNews1()

    }

    private fun configureSummaryNews(){
        val text: TextView = findViewById(R.id.summary_news1)
        text.text = "DOHA, Qatar — The U.S. men are heading home, stopped short of the World Cup quarterfinals again.\n" +
                "\n" +
                "A 3-1 loss to the Netherlands on Saturday eliminated the Americans in the round of 16, the same finish as the 2014, 2010 and 1994 squads. The USMNT has won just one knockout round game since returning to the World Cup in 1990 after a 40-year absence, when the 2002 team reached the quarterfinals.\n" +
                "\n" +
                "The loss will be a disappointment for the Americans, who were certain their talent and team chemistry could overcome their lack of experience on the world stage. They talked of winning the World Cup, part of a larger mission to change the way the world sees American soccer.\n" +
                "\n" +
                "But it’s clear the USMNT has a ways to go to be considered among the world’s elite after being outplayed by the Dutch.It might have been a very different game had Pulisic, starting four days after being subbed off at halftime with a pelvic injury, not missed a gimme in the third minute. Pulisic might have thought he was offside because his shot was off, and Andries Noppert was able to clear it with a kick save.\n" +
                "\n" +
                "But the Dutch took the lead seven minutes later when Tyler Adams and Sergino Dest lost track of Depay after he sprayed the ball wide to Dumfries. That allowed Depay to run unmarked into the penalty box and beat Matt Turner with a rocket of a shot, and the USMNT was left to play catchup – unsuccessfully – the rest of the way. \n\n" +
                "Source: Nancy Armour\n" +
                " USATODAY" +
                "\n"

    }
    private fun configureBackHomeNews() {
        val BackhomebttnNews: Button = findViewById(R.id.Back_home_bttn_news)
        BackhomebttnNews.setOnClickListener {
            val backhomeNews = Intent(this, HomePageActivity::class.java)
            startActivity(backhomeNews)
        }
    }
    private fun configureSelectAnotherNews() {
        val Select_another_bttn1: Button = findViewById(R.id.select_another_info1)
       Select_another_bttn1.setOnClickListener {
            val Prev_info1 = Intent(this, InformationExchangeActivity::class.java)
            startActivity(Prev_info1)
        }
    }
    private fun configureTopBarNews1(){
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