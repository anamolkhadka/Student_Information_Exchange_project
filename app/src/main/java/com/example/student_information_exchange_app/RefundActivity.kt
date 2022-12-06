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

        title="Request a Refund"
        configureSubmitButton()
    }
    //Sets up the submit button with firebase
    private fun configureSubmitButton(){
        val submit: Button =findViewById(R.id.rr_submit)
        submit.setOnClickListener {
            val reason:String=findViewById<EditText>(R.id.rr_text).text.toString()
            val amount:String=findViewById<EditText>(R.id.rr_value).text.toString()

            val cn1=reason.isEmpty()
            val cn2=amount.isEmpty()
            val incomplete=cn1||cn2
            if (incomplete){
                if(cn1){
                    Toast.makeText(applicationContext,"Please provide a reason for the refund", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"Please provide a refund amount", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext,"Request has been submitted to the CFO", Toast.LENGTH_LONG).show()
                findViewById<EditText>(R.id.rr_text).setText("")
                findViewById<EditText>(R.id.rr_value).setText("")
                finish()
            }
        }
    }
}