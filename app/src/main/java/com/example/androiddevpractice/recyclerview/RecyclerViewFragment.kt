package com.example.androiddevpractice.recyclerview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
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

    private val TAG = "PracticeRecyclerViewFragment"

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
        binding.binding = this

        // Allows menu Item to be added.
        setHasOptionsMenu(true);
        initRecyclerView()
        submitList()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Log.i(TAG, "onPrepareOptionsMenu")

        inflater.inflate(R.menu.recycler_view_menu, menu)


        val searchItem = menu.findItem(R.id.my_search)
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.imeOptions = EditorInfo.IME_ACTION_DONE


        searchView.setIconifiedByDefault(false)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            /**
             * Called when the user submits the query. This could be due to a key press on the keyboard
             * or due to pressing a submit button. Th e listener can override the standard behavior by
             * returning true to indicate taht it has handled the submit request. Otherwise return false
             * to let the SearchView handle the submission by launching any associated intent.
             * @query: teh query text that is to be submitted.
             * return: treu if the query has been handled by the listener, false to let the SearchView
             * perform the default action.
             */
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchTopic("%$query%")
                submitList()
                return false
            }

            /**
             * Called when the query text is changed by the user.
             * @newText: the new content of the query text field.
             * return false if the SerachView should perfomr the default action of showing any suggestions if available,
             *  true if the action was handled by the listener.
             */
            override fun onQueryTextChange(newText: String): Boolean {

                return true
            }

        })
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
        Log.i(TAG, "FAB Click")
//        viewModel.listTopic.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                Log.i(TAG, it.toString())
//            }
//        })
    }
}