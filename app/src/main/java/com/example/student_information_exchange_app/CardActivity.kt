package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.exp

class CardActivity : AppCompatActivity(){
    ///Initialize Firebase Auth
    private var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        configureTopBar()
        configureSubmitButton()
    }
    //Sets up top bar with a name and back arrow
    private fun configureTopBar(){
        val display=supportActionBar
        display?.title="Add or Remove Cards"
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
        val submit:Button=findViewById(R.id.ac_submit)
        submit.setOnClickListener {
            val card_provider:String=findViewById<Spinner>(R.id.ac_provider).selectedItem.toString()
            val card_type:String=findViewById<Spinner>(R.id.ac_type).selectedItem.toString()
            val card_num:String=findViewById<TextView>(R.id.ac_num_text).text.toString()
            val csv_num:String=findViewById<TextView>(R.id.ac_csv_text).text.toString()
            val expiry_date:String=findViewById<TextView>(R.id.ac_expiry).text.toString()

            val regex="""(0[1-9]|1[0-2])/([0-9]{2})""".toRegex()
            val cn1=card_num.length!=16
            val cn2=csv_num.length!=3
            val cn3=!regex.matches(expiry_date)
            val incomplete=cn1||cn2||cn3
            if (incomplete){
                if(cn1){
                    Toast.makeText(applicationContext,"Please provide a valid 16-digit card number", Toast.LENGTH_LONG).show()
                }else if(cn2){
                    Toast.makeText(applicationContext,"Please provide a valid 3-digit csv number", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"Please provide a valid date (mm/yy)", Toast.LENGTH_LONG).show()
                }
            }else{
                //auth
            }
        }
    }
}