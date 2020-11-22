package com.example.androiddevpractice.recyclerview

import android.util.Log
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
        val title: TextView = view.findViewById(R.id.tv_rv_item)
        val category: TextView = view.findViewById(R.id.tv_category)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.title.text = item.topic
        holder.category.text = item.category

        // Needs to be set so the transition animation knows where to return.
        holder.title.transitionName = "transition_topic_$position"

        holder.card.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                holder.title to "transition_title"
            )

           loadFragment(it, item, extras)

        }
    }


    private fun loadFragment(view: View, item: Dev, extras: FragmentNavigator.Extras) {
        Log.i("PracticeRecyclerViewAdapter", "loadFragment(), ${item.topic}")
        when (item.topic) {
            "Button" -> view.findNavController().navigate(R.id.dest_buttonFragment)
            "Menu" ->  view.findNavController().navigate(R.id.dest_menuFragment)
            "Constraint" -> view.findNavController().navigate(R.id.dest_constraintLayoutFragment)
            "Place Holder" -> view.findNavController().navigate(R.id.dest_placeHolderFragment)
            "Motion Layout" -> view.findNavController().navigate(R.id.dest_motionLayoutFragment)
            "Check Boxes" -> view.findNavController().navigate(R.id.dest_checkBoxFragment)
            "Radio Buttons" -> view.findNavController().navigate(R.id.dest_radioButtonFragment)
            "Toggle Buttons" -> view.findNavController().navigate(R.id.dest_toggleButtonFragment)
            "Switch" -> view.findNavController().navigate(R.id.dest_switchesFragment)


            else -> {
                val action = RecyclerViewFragmentDirections.actionDestRecyclerViewFragmentToDetailsFragment(item.topic)
                view.findNavController().navigate(action, extras)
            }
        }


    }

}

