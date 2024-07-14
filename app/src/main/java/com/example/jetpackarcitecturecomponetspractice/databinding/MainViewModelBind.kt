package com.example.jetpackarcitecturecomponetspractice.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModelBind():ViewModel(){
    var quoteLiveData = MutableLiveData<String>("I am a Kotlin my parent is Java")

    fun updateQuote(){
        quoteLiveData.value = "I am a kotlin my base is Java"
    }
}