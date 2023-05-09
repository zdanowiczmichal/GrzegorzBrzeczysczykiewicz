package com.example.grzegorzbrzeczysczykiewicz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentGuesserBinding
class GuesserFragment : Fragment() {

    private var _binding: FragmentGuesserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GuesserViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGuesserBinding.inflate(inflater, container, false)

        viewModel.getGuesser()
        //binding.editTextTextPersonName.text = viewModel.response.value?.get(0)?.name
        return binding.root
    }
}