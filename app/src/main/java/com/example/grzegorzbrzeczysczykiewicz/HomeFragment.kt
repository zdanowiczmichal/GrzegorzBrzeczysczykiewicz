package com.example.grzegorzbrzeczysczykiewicz

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentHomeBinding

import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase



class HomeFragment : Fragment() {

    lateinit var dbRef : DatabaseReference
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var email: String
    lateinit var password: String
    //private val viewModel: GuesserViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dbRef = Firebase.database.reference
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Initialize Firebase Auth
        binding.button.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGuesserFragment()
            binding.root.findNavController().navigate(action)
        }

        //val adapter = GuesserAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

