package com.example.student_information_exchange_app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.student_information_exchange_app.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.*

class SessionAddFragment : Fragment() {
    private var auth: FirebaseAuth = Firebase.auth
    private val storage = Firebase.storage
    private var db = Firebase.firestore
    private val collectionRef = db.collection("tutoring_sessions")
    private lateinit var title: String
    private lateinit var subject: String
    private lateinit var date: String
    private lateinit var start: String
    private lateinit var duration: String
    private lateinit var price: String
    private lateinit var capacity: String
    private lateinit var location: String
    private lateinit var description: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_session_add, container, false)
        configureSubmitButton(view)
        return view
    }

    private fun configureSubmitButton(v:View){
        val submit: Button =v.findViewById(R.id.ss_submit)
        submit.setOnClickListener {
            title=v.findViewById<EditText>(R.id.title_field).text.toString()
            subject=v.findViewById<EditText>(R.id.subject_field).text.toString()
            date=v.findViewById<EditText>(R.id.date_field).text.toString()
            start=v.findViewById<EditText>(R.id.start_time_field).text.toString()
            duration=v.findViewById<EditText>(R.id.duration_field).text.toString()
            price=v.findViewById<TextInputEditText>(R.id.price_field).text.toString()
            capacity=v.findViewById<TextInputEditText>(R.id.capacity_field).text.toString()
            location=v.findViewById<EditText>(R.id.location_field).text.toString()
            description=v.findViewById<EditText>(R.id.description_field).text.toString()

            val regex="""(0[1-9]|1[0-2])/([0-2][0-9]|3[0-1])""".toRegex()
            val cn1=title.isBlank()
            val cn2=subject.isBlank()
            val cn3=date.isBlank()
            val cn4=!regex.matches(date)
            val cn5=start.isBlank()
            val cn6=duration.isBlank()
            val cn7=price.isBlank()
            val cn8=capacity.isBlank()
            val cn9=location.isBlank()
            val cn10=description.isBlank()
            val incomplete=cn1||cn2||cn3||cn4||cn5||cn6||cn7||cn8||cn9||cn10
            if(incomplete){
                if(cn4){
                    Toast.makeText(activity?.applicationContext,"Please provide a valid date (mm/dd)", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(activity?.applicationContext,"Please complete all text fields", Toast.LENGTH_LONG).show()
                }
            }else{
                val user = Firebase.auth.currentUser
                uploadItem(user?.email.toString(),title,subject,date,start,duration,price,capacity,location,description)
                v.findViewById<EditText>(R.id.title_field).setText("")
                v.findViewById<EditText>(R.id.subject_field).setText("")
                v.findViewById<EditText>(R.id.date_field).setText("")
                v.findViewById<EditText>(R.id.start_time_field).setText("")
                v.findViewById<EditText>(R.id.duration_field).setText("")
                v.findViewById<EditText>(R.id.price_field).setText("")
                v.findViewById<EditText>(R.id.capacity_field).setText("")
                v.findViewById<EditText>(R.id.location_field).setText("")
                v.findViewById<EditText>(R.id.description_field).setText("")
            }
        }
    }
    private fun uploadItem(HOST:String,TITLE:String,SUBJECT:String,DATE:String,START:String,DURATION:String,PRICE:String,CAPACITY:String,LOCATION:String,DESCRIPTION:String){
        val item = hashMapOf(
            "Host" to HOST,
            "Title" to TITLE,
            "Subject" to SUBJECT,
            "Date" to DATE,
            "Start" to START,
            "Duration" to DURATION,
            "Price" to PRICE,
            "Capacity" to CAPACITY,
            "Location" to LOCATION,
            "Description" to DESCRIPTION,
        )
        val formatter = SimpleDateFormat("yyyy_mm_dd_hh_mm_ss", Locale.getDefault())
        val currentTime = Date()
        val documentName = formatter.format(currentTime)

        val documentRef = collectionRef.document(documentName)
        documentRef.set(item)
            .addOnSuccessListener {
                Log.d("Document upload",":Success")

            }.addOnFailureListener{ e ->
                e.message?.let { Log.d("Document upload failed", it) }
            }
        Toast.makeText(activity?.applicationContext,"Session created", Toast.LENGTH_LONG).show()
    }
}