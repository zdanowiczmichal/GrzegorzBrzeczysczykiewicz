package com.example.grzegorzbrzeczysczykiewicz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlin.random.Random
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentGuesserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.random.Random.Default.nextBoolean

class GuesserFragment : Fragment() {

    private var _binding: FragmentGuesserBinding? = null
    private val binding get() = _binding!!
    lateinit var dbRef : DatabaseReference
    private val viewModel: GuesserViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGuesserBinding.inflate(inflater, container, false)
        dbRef = Firebase.database.reference

        viewModel.response.observe(viewLifecycleOwner) { guesser ->
            var k = 0
            var list1: MutableList<Int> = mutableListOf()
            while (k < 8) {
                val x = nextBoolean()
                if (x)
                    list1.add(k)
                else
                    list1.add(99999)
            }
            if (list1[0] != 99999)
                binding.editTextTextPersonName.setText(guesser.name)
            if (list1[1] != 99999)
                binding.editTextTextPersonName2.setText(guesser.height)
            if (list1[2] != 99999)
                binding.editTextTextPersonName3.setText(guesser.mass)
            if (list1[3] != 99999)
                binding.editTextTextPersonName4.setText(guesser.hair_color)
            if (list1[4] != 99999)
                binding.editTextTextPersonName5.setText(guesser.skin_color)
            if (list1[5] != 99999)
                binding.editTextTextPersonName6.setText(guesser.eye_color)
            if (list1[6] != 99999)
                binding.editTextTextPersonName7.setText(guesser.birth_year)
            if (list1[7] != 99999)
                binding.editTextTextPersonName8.setText(guesser.gender)
            binding.num.text = dbRef.child("quizStats").child(FirebaseAuth.getInstance().uid.toString()).child("numQuizzes").toString()
            viewModel.getGuesser()
        }


        return binding.root
    }
//    fun checker(edit: EditText, num: Int) {
//        viewModel.response.observe(viewLifecycleOwner) { guesser ->
//            var x = ""
//            if (num == 0)
//                x = guesser.name
//
//            if (edit.text ==
//        }
//
//    }
}