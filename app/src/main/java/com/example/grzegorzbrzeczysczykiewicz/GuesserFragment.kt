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
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlin.random.Random
import com.example.grzegorzbrzeczysczykiewicz.databinding.FragmentGuesserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.random.Random.Default.nextBoolean

class GuesserFragment : Fragment() {

    private var _binding: FragmentGuesserBinding? = null
    private val binding get() = _binding!!
    lateinit var dbRef: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private val viewModel: GuesserViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        pullFromDb()
        _binding = FragmentGuesserBinding.inflate(inflater, container, false)
        dbRef = Firebase.database.reference
        auth = FirebaseAuth.getInstance()
        binding.num.text = viewModel.currQuizzes.toString()
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

        binding.button2.setOnClickListener {
            if (binding.editTextTextPersonName.text.toString() == viewModel.response.value?.name && list1[0] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName.setText(
                    viewModel.response.value?.name, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName.text.toString() != viewModel.response.value?.name && list1[0] == 99999){
                binding.editTextTextPersonName.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName.setText(
                    viewModel.response.value?.name, TextView.BufferType.EDITABLE)
            }
            if (binding.editTextTextPersonName2.text.toString() == viewModel.response.value?.height && list1[1] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName2.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName2.setText(
                    viewModel.response.value?.height, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName2.text.toString() == viewModel.response.value?.height && list1[0] == 99999){
                binding.editTextTextPersonName2.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName2.setText(
                    viewModel.response.value?.height, TextView.BufferType.EDITABLE)
            }
            if (binding.editTextTextPersonName3.text.toString() == viewModel.response.value?.mass && list1[2] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName3.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName3.setText(
                    viewModel.response.value?.mass, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName3.text.toString() != viewModel.response.value?.mass && list1[2] == 99999){
                binding.editTextTextPersonName3.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName3.setText(
                    viewModel.response.value?.mass, TextView.BufferType.EDITABLE)
            }
            if (binding.editTextTextPersonName4.text.toString() == viewModel.response.value?.hair_color && list1[3] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName4.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName4.setText(
                    viewModel.response.value?.hair_color, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName4.text.toString() != viewModel.response.value?.hair_color && list1[3] == 99999){
                binding.editTextTextPersonName4.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName4.setText(
                    viewModel.response.value?.hair_color, TextView.BufferType.EDITABLE)
            }
            if (binding.editTextTextPersonName5.text.toString() == viewModel.response.value?.skin_color && list1[4] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName5.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName5.setText(
                    viewModel.response.value?.skin_color, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName5.text.toString() != viewModel.response.value?.skin_color && list1[4] == 99999){
                binding.editTextTextPersonName5.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName5.setText(
                    viewModel.response.value?.skin_color, TextView.BufferType.EDITABLE)
            }
            if (binding.editTextTextPersonName6.text.toString() == viewModel.response.value?.eye_color && list1[5] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName6.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName6.setText(
                    viewModel.response.value?.eye_color, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName6.text.toString() != viewModel.response.value?.eye_color && list1[5] == 99999){
                binding.editTextTextPersonName6.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName6.setText(
                    viewModel.response.value?.eye_color, TextView.BufferType.EDITABLE)
            }
            if (binding.editTextTextPersonName7.text.toString() == viewModel.response.value?.birth_year && list1[6] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName7.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName7.setText(
                    viewModel.response.value?.birth_year, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName7.text.toString() != viewModel.response.value?.birth_year && list1[6] == 99999){
                binding.editTextTextPersonName7.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName7.setText(
                    viewModel.response.value?.birth_year, TextView.BufferType.EDITABLE)
            }
            if (binding.editTextTextPersonName8.text.toString() == viewModel.response.value?.gender && list1[7] == 99999) {
                viewModel.updateCorr()
                binding.editTextTextPersonName8.setTextColor(Color.parseColor("#AEF78E"))
                binding.editTextTextPersonName8.setText(
                    viewModel.response.value?.gender, TextView.BufferType.EDITABLE
                )
            }
            else if (binding.editTextTextPersonName8.text.toString() != viewModel.response.value?.gender && list1[7] == 99999) {
                binding.editTextTextPersonName8.setTextColor(Color.parseColor("#FB3640"))
                binding.editTextTextPersonName8.setText(
                    viewModel.response.value?.gender, TextView.BufferType.EDITABLE)
            }
            viewModel.updateQuiz()

        }


//        val x = dbRef.child("quizStats").child(FirebaseAuth.getInstance().uid.toString())
//            .child("numQuizzes").get()



        viewModel.updateQuiz()
        dbRef.child("quizStats").child(auth.uid.toString()).child("numQuizzes").setValue(viewModel.currQuizzes)
        dbRef.child("quizStats").child(auth.uid.toString()).child("numCorrect").setValue(viewModel.currCorrect)
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


    fun setDb() {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //ACCESS OBJECT WITH ALL ENTRIES WITHIN THE DATABASE
                val allDBEntries = dataSnapshot.children
                // ACCESS EACH VALUE IN DB, AND ADD TO ARRAYLIST
                for (allGuesserEntries in allDBEntries) {
                    for (singleGuesserEntry in allGuesserEntries.children) {
                        singleGuesserEntry.child("numQuizzes").value
                        singleGuesserEntry.child("numCorrect").value
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
