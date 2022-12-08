package com.example.student_information_exchange_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ViewDetailsResearch2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details_research2)
        configureSummaryResearch2()
        configureBackHomeResearch2()
        configureSelectAnotherResearch2()
        configureTopBarResearch2()
    }
    private fun configureSummaryResearch2(){
        val text: TextView = findViewById(R.id.summary_research2)
        text.text = "This project is supported by NetApp Inc. aiming to study new technologies to enhance the storage efficiency in modern storage systems. We have been trying to achieve our goal via two methods: data deduplication and erasure coding. So far, we have got some outcomes, which have been recognized by some academic conferences.\n" +
                "\n" +
                " SES-De-dupe: a Case for Low-Cost ECC-based SSD Deduplication\n" +
                "Integrating the data deduplication function into Solid State Drives (SSDs) helps avoid writing duplicate contents to NAND flash chips, which will not only effectively reduce the number of Program/Erase (P/E) operations to extend the device’s lifespan but also proportionally enlarge the logical capacity of SSD to improve the performance of its behind-the-scenes maintenance jobs such as wear-leveling (WL) and garbage- collection (GC). However, these benefits of deduplication come at a non-trivial computational cost incurred by the embedded SSD controller to compute cryptographic hashes. To address this overhead problem, some researchers have suggested replacing cryptographic hashes with error correction codes (ECCs) already embedded in the SSD chips to detect the duplicate contents. However, all existing attempts have ignored the impact of the data randomization (scrambler) module that is widely used in modern SSDs, thus making it impractical to directly integrate ECC-based deduplication into commercial SSDs. In this work, we revisit SSD’s internal structure and propose the first de-duplicatable SSD that can bypass the data scrambler module to enable the low-cost ECC-based data deduplication. Specifically, we propose two design solutions, one on the host side and the other on the device side, to enable ECC-based deduplication. Based on our approach, we can effectively exploit SSD’s built-in ECC module to calculate the hash values of stored data for data deduplication. We have evaluated our SES-De-dupe approach by feeding data traces to the SSD simulator and found that it can remove up to 30.8% redundant data with up to 17.0% write performance\n" +
                "Source: CSE Department UTA"
    }
    private fun configureBackHomeResearch2() {
        val BackhomebttnResearch2: Button = findViewById(R.id.Back_home_bttn_research2)
        BackhomebttnResearch2.setOnClickListener {
            val backhomeResearch2 = Intent(this, HomePageActivity::class.java)
            startActivity(backhomeResearch2)
        }
    }
    private fun configureSelectAnotherResearch2() {
        val Select_another_bttn_research2: Button = findViewById(R.id.select_another_info_research2)
        Select_another_bttn_research2.setOnClickListener {
            val Prev_info_research2 = Intent(this, InformationExchangeActivity::class.java)
            startActivity(Prev_info_research2)
        }
    }
    private fun configureTopBarResearch2(){
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