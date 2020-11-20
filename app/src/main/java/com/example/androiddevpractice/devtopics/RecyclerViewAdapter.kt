package com.example.androiddevpractice.devtopics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddevpractice.R
import com.example.androiddevpractice.room.Dev

class RecyclerViewAdapter() : androidx.recyclerview.widget.ListAdapter<Dev, RecyclerViewAdapter.ItemViewHolder>(MyDiffCallback()) {

    class MyDiffCallback : DiffUtil.ItemCallback<Dev>() {
        override fun areItemsTheSame(oldItem: Dev, newItem: Dev): Boolean {
            return oldItem.topic == newItem.topic
        }

        override fun areContentsTheSame(oldItem: Dev, newItem: Dev): Boolean {
            return oldItem == newItem
        }
    }


    class ItemViewHolder(private val view: View) :  RecyclerView.ViewHolder(view) {
        val card:CardView = view.findViewById(R.id.item_card)
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

        // Needs to be set so the transition animation knows where to return.
        holder.tv.transitionName = "transition_topic_$position"

        holder.card.setOnClickListener {
            val action = RecyclerViewFragmentDirections.actionDestRecyclerViewFragmentToDetailsFragment(item.topic)
            val extras = FragmentNavigatorExtras(
                holder.tv to "transition_title"
            )

           loadFragment(it, item, extras)

        }
    }


    fun loadFragment(view: View, item: Dev, extras: FragmentNavigator.Extras) {

        when (item.topic) {
            "Button" -> {
                view.findNavController().navigate(R.id.dest_buttonFragment)
            }
            "Menu" -> {
                view.findNavController().navigate(R.id.dest_menuFragment)
                true
            }

            else -> {
                val action = RecyclerViewFragmentDirections.actionDestRecyclerViewFragmentToDetailsFragment(item.topic)
                view.findNavController().navigate(action, extras)
                true
            }
        }


    }

}

