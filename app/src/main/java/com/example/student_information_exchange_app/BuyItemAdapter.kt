package com.example.student_information_exchange_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import java.io.*


class BuyItemAdapter(private val context: Context, private val dataset: List<ItemData>): RecyclerView.Adapter<BuyItemAdapter.ItemViewHolder>(){


    /* ViewHolder deals with the Recycle view to exchange the data item.
    * ItemViewHolder is derived from the RecyclerView.ViewHolder class. */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val itemImage:ImageView = view.findViewById(R.id.item_image)
        val itemName:TextView  = view.findViewById(R.id.item_title)
        val itemPrice:TextView  = view.findViewById(R.id.item_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //Create a new view
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)

        return ItemViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        ///Feeding data to the item view holder components from the item data set fetched from the firebase
        val item: ItemData = dataset[position]
        holder.itemName.text  = item.ProductName
        holder.itemPrice.text = "$ " + item.Price
        ///holder.itemImage.setImageURI(item.Image_Uri.toUri())
        ////Picasso.get().load(item.Image_Uri).into(holder.itemImage)
        ////Glide is the faster one to load image
        Glide.with(context)
            .load(item.Image_Uri)
            .into(holder.itemImage)

        ///Creating Explicit intent
        ///Opening the PurchaseDetailActivity
        holder.itemImage.setOnClickListener {
            val nextPage = Intent(context, PurchaseDetailsActivity::class.java)
            ///Passing the information of the itemImage clicked to the next activity.
            nextPage.putExtra("Name",item.ProductName)
            nextPage.putExtra("Price",item.Price)
            nextPage.putExtra("Description",item.Description)
            nextPage.putExtra("ImageUri",item.Image_Uri)
            context.startActivity(nextPage)
        }

    }

    override fun getItemCount(): Int {

        return dataset.size
    }


}
