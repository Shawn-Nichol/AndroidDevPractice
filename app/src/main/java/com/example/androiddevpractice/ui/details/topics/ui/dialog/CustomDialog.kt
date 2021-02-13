package com.example.androiddevpractice.ui.details.topics.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.androiddevpractice.R

class CustomDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater

            builder.apply {
                // Inflate and set the layout for the dialog
                // Pass null as the parent view becuase its going in the dialog layout.
                setView(inflater.inflate(R.layout.custom_dialog, null))
                setPositiveButton("Sign In",
                DialogInterface.OnClickListener { dialog, which ->
                    // Sign in user
                })

                setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, which ->
                    getDialog()?.cancel()
                })
            }



            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}