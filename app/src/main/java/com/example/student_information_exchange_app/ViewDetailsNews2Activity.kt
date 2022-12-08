package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ViewDetailsNews2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details_news2)
        configureSummaryNews2()
        configureBackHomeNews2()
        configureSelectAnotherNews2()
        configureTopBarNews2()

    }

    private fun configureSummaryNews2(){
        val text: TextView = findViewById(R.id.summary_news2)
        text.text = "Americans are now paying less for gasoline than they did before Russia invaded Ukraine in February as fuel prices continue to drop amid slowing demand across the globe. \n" +
                "\n" +
                "The average price for a gallon of gas is now USD 3.47, or less than the average  USD 3.54 per gallon that motorists paid the week of February 21, when Russia began its military campaign in Ukraine, according to data from AAA.Russia's invasion of Ukraine contributed to a sharp spike in gas prices earlier this year, pushing prices at the pump to an all-time high of  USD 5.02 a gallon on June 14. The combination of high gas prices with rising costs for everything from food to automobiles juiced inflation to a 40-year high in 2022, eroding many Americans' purchasing power and pinching their wallets. \n" +
                "\n" +
                "But gas prices have fallen sharply in recent weeks amid a slowdown in demand for the commodity, as well as fears about economic shutdowns across the globe, according to AAA. China, for instance, continues to rely on shutdowns to contain COVID outbreaks, although recent protests in that country have prompted some signals that it may shift from its zero-COVID policies. Gas prices may have more room to fall in the coming weeks, according to GasBuddy analyst Patrick De Haan. Prices are dropping \"under heavy selling pressure as China sees protests for its zero-Covid policies, shut downs of major cities, and U.S. demand comes under seasonal pressure, he noted in a November 28 blog post. \n" +
                "\n\n" +
                "Source: Aimee Picchi\n" +
                "CBS NEWS"

    }
    private fun configureBackHomeNews2() {
        val BackhomebttnNews2: Button = findViewById(R.id.Back_home_bttn_news2)
        BackhomebttnNews2.setOnClickListener {
            val backhomeNews2 = Intent(this, HomePageActivity::class.java)
            startActivity(backhomeNews2)
        }
    }
    private fun configureSelectAnotherNews2() {
        val Select_another_bttn_news2: Button = findViewById(R.id.select_another_info_news2)
        Select_another_bttn_news2.setOnClickListener {
            val Prev_info2 = Intent(this, InformationExchangeActivity::class.java)
            startActivity(Prev_info2)
        }
    }
    private fun configureTopBarNews2(){
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