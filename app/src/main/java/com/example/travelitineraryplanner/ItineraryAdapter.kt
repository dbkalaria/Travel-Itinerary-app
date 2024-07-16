package com.example.travelitineraryplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItineraryAdapter(private val itinerary: List<ItineraryItem>) :
    RecyclerView.Adapter<ItineraryAdapter.ItineraryViewHolder>() {

    class ItineraryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewDay: TextView = itemView.findViewById(R.id.textViewDay)
        val textViewTime: TextView = itemView.findViewById(R.id.textViewTime)
        val textViewActivity: TextView = itemView.findViewById(R.id.textViewActivity)
        val checkBoxDone: CheckBox = itemView.findViewById(R.id.checkBoxDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItineraryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_itinerary, parent, false)
        return ItineraryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItineraryViewHolder, position: Int) {
        val item = itinerary[position]
        holder.textViewDay.text = item.day
        holder.textViewTime.text = item.time
        holder.textViewActivity.text = item.activity
        holder.checkBoxDone.isChecked = item.done

        holder.checkBoxDone.setOnCheckedChangeListener { _, isChecked ->
            item.done = isChecked
        }
    }

    override fun getItemCount(): Int = itinerary.size
}
