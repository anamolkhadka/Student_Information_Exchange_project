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
import android.widget.RadioGroup
import android.widget.Toast
import com.example.student_information_exchange_app.R
import com.example.student_information_exchange_app.SessionData
import com.example.student_information_exchange_app.TutoringSessionActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class SessionRemoveFragment : Fragment() {
    private lateinit var itemArrayList: ArrayList<SessionData>
    private var db = Firebase.firestore
    private var user = Firebase.auth.currentUser
    private val email = user?.email.toString()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_session_remove, container, false)

        itemArrayList = arrayListOf()
        eventChangeListener(view)
        configureRemoveButton(view)
        return view
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun eventChangeListener(v:View){
        val collectionRef = db.collection("tutoring_sessions")
        collectionRef.addSnapshotListener{value,e ->

            if(e != null){
                Log.d("FireStore error",e.message.toString())
                return@addSnapshotListener

            }
            for(doc in value!!) {
                Log.d("Document","fetch succeed")
                Log.d("document",doc.toString())
                itemArrayList.add(doc.toObject<SessionData>())
                Log.d("myItemList",itemArrayList.toString())
            }
            setUp(v)
        }
    }
    private fun setUp(v:View){
        val group: RadioGroup =v.findViewById(R.id.ras_group)

        if(itemArrayList.toString()==""){
            Toast.makeText(activity?.applicationContext,"No sessions exist", Toast.LENGTH_LONG).show()

        }else{
            for (item in itemArrayList) {
                if(item.Host.equals(email)) {
                    val radioButton = RadioButton(context)
                    radioButton.text = item.Title
                    group.addView(radioButton)
                }
            }
        }
    }
    private fun configureRemoveButton(v: View) {
        val button: Button =v.findViewById(R.id.rs_submit)
        val group: RadioGroup =v.findViewById(R.id.ras_group)
        if(group.isSelected) {
            button.setOnClickListener {
                Toast.makeText(activity?.applicationContext, "Removed", Toast.LENGTH_LONG).show()
            }
        }
    }
}