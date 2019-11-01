package com.stepasha.makeupagain.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stepasha.makeupagain.R
import com.stepasha.makeupagain.model.MakeupItem
import kotlinx.android.synthetic.main.makeup_list_item.view.*

class MakeupRecyclerViewAdapter(private val data: Array<MakeupItem>) :
    RecyclerView.Adapter<MakeupRecyclerViewAdapter.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.image_view
        val itemName: TextView = view.text_view_name
        val itemPrice: TextView = view.text_view_price
        val itemRating: TextView = view.text_view_rating
        val card: CardView = view.card_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.makeup_list_item, parent, false)
        context = parent.context
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()
            .load(data[position].image_link)
            .resize(80, 80)
            .centerCrop()
            .into(holder.imageView)
        holder.itemName.text = data[position].name
        holder.itemPrice.text = data[position].price
        holder.itemRating.text = "${data[position].rating}/5.0"


    }
}