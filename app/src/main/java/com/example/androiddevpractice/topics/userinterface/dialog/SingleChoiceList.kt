package com.example.androiddevpractice.topics.userinterface.dialog


import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.androiddevpractice.R


class SingleChoiceList : DialogFragment() {

    private var TAG = "PracticeSingleChoiceList"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Select Item Title")
                .setItems(R.array.item_array,
                DialogInterface.OnClickListener{ dialog, which ->
                    // Which argument contains the index position
                    when(which) {
                        0 -> Log.i(TAG, "Item One")
                        1 -> Log.i(TAG, "Item Two")
                        2 -> Log.i(TAG, "Item Three")
                        3 -> Log.i(TAG, "Item Four")
                    }
                })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}