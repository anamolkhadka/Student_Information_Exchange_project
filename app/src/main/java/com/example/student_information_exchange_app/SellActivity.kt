package com.example.student_information_exchange_app

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.*


class SellActivity : AppCompatActivity() {

    ///Creating a storage reference
    private val storage = Firebase.storage
    //Getting FireStore reference
    private val db = Firebase.firestore
    private val collectionRef = db.collection("items_for_Sale")
    var mImageUri: Uri? = null
    private lateinit var name: String
    private lateinit var price: String
    private lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)
        title="Sell your items here."

        configureChoosePhotoButton()
        configureConfirmButton()

    }
    //Handling the Photos from the device
    private fun configureChoosePhotoButton() {
        val chooseImageButton = findViewById<Button>(R.id.upload_photo_button)
        chooseImageButton.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            resultLauncher.launch(gallery)

        }

    }
    ///Checking whether the user launched and successfully selected the picture and then displaying
    /// into image view.
    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            mImageUri = data?.data
            val imageSelected = findViewById<ImageView>(R.id.upload_image_id)
            imageSelected.setImageURI(mImageUri)

        }
    }


    private fun configureConfirmButton() {

        val confirmButton      = findViewById<Button>(R.id.confirm_transaction_button)
        confirmButton.setOnClickListener {
            val productName        = findViewById<EditText>(R.id.product_name_input).text.toString()
            val productPrice       = findViewById<EditText>(R.id.product_price_input).text.toString()
            val productDescription = findViewById<EditText>(R.id.product_description_input).text.toString()

            ///Assigning values
            name = productName
            price= productPrice
            description = productDescription

            ///Checking for null values
            if (productName.isBlank() || productPrice.isBlank() || productDescription.isBlank()){

                if (productName.isEmpty()){
                    val text = "Product name is required !"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(applicationContext,text,duration)
                    toast.show()
                }
                else if (productPrice.isEmpty()){
                    Toast.makeText(applicationContext,"Product price is required !",Toast.LENGTH_LONG).show()
                }
                else if (productDescription.isEmpty()) {
                    Toast.makeText(applicationContext,"Product description is required !",Toast.LENGTH_LONG).show()
                }
            }
            else {
                ///try to upload the product image in the data storage.
                uploadImage()

            }

        }
    }

    ///Uploading the product in the database and the photo on the data storage.
    private fun uploadImage(){

        ///check whether the ImageUri is Null.
        if(mImageUri != null){

            uploadItem(name,price,description)

            //Formatting name for the file to be uploaded.
            val formatter = SimpleDateFormat("yyyy_mm_dd_hh_mm_ss", Locale.getDefault())
            val currentTime = Date()
            val filename = formatter.format(currentTime)

            ///Getting reference
            val storageReference = storage.getReference("Item_Images/$filename")

            val uploadTask = storageReference.putFile(mImageUri!!)
            uploadTask.addOnFailureListener { e ->
                ///Handle unsuccessful uploads
                Toast.makeText(applicationContext,"Unable to complete the Transaction.",Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext,e.message,Toast.LENGTH_LONG).show()

            }.addOnSuccessListener {
                ///Handle Success
                mImageUri = null
                Toast.makeText(applicationContext,"Transaction Succeed ! ",Toast.LENGTH_SHORT).show()
                ///Take the user back to dashboard.
                val nextPage = Intent(this, BuyAndSellActivity::class.java)
                startActivity(nextPage)

            }.addOnProgressListener { taskSnapshot ->
                ///Handling Progress bar
                val myProgressbar  = findViewById<ProgressBar>(R.id.upload_progress_bar)
                val progress: Double = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                myProgressbar.progress = progress.toInt()

            }

        }else {
            Toast.makeText(this, "Please select the picture", Toast.LENGTH_SHORT).show()
        }

    }
    ///Function to upload the product information in firebase fireStore database.
    private fun uploadItem(Name:String,Price:String,Description:String){

        ///Creating an object from the user information.
        val item = hashMapOf(
            "ProductName" to Name,
            "Price" to Price,
            "Description" to Description,
            "Image_Uri" to mImageUri.toString()
        )
        ////Creating a document reference.
        ///Setting a unique name for each document using timestamp
        //Formatting name for the file to be uploaded.
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


    }

}