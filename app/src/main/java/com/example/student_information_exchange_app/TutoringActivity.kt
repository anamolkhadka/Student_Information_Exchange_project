package com.example.student_information_exchange_app

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.student_information_exchange_app.adapters.TutoringServiceAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class TutoringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutoring)

        configureTopBar()
        configureViewPager()
    }
    //Sets up top bar with a name and back arrow
    private fun configureTopBar(){
        val display=supportActionBar
        display?.title="Tutoring Services"
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
        val tabLayout:TabLayout=findViewById(R.id.tabLayout)
        val viewPager:ViewPager2 =findViewById(R.id.ts_pager)
        val person=ContextCompat.getDrawable(this, R.drawable.person_icon)
        val cap=ContextCompat.getDrawable(this, R.drawable.grad_icon)

        val adapter=TutoringServiceAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager){tab,position->
            when(position){
                0->{
                    tab.text="Tutor"
                    tab.icon=person
                }
                1->{
                    tab.text="Student"
                    tab.icon=cap
                }
            }
        }.attach()
    }
}