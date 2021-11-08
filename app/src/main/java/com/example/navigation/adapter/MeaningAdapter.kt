package com.example.navigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R

class MeaningAdapter(val word: String): RecyclerView.Adapter<MeaningAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val textview: TextView = view.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item_meaning, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textview.text = word
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}