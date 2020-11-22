package com.example.androiddevpractice.recyclerview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var userName: String
    private lateinit var mContext: Context
    val rvAdapter = RecyclerViewAdapter()

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
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_recycler_view, container, false)


        initRecyclerView()
        submitList()

        return binding.root
    }

    fun submitList() {
        viewModel?.devTopics.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvAdapter.submitList(it)
            }
        })
    }

    fun initRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


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