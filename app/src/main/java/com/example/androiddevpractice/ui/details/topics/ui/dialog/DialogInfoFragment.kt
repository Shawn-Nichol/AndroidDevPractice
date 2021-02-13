package com.example.androiddevpractice.ui.details.topics.ui.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentDialogInfoBinding




class DialogInfoFragment : Fragment(), MyAlertDialog.MyAlertDialogListener {

    private val TAG = "PracticeDialogInfoFragment"

    private lateinit var binding: FragmentDialogInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_info, container, false)
        binding.binding = this

        return binding.root
    }

    override fun onDialogPositiveCLick(dialog: DialogFragment) {
        Log.i(TAG, "Listener returns a postive click")
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Log.i(TAG, "Listener returns a negative click")
    }

    fun launchAlertDialog() {
        // Old way to do this with fragments
//        val dialog = MyAlertDialog()
//            dialog.setTargetFragment(getCurrentFragment, 0)
//            dialog.show(requireActivity().supportFragmentManager, "MyAlertDialog")
        findNavController().navigate(DialogInfoFragmentDirections.actionDestDialogInfoFragmentToMyAlertDialog())

    }

    fun launchSingleChoice() {
        findNavController().navigate(DialogInfoFragmentDirections.actionDestDialogInfoFragmentToSingleChoiceList())
    }

    fun launchCustomDialog() {
        findNavController().navigate(DialogInfoFragmentDirections.actionDestDialogInfoFragmentToCustomDialog())
    }

    fun launchMultipleChoice() {
        findNavController().navigate(DialogInfoFragmentDirections.actionDestDialogInfoFragmentToMultiChoiceList())
    }
}