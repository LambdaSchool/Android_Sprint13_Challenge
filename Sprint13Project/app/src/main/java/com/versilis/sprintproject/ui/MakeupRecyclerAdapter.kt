package com.versilis.sprintproject.ui

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.versilis.sprintproject.R
import com.versilis.sprintproject.data.local.model.Makeup
import com.versilis.sprintproject.util.inflate
import kotlinx.android.synthetic.main.cv_makeup_product.view.*

class MakeupRecyclerAdapter(private var makeupProductList: List<Makeup>) : RecyclerView.Adapter<MakeupRecyclerAdapter.MakeupCardViewHolder>() {

    inner class MakeupCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val priceTextView = itemView.findViewById(R.id.tv_price) as TextView
        private val nameTextView = itemView.findViewById(R.id.tv_name) as TextView
        private val ratingTextView = itemView.findViewById(R.id.tv_rating) as TextView
        private val productImageView = itemView.findViewById(R.id.iv_makeup_photo) as ImageView

        fun bindData(makeupProduct: Makeup) {
            priceTextView.text = makeupProduct.price.toString()
            nameTextView.text = makeupProduct.name
            ratingTextView.text = makeupProduct.rating.toString()
            Picasso
                .get()
                .load(makeupProduct.imageUri)
                .into(productImageView)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MakeupRecyclerAdapter.MakeupCardViewHolder {
        val inflatedView = parent.inflate(R.layout.cv_makeup_product)
        return MakeupCardViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return makeupProductList.size
    }

    override fun onBindViewHolder(
        holder: MakeupRecyclerAdapter.MakeupCardViewHolder,
        position: Int
    ) {
        holder.bindData(makeupProductList[position])
    }

    fun update(newProductList: List<Makeup>) {
        makeupProductList = newProductList
        notifyDataSetChanged()
    }
}