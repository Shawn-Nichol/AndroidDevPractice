package com.example.androiddevpractice.ui.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.androiddevpractice.R
import com.example.androiddevpractice.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    val TAG =  "PracticeLoginFragment"
    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.binding = this

        initDoneButtonHandler()

        return binding.root
    }

    /**
     * Preforms action when the done button is clicked,
     *
     */
    private fun initDoneButtonHandler() {
        binding.inputEditTextPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE && enterUser()) {
                // Closes keyboard
                true
            }
            // Keeps keyboard open.
            false
        }
    }


    /**
     * Checks password to ensure that it is correct, if not the user can't enter the app.
     */
    fun enterUser() : Boolean {
        val user = binding.textInputUserName.editText?.text.toString()
        Log.i(TAG, "User: $user")
        val password = binding.textInputPassword.editText?.text.toString().toInt()


        val userInfo = UserInfo()

        if(userInfo.checkPassword(password)) {
            //val action = RecyclerViewFragment
            val action = LoginFragmentDirections.actionLoginFragmentToRecyclerViewFragment(user)
            view?.findNavController()?.navigate(action)

            // Hides keyboard
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)


            return true
        }
            binding.textInputPassword.error = getString(R.string.wrong_password)
            return false
    }
}