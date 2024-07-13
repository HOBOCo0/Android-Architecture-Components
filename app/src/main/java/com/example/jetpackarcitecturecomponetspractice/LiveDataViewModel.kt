package com.example.jetpackarcitecturecomponetspractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// this class will hold the Livedata and logic for our main activity
class LiveDataViewModel() : ViewModel() {

    /*
    live data are of two types mutable and normal

    MutableLiveDat -> can be updated or the value can be modified and observed.
    LiveData ->   the values can not be updated or modified and it can only be observed
     */

    // this value needs to be private to prevent modification
    private val myLiveDataObject = MutableLiveData<String>("I am a String")

    //and data can be accessed using normal LiveData Holder because it can only be observed
    val myliveData: LiveData<String>
        get() = myLiveDataObject

    fun updateMyLiveData() {
        myLiveDataObject.value = "I am a sequence of characters"
    }
}