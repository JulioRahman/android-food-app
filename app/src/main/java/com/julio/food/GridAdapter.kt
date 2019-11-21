package com.julio.food

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_food.view.*

class GridAdapter(private val listFoods: ArrayList<Food>) :
    RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_food, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = listFoods.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Picasso.get().load(listFoods[position].photo).into(holder.imgPhoto)
        holder.txtTitle.text = listFoods[position].name

        holder.itemView.setOnClickListener {
            holder.itemView.context.let {
                it.startActivity(Intent(it, DetailActivity::class.java).apply {
                    putExtra("NAME", listFoods[position].name)
                    putExtra("PHOTO", listFoods[position].photo)
                    putExtra("DETAIL", listFoods[position].detail)
                })
            }
        }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.item_photo
        var txtTitle: TextView = itemView.item_name
    }
}