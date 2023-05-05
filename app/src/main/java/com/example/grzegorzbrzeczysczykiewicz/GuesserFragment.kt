package com.example.grzegorzbrzeczysczykiewicz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentGuesserBinding
class GuesserFragment : Fragment() {

    private var _binding: FragmentGuesserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGuesserBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}