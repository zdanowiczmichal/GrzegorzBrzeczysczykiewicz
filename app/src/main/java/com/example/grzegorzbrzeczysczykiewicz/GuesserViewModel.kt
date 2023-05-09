package com.example.grzegorzbrzeczysczykiewicz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.common.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class GuesserViewModel: ViewModel() {
    private val _response = MutableLiveData<List<Guesser>>()
    val response: MutableLiveData<List<Guesser>>
        get() = _response

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
                var guesserFetched = mutableListOf<Guesser>()
                val apiResponse: ApiResponse? = response.body()
                val guesserItemsList = apiResponse?.guesserItemsList ?: listOf()

                for (guesserItems in guesserItemsList) {
                    val name = guesserItems.name
                    val height = guesserItems.height
                    val mass = guesserItems.mass
                    val hair_color = guesserItems.hair_color
                    val skin_color = guesserItems.skin_color
                    val eye_color = guesserItems.eye_color
                    val birth_year = guesserItems.birth_year
                    val gender = guesserItems.gender
                    val newGuesser = Guesser(name, height, mass, hair_color, skin_color, eye_color, birth_year, gender)
                    guesserFetched.add(newGuesser)
                }
                _response.value = guesserFetched
            }
        })
    }
}