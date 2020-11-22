package com.example.androiddevpractice.topics.userinterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentCheckBoxBinding


class CheckBoxFragment : Fragment() {
    private lateinit var binding: FragmentCheckBoxBinding


    private var itemOne = false
    private var itemTwo = false
    private var itemThree = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_check_box, container, false)
        binding.binding = this

        return binding.root

    }

    fun myCheckBox(view: View) {
        if(view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_item_one -> {
                    itemOne = checked
                }
                R.id.checkbox_item_two -> {
                    itemTwo = checked
                }
                R.id.checkbox_item_three -> {
                    itemThree = checked
                }
            }
        }
    }

    fun submit() {
        var checkedItems: String = ""

        if(itemOne) checkedItems = "Item One, "
        if(itemTwo) checkedItems +="Item Two, "
        if(itemThree) checkedItems += "ItemThree"

        Toast.makeText(context, checkedItems, Toast.LENGTH_SHORT).show()

    }
}