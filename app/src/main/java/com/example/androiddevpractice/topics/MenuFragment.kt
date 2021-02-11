package com.example.androiddevpractice.topics

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import androidx.appcompat.view.ActionMode
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.androiddevpractice.ui.MainActivity
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentMenuBinding


class MenuFragment : Fragment(), PopupMenu.OnMenuItemClickListener {

    private val TAG = "PracticeMenuFragment"

    private lateinit var binding: FragmentMenuBinding
    private var actionMode: ActionMode ?= null
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        binding.binding = this

        navController = requireActivity().findNavController(R.id.nav_host_fragment)

        registerForContextMenu(binding.btnFloatingMenu)

        return binding.root
    }

    /**
     * Inflate the floating action menu.
     */
    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        Log.i(TAG, "onCreateContextMenu")
        val inflater = MenuInflater(context)
        inflater.inflate(R.menu.contextual_menu, menu)
    }

    /**
     * Item select for the floating action menu.
     */
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.dest_contextual1Fragment -> {
                Log.i(TAG, "onContextItemSelect One")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }

            R.id.dest_contextual2Fragment -> {
                Log.i(TAG, "onContextItemSelect two")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }

            R.id.dest_contextual3Fragment -> {
                Log.i(TAG, "onContextItemSelect three")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }

            else -> {
                Log.i(TAG, "onContextItemSelect else")
                false
            }
        }
    }

    /**
     * Called to start Contextual Action Mode.
     */
    fun myCAB() {
        if (actionMode != null) return
        actionMode = (activity as MainActivity).startSupportActionMode(actionModeCallback)
    }

    private val actionModeCallback = object : ActionMode.Callback {
        /**
         * Called when the action mode is created
         */
        override fun onCreateActionMode(mode: ActionMode, menu: Menu?): Boolean {
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.contextual_menu, menu)
            return true
        }

        /**
         * Called each time the action mode is shown. Always called after onCreateActionMode, maybe
         * call multiple times if the mode is invalidated.
         */
        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.dest_contextual1Fragment -> {
                    Log.i(TAG, "onActionItemClick One")
                    mode.finish() // Action picked, so close the CAB
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                R.id.dest_contextual2Fragment -> {
                    Log.i(TAG, "onActionItemClick Two")
                    mode.finish() // Action picked, so close the CAB
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                R.id.dest_contextual3Fragment -> {
                    Log.i(TAG, "onActionItemClick Three")
                    mode.finish() // Action picked, so close the CAB
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                else -> false
            }
        }

        /**
         * Called when the user exits the action mode.
         */
        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }
    }

    fun popupMenu(v: View) {
        PopupMenu(context, v).apply {
            setOnMenuItemClickListener(this@MenuFragment)
            inflate(R.menu.main_menu)
            show()
        }
    }

    /**
     * Handles Pop Menu clicks
     */
    override fun onMenuItemClick(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.dest_menu1Fragment -> {
                Log.i(TAG, "onMenuItemClick Pop 1")
                NavigationUI.onNavDestinationSelected(item, navController)
            }
            R.id.dest_menu2Fragment -> {
                Log.i(TAG, "onMenuItemClick Pop 2")
                NavigationUI.onNavDestinationSelected(item, navController)
            }
            R.id.dest_menu3Fragment -> {
                Log.i(TAG, "onMenuItemClick Pop 3")
                NavigationUI.onNavDestinationSelected(item, navController)
            }
            else -> false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        actionMode = null
    }
}