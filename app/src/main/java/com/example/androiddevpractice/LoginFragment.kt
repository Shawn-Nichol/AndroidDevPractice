package com.example.androiddevpractice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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




        return binding.root
    }


    fun enterUser() {
        val user = binding.editTextUserName.editText?.text.toString()
        Log.i(TAG, "User: $user")
        val password = binding.editTextPassword.editText?.text.toString().toInt()

        if(password == 4369) {
            //val action = RecyclerViewFragment
            val action = LoginFragmentDirections.actionLoginFragmentToRecyclerViewFragment(user)
            view?.findNavController()?.navigate(action)

        } else {
            binding.editTextPassword.error = getString(R.string.wrong_password)
        }



    }
}