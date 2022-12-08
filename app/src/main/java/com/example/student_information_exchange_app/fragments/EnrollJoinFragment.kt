package com.example.student_information_exchange_app.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.student_information_exchange_app.R
import com.example.student_information_exchange_app.SessionData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class EnrollJoinFragment : Fragment() {
    private var db = Firebase.firestore
    private val collectionRef = db.collection("tutoring_sessions")
    private lateinit var itemArrayList: ArrayList<SessionData>
    private lateinit var indirList: java.util.ArrayList<Int>
    private lateinit var docnames: java.util.ArrayList<String>
    private val user = Firebase.auth.currentUser
    private val email = user?.email.toString()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_enroll_join, container, false)

        itemArrayList = arrayListOf()
        indirList = arrayListOf()
        docnames = arrayListOf()
        eventChangeListener(view)
        configureSelectButton(view)
        configureSubmitButton(view)
        return view
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun eventChangeListener(v:View){
        collectionRef.addSnapshotListener{value,e ->

            if(e != null){
                Log.d("FireStore error",e.message.toString())
                return@addSnapshotListener

            }
            itemArrayList.clear()
            docnames.clear()
            for((idx, doc) in value!!.withIndex()) {
                Log.d("Document","fetch succeed")
                Log.d("document",doc.toString())
                itemArrayList.add(doc.toObject<SessionData>())
                docnames.add(idx, doc.id)
                Log.d("myItemList",itemArrayList.toString())
            }
            setUp(v)
        }
    }
    private fun setUp(v:View){
        val group: RadioGroup =v.findViewById(R.id.bs_group)
        val submit: Button =v.findViewById(R.id.bs_submit)
        val select: Button =v.findViewById(R.id.bs_select)

        submit.isEnabled=false
        select.isEnabled=false
        indirList.clear()
        group.removeAllViews()
        var index = 0
        var count = 0
        for (item in itemArrayList) {
            if(!(item.Host.equals(email))) {
                val radioButton = RadioButton(context)
                radioButton.text = item.Title
                radioButton.id = count
                count++
                group.addView(radioButton)
                indirList.add(index)
                submit.isEnabled = true
                select.isEnabled=true
                break
            }
            index++
        }
    }
    private fun configureSelectButton(v:View){
        val group:RadioGroup=v.findViewById(R.id.bs_group)
        val button: Button=v.findViewById(R.id.bs_select)

        button.setOnClickListener {
            if(group.checkedRadioButtonId!=-1) {
                v.findViewById<TextView>(R.id.re_title)
                    .setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Title)
                v.findViewById<TextView>(R.id.re_subject)
                    .setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Subject)
                v.findViewById<TextView>(R.id.re_date)
                    .setText("on ${itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Date}")
                v.findViewById<TextView>(R.id.re_start)
                    .setText("at ${itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Start}")
                v.findViewById<TextView>(R.id.re_duration)
                    .setText("for ${itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Duration}")
                v.findViewById<TextView>(R.id.re_price)
                    .setText("${itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Price} each, ")
                v.findViewById<TextView>(R.id.re_capacity)
                    .setText("up to ${itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Capacity} people")
                v.findViewById<TextView>(R.id.re_location)
                    .setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Location)
                v.findViewById<TextView>(R.id.re_description)
                    .setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Description)
            }
        }
    }
    private fun configureSubmitButton(v:View){
        val button: Button=v.findViewById(R.id.bs_submit)

        button.setOnClickListener {
            Toast.makeText(activity?.applicationContext,"Requested tutor for enrollment", Toast.LENGTH_LONG).show()
        }
    }
}