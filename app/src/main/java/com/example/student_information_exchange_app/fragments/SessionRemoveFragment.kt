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
    private var db = Firebase.firestore
    private val collectionRef = db.collection("tutoring_sessions")
    private lateinit var itemArrayList: ArrayList<SessionData>
    private lateinit var indirList: java.util.ArrayList<Int>
    private lateinit var docnames: java.util.ArrayList<String>
    private var user = Firebase.auth.currentUser
    private val email = user?.email.toString()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_session_remove, container, false)

        itemArrayList = arrayListOf()
        indirList = arrayListOf()
        docnames = arrayListOf()
        eventChangeListener(view)
        configureRemoveButton(view)
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
        val group: RadioGroup =v.findViewById(R.id.ras_group)
        val remove:Button = v.findViewById(R.id.rs_submit)

        remove.isEnabled = false
        indirList.clear()
        group.removeAllViews()
        var index = 0
        var count = 0
        for (item in itemArrayList) {
            if (item.Host.equals(email)) {
                val radioButton = RadioButton(context)
                radioButton.text = item.Title
                radioButton.id = count
                count++
                group.addView(radioButton)
                indirList.add(index)
                remove.isEnabled = true
                break
            }
            index++
        }
    }
    private fun configureRemoveButton(v: View) {
        val button: Button =v.findViewById(R.id.rs_submit)
        val group: RadioGroup =v.findViewById(R.id.ras_group)

        button.setOnClickListener {
            if(group.checkedRadioButtonId!=-1) {
                val old_id=group.checkedRadioButtonId
                val old_idx=indirList.get(old_id)
                val name = docnames.get(old_idx)

                collectionRef.document(name)
                    .delete()
                    .addOnSuccessListener {
                        Log.d("Document deleted", ":Success")
                        Toast.makeText(activity?.applicationContext, "Session removed", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { e ->
                        e.message?.let { Log.d("Document delete failed", it) }
                    }

            }
        }
    }
}