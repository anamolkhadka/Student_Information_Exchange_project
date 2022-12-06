package com.example.student_information_exchange_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class BankActivity : AppCompatActivity(){
    ///Initialize Firebase Auth
    private var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        title="Link or Unlink Banks"
        configureSubmitButton()
    }
    //Sets up the submit button with firebase
    private fun configureSubmitButton(){
        val submit:Button=findViewById(R.id.lb_submit)
        submit.setOnClickListener {
            val bank_provider:String=findViewById<Spinner>(R.id.lb_provider).selectedItem.toString()
            val account_type:String=findViewById<Spinner>(R.id.lb_type).selectedItem.toString()
            val routing_num:String=findViewById<TextView>(R.id.lb_routing_text).text.toString()
            val account_num:String=findViewById<TextView>(R.id.lb_account_text).text.toString()

            val cn1=routing_num.length!=9
            val cn2=account_num.length!=12
            val incomplete=cn1||cn2
            if (incomplete){
                if(cn1){
                    Toast.makeText(applicationContext,"Please provide a valid 9-digit routing number", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"Please provide a valid 12-digit account number", Toast.LENGTH_LONG).show()
                }
            }else{
                //auth
            }
        }
    }
}