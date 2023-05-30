package com.example.grzegorzbrzeczysczykiewicz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.common.api.Api
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class GuesserViewModel : ViewModel() {

    private val _response = MutableLiveData<Guesser>()
    val response: MutableLiveData<Guesser>
        get() = _response

    private var _userName: String = ""
    val username: String
        get() = _userName

    private var _currQuizzes: Int = 0
    val currQuizzes: Int
        get() = _currQuizzes

    private var _currCorrect: Int = 0
    val currCorrect: Int
        get() = _currCorrect



    fun setUserName(username : String ) {
        _userName = username
    }

    fun getGuesser() {
        val list = listOf(
            (SWAPI.swapi.getGuessers1()),
            SWAPI.swapi.getGuessers2(),
            SWAPI.swapi.getGuessers3(),
            SWAPI.swapi.getGuessers4(),
            SWAPI.swapi.getGuessers5(),
            SWAPI.swapi.getGuessers6(),
            SWAPI.swapi.getGuessers7(),
            SWAPI.swapi.getGuessers8(),
            SWAPI.swapi.getGuessers9()
        )
        val request = list.random()
        request.enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure" + t.message)
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                val apiResponse: ApiResponse? = response.body()
                val guesserItemsList = apiResponse?.guesserItemsList ?: listOf()
                val guesserList: MutableList<Guesser> = mutableListOf()
                lateinit var newGuesser: Guesser
                for (guesserItems in guesserItemsList) {
                    val name = guesserItems.name
                    val height = guesserItems.height
                    val mass = guesserItems.mass
                    val hair_color = guesserItems.hair_color
                    val skin_color = guesserItems.skin_color
                    val eye_color = guesserItems.eye_color
                    val birth_year = guesserItems.birth_year
                    val gender = guesserItems.gender
                    newGuesser = Guesser(
                        name,
                        height,
                        mass,
                        hair_color,
                        skin_color,
                        eye_color,
                        birth_year,
                        gender

                    )
                    guesserList.add(newGuesser)
                }


                _response.value = guesserList[(0..guesserList.size - 1).random()]
            }
        })
    }
    fun updateCorr() {
        _currCorrect++
    }

    fun updateQuiz() {
        _currQuizzes++
    }

    fun setCurrCorrect(newValue: Int ) {
        _currCorrect = newValue
    }

    fun setCurrQuizzes(newValue: Int ) {
        _currQuizzes = newValue
    }

}