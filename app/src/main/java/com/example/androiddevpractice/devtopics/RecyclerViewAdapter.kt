package com.example.androiddevpractice.devtopics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev

class RecyclerViewAdapter() : ListAdapter<Dev, RecyclerViewAdapter.ItemViewHolder>(MyDiffCallback()) {

    class MyDiffCallback : DiffUtil.ItemCallback<Dev>() {
        override fun areItemsTheSame(oldItem: Dev, newItem: Dev): Boolean {
            return oldItem.topic == newItem.topic
        }

        override fun areContentsTheSame(oldItem: Dev, newItem: Dev): Boolean {
            return oldItem == newItem
        }
    }


    class ItemViewHolder(private val view: View) :  RecyclerView.ViewHolder(view) {
        val tv: TextView = view.findViewById(R.id.tv_rv_item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.tv.text = item.topic
    }


}

