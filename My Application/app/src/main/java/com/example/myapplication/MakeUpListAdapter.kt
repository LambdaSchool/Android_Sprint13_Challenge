package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.MakeupProduct
import kotlinx.android.synthetic.main.makeup_product_layout.view.*

class MakeUpListAdapter(val data: List<MakeupProduct>): RecyclerView.Adapter<MakeUpListAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvBrand = view.tv_brand
        val tvId = view.tv_product_id
        val tvCategory = view.tv_category
        val tvRating = view.tv_rating
        val tvDescription = view.tv_description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.makeup_product_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvBrand.setText(data[position].brand)
        holder.tvId.setText("Position ID: ${data[position].id}")
        holder.tvCategory.setText(data[position].category)
        holder.tvRating.setText("Rating: ${data[position].rating}")
        holder.tvDescription.setText(data[position].description)
    }
}