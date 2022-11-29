package com.example.student_information_exchange_app

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class SellActivity : AppCompatActivity() {

    ///Creating a storage reference
    /*private val storage = Firebase.storage
    ///Points to root reference
    private val storageRef = storage.reference

    ///Creating reference to "Air_pods.jpg" in the firebase storage
    val airpodsRef = storageRef.child("Air_pods.jpg")
    ///Creating reference to 'Item_Images/Air_pods.jpg'
    val airpodsImageRef = storageRef.child("Item_Images/Air_pods.jpg")*/
    private var mImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)
        title="Sell your items here."

        var buttonChecked  = findViewById<RadioGroup>(R.id.used_new_buttons)
        var myProgressbar  = findViewById<ProgressBar>(R.id.upload_progress_bar)


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
                ///try to upload the product in the data storage.
                uploadItem()

            }

        }
    }
    ///Trying to get the extension of the photo getting uploaded.
    private fun getFileExtension(uri: Uri): String? {
        val cR = contentResolver
        val mime = MimeTypeMap.getSingleton()
        return mime.getExtensionFromMimeType(cR.getType(uri))
    }

    ///Uploading the product in the database and the photo on the data storage.
    private fun uploadItem(){
        val itemImage = findViewById<ImageView>(R.id.upload_image_id)
        ///check whether the ImageUri is Null.
        if(mImageUri != null){
            Toast.makeText(this, "Photo selected", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Please select the picture", Toast.LENGTH_SHORT).show();
        }
    }


}