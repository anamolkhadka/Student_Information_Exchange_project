package com.example.student_information_exchange_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

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

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        ///Feeding data to the item view holder components from the item data set fetched from the firebase
        val item: ItemData = dataset[position]
        holder.itemName.text  = item.ProductName
        holder.itemPrice.text = item.Price
        holder.itemImage.setImageURI(item.Image_Uri.toUri())

    }

    override fun getItemCount(): Int {

        return dataset.size
    }


}
