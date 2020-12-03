package com.example.androiddevpractice.topics.userinterface.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.androiddevpractice.R

class MultiChoiceList : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Items that were selected.
            val selectedItems = ArrayList<Int>()
            val builder = AlertDialog.Builder(it)
                builder.apply {
                    setTitle("Multi choice list")
                    setMultiChoiceItems(R.array.item_array, null,
                    DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                        if(isChecked)
                            // Item selected by the user
                            selectedItems.contains(which)
                        else if(selectedItems.contains(which)) {
                            // Else, if the item is already in the list remove it
                            selectedItems.remove(Integer.valueOf(which))
                        }
                    })
                    
                    setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  
                        // save the results somewher
                    })
                    
                    setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, which ->
                        // Do nothing.
                    })

                }

            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }
}