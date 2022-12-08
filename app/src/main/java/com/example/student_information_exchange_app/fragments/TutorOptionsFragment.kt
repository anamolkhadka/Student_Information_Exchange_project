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
import android.widget.RadioButton
import android.widget.Toast
import com.example.student_information_exchange_app.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class TutorOptionsFragment : Fragment() {
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
        val view:View=inflater.inflate(R.layout.fragment_tutor_options, container, false)

        itemArrayList = arrayListOf()
        eventChangeListener(view)
        return view
    }
    private fun setUp(v:View){
        if(checkPM()){
            disableSessionButton(v)
            disableAnnouncementButton(v)
            disableRequestsButton(v)
        }else{
            enableSessionButton(v)
            enableAnnouncementButton(v)
            enableRequestsButton(v)
        }
        configureSessionButton(v)
        configureAnnouncementButton(v)
        configureRequestsButton(v)
        configureBankButton(v)
    }
    //Disables the session button
    private fun disableSessionButton(v: View) {
        val button: Button=v.findViewById(R.id.sm_button)
        button.isEnabled = false
    }
    //Enables the session button
    private fun enableSessionButton(v: View) {
        val button: Button=v.findViewById(R.id.sm_button)
        button.isEnabled = true
    }
    //Disables the announcement button
    private fun disableAnnouncementButton(v: View) {
        val button: Button=v.findViewById(R.id.am_button)
        button.isEnabled = false
    }
    //Enables the announcement button
    private fun enableAnnouncementButton(v: View) {
        val button: Button=v.findViewById(R.id.am_button)
        button.isEnabled = true
    }
    //Disables the requests button
    private fun disableRequestsButton(v: View) {
        val button: Button=v.findViewById(R.id.vm_button)
        button.isEnabled = false
    }
    //Enables the requests button
    private fun enableRequestsButton(v: View) {
        val button: Button=v.findViewById(R.id.vm_button)
        button.isEnabled = true
    }
    //Handling the manage sessions button for tutor's options
    private fun configureSessionButton(v: View) {
        val button: Button=v.findViewById(R.id.sm_button)
        button.setOnClickListener {
            val page = Intent(activity, TutoringSessionActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the announcement button for tutor's options
    private fun configureAnnouncementButton(v: View) {
        val button: Button=v.findViewById(R.id.am_button)
        button.setOnClickListener {
            val page = Intent(activity, TutoringAnnouncementActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the view requests button for tutor's options
    private fun configureRequestsButton(v: View) {
        val button: Button=v.findViewById(R.id.vm_button)
        button.setOnClickListener {
            val page = Intent(activity, TutoringRequestActivity::class.java)
            startActivity(page)
        }
    }
    //Handling the configure bank button for tutor's options
    private fun configureBankButton(v: View) {
        val button: Button=v.findViewById(R.id.cb_button)
        button.setOnClickListener {
            val page = Intent(activity, BankActivity::class.java)
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