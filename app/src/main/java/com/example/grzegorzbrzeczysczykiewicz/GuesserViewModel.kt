package com.example.grzegorzbrzeczysczykiewicz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.common.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class GuesserViewModel {
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
                val apiResponse: ApiResponse? = response.body()
                //val guesserItemsList = apiResponse?.guesserItemList ?: listOf()

                //for (bookItems in bookItemsList) {
                    //val bookVolumeInfo = bookItems.bookVolumeInfo
                    //val smallThumbnail = bookItems.bookVolumeInfo.imageLink.smallThumbnail
                    //val title = bookVolumeInfo.title
                    //val subtitle = bookVolumeInfo.subtitle?:""
                    //var authors = ""
                    //val url = bookVolumeInfo.url
                    //val imageUri = smallThumbnail.toUri().buildUpon().scheme("https").build()
                    //val newGuesser = Guesser()
                //}
                //_response.value = newGuesser
            }
        })
    }
}