package com.example.helpdesk

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val Desciption = MutableLiveData<String>()
    // The current score
    val Title = MutableLiveData<String>()
    val Requester = MutableLiveData<String>()
    init {
        Log.i("GameViewModel", "GameViewModel created!")
        Desciption.value = "Desciption"
        Title.value = "Title"
        Requester.value = "Requester"

    }
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }



}
