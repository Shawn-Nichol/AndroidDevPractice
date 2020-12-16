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


class RecyclerViewAdapter() : androidx.recyclerview.widget.ListAdapter<Dev,
        RecyclerViewAdapter.ItemViewHolder>(MyDiffCallback()) {


    lateinit var searchList: List<Dev>

    class MyDiffCallback : DiffUtil.ItemCallback<Dev>() {

        override fun areItemsTheSame(oldItem: Dev, newItem: Dev): Boolean {
            return oldItem.topic == newItem.topic
        }

        override fun areContentsTheSame(oldItem: Dev, newItem: Dev): Boolean {
            return oldItem == newItem
        }


    }

    /**
     * Views for each item in the recyclerView.
     */
    class ItemViewHolder(private val view: View) :  RecyclerView.ViewHolder(view) {
        val card:CardView = view.findViewById(R.id.item_card)
        val title: TextView = view.findViewById(R.id.tv_rv_item)
        val category: TextView = view.findViewById(R.id.tv_category)
    }

    /**
     * layout to load for each item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Bind data from each item to a viewItem.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        // Set Item to View
        holder.title.text = item.topic
        holder.category.text = item.category

        // Sets a unique transition name, so transition knows where to end when back button is pressed.
        holder.title.transitionName = "transition_topic_$position"

        holder.card.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                holder.title to "transition_title"
            )

           loadFragment(it, item, extras)
        }
    }

    /**
     * Loads framgent depending on item selection.
     */
    private fun loadFragment(view: View, item: Dev, extras: FragmentNavigator.Extras) {
        Log.i("PracticeRecyclerViewAdapter", "loadFragment(), ${item.topic}")
        when (item.topic) {
            "Button" -> view.findNavController().navigate(R.id.dest_buttonFragment)
            "Menu" -> view.findNavController().navigate(R.id.dest_menuFragment)
            "Constraint" -> view.findNavController().navigate(R.id.dest_constraintLayoutFragment)
            "Place Holder" -> view.findNavController().navigate(R.id.dest_placeHolderFragment)
            "Motion Layout" -> view.findNavController().navigate(R.id.dest_motionLayoutFragment)
            "Check Boxes" -> view.findNavController().navigate(R.id.dest_checkBoxFragment)
            "Radio Buttons" -> view.findNavController().navigate(R.id.dest_radioButtonFragment)
            "Toggle Buttons" -> view.findNavController().navigate(R.id.dest_toggleButtonFragment)
            "Switch" -> view.findNavController().navigate(R.id.dest_switchesFragment)
            "Pickers" -> view.findNavController().navigate(R.id.dest_pickerFragment)
            "ToolTip" -> view.findNavController().navigate(R.id.dest_toolTipFragment)
            "Notification" -> view.findNavController().navigate(R.id.dest_notificationFragment)
            "System UI" -> view.findNavController().navigate(R.id.dest_systemUIFragment)
            "Toast" -> view.findNavController().navigate(R.id.dest_toastFragment)
            "Snackbar" -> view.findNavController().navigate(R.id.dest_snackbarFragment)
            "Dialog" -> view.findNavController().navigate(R.id.dest_dialogInfoFragment)
            "Preference" -> view.findNavController().navigate(R.id.dest_myPreferencesFragment)
            else -> {
                val action = RecyclerViewFragmentDirections.actionDestRecyclerViewFragmentToDetailsFragment(
                    item.topic, item.category
                )
                view.findNavController().navigate(action, extras)
            }
        }
    }
}

