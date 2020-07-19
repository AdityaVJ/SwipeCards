package com.jajodia.swipecards.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jajodia.swipecards.R
import com.jajodia.swipecards.models.DataModel
import kotlinx.android.synthetic.main.swipable_card.view.*

class SwipeCardAdapter(private val list: List<DataModel>) :
    RecyclerView.Adapter<SwipeCardAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.swipable_card, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        val item = list[position]
        holder.itemView.card_text.text = item.text

    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
