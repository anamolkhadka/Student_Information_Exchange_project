package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.core.app.NavUtils

class RefundActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refund)

        configureTopBar()
        configureSubmitButton()
    }
    //Sets up top bar with a name and back arrow
    private fun configureTopBar(){
        val display=supportActionBar
        display?.title="Request a Refund"
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
    //Sets up the submit button with firebase
    private fun configureSubmitButton(){
        val submit: Button =findViewById(R.id.rr_submit)
        submit.setOnClickListener {
            val reason:String=findViewById<EditText>(R.id.rr_text).text.toString()

            val cn1=reason.isEmpty()
            val incomplete=cn1
            if (incomplete){
                if(cn1){
                    Toast.makeText(applicationContext,"Please provide a reason for the refund", Toast.LENGTH_LONG).show()
                }else{

                }
            }else{
                //auth
            }
        }
    }
}