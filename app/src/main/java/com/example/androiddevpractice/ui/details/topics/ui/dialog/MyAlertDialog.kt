package com.example.androiddevpractice.ui.details.topics.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyAlertDialog : DialogFragment(){

    private val TAG = "PracticeBasicDialog"

    internal lateinit var listener: MyAlertDialogListener


    /*
     * The activity that creates an instance of this dialog fragment must implemnt this interface in order
     * to receive event callbacks. Each method passes the DialogFragment in case the host needs it.
     */
    interface MyAlertDialogListener{
        fun onDialogPositiveCLick(dialog: DialogFragment)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        findNavController().
//        // Verify that the host activity implements the callback interface
//        try {
//            // Instantiate the NoticeDialogListener so events can be sent to the host.
//            listener = context as MyAlertDialogListener
//        } catch (e: ClassCastException) {
//            // The activity doesn't implement the interface, throw exception
//            throw ClassCastException((context.toString() + " must implement MyAlertDialogListener"))
//        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog contruction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("My Dialog message")
                .setTitle("Dialog Title")
                .setPositiveButton("Positive button",
                    DialogInterface.OnClickListener{ dialog, id ->
                        Log.i(TAG, "onCreateDialog, postive button")
                        listener.onDialogPositiveCLick(this)

                    })
                .setNegativeButton("Negative ",
                    DialogInterface.OnClickListener { dialog, which ->
                        Log.i(TAG, "onCreateDialog, negative button")
//                        listener.onDialogNegativeClick(this)


                })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}