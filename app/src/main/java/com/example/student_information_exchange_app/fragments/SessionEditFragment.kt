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
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.student_information_exchange_app.ItemData
import com.example.student_information_exchange_app.R
import com.example.student_information_exchange_app.RatingActivity
import com.example.student_information_exchange_app.SessionData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class SessionEditFragment : Fragment() {
    private lateinit var itemArrayList: ArrayList<SessionData>
    private lateinit var indirList:ArrayList<Int>
    private var db = Firebase.firestore
    private val user = Firebase.auth.currentUser
    private val email = user?.email.toString()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_session_edit, container, false)

        itemArrayList = arrayListOf()
        indirList= arrayListOf()
        eventChangeListener(view)
        configureSelectButton(view)
        configureSubmitButton(view)
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
        val group:RadioGroup=v.findViewById(R.id.sas_rgroup)
        val submit:Button=v.findViewById(R.id.ms_submit)

        if(itemArrayList.size==0){
            Toast.makeText(activity?.applicationContext,"No sessions exist", Toast.LENGTH_LONG).show()
            submit.isEnabled=false
        }else{
            submit.isEnabled=true
            var index = 0
            var count = 0
            for (item in itemArrayList) {
                if(item.Host.equals(email)) {
                    val radioButton = RadioButton(context)
                    radioButton.text = item.Title
                    radioButton.id = count
                    count++
                    group.addView(radioButton)
                    indirList.add(index)
                }
                index++
            }
        }
    }
    private fun configureSelectButton(v:View){
        val group:RadioGroup=v.findViewById(R.id.sas_rgroup)
        val button: Button=v.findViewById(R.id.modify_button)
        button.setOnClickListener {
            v.findViewById<EditText>(R.id.location_edit).setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Location)
            v.findViewById<EditText>(R.id.start_time_edit).setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Start)
            v.findViewById<EditText>(R.id.capacity_edit).setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Capacity)
            v.findViewById<EditText>(R.id.description_edit).setText(itemArrayList.get(indirList.get(group.checkedRadioButtonId)).Description)
        }
    }
    private fun configureSubmitButton(v:View){
        val button: Button=v.findViewById(R.id.ms_submit)
        button.setOnClickListener {
            val location:String=v.findViewById<EditText>(R.id.location_edit).text.toString()
            val start:String=v.findViewById<EditText>(R.id.start_time_edit).text.toString()
            val capacity:String=v.findViewById<EditText>(R.id.capacity_edit).text.toString()
            val description:String=v.findViewById<EditText>(R.id.description_edit).text.toString()

            if(location.isBlank()||start.isBlank()||capacity.isBlank()||description.isBlank()){
                Toast.makeText(activity?.applicationContext,"Please fill all fields", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(activity?.applicationContext,"Session modified", Toast.LENGTH_LONG).show()
                v.findViewById<EditText>(R.id.location_edit).setText("")
                v.findViewById<EditText>(R.id.start_time_edit).setText("")
                v.findViewById<EditText>(R.id.capacity_edit).setText("")
                v.findViewById<EditText>(R.id.description_edit).setText("")
            }
        }
    }
}