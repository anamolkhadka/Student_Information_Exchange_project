package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ViewDetailsResearch1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details_research1)
        configureSummaryResearch1()
        configureBackHomeResearch1()
        configureSelectAnotherResearch1()
        configureTopBarResearch1()
    }
    private fun configureSummaryResearch1(){
        val text: TextView = findViewById(R.id.summary_research1)
        text.text = "This project develops a highly scalable, readily implementable, host-based flow congestion control solution, possibly with minimum assistance from the top-of-the-rack (ToR) switches for performance enhancement. The following four salient features separate the proposed solution from the existing ones: (a) it is globally optimal by design, achieving a known global design objective and fairness criterion for all the flows including TCP flows; (b) it provides minimum rate guaranteed service (MRGS), and hence, can be used to facilitate SLO guaranteed services; (c) it is pricing aware, allowing any given pricing structure to be easily parameterized in the flow controllers to enable price-based service differentiation among flows; and (d) it allows optimal, dynamic multipath load balancing for traffic engineering.\n" +
                "\n" +
                "\n" +
                "\n" +
                "DCMRG: AnIncast-Coﬂow-Aware, Minimum-Rate-Guaranteed Congestion Control Protocol\n" +
                "DCMRG is an incast-coﬂow-aware and ECN-based soft minimum-rate-guaranteed congestion control protocol for datacenter applications. It is composed of two majorcomponents, i.e., a congestion controller running on the send host and an incast congestion controller running on the receive host. DCMRG possesses three salient features. First, it is the ﬁrst congestion control protocol that integrates congestion control with coﬂow-aware incast control while providing soft minimum ﬂow rate guarantee. Second, DCMRG is readily deployable in datacenter networks. It only requires software upgrade in the hosts and minimum assistance (i.e., ECN) from in-network nodes. Third, DCMRG is backward compatible with and, by design, friendly to the widely deployed, standard-based transport protocols, such as TCP and DCTCP.\n" +
                "\n" +
                "Source: CSE Department at UTA"
    }
    private fun configureBackHomeResearch1() {
        val Backhomebttnresearch1: Button = findViewById(R.id.Back_home_bttn_research1)
        Backhomebttnresearch1.setOnClickListener {
            val backhomeresearch1 = Intent(this, HomePageActivity::class.java)
            startActivity(backhomeresearch1)
        }
    }
    private fun configureSelectAnotherResearch1() {
        val Select_another_research1: Button = findViewById(R.id.select_another_info_research1)
        Select_another_research1.setOnClickListener {
            val Prev_info_research1 = Intent(this, InformationExchangeActivity::class.java)
            startActivity(Prev_info_research1)
        }
    }
    private fun configureTopBarResearch1(){
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