package com.example.student_information_exchange_app

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.student_information_exchange_app.adapters.TutoringServiceAdapter
import com.example.student_information_exchange_app.adapters.TutoringSessionAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TutoringSessionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutoring_session)

        configureTopBar()
        configureViewPager()
    }
    //Sets up top bar with a name and back arrow
    private fun configureTopBar(){
        val display=supportActionBar
        display?.title="Manage Scheduled Sessions"
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
    //Sets up the viewpager and its elements
    private fun configureViewPager(){
        val tabLayout: TabLayout =findViewById(R.id.session_tabs)
        val viewPager: ViewPager2 =findViewById(R.id.st_pager)

        val adapter= TutoringSessionAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager){tab,position->
            when(position){
                0->{
                    tab.text="Add"
                }
                1->{
                    tab.text="Edit"
                }
                2->{
                    tab.text="Remove"
                }
            }
        }.attach()
    }
}
