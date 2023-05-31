package com.example.grzegorzbrzeczysczykiewicz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlin.random.Random
import androidx.fragment.app.activityViewModels
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentGuesserBinding
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentHomeBinding
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentStatsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class StatsFragment : Fragment() {

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!
    lateinit var dbRef: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private val viewModel: GuesserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dbRef = Firebase.database.reference
        auth = FirebaseAuth.getInstance()
        pullFromDb()
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        binding.textView13.text = viewModel.currQuizzes.toString()
        binding.textView14.text = viewModel.currCorrect.toString()
        return binding.root
    }
    fun pullFromDb() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //ACCESS OBJECT WITH ALL ENTRIES WITHIN THE DATABASE
                val allDBEntries = dataSnapshot.children
                // ACCESS EACH VALUE IN DB, AND ADD TO ARRAYLIST
                for (allGuesserEntries in allDBEntries) {
                    for (singleGuesserEntry in allGuesserEntries.children) {
                        val quiz = singleGuesserEntry.child("numQuizzes").getValue().toString()
                        val corr = singleGuesserEntry.child("numCorrect").getValue().toString()
                        val currentQuizzes = quiz.toInt()
                        val currentCorrect = corr.toInt()
                        viewModel.setCurrQuizzes(currentQuizzes)
                        viewModel.setCurrCorrect(currentCorrect)

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("MainFragment", "Failed to read value.", error.toException())
            }
        })
    }
}