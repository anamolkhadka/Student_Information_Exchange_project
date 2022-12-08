package com.example.student_information_exchange_app.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.student_information_exchange_app.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class StudentOptionsFragment : Fragment() {
    private var db = Firebase.firestore
    private val collectionRef = db.collection("transaction_mediums")
    private lateinit var itemArrayList: ArrayList<BankData>
    private val user = Firebase.auth.currentUser
    private val email = user?.email.toString()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_student_options, container, false)

        itemArrayList = arrayListOf()
        eventChangeListener(view)
        return view
    }
    private fun setUp(v:View){
        if(checkPM()){
            disableEnrollButton(v)
            disableRatingButton(v)
        }else{
            enableEnrollButton(v)
            enableRatingButton(v)
        }
        configureEnrollButton(v)
        configureRatingButton(v)
        configureBankButton(v)
    }
    //Disables the enroll button
    private fun disableEnrollButton(v: View) {
        val button: Button=v.findViewById(R.id.em_button)
        button.isEnabled = false
    }
    //Enables the enroll button
    private fun enableEnrollButton(v: View) {
        val button: Button=v.findViewById(R.id.em_button)
        button.isEnabled = true
    }
    //Disables the rating button
    private fun disableRatingButton(v: View) {
        val button: Button=v.findViewById(R.id.rt_button)
        button.isEnabled = false
    }
    //Enables the rating button
    private fun enableRatingButton(v: View) {
        val button: Button=v.findViewById(R.id.rt_button)
        button.isEnabled = true
    }
    //Handling the enroll button for student's options
    private fun configureEnrollButton(v: View) {
        val button: Button=v.findViewById(R.id.em_button)
        button.setOnClickListener {
            val page = Intent(activity, EnrollmentActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the rating button for student's options
    private fun configureRatingButton(v: View) {
        val button: Button=v.findViewById(R.id.rt_button)
        button.setOnClickListener {
            val page = Intent(activity, RatingActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the configure bank button for student's options
    private fun configureBankButton(v: View) {
        val bankButton: Button=v.findViewById(R.id.cc_button)
        bankButton.setOnClickListener {
            val page = Intent(activity, CardActivity::class.java)
            startActivity(page)
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun eventChangeListener(v: View){
        collectionRef.addSnapshotListener{value,e ->

            if(e != null){
                Log.d("FireStore error",e.message.toString())
                return@addSnapshotListener

            }
            for(doc in value!!) {
                Log.d("Document","fetch succeed")
                Log.d("document",doc.toString())
                itemArrayList.add(doc.toObject<BankData>())
                Log.d("myItemList",itemArrayList.toString())
            }
            setUp(v)
        }
    }
    private fun checkPM(): Boolean {
        if(itemArrayList.size!=0){
            for (item in itemArrayList) {
                if(item.Host.equals(email)) {
                    return false
                }
            }
        }
        return true
    }
}