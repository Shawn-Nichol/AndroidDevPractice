package com.example.androiddevpractice.ui.recyclerview

import android.content.Context
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddevpractice.room.Dev
import com.example.androiddevpractice.ui.main.MainActivityViewModel

class CustomTouchHelper(context: Context, val viewModel: MainActivityViewModel) : ItemTouchHelper.Callback() {

    /**
     * Sets flags so you can tell if an item was swiped or dragged.
     */
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags =  ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlags, swipeFlags  )
    }

    /**
     * Notifies the adapter of the position the item was dragged to and updates the RecyclerView.
     */
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val startPosition = viewHolder.adapterPosition
        val endPosition = target.adapterPosition
        recyclerView.adapter?.notifyItemMoved(startPosition, endPosition)
        return true
    }

    /**
     * Deletes item from, if swiped of in the left or right direction.
     */
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val editList: MutableList<Dev>? = viewModel.listOfDevTopics.value as MutableList<Dev>?
        val editDevList = editList?.toMutableList()

        val topic: Dev = editDevList!![viewHolder.adapterPosition]
        viewModel.deleteTopic(topic)
    }
}