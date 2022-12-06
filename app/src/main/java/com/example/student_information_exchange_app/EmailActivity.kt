package com.example.student_information_exchange_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        title= "Send a message"
        configureSendEmailButton()

    }

    private fun configureSendEmailButton(){
        val button:Button = findViewById(R.id.send_email_button)
        button.setOnClickListener{

            ///Taking values from the input fields
            val email   = findViewById<EditText>(R.id.emailAddress).text.toString()
            val subject = findViewById<EditText>(R.id.subject_text_input).text.toString()
            val message = findViewById<EditText>(R.id.message_text_input).text.toString()

            ///Separating the multiple email address and storing in array.
            val addresses = email.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,addresses)
                putExtra(Intent.EXTRA_SUBJECT,subject)
                putExtra(Intent.EXTRA_TEXT,message)

            }
            startActivity(intent)
//            if(intent.resolveActivity(packageManager) != null) {
//
//                startActivity(intent)
//
//            }else{
//                Toast.makeText(this,"Required Email App is not installed in the device",Toast.LENGTH_SHORT).show()
//
//            }

        }

    }
}