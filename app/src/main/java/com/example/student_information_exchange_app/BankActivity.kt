package com.example.student_information_exchange_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.*

class BankActivity : AppCompatActivity(){
    private var db = Firebase.firestore
    private val collectionRef = db.collection("transaction_mediums")
    private lateinit var itemArrayList: ArrayList<BankData>
    private lateinit var indirList:ArrayList<Int>
    private val user = Firebase.auth.currentUser
    private val email = user?.email.toString()
    private lateinit var provider:String
    private lateinit var type:String
    private lateinit var routing:String
    private lateinit var account:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        title="Link or Unlink Banks"
        itemArrayList = arrayListOf()
        indirList= arrayListOf()
        configureSubmitButton()
    }
    //Sets up the submit button with firebase
    private fun configureSubmitButton(){
        val submit:Button=findViewById(R.id.lb_submit)
        submit.setOnClickListener {
            provider=findViewById<Spinner>(R.id.lb_provider).selectedItem.toString()
            type=findViewById<Spinner>(R.id.lb_type).selectedItem.toString()
            routing=findViewById<TextView>(R.id.lb_routing_text).text.toString()
            account=findViewById<TextView>(R.id.lb_account_text).text.toString()

            val cn1=routing.length!=9
            val cn2=account.length!=12
            val incomplete=cn1||cn2
            if (incomplete){
                if(cn1){
                    Toast.makeText(applicationContext,"Please provide a valid 9-digit routing number", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"Please provide a valid 12-digit account number", Toast.LENGTH_LONG).show()
                }
            }else{
                val user = Firebase.auth.currentUser
                uploadItem(user?.email.toString(),provider,type,routing,account)
                findViewById<TextView>(R.id.lb_routing_text).text=""
                findViewById<TextView>(R.id.lb_account_text).text=""
            }
        }
    }
    private fun uploadItem(HOST:String,PROVIDER:String,TYPE:String,ROUTING:String,ACCOUNT:String){
        val item = hashMapOf(
            "Host" to HOST,
            "Provider" to PROVIDER,
            "Type" to TYPE,
            "Routing" to ROUTING,
            "Account" to ACCOUNT,
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
        Toast.makeText(applicationContext,"Account linked", Toast.LENGTH_LONG).show()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun eventChangeListener(v: View){
        val collectionRef = db.collection("transaction_mediums")
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
            setUp()
        }
    }
    private fun setUp(){
        val group: RadioGroup =findViewById(R.id.ub_group)
        val remove:Button=findViewById(R.id.ub_remove)

        if(itemArrayList.size==0){
            Toast.makeText(applicationContext,"No banks exist", Toast.LENGTH_LONG).show()
            remove.isEnabled=false
        }else{
            remove.isEnabled=true
            var index = 0
            var count = 0
            for (item in itemArrayList) {
                //if(item.Host.equals(email)) {
                    val radioButton = RadioButton(this)
                    radioButton.text = item.Type
                    radioButton.id = count
                    count++
                    group.addView(radioButton)
                    indirList.add(index)
                //}
                index++
            }
        }
    }
}