package com.example.grzegorzbrzeczysczykiewicz

import android.content.ContentValues
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
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
    lateinit var dbRef: DatabaseReference
    private val viewModel: GuesserViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGuesserBinding.inflate(inflater, container, false)
        dbRef = Firebase.database.reference

        binding.button2.setOnClickListener {
            binding.editTextTextPersonName.setText(viewModel.response.value?.name, TextView.BufferType.EDITABLE)
            if (binding.editTextTextPersonName.text.toString() == viewModel.response.value?.name) {
                yes()
            }
            if (binding.editTextTextPersonName2.text.toString() == viewModel.response.value?.height) {
                yes()
            }
            if (binding.editTextTextPersonName3.text.toString() == viewModel.response.value?.mass) {
                yes()
            }
            if (binding.editTextTextPersonName4.text.toString() == viewModel.response.value?.hair_color) {
                yes()
            }
            if (binding.editTextTextPersonName5.text.toString() == viewModel.response.value?.skin_color) {
                yes()
            }
            if (binding.editTextTextPersonName6.text.toString() == viewModel.response.value?.eye_color) {
                yes()
            }
            if (binding.editTextTextPersonName7.text.toString() == viewModel.response.value?.birth_year) {
                yes()
            }
            if (binding.editTextTextPersonName8.text.toString() == viewModel.response.value?.gender) {
                yes()
            }
        }
        var k = 0
        val list1: MutableList<Int> = mutableListOf()
        while (k < 8) {
            val x = nextBoolean()
            if (x)
                list1.add(0)
            else
                list1.add(99999)
            k += 1

        }
        if (list1[0] != 99999)
            binding.editTextTextPersonName.setText(viewModel.response.value?.name)
        if (list1[1] != 99999)
            binding.editTextTextPersonName2.setText(viewModel.response.value?.height)
        if (list1[2] != 99999)
            binding.editTextTextPersonName3.setText(viewModel.response.value?.mass)
        if (list1[3] != 99999)
            binding.editTextTextPersonName4.setText(viewModel.response.value?.hair_color)
        if (list1[4] != 99999)
            binding.editTextTextPersonName5.setText(viewModel.response.value?.skin_color)
        if (list1[5] != 99999)
            binding.editTextTextPersonName6.setText(viewModel.response.value?.eye_color)
        if (list1[6] != 99999)
            binding.editTextTextPersonName7.setText(viewModel.response.value?.birth_year)
        if (list1[7] != 99999)
            binding.editTextTextPersonName8.setText(viewModel.response.value?.gender)
        binding.num.text = dbRef.child("quizStats").child(FirebaseAuth.getInstance().uid.toString()).child("numQuizzes").toString().toInt().toString()

        return binding.root
    }
    fun yes() {
        var x = dbRef.child("quizStats").child(FirebaseAuth.getInstance().uid.toString()).child("numCorrect").toString().toInt()
        x += 1
        dbRef.child("quizStats").child(FirebaseAuth.getInstance().uid.toString()).child("numCorrect").setValue(x)
        binding.editTextTextPersonName.setTextColor(Color.parseColor("#AEF78E"));
    }
}
