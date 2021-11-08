package com.example.navigation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.VocabFragmentDirections
import com.example.navigation.model.Vocabulary
import javax.sql.DataSource

class WordAdapter(): RecyclerView.Adapter<WordAdapter.ItemViewHolder>() {

    var dataset = com.example.navigation.data.DataSource().loadVocabulary()
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.mobile_image)
        val vocab: TextView = view.findViewById(R.id.vocab_word)
        val vocabCard: CardView = view.findViewById(R.id.vocab_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.wordImageResource)
        holder.vocab.setText(item.word)
        holder.vocabCard.setOnClickListener{
            val action = VocabFragmentDirections.actionVocabFragmentToVocabMeaningFragment(item.word, item.wordImageResource.toString(),item.wordSoundResource.toString())
            holder.view.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int = dataset.size
}