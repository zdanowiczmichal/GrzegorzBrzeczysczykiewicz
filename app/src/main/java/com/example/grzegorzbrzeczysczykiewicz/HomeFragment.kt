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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    lateinit var dbRef : DatabaseReference
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private val viewModel: GuesserViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dbRef = Firebase.database.reference
        auth = FirebaseAuth.getInstance()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Initialize Firebase Auth

        binding.button.setOnClickListener {
            signIn(binding.username.text.toString(), binding.password.text.toString())

        }
        binding.signup.setOnClickListener{
            createAccount(binding.username.text.toString(), binding.password.text.toString())
        }
        return binding.root
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            reload()
//        }
    }

    private fun createAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    val action = HomeFragmentDirections.actionHomeFragmentToGuesserFragment()
                    binding.root.findNavController().navigate(action)
                    dbRef.child("quizStats").child(FirebaseAuth.getInstance().uid.toString()).child("numQuizzes").setValue(0)
                    dbRef.child("quizStats").child(FirebaseAuth.getInstance().uid.toString()).child("numCorrect").setValue(0)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        context,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        // [END create_user_with_email]
    }

    private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val action = HomeFragmentDirections.actionHomeFragmentToGuesserFragment()
                    binding.root.findNavController().navigate(action)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        context,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        // [END sign_in_with_email]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

