package com.example.student_information_exchange_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class BuyActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemArrayList: ArrayList<ItemData>
    private lateinit var myAdapter: BuyItemAdapter
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)

        //Finding the reference to the RecyclerView within the layout.
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        title="Market Place"

        itemArrayList = arrayListOf()
        myAdapter = BuyItemAdapter(this, itemArrayList)
        recyclerView.adapter = myAdapter
        eventChangeListener()
        ///configureTopBar()


    }
    ///Retrieving the data from the firebase.
//    private fun eventChangeListener(){
//
//        val collectionRef = db.collection("items_for_Sale")
//        collectionRef.addSnapshotListener(object : EventListener<QuerySnapshot>{
//
//            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
//                if (error != null) {
//                    Log.d("FireStore error",error.message.toString())
//                    return
//                }
//                for(dc: DocumentChange in value?.documentChanges!!) {
//                    ///If the new document added is the same type.
//                    if(dc.type == DocumentChange.Type.ADDED){
//                        Log.d("Document","fetch succeed")
//                        Log.d("document",dc.document.toString())
//                        ///Converting the document to the ItemData class object
//                        itemArrayList.add(dc.document.toObject(ItemData::class.java))
//                          Log.d("myItemList",itemArrayList.toString())
//
//                    }
//                }
//                myAdapter.notifyDataSetChanged()
//
//            }
//
//        })
//
//    }
    ///Retrieving the data from the firebase.
    @SuppressLint("NotifyDataSetChanged")
    private fun eventChangeListener(){
        val collectionRef = db.collection("items_for_Sale")
        collectionRef.addSnapshotListener{value,e ->

            if(e != null){
                Log.d("FireStore error",e.message.toString())
                return@addSnapshotListener

            }
            for(doc in value!!) {
                Log.d("Document","fetch succeed")
                Log.d("document",doc.toString())
                ///Converting the document to the ItemData class object
                itemArrayList.add(doc.toObject<ItemData>())
                Log.d("myItemList",itemArrayList.toString())

            }
            myAdapter.notifyDataSetChanged()

        }

    }

}