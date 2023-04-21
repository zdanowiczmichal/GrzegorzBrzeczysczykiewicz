package com.example.grzegorzbrzeczysczykiewicz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GuesserViewModel {
    private val _response = MutableLiveData<List<Guesser>>()
    val response: LiveData<List<Guesser>>
        get() = _response
}