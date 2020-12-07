package com.example.androiddevpractice.recyclerview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddevpractice.MainActivityViewModel
import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentRecyclerViewBinding
import com.example.androiddevpractice.recyclerview.ui.CustomTouchHelper


class RecyclerViewFragment : Fragment() {

    private val TAG = "PracticeRecyclerViewFragmnet"

    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var userName: String
    private lateinit var mContext: Context
    private val rvAdapter = RecyclerViewAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val args: RecyclerViewFragmentArgs = RecyclerViewFragmentArgs.fromBundle(requireArguments())
        userName = args.UserName
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView")
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_recycler_view, container, false
        )

        // Allows menu Item to be added.
        setHasOptionsMenu(true);
        initRecyclerView()
        submitList()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Log.i(TAG, "onPrepareOptionsMenu")

        menu.add(Menu.NONE, Menu.NONE, 0, "Search")?.apply {
            setIcon(R.drawable.ic_search)
            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.title == "Search") {
            Log.i(TAG, "Search clicked.")
            viewModel.searchTopic("Life%")
            // submits list with search result to he RecyclerView.
            submitList()
            // Return so the onOptionItemSelected in the MainActivity doesn't run.
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun submitList() {
        viewModel.listDevTopics.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvAdapter.submitList(it)
            }
        })
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.apply {
            adapter = rvAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


            val customItemTouchHelper = ItemTouchHelper(CustomTouchHelper(mContext, viewModel))
            customItemTouchHelper.attachToRecyclerView(recyclerView)

            // Delay Transition on backpress
            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
    }

    fun fabClick() {

    }
}